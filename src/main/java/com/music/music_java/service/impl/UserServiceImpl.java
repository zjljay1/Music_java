package com.music.music_java.service.impl;

import cn.dev33.satoken.secure.SaBase64Util;
import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;
import com.music.music_java.mapper.UserMapper;
import com.music.music_java.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @since 2022-11-03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserVo userVo) {
        userVo.setPassword(SaBase64Util.encode(userVo.getPassword()));
        return userMapper.login(userVo);
    }

}
