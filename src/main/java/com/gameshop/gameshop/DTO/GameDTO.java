package com.gameshop.gameshop.DTO;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private MultipartFile gameimage;

}
