package com.example.servis7;

import org.springframework.data.jpa.repository.JpaRepository;

// Інтерфейс для роботи з базою даних через JPA
public interface CourseRepository extends JpaRepository<Course, Long> {
    // JpaRepository вже надає всі необхідні методи для CRUD операцій
}
