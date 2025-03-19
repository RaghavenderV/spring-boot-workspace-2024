package com.vodapally.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TBL",
            joinColumns = {
            @JoinColumn(name = "student_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id")
            }
    )
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
    //@JsonManagedReference // stackoverflow error for lombok issue - not related to jpa
    private Set<Course> courses = new HashSet<>();
}
