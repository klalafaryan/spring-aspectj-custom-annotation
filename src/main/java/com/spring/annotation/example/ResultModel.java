package com.spring.annotation.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResultModel<T> {

    @JsonProperty
    private T result;

    @JsonProperty(value = "errors", required = false)
    private List<String> errors;

    public ResultModel(final T result) {
        this();
        this.result = result;
    }

    public ResultModel(final List<String> errors) {
        this.errors = errors;
    }

    public ResultModel() {
        this.errors = new ArrayList<>();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
