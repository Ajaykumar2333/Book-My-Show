package com.example.Book_My_Show.Controller;


import com.example.Book_My_Show.DTO.UserDto;
import com.example.Book_My_Show.Models.UserEntity;
import com.example.Book_My_Show.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userDto){
        return userService.createUSer(userDto);

    }
}
