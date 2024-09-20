package com.springleaf.oneblog.controller;

import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.service.IArticleService;
import com.springleaf.oneblog.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    IArticleService articleService;

    @PostMapping
    public Result articles(@RequestBody PageParams pageParams) {
        return articleService.listArticlePage(pageParams);
    }
}
