package com.tbb.krazyolives.services;

import com.tbb.krazyolives.data.AuthGroupRepository;
import com.tbb.krazyolives.data.UserRepository;
import com.tbb.krazyolives.models.AuthGroup;
import com.tbb.krazyolives.models.User;
import com.tbb.krazyolives.validators.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {


   

        private UserRepository userRepository;
        private AuthGroupRepository authGroupRepository;
@Autowired
    public UserService(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    public List<User> getAllUsers() {
            return userRepository.findAll();
        }


        public void saveUsers(User user) {
            this.userRepository.save(user);
        }


        public User getUserById(long id) {
            Optional< User > optional = userRepository.findById(id);
            User user = null;
            if (optional.isPresent()) {
                user = optional.get();
            } else {
                throw new RuntimeException(" Users not found for id :: " + id);
            }
            return user;
        }


        public void deleteUserById(long id) {
            this.userRepository.deleteById(id);
        }


    @Transactional(rollbackOn = {NoSuchElementException.class})
    public User findByEmail(String email) throws NoSuchElementException{
        return userRepository.findByEmail(email);
    }

    public User registerNewUserAccount(User user) throws UserAlreadyExistException {
        if (emailExists(user.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + user.getEmail());
        }
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail().toLowerCase());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        authGroupRepository.save(new AuthGroup(user.getEmail(), "ROLE_USER"));
        return user;
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }


}