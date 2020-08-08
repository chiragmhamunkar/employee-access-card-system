package com.example.accesscard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Data
public class PageRequestParams {

    protected int page = 0;
    protected int size = 100;

}
