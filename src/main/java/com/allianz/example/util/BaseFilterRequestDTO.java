package com.allianz.example.util;

import com.allianz.example.model.SortDTO;
import lombok.Data;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sortDTO;
}
