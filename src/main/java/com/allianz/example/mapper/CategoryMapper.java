package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.PageDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

    @Autowired
    @Lazy
    ProductMapper productMapper;

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(entity.getId());
        categoryDTO.setUuid(entity.getUuid());
        categoryDTO.setCreationDate(entity.getCreationDate());
        categoryDTO.setUpdatedDate(entity.getUpdatedDate());

        Set<ProductDTO> productDTOS = new HashSet<>();
        productDTOS.addAll(new ArrayList<>(productMapper.entityListToDTOList(new ArrayList<>(entity.getProductList()))));
        categoryDTO.setProductList(productDTOS);

        return categoryDTO;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setCreationDate(dto.getCreationDate());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setName(dto.getName());

        Set<ProductEntity> productEntities = new HashSet<>();
        productEntities.addAll(new ArrayList<>(productMapper.dtoListTOEntityList(new ArrayList<>(dto.getProductList()))));
        categoryEntity.setProductList(productEntities);

        return categoryEntity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (CategoryEntity category : categoryEntities) {
            categoryDTOList.add(entityToDTO(category));
        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {

        List<CategoryEntity> categoryEntityList = new ArrayList<>();

        for (CategoryDTO category : categoryDTOS) {
            categoryEntityList.add(dtoToEntity(category));
        }
        return categoryEntityList;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setUuid(dto.getUuid());
        categoryEntity.setCreationDate(dto.getCreationDate());
        categoryEntity.setUpdatedDate(dto.getUpdatedDate());
        categoryEntity.setName(dto.getName());

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> requestDtoListTOEntityList(List<CategoryRequestDTO> categoryRequestDTOS) {
        return null;
    }

    @Override
    public CategoryEntity requestDTOToExistEntity(CategoryRequestDTO categoryRequestDTO, CategoryEntity entity) {
        return null;
    }

    @Override
    public PageDTO<CategoryDTO> pageEntityToPageDTO(Page<CategoryEntity> categoryEntities) {
        return null;
    }
}
