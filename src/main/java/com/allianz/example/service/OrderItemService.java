package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
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
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemMapper, OrderItemEntityRepository> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Override
    public OrderItemMapper getMapper() {
        return orderItemMapper;
    }

    @Override
    public OrderItemEntityRepository getRepository() {
        return orderItemEntityRepository;
    }
}
