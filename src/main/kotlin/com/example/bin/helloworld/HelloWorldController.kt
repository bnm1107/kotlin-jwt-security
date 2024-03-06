package com.example.bin.helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/helloWorld/v1")
class HelloWorldController {

    @GetMapping("/string")
    fun helloWorld(): String{
        return "Hello World"
    }
}