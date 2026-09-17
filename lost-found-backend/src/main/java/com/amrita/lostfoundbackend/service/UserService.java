package com.amrita.lostfoundbackend.service;

import com.amrita.lostfoundbackend.entity.user;
import com.amrita.lostfoundbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public user registerUser(user user) {
        return userRepository.save(user);
    }
}