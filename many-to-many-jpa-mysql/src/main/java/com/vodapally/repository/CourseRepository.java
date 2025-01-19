package com.vodapally.repository;

import com.vodapally.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByFeeLessThan(double fee);
}
