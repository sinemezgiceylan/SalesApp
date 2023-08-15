package com.allianz.example.model;

import lombok.Data;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.springframework.data.domain.Sort;

@Data
public class SortDTO {

    private String columnName;
    private Sort.Direction directionEnum;
}
