package xyz.sm10.blogs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.sm10.blogs.dto.UserDto;
import xyz.sm10.blogs.services.impl.UserServiceImpl;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {

    private final UserServiceImpl userService;

    // find a user by id:
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // get list of all users:
    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public String postMethodName(@RequestBody UserDto newUser) {
        UserDto createdUser = userService.createUser(newUser);
        return "New user registered successfully with id:" + createdUser.getId();
    }

    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable Integer uid) {
        userService.deleteUser(uid);
    }
    
}
