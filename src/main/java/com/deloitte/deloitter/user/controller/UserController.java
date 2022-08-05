package com.deloitte.deloitter.user.controller;


import com.deloitte.deloitter.mapstruct.dtos.UserDeleteDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetAllDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetDto;
import com.deloitte.deloitter.mapstruct.dtos.UserPostDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import com.deloitte.deloitter.user.entity.User;
import com.deloitte.deloitter.user.repository.UserRepository;
import com.deloitte.deloitter.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(
            UserServiceImpl userService
    ) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getUser(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<UserGetAllDto> getUserAll(@PathVariable(value = "id") Long id) {
        return userService.getUserAll(id);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserPostDto userPostDto){
        return userService.createUser(userPostDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@Valid @RequestBody UserDeleteDto userDeleteDto){
        return userService.deleteUser(userDeleteDto);
    }

//    @GetMapping(value = "/{login}")
//    public User getUser(@PathVariable String login) {
//        return userService.findUserByLogin(login);
//    }
//
//    @PostMapping(value = "")
//    public User saveUser(@Valid @RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @PutMapping(value = "")
//    public User updateUser(@Valid @RequestBody User user) {
//        return userService.updateUser(user);
//    }
//
//    @DeleteMapping(value = "/{login}")
//    public void deleteUser(@PathVariable String login) {
//        userService.deleteUserByLogin(login);
//    }
//
//    @GetMapping(value = "/{login}/dwitts")
//    public List<Dwitt> getUserDwitts(@PathVariable String login) {
//        return userService.getUserDwitts(login);
//    }
}
