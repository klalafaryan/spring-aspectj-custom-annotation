package com.spring.annotation.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ResultModel<String>> create(@RequestBody final CreateUserRequestModel createUserRequestModel) {
        ResultModel<String> resultModel = userService.create(createUserRequestModel);
        return ResponseEntity.ok(resultModel);
    }
}