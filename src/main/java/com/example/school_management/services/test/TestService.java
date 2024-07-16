package com.example.school_management.services.test;

import com.example.school_management.entities.TestEntity;

import java.util.List;

public interface TestService {
    TestEntity addTest(TestEntity testEntity);

    List<TestEntity> getTests();
}
