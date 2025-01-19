package com.vodapally.sms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message = "First Name can not be Null")
    @NotBlank(message = "FirstName can not be blank")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(regexp = "^(.+)@(.+)$", message = "Please enter a valid email id")
    @NotEmpty(message = "email can not be empty")
    @Column(name = "email")
    private String email;
}
