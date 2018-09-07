package com.bank.xyzbank.controller;

import com.bank.xyzbank.model.BankUser;
import com.bank.xyzbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value = "name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@RequestBody BankUser bankUser) {
        int createdUserId = userService.addUserToBank(bankUser);
        return "User added successfully with user ID: " + createdUserId;
    }

}
