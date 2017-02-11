package com.spring.annotation.example;

import java.util.List;

public abstract class AbstractRequestModel {

    /**
     * All Request models should override this abstract method
     * @return the List of errors
     */
    public abstract List<String> validateFields();
}