package com.company.web.api;

import com.company.web.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign 客户端继承：UserClient extends UserApi
 * 普通服务端实现：UserFeignServer implements UserApi
 */
public interface UserApi {

    @RequestMapping(method = RequestMethod.GET, value ="/users/{id}")
    public User getUser(@PathVariable("id") long id);
}
