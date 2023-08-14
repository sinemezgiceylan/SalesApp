package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "tax_uuid"
        )
)
public class TaxEntity extends BaseEntity {

    @Column
    private String name;

    @Column(unique = true)
    private String code;

    @Column
    private BigDecimal rate;

}
