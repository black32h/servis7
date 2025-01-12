package com.example.servis7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // Вказуємо, що цей клас є сутністю для бази даних
public class Course {

    @Id  // Вказуємо, що це поле є первинним ключем
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматично генеруємо значення для id
    private Long id;

    private String name;  // Назва курсу
    private String description;  // Опис курсу
    private String instructor;  // Ім'я викладача

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для назви курсу
    public String getName() {
        return name;
    }

    // Сеттер для назви курсу
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для опису курсу
    public String getDescription() {
        return description;
    }

    // Сеттер для опису курсу
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для викладача
    public String getInstructor() {
        return instructor;
    }

    // Сеттер для викладача
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
