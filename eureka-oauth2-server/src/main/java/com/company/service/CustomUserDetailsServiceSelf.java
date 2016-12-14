package com.company.service;

import com.company.domain.Role;
import com.company.web.domain.Member;
import com.company.web.repository.AccountUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CustomUserDetailsServiceSelf implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsServiceSelf.class);
	@Autowired
	private AccountUserRepository accountUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = accountUserRepository.findOneByMobile(username);
		if (member == null) {
			log.error("用户不存在");
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return new UserRepositoryUserDetails(member);
	}

	private final static class UserRepositoryUserDetails extends Member implements UserDetails {

		private UserRepositoryUserDetails(Member member) {
			super(member);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Role role = new Role();
			return role.getRoles();
		}

		@Override
		public String getUsername() {
			return getMobile();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}
	
	/*public static void main(String[] args) {
		String password = "4bd1kufizod95rlm157rxqfueb4ernj5";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
		System.out.println(System.currentTimeMillis());
	}*/
	
	/*
	  INSERT INTO oauth_client_details (
			client_id,
			client_secret,
			scope,
			authorized_grant_types,
			authorities,
			access_token_validity
		)
		VALUES
			(
				'wxb_doki_api_ios',
				'$2a$10$/AgahDVVEckNZt18ZIrQVONkXVx/NG.srm9tX6JgkZ8r8ULeLr3o.',
				'read,write',
				'client_credentials,refresh_token',
				'USER',
				'2592000'
			)
			*/
}