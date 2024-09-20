package com.springleaf.oneblog.service.impl;

import com.springleaf.oneblog.mapper.SysUserMapper;
import com.springleaf.oneblog.pojo.SysUser;
import com.springleaf.oneblog.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(Long userId) {
        return sysUserMapper.findUserById(userId);
    }
}
