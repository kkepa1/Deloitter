package com.deloitte.deloitter.user.controller;


import com.deloitte.deloitter.user.entity.User;
import com.deloitte.deloitter.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping(value = "/{name}")
    public User getUser(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @PostMapping(value = "")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(value = "")
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{name}")
    public void deleteUser(@PathVariable String name) {
        userService.deleteUserByName(name);
    }
}
