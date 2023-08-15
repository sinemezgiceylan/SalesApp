package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class PageDTO<DTO extends BaseDTO> {

    private int totalPage;

    private long totalElements;

    private int number;

    private int size;

    private int numberOfElement;

    private List<DTO> content;

    private boolean isContent;

    private Sort sort;

}
