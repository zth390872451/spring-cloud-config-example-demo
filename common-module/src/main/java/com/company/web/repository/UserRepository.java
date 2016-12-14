package com.company.web.repository;

import com.company.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

    User findOneByLoginName(String loginName);

    User findOneByMobile(String mobile);

}
