package xyz.sm10.blogs.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import xyz.sm10.blogs.dto.UserDto;
import xyz.sm10.blogs.entities.User;
import xyz.sm10.blogs.exceptions.ResourceNotFoundException;
import xyz.sm10.blogs.repositories.UserRepo;
import xyz.sm10.blogs.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto newUser) {
        // check if user already exists:
        boolean exists = userRepo.existsByEmail(newUser.getEmail());
        if (exists) {
            throw new RuntimeException("User already exists with email: " + newUser.getEmail());
        }

        // convert DTO --> entity
        User usr = modelMapper.map(newUser, User.class);

        User savedUser = userRepo.save(usr);

        //convert entity --> DTO
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto User, Integer UserId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer uid) {
        User user = userRepo.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", uid));
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getBio()); // we can do this using model mapper later.
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();

        return users
                .stream()
                .map(user -> new UserDto( // we will later do this using model mapper
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
    public void deleteUser(Integer uid) {
        User exists = userRepo.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", uid));
        userRepo.deleteById(uid);
        return;
    }
}
