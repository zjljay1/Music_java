package com.music.music_java.controller;


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

    @PostMapping("/loginout")
    public CommonResult<Object> out(){
        StpUtil.logout();
        return CommonResult.success(null);
    }

}

