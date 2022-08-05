package com.deloitte.deloitter.user.service;

import com.deloitte.deloitter.mapstruct.dtos.UserDeleteDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetAllDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetDto;
import com.deloitte.deloitter.mapstruct.dtos.UserPostDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserGetDto> getUser(Long id);

    ResponseEntity<UserGetAllDto> getUserAll(Long id);

    ResponseEntity<Void> createUser(UserPostDto userPostDto);

    ResponseEntity<Void> deleteUser(UserDeleteDto userDeleteDto);


}
