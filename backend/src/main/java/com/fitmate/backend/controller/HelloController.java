package com.fitmate.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "hello", description = "Hello API")
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping(value="/world")
    @Operation(summary = "테스트용 hello world" , description = "hello world")
    public String hello(String msg){
        return msg;
    }
}
