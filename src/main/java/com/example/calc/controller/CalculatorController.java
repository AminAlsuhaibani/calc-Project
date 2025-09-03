package com.example.calc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    //for adding two numbers
    @PostMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        return a + b;
    }

    //for subtracting two numbers
    @PostMapping("/sub")
    public Integer sub(@RequestParam Integer a, @RequestParam Integer b) {
        return a - b;
    }

    //for div two number
    @PostMapping("/div")
    public Integer div(@RequestParam Integer a, @RequestParam Integer b) {
        return a / b;
    }
}
