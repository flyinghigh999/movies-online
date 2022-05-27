package com.gzmu.server.service.impl;

import com.gzmu.server.entity.ChapterEntity;
import com.gzmu.server.entity.ChapterEntityExample;
import com.gzmu.server.mapper.ChapterMapper;
import com.gzmu.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<ChapterEntity> list() {
        ChapterEntityExample chapterExample = new ChapterEntityExample();
        chapterExample.createCriteria().andIdEqualTo("1");
        chapterExample.setOrderByClause("id asc");
        //select id, course_id, `name` from chapter WHERE ( id = ? ) order by id asc
        return chapterMapper.selectByExample(chapterExample);
    }
}
