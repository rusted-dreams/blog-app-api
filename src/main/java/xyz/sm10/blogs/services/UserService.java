package xyz.sm10.blogs.services;

import xyz.sm10.blogs.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto User);
    UserDto updateUser(UserDto User, Integer UserId);
    UserDto getUserById(Integer UserId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer UserId);
}
