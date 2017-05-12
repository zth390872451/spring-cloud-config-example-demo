package com.company.web.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@EnableOAuth2Client
public class OAuth2Configuration  extends AuthorizationServerConfigurerAdapter {

	@Value("${oauth2.serverPath}")
	private String tokenUrl;

	@Bean
	protected ResourceOwnerPasswordResourceDetails details() {
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setAccessTokenUri(tokenUrl);
		details.setScope(Arrays.asList("read", "write"));
		return details;
	}
	
	@Bean
	protected ClientCredentialsResourceDetails clientCredentialsDetails() {
		ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
		details.setAccessTokenUri(tokenUrl);
		details.setScope(Arrays.asList("read", "write"));
		return details;
	}


}
