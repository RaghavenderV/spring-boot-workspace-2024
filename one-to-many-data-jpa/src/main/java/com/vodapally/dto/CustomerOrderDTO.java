package com.vodapally.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {
    private String name;
    private Long count;
    private double price;

}
