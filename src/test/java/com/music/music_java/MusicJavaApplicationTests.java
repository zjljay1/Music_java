package com.music.music_java;

import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;
import com.music.music_java.service.UserService;
import com.music.music_java.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Properties;

@SpringBootTest
class MusicJavaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void index() {
        String bendi1 = System.getProperty("user.dir");
        String[] strings = bendi1.split("\\\\");
        String bendi2 = "";
        for (int i = 0; i < strings.length; i++) {
            bendi2 += strings[i] + "/";
        }
        System.out.println(bendi2);
    }

    @Test
    void loginTest() {
        User admin = userService.login(new UserVo("admin", "123456"));
        System.out.println(admin);
    }

    @Test
    void rwgisterTest() {
        User user = new User();
        user.setUsername("wuhu");
        user.setPassword("123456");
        user.setAccountname("55");
        boolean register = userService.register(user);
        if (register)
            System.out.println("成功");
        else
            System.out.println("失败");

    }



}
