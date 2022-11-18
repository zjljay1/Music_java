package com.music.music_java.service.impl;

import com.music.music_java.common.util.MusicFileUtil;
import com.music.music_java.entity.mbg.Songs;
import com.music.music_java.mapper.SongsMapper;
import com.music.music_java.service.SongsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 歌曲 服务实现类
 * </p>
 *
 * @since 2022-11-03
 */
@Service
public class SongsServiceImpl  implements SongsService {

    @Override
    public boolean addSongs(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();

        String type = originalFilename.substring(originalFilename.indexOf('.'));
        MusicFileUtil musicFileUtil = new MusicFileUtil(type, file);

        String fws = musicFileUtil.uploadFile();

        return true;
    }
}
