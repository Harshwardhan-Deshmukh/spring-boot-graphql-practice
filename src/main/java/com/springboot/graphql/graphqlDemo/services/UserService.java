package com.springboot.graphql.graphqlDemo.services;

import com.springboot.graphql.graphqlDemo.entities.User;
import com.springboot.graphql.graphqlDemo.repositories.UserRepository;
import com.springboot.graphql.graphqlDemo.utils.ExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> ExceptionHandler.throwResourceNotFound(id, "User"));
    }

    public Boolean deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> ExceptionHandler.throwResourceNotFound(id, "User"));
        userRepository.delete(user);
        return true;
    }
}
