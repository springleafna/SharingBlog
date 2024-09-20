package com.springleaf.oneblog.mapper;

import com.springleaf.oneblog.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("select * from ms_sys_user where id =#{userId}")
    SysUser findUserById(Long userId);
}
