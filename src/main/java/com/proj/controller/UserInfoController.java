package com.proj.controller;


import com.proj.model.UserInfo;
import com.proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

    @GetMapping
    public List<UserInfo> getUserInfos() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/mail/{mail}")
    public UserInfo getUserByMail(@PathVariable  String mail) {
        return userService.getUserByEmail(mail);
    }

    @PutMapping
    public UserInfo updateUserInfo(@RequestBody UserInfo userInfo){
        return userService.updateUser(userInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteUserInfoById(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
