package com.gzmu.server.service.impl;

import com.gzmu.server.entity.TestEntity;
import com.gzmu.server.mapper.TestMapper;
import com.gzmu.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public List<TestEntity> getUser() {
        return testMapper.selectByExample(null);
    }
}
