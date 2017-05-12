package com.company.web.controller;


import com.company.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Desc 授权
 *
 同一个会员登录（可能存在2个版本的APP）
	member.setClientId(client_id);后一个
 * @author umeox
 * @version II
 */
@RestController
@RequestMapping("/api/oauth2")
public class Oauth2Controller {
	
	private static final Logger log = LoggerFactory.getLogger(Oauth2Controller.class);

	@Autowired
	private ResourceOwnerPasswordResourceDetails resource;//账号密码验证(密Oauth2的码模式)
	@Autowired
	private ClientCredentialsResourceDetails clientCredentials;//客户端验证(Oauth2的客户端模式)
	@Autowired
	private UserRepository userRepository;
	/**
	 * 获取token
	 */
	@RequestMapping(value = "/pwdToken",method = RequestMethod.POST)
	public Object accessToken(@RequestParam(value = "client_id") String client_id,
							  @RequestParam(value = "client_secret") String client_secret,
							  @RequestParam(value = "grant_type") String grant_type,
							  @RequestParam(value = "username") String username,
							  @RequestParam(value = "password") String password
									 ){
		//App端dm5加密后不足32位加零补齐的情况
		String pre = "";
		if (password.length() < 32) {

			int len = 32 - password.length();
			pre = String.format("%0" + len + "d", 0);
		}
//		resource.setAccessTokenUri(tokenUrl);
		resource.setClientId(client_id);
		resource.setClientSecret(client_secret);
		resource.setGrantType(grant_type);// ResourceOwnerPasswordResourceDetails 默认已经是 password 认证类型
		//resource.setScope(Arrays.asList("read", "write"));
		resource.setUsername(username);
		resource.setPassword(pre + password);

		ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
		OAuth2AccessToken accessToken = null;
		try {
			accessToken = provider.obtainAccessToken(resource, new DefaultAccessTokenRequest());
		} catch (NullPointerException e) {
			log.error("授权失败原因：{}", e.getMessage());
			return "用户不存在";
		}catch (Exception e){
			log.error("授权失败原因：{}", e.getMessage());
			return "创建token失败";
		}



		String token = accessToken.getValue();
		int expiresIn = accessToken.getExpiresIn();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("access_token", token);
		map.put("token_type", accessToken.getTokenType());
		map.put("expires_in", expiresIn);

		return accessToken;
	}

//@Autowired
//private DefaultTokenServices defaultTokenServices;

	/**
	 * 信任的客户端获取token
	 */
	@RequestMapping(value = "/clientToken",method = RequestMethod.POST)
	public Object getToken(@RequestParam(value = "client_id") String client_id,
								   @RequestParam(value = "client_secret") String client_secret,
								   @RequestParam(value = "grant_type") String grant_type
								   ){

//		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate();
		/*DefaultTokenServices defaultTokenServices = (DefaultTokenServices) ApplicationSupport.getBean("defaultTokenServices");
		OAuth2AccessToken oAuth2AccessToken = defaultTokenServices.readAccessToken("58741895-8c2d-4f3c-9f95-08c258e956cf");
		boolean expired = oAuth2AccessToken.isExpired();
		System.out.println("oAuth2AccessToken = " + oAuth2AccessToken);
*/
		clientCredentials.setClientId(client_id);
		clientCredentials.setClientSecret(client_secret);
		clientCredentials.setGrantType(grant_type);
		ClientCredentialsAccessTokenProvider provider = new ClientCredentialsAccessTokenProvider();
		OAuth2AccessToken accessToken = null;
		try {
			accessToken = provider.obtainAccessToken(clientCredentials, new DefaultAccessTokenRequest());
		} catch (Exception e) {
			e.printStackTrace();
			return "error 401";
		}
		return accessToken+"";
	}

}
