package com.atguigu.gmall.gmalluser1.user.service.impl;


import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.gmalluser1.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.gmalluser1.user.mapper.UserMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component  //加上@Component注解的类会自动被Spring扫描到生成Bean注册到spring容器中
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
//        return userMapper.selectAllUser();
        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        //查询规则，什么规则去查询
        Example example=new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId",memberId);
        return umsMemberReceiveAddressMapper.selectByExample(example);


//        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
//        umsMemberReceiveAddress.setMember_id(memberId);
//        return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
    }
}
