package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AccountDto;
import com.example.zorgappfinal.dto.ImageDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.models.Account;
import com.example.zorgappfinal.models.Image;
import com.example.zorgappfinal.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    ImageRepository imageRepository;

    public ImageDto getImageById(Long id) {
        if (imageRepository.findById(id).isPresent()) {
            Image image = imageRepository.findById(id).get();
            ImageDto dto = transfertoDto(image);
            return dto;
        } else {
            throw new RecordNotFoundException("No client found");
        }
    }


    public ImageDto transfertoDto(Image image) {
        ImageDto dto = new ImageDto();

        dto.setId(image.getId());
        dto.setContent(image.getContent());

        return dto;

    }
}
