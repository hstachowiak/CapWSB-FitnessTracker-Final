package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    User addUser(UserDto userDto);
    UserDto findUserById(Long id);
    User updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
