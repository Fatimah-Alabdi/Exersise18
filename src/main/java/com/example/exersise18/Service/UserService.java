package com.example.exersise18.Service;

import com.example.exersise18.Api.ApiExeption;
import com.example.exersise18.Model.User;
import com.example.exersise18.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);

    }
    public void UpdateUser(Integer id,User user) {
        User user1 = userRepository.findUserById(id);
        if(user1 == null) {
            throw new ApiExeption("no user found");
        }

        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setRole(user.getRole());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);

    }

    public void deleteUser(Integer id) {
        User user = userRepository.findUserById(id);
        if(user == null) {

            throw new ApiExeption("no user found");
        }
        userRepository.delete(user);

    }
    public User  findByUserNameAndPassword(String username, String password) {
        User u1=userRepository.findByUsernameAndPassword(username, password);
        if(u1 == null) {
            throw new ApiExeption("Invalid username or password");
        }

        return u1;

    }
    public User  findUserByEmail(String email) {
        User u1 = userRepository.searchByemeil(email);
        if (u1 == null) {
            throw new ApiExeption("no user found");
        }
        return u1;
    }
    public List<User> findUserByRole(String role) {
        List<User>u1=userRepository.findUserByRole(role);
        if(u1 == null) {
            throw new ApiExeption("no user found");
        }
        return u1;
    }
    public List<User> findUserByAgeorAbove(int age) {
        List<User>u=userRepository.searchUserByAgeOrAbove(age);
        if(u == null) {
            throw new ApiExeption("no user found");
        }
        return u;
    }
}
