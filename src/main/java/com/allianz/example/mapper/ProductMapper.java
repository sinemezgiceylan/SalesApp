package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.*;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
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
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Autowired
    @Lazy
    CategoryMapper categoryMapper;
    @Autowired
    TaxMapper taxMapper;

    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setCreationDate(entity.getCreationDate());
        productDTO.setUuid(entity.getUuid());
        productDTO.setUpdatedDate(entity.getUpdatedDate());
        productDTO.setCode(entity.getCode());
        productDTO.setColor(entity.getColor());
        productDTO.setBuyPrice(entity.getBuyPrice());
        productDTO.setName(entity.getName());
        productDTO.setTax(taxMapper.entityToDTO(entity.getTax()));
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setSellPrice(entity.getSellPrice());
        Set<CategoryDTO> categoryDTOS = new HashSet<>(new ArrayList<>
                (categoryMapper.entityListToDTOList(new ArrayList<>(entity.getCategoryList()))));
        productDTO.setCategoryList(categoryDTOS);

        return productDTO;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(dto.getId());
        productEntity.setCreationDate(dto.getCreationDate());
        productEntity.setUuid(dto.getUuid());
        productEntity.setUpdatedDate(dto.getUpdatedDate());
        productEntity.setCode(dto.getCode());
        productEntity.setColor(dto.getColor());
        productEntity.setBuyPrice(dto.getBuyPrice());
        productEntity.setName(dto.getName());
        productEntity.setTax(taxMapper.dtoToEntity(dto.getTax()));
        productEntity.setQuantity(dto.getQuantity());
        productEntity.setSellPrice(dto.getSellPrice());
        Set<CategoryEntity> categoryEntities = new HashSet<>(new ArrayList<>
                (categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
        productEntity.setCategoryList(categoryEntities);

        return productEntity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {

        List<ProductDTO> productDTOList = new ArrayList<>();

        for (ProductEntity product : productEntities) {
            productDTOList.add(entityToDTO(product));
        }
        return productDTOList;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {

        List<ProductEntity> productEntityList = new ArrayList<>();

        for (ProductDTO product : productDTOS) {
            productEntityList.add(dtoToEntity(product));
        }
        return productEntityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(dto.getId());
        productEntity.setCreationDate(dto.getCreationDate());
        productEntity.setUuid(dto.getUuid());
        productEntity.setUpdatedDate(dto.getUpdatedDate());
        productEntity.setCode(dto.getCode());
        productEntity.setColor(dto.getColor());
        productEntity.setBuyPrice(dto.getBuyPrice());
        productEntity.setName(dto.getName());
        productEntity.setTax(taxMapper.requestDTOToEntity(dto.getTax()));
        productEntity.setQuantity(dto.getQuantity());
        productEntity.setSellPrice(dto.getSellPrice());
        Set<CategoryEntity> categoryEntities = new HashSet<>(new ArrayList<>
                (categoryMapper.requestDtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
        productEntity.setCategoryList(categoryEntities);

        return productEntity;
    }

    @Override
    public List<ProductEntity> requestDtoListTOEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }

    @Override
    public ProductEntity requestDTOToExistEntity(ProductRequestDTO productRequestDTO, ProductEntity entity) {
        return null;
    }

    @Override
    public PageDTO<ProductDTO> pageEntityToPageDTO(Page<ProductEntity> productEntities) {
        return null;
    }
}
