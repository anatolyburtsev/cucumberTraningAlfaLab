package ru.onotole.cucuEdu.cucuEduRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.onotole.cucuEdu.cucuEduRest.entities.Operation;
import ru.onotole.cucuEdu.cucuEduRest.entities.User;
import ru.onotole.cucuEdu.cucuEduRest.services.UserService;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/{userName}")
    public User createUser(@PathVariable("userName") String userName,
                           @RequestHeader(value = "vip", defaultValue = "false") Boolean vip,
                           @RequestParam(value = "initialSum", required = false) Integer initialSum) {
        return userService.createUser(userName, vip, initialSum);
    }

    @GetMapping(value = "/user/{userName}")
    public User getUser(@PathVariable("userName") String userName) {
        return userService.getUser(userName);
    }

    @PostMapping(value = "/user/{userName}/change")
    public User changeMoney(@PathVariable("userName") String userName,
                            @RequestBody @Valid Operation operation) {
        return userService.performOperation(userName, operation);
    }
}
