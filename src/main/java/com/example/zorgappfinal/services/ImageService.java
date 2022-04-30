package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.ImageDto;
import com.example.zorgappfinal.models.Image;
import org.springframework.stereotype.Service;


public interface ImageService {

    public ImageDto getImageById(Long id);
    public ImageDto transfertoDto(Image image);
}
