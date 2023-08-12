package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryRequestDTO extends BaseDTO {

    private String name;
    private Set<ProductRequestDTO> productList;
}
