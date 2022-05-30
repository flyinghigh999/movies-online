package com.gzmu.server.service;

import com.gzmu.server.entity.ChapterEntity;
import com.gzmu.server.view.ChapterView;
import com.gzmu.server.view.PageModel;

import java.util.List;

public interface ChapterService {

    PageModel<ChapterView> list(PageModel pageModel);
}
