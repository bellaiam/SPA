package com.tbb.krazyolives.security;


import com.tbb.krazyolives.data.AuthGroupRepository;
import com.tbb.krazyolives.models.AuthGroup;
import com.tbb.krazyolives.models.User;
import com.tbb.krazyolives.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AppUserDetailsService implements UserDetailsService {

    AuthGroupRepository authGroupRepository;
    UserService userService;
    @Autowired
    public AppUserDetailsService(AuthGroupRepository authGroupRepository, UserService userService) {
        this.authGroupRepository = authGroupRepository;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= null;
        try {
            user =userService.findByEmail(email);

        } catch (NoSuchElementException ex){
            log.warn("Couldn't find email: " + email);
            ex.printStackTrace();
        } catch(UsernameNotFoundException e){
            log.warn("Couldn't find email: " + email);
            e.printStackTrace();
        }
        List<AuthGroup> authGroups = authGroupRepository.findByaEmail(email);
        return new AppUserPrincipal(user, authGroups);
    }
}
