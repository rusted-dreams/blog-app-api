package xyz.sm10.blogs.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.UserDto;
import xyz.sm10.blogs.entities.User;
import xyz.sm10.blogs.repositories.UserRepo;
import xyz.sm10.blogs.services.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto User) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto User, Integer UserId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer UserId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();

        return users
                .stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getBio()
                        )
                )
                .toList();
    }

    @Override
    public void deleteUser(Integer UserId) {

    }
}
