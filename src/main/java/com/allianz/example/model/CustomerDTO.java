package com.allianz.example.model;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO extends BaseDTO {

    private PersonDTO person;
    private Boolean isCorporate;
    private String CompanyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderDTO> orderList;

}
