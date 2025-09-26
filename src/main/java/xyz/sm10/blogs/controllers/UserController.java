package xyz.sm10.blogs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sm10.blogs.dto.UserDto;
import xyz.sm10.blogs.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/api/users/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
