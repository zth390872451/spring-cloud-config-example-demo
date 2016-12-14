/**
 * 
 */
package com.company.repository;

import com.company.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

	public Member findOneByMobile(String mobile);
	

}
