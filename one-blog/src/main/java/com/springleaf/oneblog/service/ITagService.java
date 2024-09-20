package com.springleaf.oneblog.service;

import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.vo.TagVo;

import java.util.List;

public interface ITagService {
    List<TagVo> findTagsByArticleId(Long id);

    Result hot(int limit);
}
