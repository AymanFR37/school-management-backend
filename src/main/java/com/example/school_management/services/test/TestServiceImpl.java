package com.example.school_management.services.test;

import com.example.school_management.entities.TestEntity;
import com.example.school_management.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

    @Override
    public TestEntity addTest(TestEntity testEntity) {
        return testRepository.save(testEntity);
    }

    @Override
    public List<TestEntity> getTests() {
        return testRepository.findAll();
    }
}
