package com.company.web.repository;

import com.company.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    User findUserByUserName(String userName);

}
