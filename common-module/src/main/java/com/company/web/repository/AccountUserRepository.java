package com.company.web.repository;

import com.company.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountUserRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

	public Member findOneByMobile(String mobile);
}
