package com.atguigu.gmall.gmalluser1.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
public class UserController {
//    @Reference:远程dubbo协议代理
    @Reference
    UserService userService;

//    映射请求路径
    @RequestMapping("umsMemberReceiveAddress")
//    接收前端传递给后端的json字符串中的数据
    //@ResponseBody     //看清楚！不是@RequestBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

    @RequestMapping("getAllUser")
//    接收前端传递给后端的json字符串中的数据
//    @RequestBody
    public List<UmsMember> getAllUser(){
        //查找所有用户
        List<UmsMember> umsmember=userService.getAllUser();
        return umsmember;
    }
}
