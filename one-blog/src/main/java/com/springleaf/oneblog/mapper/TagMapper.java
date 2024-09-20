package com.springleaf.oneblog.mapper;

import com.springleaf.oneblog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    List<Tag> findTagsByArticleId(Long id);

    List<Long> findHotTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIdsList);
}
