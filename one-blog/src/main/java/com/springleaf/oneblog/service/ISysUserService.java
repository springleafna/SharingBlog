package com.springleaf.oneblog.service;

import com.springleaf.oneblog.pojo.SysUser;

public interface ISysUserService {
    SysUser findUserById(Long userId);
}
