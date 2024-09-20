package com.springleaf.oneblog.controller;

import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    ITagService tagService;

    @GetMapping("/hot")
    public Result listHotTags(){
        int limit = 6;
        return tagService.hot(limit);
    }
}
