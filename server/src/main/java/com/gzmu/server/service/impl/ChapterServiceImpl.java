package com.gzmu.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzmu.server.entity.ChapterEntity;
import com.gzmu.server.entity.ChapterEntityExample;
import com.gzmu.server.mapper.ChapterMapper;
import com.gzmu.server.service.ChapterService;
import com.gzmu.server.view.ChapterView;
import com.gzmu.server.view.PageModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public PageModel<ChapterView> list(PageModel pageModel) {
        PageHelper.startPage(pageModel.getPageNum(),pageModel.getPageSize());
//        chapterExample.createCriteria().andIdEqualTo("1");
//        chapterExample.setOrderByClause("id asc");
        //select id, course_id, `name` from chapter WHERE ( id = ? ) order by id asc

        //执行业务，查询chapter表里id等于1的数据，并且升序排列
        ChapterEntityExample chapterExample = new ChapterEntityExample();
        List<ChapterEntity> chapterEntity = chapterMapper.selectByExample(chapterExample);

        //数据处理
        PageInfo<ChapterEntity> pageInfo = new PageInfo<>(chapterEntity);
        pageModel.setTotal(pageInfo.getTotal());
        List<ChapterView> chapterViews = convertChapterViewListfromEntity(chapterEntity);
        pageModel.setList(chapterViews);
        return pageModel;

    }


    /**
     * 实体类型转换-->entity->view
     * @param chapterEntity
     * @return
     */
    private ChapterView convertViewformChapterEntity(ChapterEntity chapterEntity){
        if(chapterEntity == null){
            return null;
        }
        ChapterView chapterView = new ChapterView();

        //将chapterEntity里的数据--赋值--给chapterView里对应的字段
        BeanUtils.copyProperties(chapterEntity,chapterView);
        return chapterView;
    }

    /**
     * list类型转换-->chapterEntityList->chapterViewList
     * @param chapterEntityList
     * @return
     */
    private List<ChapterView> convertChapterViewListfromEntity(List<ChapterEntity> chapterEntityList){
        if(chapterEntityList.isEmpty()){
            return null;
        }
        List<ChapterView> chapterViewList = new ArrayList<>();
        ChapterView chapterView = new ChapterView();
        for(ChapterEntity entity:chapterEntityList){
            BeanUtils.copyProperties(entity,chapterView);
            chapterViewList.add(chapterView);
        }
        return chapterViewList;
    }

}
