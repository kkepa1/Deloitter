package com.deloitte.deloitter.user.controller;


import com.deloitte.deloitter.mapstruct.dtos.UserGetDto;
import com.deloitte.deloitter.mapstruct.mapper.MapStructMapper;
import com.deloitte.deloitter.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private MapStructMapper mapstructMapper;

    private UserRepository userRepository;

    @Autowired
    public UserController(
            MapStructMapper mapstructMapper,
            UserRepository userRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getUser(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(
                mapstructMapper.userToUserDto(
                        userRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
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
