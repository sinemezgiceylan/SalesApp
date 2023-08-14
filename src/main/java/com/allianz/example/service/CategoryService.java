package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO, CategoryRequestDTO,
        IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO>,
        IBaseRepository<CategoryEntity>> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public CategoryMapper getMapper() {
        return categoryMapper;
    }

    @Override
    public CategoryEntityRepository getRepository() {
        return categoryEntityRepository;
    }
}
