package com.foodApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.servlet.ModelAndView;

import com.foodApp.models.food;
import com.foodApp.repository.foodRepository;

@Controller
public class foodController {
    @Autowired
    private foodRepository fr;

    @RequestMapping(value = "/addFood", method = RequestMethod.GET)
    public String form(){
        return "food/formFood";
    }
    
    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public String form(food food){
        fr.save(food);
        return "redirect:/addFood";
    }
    @RequestMapping("/food")
    public ModelAndView foodList(){
         ModelAndView mv  = new ModelAndView("index");
         Iterable<food> foods = fr.findAll();
        mv.addObject("foods", foods);
        return mv;
    }
}
