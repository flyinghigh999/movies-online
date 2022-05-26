package com.gzmu.servive.impl;

import com.gzmu.mapper.TestMapper;
import com.gzmu.servive.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public String getUser() {
        return testMapper.getUser();
    }
}
