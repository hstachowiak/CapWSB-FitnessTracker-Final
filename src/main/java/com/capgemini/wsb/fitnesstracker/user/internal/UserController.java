package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) throws InterruptedException {
        // Demonstracja how to use @RequestBody
        System.out.println("User with e-mail: " + userDto.email() + " passed to the request");

        User createdUser = userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // Zmiana statusu na 201
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // Zmiana statusu na 204
    }
}
