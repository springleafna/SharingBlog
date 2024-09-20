package com.springleaf.oneblog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.springleaf.oneblog.mapper.TagMapper;
import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.pojo.Tag;
import com.springleaf.oneblog.service.ITagService;
import com.springleaf.oneblog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        return tagMapper.findTagsByArticleId(id)
                .stream()
                .map(tag -> BeanUtil.copyProperties(tag, TagVo.class))
                .collect(Collectors.toList());
    }

    @Override
    public Result hot(int limit) {
        List<Long> tagIdsList = tagMapper.findHotTagIds(limit);
        if (CollectionUtil.isEmpty(tagIdsList)) {
            return Result.success(Collections.emptyList());
        }
        //再通过tagId的集合查找对应的tagName    即tag对象
        //select * from tag where id in(1,2,3,4)
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIdsList);
        return null;
    }
}
