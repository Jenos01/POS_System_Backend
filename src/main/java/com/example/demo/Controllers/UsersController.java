package com.example.demo.Controllers;


import com.example.demo.Entity.Users;
import com.example.demo.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public Users addUser(@RequestBody Users user) {
        return usersService.adduser(user);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

//    @DeleteMapping
//    public void deleteUser(@RequestBody Users user) {
//         usersService.deleteUsers(user);
//    }



}
