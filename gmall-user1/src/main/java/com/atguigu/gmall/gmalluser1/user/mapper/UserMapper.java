package com.atguigu.gmall.gmalluser1.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//@Repository("userMapper")
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
