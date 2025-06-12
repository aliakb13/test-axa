package com.example.axa_test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.axa_test.model.recordDto.BaseResponse;
import com.example.axa_test.model.recordDto.UserRequest;
import com.example.axa_test.model.recordDto.UserResponse;
import com.example.axa_test.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @GetMapping("")
  public ResponseEntity<?> getUsers() {
    return ResponseEntity.ok(
      new BaseResponse<List<UserResponse>>(HttpStatus.OK, "Berhasil mendapatkan data", userService.getAllUser())
    );
  }

  @PostMapping("")
  public ResponseEntity<?> addUser(@RequestBody UserRequest request) {
      return ResponseEntity.ok(
        new BaseResponse<UserResponse>(HttpStatus.CREATED, "Berhasil membuat user!", userService.createUser(request))
      );
  }
  

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(
      new BaseResponse<UserResponse>(HttpStatus.OK, "Berhasil mendapatkan data", userService.findUserById(id))
    );
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
    return ResponseEntity.ok(
      new BaseResponse<UserResponse>(HttpStatus.OK, "Berhasil memperbarui data!", userService.updateUser(id, request))
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    return ResponseEntity.ok(
      new BaseResponse<String>(HttpStatus.OK, "Berhasil menghapus data!", "User dengan id: " + + userService.delete(id))
    );
  }
}
