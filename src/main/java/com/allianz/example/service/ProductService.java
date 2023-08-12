package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TaxEntityRepository taxEntityRepository;

    public ProductEntity createProduct(ProductRequestDTO request) {
        ProductEntity productEntity = new ProductEntity();
        if (request.getTax() != null) {
            TaxEntity taxEntity = taxEntityRepository.findById(request.getTax().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + request.getTax().getId()));
            productEntity.setTax(taxEntity);
        }

        productEntity.setBuyPrice(request.getBuyPrice());
        productEntity.setCode(request.getCode());
        productEntity.setName(request.getName());
        productEntity.setQuantity(request.getQuantity());
        productEntity.setBuyPrice(request.getBuyPrice());
        productEntity.setColor(request.getColor());
        productEntity.setCategoryList(request.getCategory());
        productEntity.setSellPrice(request.getSellPrice());

        productEntityRepository.save(productEntity);

        return productEntity;
    }

    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntityList);
    }

    public ProductDTO getByUUID(UUID uuid) {

        Optional<ProductEntity> productEntityOptional = productEntityRepository.findByUuid(uuid);

        return productEntityOptional.map(productEntity -> productMapper.entityToDTO(productEntity)).orElse(null);

    }
}
