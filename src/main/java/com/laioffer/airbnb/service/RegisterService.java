package com.laioffer.airbnb.service;

import com.laioffer.airbnb.exception.UserAlreadyExistException;
import com.laioffer.airbnb.model.Authority;
import com.laioffer.airbnb.model.User;
import com.laioffer.airbnb.model.UserRole;
import com.laioffer.airbnb.repository.AuthorityRepository;
import com.laioffer.airbnb.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    public RegisterService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void add(User user, UserRole role) {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistException("User already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }
}
