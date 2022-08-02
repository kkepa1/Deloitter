package com.deloitte.deloitter.user.service;

import com.deloitte.deloitter.user.entity.User;

public interface IUserService {

    User findUserByName(String name);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUserByName(String name);
}
