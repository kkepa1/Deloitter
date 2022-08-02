package com.deloitte.deloitter.user.service;

import com.deloitte.deloitter.user.entity.User;
import com.deloitte.deloitter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        }
        return null;
    }

    @Override
    public User updateUser(User user){
        User upUser = userRepository.findUserByName(user.getName());
        if(upUser!=null) {
            upUser.setName(user.getName());
            upUser.setPassword(user.getPassword());
            return userRepository.save(upUser);
        }
        return null;
    }

    @Override
    public void deleteUserByName(String name){
        userRepository.delete(findUserByName(name));
    }
}
