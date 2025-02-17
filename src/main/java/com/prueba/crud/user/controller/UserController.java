package com.prueba.crud.user.controller;

import com.prueba.crud.user.model.User;
import com.prueba.crud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        Optional<User> user = userService.getUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userSaved = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
