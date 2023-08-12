package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    public OrderItemEntity createOrderItem(OrderItemRequestDTO request) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        if (request.getProduct() != null) {
            ProductEntity productEntity = productEntityRepository.findById(request.getProduct().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + request.getProduct().getId()));
            orderItemEntity.setProduct(productEntity);
        }

        orderItemEntity.setQuantity(request.getQuantity());
        orderItemEntity.setSellPrice(request.getSellPrice());

        orderItemEntityRepository.save(orderItemEntity);

        return orderItemEntity;
    }

    public List<OrderItemDTO> getAll() {
        List<OrderItemEntity> orderItemEntityList = orderItemEntityRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntityList);
    }

    public OrderItemDTO getByUUID(UUID uuid) {

        Optional<OrderItemEntity> orderItemEntityOptional = orderItemEntityRepository.findByUuid(uuid);

        return orderItemEntityOptional.map(orderItemEntity -> orderItemMapper.entityToDTO(orderItemEntity)).orElse(null);

    }
}
