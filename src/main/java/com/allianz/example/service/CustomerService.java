package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, CustomerRequestDTO> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PersonEntityRepository personEntityRepository;

    public CustomerEntity createCustomer(CustomerRequestDTO request) {
        CustomerEntity customerEntity = new CustomerEntity();

        PersonEntity personEntity = personEntityRepository.findById(request.getPerson().getId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + request.getPerson().getId()));

        customerEntity.setPerson(personEntity);
        customerEntity.setTaxOffice(request.getTaxOffice());
        customerEntity.setIsCorporate(request.getIsCorporate());
        customerEntity.setTaxNumber(request.getTaxNumber());
        customerEntity.setOrderList(request.getOrderList());
        customerEntity.setCompanyName(request.getCompanyName());

        customerEntityRepository.save(customerEntity);

        return customerEntity;
    }

    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customerEntityList = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(customerEntityList);
    }

    public CustomerDTO getByUUID(UUID uuid) {

        Optional<CustomerEntity> customerEntityOptional = customerEntityRepository.findByUuid(uuid);

        return customerEntityOptional.map(customerEntity -> customerMapper.entityToDTO(customerEntity)).orElse(null);

    }
}
