package com.gzmu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestMapper {

    public String getUser();

}
