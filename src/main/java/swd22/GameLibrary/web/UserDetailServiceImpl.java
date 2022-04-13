package swd22.GameLibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import swd22.GameLibrary.domain.User;
import swd22.GameLibrary.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
    	User currentuser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(currentuser.getRole()));
        return user;
    } 
}
