package com.music.music_java.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
*@author 登录接收参数
*@Description
*@Date 21:10 2022/9/29
*@Param
*@Return
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {

    private String username;

    private String password;

}
