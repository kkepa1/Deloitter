package com.deloitte.deloitter.user.service;

import com.deloitte.deloitter.user.entity.User;
import com.deloitte.deloitter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByName(String name){
        return userRepository.findUserByName(name);
    }

    @Override
    public User saveUser(User user){
        if (userRepository.findUserByName(user.getName()) == null) {
            return userRepository.save(user);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find user with this name");
        }
    }

    @Override
    public User updateUser(User user){
        User upUser = userRepository.findUserByName(user.getName());
        if(upUser!=null) {
            upUser.setName(user.getName());
            upUser.setPassword(user.getPassword());
            return userRepository.save(upUser);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find user with this name");
        }
    }

    @Override
    public String deleteUserByName(String name){
        if(userRepository.findUserByName(name) != null){
            userRepository.delete(findUserByName(name));
            return "User deleted";
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find user with this name");
        }
    }
}
