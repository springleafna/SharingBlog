package com.springleaf.oneblog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springleaf.oneblog.mapper.ArticleMapper;
import com.springleaf.oneblog.pojo.Article;
import com.springleaf.oneblog.pojo.PageBean;
import com.springleaf.oneblog.pojo.Result;
import com.springleaf.oneblog.pojo.SysUser;
import com.springleaf.oneblog.service.IArticleService;
import com.springleaf.oneblog.service.ISysUserService;
import com.springleaf.oneblog.service.ITagService;
import com.springleaf.oneblog.vo.ArticleVo;
import com.springleaf.oneblog.vo.PageParams;
import com.springleaf.oneblog.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ITagService tagService;
    @Autowired
    ISysUserService sysUserService;

    @Override
    public Result listArticlePage(PageParams pageParams) {
        //1.开启分页查询  使用PageHelper
        PageHelper.startPage(pageParams.getPage(), pageParams.getPageSize());
        //2.获取全部article
        List<Article> articleList = articleMapper.findAllArticles();
        if (CollectionUtil.isEmpty(articleList)) {
            return Result.success(Collections.emptyList());
        }
        //我们虽然获取了所有的文章，但是我们展示给用户的并非是文章的所有信息，有些信息我们并不想展示给用户
        //所有要将文章集合转换成对应的Vo集合
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : articleList) {
            ArticleVo articleVo = BeanUtil.copyProperties(article, ArticleVo.class);
            articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));

            List<TagVo> tags = tagService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);

            SysUser sysUser = sysUserService.findUserById(article.getId());
            articleVo.setAuthor(sysUser.getNickname());
            articleVoList.add(articleVo);
        }

        //3.将articleVoList强转为Page对象(Page类在package com.github.pageHelper中)
        //Page中提供了方法，可以获取PageHelper分页查询后得到的总记录条数和当前页数据
        Page<ArticleVo> articlePage = (Page<ArticleVo>) articleVoList;
        //4.创建PageBean对象，用来封装查询到的数据
        PageBean<ArticleVo> pb = new PageBean<>();
        //把数据填充到PageBean对象中
        pb.setTotal(articlePage.getTotal());//获取全部数据条数
        pb.setItems(articlePage.getResult());//获取当前要展示的数据，根据pageNum和pageSize
        return Result.success(pb);
    }
}
