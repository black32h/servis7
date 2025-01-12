package com.example.servis7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseUpdateController {

    private final CourseUpdateService courseUpdateService;

    public CourseUpdateController(CourseUpdateService courseUpdateService) {
        this.courseUpdateService = courseUpdateService;
    }

    @GetMapping("/courses/update-descriptions")
    public ResponseEntity<List<String>> updateCourseDescriptions() {
        List<String> updatedCourses = courseUpdateService.updateCourseDescriptions();
        return ResponseEntity.ok(updatedCourses);
    }
}
