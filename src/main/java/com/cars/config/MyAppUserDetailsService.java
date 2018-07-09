package com.cars.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cars.Repository.UserMenRepository;
import com.cars.model.UsrMen;
import com.cars.model.UsrProfilUtil;

@Service
public class MyAppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserMenRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		UsrMen activeUserInfo = userRepository.findUser(userName);

        if (activeUserInfo == null) {
            throw new UsernameNotFoundException(userName);
        }

		UserDetails userDetails = new User(activeUserInfo.getUtil(),
				activeUserInfo.getPwd(), getGrantedAuthorities(activeUserInfo));

		return userDetails;

	}

	private List<GrantedAuthority> getGrantedAuthorities(UsrMen user) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UsrProfilUtil  p:user.getUsrProfilUtils()) {

			System.out.println("UserProfile : " + p.getProfil().getLibProfil());

			authorities.add(new SimpleGrantedAuthority(p.getProfil().getLibProfil()));

		}

		return authorities;
	}
}

