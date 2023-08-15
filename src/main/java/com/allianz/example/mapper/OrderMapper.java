package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.PageDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    OrderItemMapper orderItemMapper;


    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(entity.getId());
        orderDTO.setUuid(entity.getUuid());
        orderDTO.setCreationDate(entity.getCreationDate());
        orderDTO.setUpdatedDate(entity.getUpdatedDate());
        orderDTO.setOrderStatus(entity.getOrderStatus());
        orderDTO.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));
        orderDTO.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        orderDTO.setTotalSellPrice(entity.getTotalSellPrice());

        return orderDTO;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setUuid(dto.getUuid());
        orderEntity.setCreationDate(dto.getCreationDate());
        orderEntity.setUpdatedDate(dto.getUpdatedDate());
        orderEntity.setOrderStatus(dto.getOrderStatus());
        orderEntity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        orderEntity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        orderEntity.setTotalSellPrice(dto.getTotalSellPrice());

        return orderEntity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {

        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (OrderEntity order : orderEntities){
            orderDTOList.add(entityToDTO(order));
        }
        return orderDTOList;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {

        List<OrderEntity> orderEntityList = new ArrayList<>();

        for (OrderDTO order : orderDTOS) {
            orderEntityList.add(dtoToEntity(order));
        }
        return orderEntityList;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(dto.getId());
        orderEntity.setUuid(dto.getUuid());
        orderEntity.setCreationDate(dto.getCreationDate());
        orderEntity.setUpdatedDate(dto.getUpdatedDate());
        orderEntity.setOrderStatus(dto.getOrderStatus());
        orderEntity.setOrderItemList(orderItemMapper.requestDtoListTOEntityList(dto.getOrderItemList()));
        orderEntity.setTotalSellPrice(dto.getTotalSellPrice());

        return orderEntity;
    }

    @Override
    public List<OrderEntity> requestDtoListTOEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToExistEntity(OrderRequestDTO orderRequestDTO, OrderEntity entity) {
        return null;
    }

    @Override
    public PageDTO<OrderDTO> pageEntityToPageDTO(Page<OrderEntity> orderEntities) {
        return null;
    }
}
