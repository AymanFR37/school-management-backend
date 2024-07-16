package com.example.school_management.controllers;

import com.example.school_management.entities.TestEntity;
import com.example.school_management.services.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping
    public TestEntity addTest(@RequestBody TestEntity testEntity) {
        return testService.addTest(testEntity);
    }

    @GetMapping
    public List<TestEntity> getTest() {
        return testService.getTests();
    }
}
