package com.zjh.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjh.gmall.ums.entity.Admin;
import com.zjh.gmall.ums.mapper.AdminMapper;
import com.zjh.gmall.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-12-21
 */
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        QueryWrapper<Admin> wrapper =new QueryWrapper<Admin>().eq("username",username);

        Admin admin = adminMapper.selectOne(wrapper);
        return admin;
    }

    //获取用户详情
    @Override
    public Admin getUserInfo(String userName) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",userName));
    }
}
