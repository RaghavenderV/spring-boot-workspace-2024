package com.vodapally.spring_boot_interceptor_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
