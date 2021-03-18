package com.example.springboot.service;

import com.example.springboot.model.AppUser;
import com.example.springboot.repo.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private IAppUserRepo appUserRepo;

    @Override
    public AppUser getUserByName(String name) {
        return appUserRepo.getAppUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=this.getUserByName(username);
        List<GrantedAuthority>authorities=new ArrayList<>();
        authorities.add(appUser.getRole());
        UserDetails userDetails=new User(appUser.getName(),appUser.getPassword(),authorities);
        return userDetails;
    }
}
