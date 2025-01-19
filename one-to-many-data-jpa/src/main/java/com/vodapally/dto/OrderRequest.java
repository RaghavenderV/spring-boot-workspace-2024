package com.vodapally.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderRequest<T> {
   private T customer;
}
