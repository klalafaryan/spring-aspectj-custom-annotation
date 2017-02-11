package com.spring.annotation.example;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @ValidateRequest
    public ResultModel<String> create(final CreateUserRequestModel userRequestModel) {
        //Returning result model object
        return new ResultModel<>(userRequestModel.getFirstName() + ", " + userRequestModel.getLastName());
    }
}
