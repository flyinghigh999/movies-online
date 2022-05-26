package com.gzmu.server.service.impl;

import com.gzmu.server.mapper.TestMapper;
import com.gzmu.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public String getUser() {
        return testMapper.getUser();
    }
}
