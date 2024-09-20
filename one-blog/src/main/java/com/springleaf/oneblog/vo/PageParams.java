package com.springleaf.oneblog.vo;

import lombok.Data;

@Data
public class PageParams {
    //当前页数
    private int page = 1;
    //每页条数
    private int pageSize = 10;
}
