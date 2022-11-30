package com.music.music_java;

import com.music.music_java.entity.mbg.Songs;
import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;
import com.music.music_java.mapper.SongsMapper;
import com.music.music_java.service.UserService;
import com.music.music_java.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

@SpringBootTest
class MusicJavaApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private SongsMapper songsMapper;

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
    void Mmin() {
        HashMap<String, String> hashMap = new HashMap<>();
        String s = hashMap.get("1");
        System.out.println(s);
        System.out.println(hashMap);
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

    @Test
    void TestAddSongs(){
        Songs songs = new Songs();
        songs.setSong("枫");
        songs.setSingerName("jay");
        songs.setUserId(1L);
        songs.setSingerId(1L);
        int i = songsMapper.insertSongs(songs);
        System.out.println(i);
    }

    @Test
    void TestDeleteSongs(){
        int i = songsMapper.deleteSongs(1L, 1L);
        System.out.println(i);
    }

}
