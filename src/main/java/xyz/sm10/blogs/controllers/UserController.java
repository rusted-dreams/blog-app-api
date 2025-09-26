package xyz.sm10.blogs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.sm10.blogs.dto.UserDto;
import xyz.sm10.blogs.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    // find a user by id:
    @GetMapping("/api/user/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // get list of all users:
    @GetMapping("/api/users/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
