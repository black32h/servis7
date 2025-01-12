package com.example.servis7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(CourseUpdateService.class);

    @Value("${course.service.url}")
    private String courseServiceUrl;

    @Value("${enrollment.service.url}")
    private String enrollmentServiceUrl;

    private final RestTemplate restTemplate;

    public CourseUpdateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> updateCourseDescriptions() {
        List<String> updatedCourses = new ArrayList<>();

        try {
            // Отримуємо всі курси
            String coursesUrl = courseServiceUrl + "/courses";
            Course[] allCourses = restTemplate.getForObject(coursesUrl, Course[].class);

            if (allCourses != null) {
                for (Course course : allCourses) {
                    // Отримуємо список студентів для курсу
                    String enrollmentUrl = enrollmentServiceUrl + "/enrollments/courses/" + course.getId();
                    Long[] enrolledStudents = restTemplate.getForObject(enrollmentUrl, Long[].class);

                    // Якщо студентів немає, оновлюємо опис курсу
                    if (enrolledStudents == null || enrolledStudents.length == 0) {
                        course.setDescription(course.getDescription() + " Набір студентів ще не відкрито.");
                        restTemplate.put(courseServiceUrl + "/courses/" + course.getId(), course);
                        updatedCourses.add(course.getName());
                    } else {
                        logger.info("Курс '{}' вже має студентів. Оновлення не потрібне.", course.getName());
                    }
                }
            } else {
                logger.warn("Не вдалося отримати курси за адресою: {}", coursesUrl);
            }
        } catch (Exception e) {
            logger.error("Помилка при оновленні опису курсів: {}", e.getMessage(), e);
        }

        return updatedCourses;
    }
}
