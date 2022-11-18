package com.music.music_java.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.music.music_java.common.api.CommonResult;
import com.music.music_java.common.util.MusicFileUtil;
import com.music.music_java.service.SongsListService;
import com.music.music_java.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("UpdateFile")
    public CommonResult<String> musicFile(@RequestParam("file") MultipartFile file){

        if (file == null)
            return CommonResult.failed("文件未收到，请重新上传");

        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith("mgg")) {
            return CommonResult.failed("文件格式错误，请重新上传");
        }

        String type = originalFilename.substring(originalFilename.indexOf('.'));
        MusicFileUtil musicFileUtil = new MusicFileUtil(type, file);
        String s = musicFileUtil.uploadFile();

        return CommonResult.success(s);


    }

}

