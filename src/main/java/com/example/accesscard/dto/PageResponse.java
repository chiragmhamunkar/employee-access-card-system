package com.example.accesscard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse <T>{
    private int pageNo;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private int dataSize;

    private List<T> data;

}
