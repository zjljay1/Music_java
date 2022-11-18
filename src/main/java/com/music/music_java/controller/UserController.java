package com.music.music_java.controller;


import cn.dev33.satoken.secure.SaBase64Util;
import cn.dev33.satoken.stp.StpUtil;
import com.music.music_java.common.api.CommonResult;
import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;
import com.music.music_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @since 2022-11-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登录
     * @param userVo
     * @return
     */
    @PostMapping("/login")
    public CommonResult<Object> login(@RequestBody UserVo userVo){

        User user = userService.login(userVo);
        if (user != null){
            StpUtil.login(user.getId());
            // 获取当前会话的token值
            Map<String,String> map = new HashMap<>();
            map.put("TokenName",StpUtil.getTokenName());
            map.put("TokenValue",StpUtil.getTokenValue());
            return CommonResult.success(map,"登录成功,欢迎使用");
        }
        return CommonResult.failed("登录失败");
    }

    /**
     * 登出
     * @return
     */
    @PostMapping("/loginout")
    public CommonResult<Object> out(){
        StpUtil.logout();
        return CommonResult.success(null);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public CommonResult<Object> register(@RequestBody User user){
        //判断是否注册成功
        if (userService.register(user)){
            User login = userService.login(new UserVo(user.getUsername(), SaBase64Util.decode(user.getPassword())));
            StpUtil.login(login.getId());
            // 获取当前会话的token值
            Map<String,String> map = new HashMap<>();
            map.put("TokenName",StpUtil.getTokenName());
            map.put("TokenValue",StpUtil.getTokenValue());
            return CommonResult.success(map,"注册成功,欢迎使用");
        }
        else {
            return CommonResult.failed("注册失败");
        }
    }

}

