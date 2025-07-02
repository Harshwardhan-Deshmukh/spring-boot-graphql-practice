package com.springboot.graphql.graphqlDemo.controllers;

import com.springboot.graphql.graphqlDemo.entities.User;
import com.springboot.graphql.graphqlDemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MutationMapping(name = "createUser")
    public User createUser(@Argument String name, @Argument String phone,
                           @Argument String email, @Argument String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping(name = "getUser")
    public User findUserById(@Argument(name = "userId") Long id) {
        return userService.findUserById(id);
    }

    @MutationMapping(name = "deleteUser")
    public Boolean deleteUser(@Argument(name = "userId") Long id) {
        return userService.deleteUserById(id);
    }
}
