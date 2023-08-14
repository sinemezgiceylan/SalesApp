package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    @Lazy
    OrderMapper orderMapper;

    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setUuid(entity.getUuid());
        customerDTO.setUpdatedDate(entity.getUpdatedDate());
        customerDTO.setCreationDate(entity.getCreationDate());
        customerDTO.setPerson(personMapper.entityToDTO(entity.getPerson()));
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setIsCorporate(entity.getIsCorporate());
        customerDTO.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setTaxOffice(entity.getTaxOffice());

        return customerDTO;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(dto.getId());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setPerson(personMapper.dtoToEntity(dto.getPerson()));
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (CustomerEntity customer : customerEntities) {
            customerDTOList.add(entityToDTO(customer));
        }

        return customerDTOList;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {

        List<CustomerEntity> customerEntityList = new ArrayList<>();

        for (CustomerDTO customer : customerDTOS) {
            customerEntityList.add(dtoToEntity(customer));
        }

        return customerEntityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(dto.getId());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setPerson(personMapper.requestDTOToEntity(dto.getPerson()));
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }

    @Override
    public List<CustomerEntity> requestDtoListTOEntityList(List<CustomerRequestDTO> customerRequestDTOS) {
        return null;
    }

    @Override
    public CustomerEntity requestDTOToExistEntity(CustomerRequestDTO customerRequestDTO, CustomerEntity entity) {
        return null;
    }
}
