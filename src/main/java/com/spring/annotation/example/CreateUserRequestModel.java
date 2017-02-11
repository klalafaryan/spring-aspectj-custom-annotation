package com.spring.annotation.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateUserRequestModel extends AbstractRequestModel {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public List<String> validateFields() {
        final List<String> errors = new ArrayList<>();

        if (StringUtils.isEmpty(firstName)) {
            errors.add("First name can't be empty");
        }

        if (StringUtils.isEmpty(lastName)) {
            errors.add("Last name can't be empty");
        }

        return errors;
    }
}
