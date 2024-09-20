package com.springleaf.oneblog.mapper;

import com.springleaf.oneblog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<Article> findAllArticles();
}
