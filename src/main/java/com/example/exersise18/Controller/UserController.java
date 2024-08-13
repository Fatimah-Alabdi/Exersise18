package com.example.exersise18.Controller;

import com.example.exersise18.Api.ApiResponse;
import com.example.exersise18.Model.User;
import com.example.exersise18.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser() {
       return ResponseEntity.status(200).body(userService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse( "User added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        userService.UpdateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse( "User updated successfully"));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse( "User deleted successfully"));
    }
    @PostMapping("/check")
    public ResponseEntity checkPasswordAndUsername(@RequestParam String username, @RequestParam String password) {
        User user = userService.findByUserNameAndPassword(username, password);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/findbyemail")
    public ResponseEntity findUserByEmail(@RequestParam String email) {
        User u=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(u);
    }
    @GetMapping("/getuserbyrole")
    public ResponseEntity getUsersByRole(@RequestParam String role) {

        List<User>u = userService.findUserByRole(role);
        return ResponseEntity.status(200).body(u);

    }
    @GetMapping("/finduserbyage")
    public ResponseEntity finuserByAgeOrAbove(@RequestParam int age) {
        List<User> users=userService.findUserByAgeorAbove(age);
        return ResponseEntity.status(200).body(users);
    }

}
