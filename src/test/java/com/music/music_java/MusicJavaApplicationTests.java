package com.music.music_java;

import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;
import com.music.music_java.service.UserService;
import com.music.music_java.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicJavaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User admin = userService.login(new UserVo("admin", "123456"));
        System.out.println(admin);
    }

}
