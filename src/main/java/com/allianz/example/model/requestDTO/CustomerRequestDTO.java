package com.allianz.example.model.requestDTO;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequestDTO extends BaseDTO {

    private PersonRequestDTO person;
    private Boolean isCorporate;
    private String CompanyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderRequestDTO> orderList;
}
