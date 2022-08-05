package com.deloitte.deloitter.user.service;

import com.deloitte.deloitter.mapstruct.dtos.UserDeleteDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetAllDto;
import com.deloitte.deloitter.mapstruct.dtos.UserGetDto;
import com.deloitte.deloitter.mapstruct.dtos.UserPostDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import com.deloitte.deloitter.user.entity.User;
import com.deloitte.deloitter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private MapStructMapper mapstructMapper;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(
            MapStructMapper mapstructMapper,
            UserRepository userRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<UserGetDto> getUser(Long id) {
        return new ResponseEntity<>(
                mapstructMapper.userToUserDto(
                        userRepository.findById(id).orElse(null)
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserGetAllDto> getUserAll(Long id) {
        return new ResponseEntity<>(
                mapstructMapper.userToUserAllDto(
                        userRepository.findById(id).orElse(null)
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Void> createUser(UserPostDto userPostDto) {
        userRepository.save(mapstructMapper.userPostDtoToUser(userPostDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UserDeleteDto userDeleteDto) {
        User user = userRepository.findByLoginAndPassword(mapstructMapper.userToUserDeleteDto(userDeleteDto).getLogin(), mapstructMapper.userToUserDeleteDto(userDeleteDto).getPassword());
        if (user != null){
            userRepository.deleteById(user.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
