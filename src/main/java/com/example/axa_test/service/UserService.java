package com.example.axa_test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.axa_test.model.entities.Users;
import com.example.axa_test.model.recordDto.UserRequest;
import com.example.axa_test.model.recordDto.UserResponse;
import com.example.axa_test.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public UserResponse createUser(UserRequest request) {
    Users user = userRepository.save(Users.builder().username(request.username()).password(request.password()).build());

    return new UserResponse(user.getUserId(), user.getUsername());
  }

  public UserResponse findUserById(Long userId) {
    Users user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Id with " + userId));

    return new UserResponse(user.getUserId(), user.getUsername());
  }

  public List<UserResponse> getAllUser() {
    return userRepository.findAll().stream().map(user -> new UserResponse(user.getUserId(), user.getUsername())).collect(Collectors.toList());
  }

  public UserResponse updateUser(Long userId, UserRequest request) {
    Users user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Id with " + userId));

    user.setUsername(request.username());
    user.setPassword(request.password());
    userRepository.save(user);

    return new UserResponse(user.getUserId(),user.getUsername());
  }

  public Long delete(Long userId) {
    Users user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Id with " + userId));

    userRepository.delete(user);
    return userId;
  }
}
