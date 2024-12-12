package com.api.dtos.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    @JsonSerialize
    private String title;

    @JsonSerialize
    private String detail;

    public ErrorResponse(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public ErrorResponse(ObjectError error) {
        this.title = error.getDefaultMessage();
        this.detail = "Please provide a valid " + ((FieldError) error).getField() + ".";
    }

    // Called by controllers when there's a Hibernate Validation error
    public static List<ErrorResponse> buildErrors(BindingResult errors) {
        List<ErrorResponse> res = new ArrayList<>();

        for (ObjectError e : errors.getAllErrors()) {
            res.add(new ErrorResponse(e));
        }

        return res;
    }
}
