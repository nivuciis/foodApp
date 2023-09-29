package com.dev.foodapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.foodapp.Entity.FoodImage;
import com.dev.foodapp.Services.FoodImageService;

@RestController
@RequestMapping("/api/foodimages")
public class FoodImageController {
    
    @Autowired
    private FoodImageService imageService;

    @GetMapping("/")
    public List<FoodImage> searchAll(){
       return imageService.searchAll();
    }

    @PostMapping("/")
    public FoodImage insert(@RequestParam("idFood") Long idFood,@RequestParam MultipartFile file){
        return imageService.insert(idFood, file);
    }
    @PutMapping
    public FoodImage changue(@RequestParam("idFood") Long idFood,@RequestParam MultipartFile file){
        return imageService.insert(idFood, file);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        imageService.delete(id);
        return ResponseEntity.ok().build();
    }
}
