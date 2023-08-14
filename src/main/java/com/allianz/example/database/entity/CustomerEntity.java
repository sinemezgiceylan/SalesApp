package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
public class CustomerEntity extends BaseEntity {

    @OneToOne
    private PersonEntity person;

    @Column
    private Boolean isCorporate;

    @Column
    private String CompanyName;

    @Column
    private String taxNumber;

    @Column
    private String taxOffice;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<OrderEntity> orderList;
}
