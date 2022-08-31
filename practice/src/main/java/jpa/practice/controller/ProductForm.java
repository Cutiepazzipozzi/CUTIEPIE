package jpa.practice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.File;

@Getter
@Setter
public class ProductForm {

    private String id;
    @NotEmpty
    private String pName;

    private int price;

    private int stock;

    private MultipartFile file;
}
