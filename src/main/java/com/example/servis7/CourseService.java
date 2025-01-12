package com.example.servis7;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Метод для створення нового курсу
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Метод для отримання курсу за його id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    // Метод для оновлення курсу
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourseById(id);
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setInstructor(course.getInstructor());
        return courseRepository.save(existingCourse);
    }

    // Метод для видалення курсу
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    // Метод для отримання всіх курсів
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

