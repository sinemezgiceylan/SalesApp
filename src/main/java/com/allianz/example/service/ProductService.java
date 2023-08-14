package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO,
        IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO>,
        IBaseRepository<ProductEntity>> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TaxEntityRepository taxEntityRepository;


    @Override
    public ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    public ProductEntityRepository getRepository() {
        return productEntityRepository;
    }
}
