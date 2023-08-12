package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    public OrderEntity createOrder(OrderRequestDTO request) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderStatus(request.getOrderStatus());
        orderEntity.setOrderItemList(request.getOrderItemList());
        orderEntity.setCustomer(request.getCustomer());
        orderEntity.setTotalSellPrice(request.getTotalSellPrice());

        orderEntityRepository.save(orderEntity);

        return orderEntity;
    }

    public List<OrderDTO> getAll() {
        List<OrderEntity> orderEntityList = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntityList);
    }

    public OrderDTO getByUUID(UUID uuid) {

        Optional<OrderEntity> orderEntityOptional = orderEntityRepository.findByUuid(uuid);

        return orderEntityOptional.map(orderEntity -> orderMapper.entityToDTO(orderEntity)).orElse(null);

    }
}
