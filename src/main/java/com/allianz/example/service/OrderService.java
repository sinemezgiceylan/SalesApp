package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO,
        OrderMapper, OrderEntityRepository> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Override
    public OrderMapper getMapper() {
        return orderMapper;
    }

    @Override
    public OrderEntityRepository getRepository() {
        return orderEntityRepository;
    }
}
