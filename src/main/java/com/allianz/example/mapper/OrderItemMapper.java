package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {

        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(entity.getId());
        orderItemDTO.setUuid(entity.getUuid());
        orderItemDTO.setCreationDate(entity.getCreationDate());
        orderItemDTO.setUpdatedDate(entity.getUpdatedDate());
        orderItemDTO.setProduct(productMapper.entityToDTO(entity.getProduct()));
        orderItemDTO.setQuantity(entity.getQuantity());
        orderItemDTO.setSellPrice(entity.getSellPrice());

        return orderItemDTO;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setCreationDate(dto.getCreationDate());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setSellPrice(dto.getSellPrice());

        return orderItemEntity;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();

        for (OrderItemEntity orderItem : orderItemEntities) {
            orderItemDTOList.add(entityToDTO(orderItem));
        }
        return orderItemDTOList;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {

        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();

        for (OrderItemDTO orderItem : orderItemDTOS) {
            orderItemEntityList.add(dtoToEntity(orderItem));
        }
        return orderItemEntityList;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setCreationDate(dto.getCreationDate());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setProduct(productMapper.requestDTOToEntity(dto.getProduct()));
        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setSellPrice(dto.getSellPrice());

        return orderItemEntity;
    }

    @Override
    public List<OrderItemEntity> requestDtoListTOEntityList(List<OrderItemRequestDTO> orderItemRequestDTOS) {

        List<OrderItemEntity> entityList = new ArrayList<>();

        for (OrderItemRequestDTO orderItem : orderItemRequestDTOS) {
            entityList.add(requestDTOToEntity(orderItem));
        }

        return entityList;
    }
}
