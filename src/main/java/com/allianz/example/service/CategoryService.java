package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO, CategoryRequestDTO> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryEntity createCategory(String name) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(name);
        return categoryEntityRepository.save(categoryEntity);
    }


    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntityListEntityList = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntityListEntityList);
    }

    public CategoryDTO getByUUID(UUID uuid) {

        Optional<CategoryEntity> categoryEntityOptional = categoryEntityRepository.findByUuid(uuid);

        return categoryEntityOptional.map(categoryEntity -> categoryMapper.entityToDTO(categoryEntity)).orElse(null);

    }



    @Transactional
    public boolean deleteBillByUuid(UUID uuid) {
        return deleteEntityByUuid(uuid);
    }


}
