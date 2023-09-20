package com.foodApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class foodController {
    @RequestMapping("/addFood")
    public String form(){
        return "food/formFood";
    }
}
