package com.music.music_java.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.music.music_java.common.api.CommonResult;
import com.music.music_java.common.util.MusicFileUtil;
import com.music.music_java.entity.mbg.Songs;
import com.music.music_java.service.SongsListService;
import com.music.music_java.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 歌曲 前端控制器
 * </p>
 *
 * @since 2022-11-03
 */
@SaCheckLogin
@RestController
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongsService songsService;

    @GetMapping("listAll")
    public CommonResult<List<Songs>> AllSongs(@RequestParam("id") Long id){
        List<Songs> songs = songsService.selectAllSongs(id);
        return CommonResult.success(songs);
    }

    @PostMapping("UploadFile")
    public CommonResult<String> UploadFile(@RequestParam("userId") Long userId,@RequestParam("singerName") String singerName,@RequestParam("file") MultipartFile file){

        if (file == null)
            return CommonResult.failed("文件未收到，请重新上传");

        // 获取歌曲名称
        String originalFilename = file.getOriginalFilename();

        // 判断后缀名
        if (!originalFilename.endsWith("mgg") && !originalFilename.endsWith("jpg")) {
            return CommonResult.failed("文件格式错误，请重新上传");
        }

        boolean flag = songsService.addSongs(userId,singerName,file);

        if (flag)
            return CommonResult.success("添加歌曲成功");
        else
            return CommonResult.failed("添加歌曲失败，请稍等重新添加");


    }

}

