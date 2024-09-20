package com.springleaf.oneblog.service;

import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.vo.PageParams;
import org.springframework.stereotype.Service;

public interface IArticleService {
    Result listArticlePage(PageParams pageParams);
}
