package com.dev.foodapp.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.foodapp.Entity.Food;
import com.dev.foodapp.Entity.FoodImage;
import com.dev.foodapp.Repository.FoodImageRepository;
import com.dev.foodapp.Repository.FoodRepository;

@Service
public class FoodImageService {
    
    @Autowired
    private FoodImageRepository imageRepo;
    @Autowired
    private FoodRepository foodRepo;
    
    //Get
    public List<FoodImage> searchAll(){
        return imageRepo.findAll();
    }

    //Utilizará essa função para o Post e Put
    public FoodImage insert(Long idFood, MultipartFile file){
        Food food = foodRepo.findById(idFood).get();
        FoodImage newImage  = new FoodImage();
        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String imgName = String.valueOf(food.getId()) + file.getOriginalFilename();
				Path pathSource = Paths
						.get("c:/imagens/" +imgName );
                Files.write(pathSource,bytes);
                newImage.setName(imgName);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        newImage.setFood(food);
        newImage = imageRepo.saveAndFlush(newImage);
        return newImage;
    }

    //Delete

    public void delete(Long id){
        FoodImage image = imageRepo.findById(id).get();
        imageRepo.delete(image);
    }


}
