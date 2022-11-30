package com.music.music_java.service.impl;

import com.music.music_java.common.util.MusicFileUtil;
import com.music.music_java.entity.mbg.Songs;
import com.music.music_java.mapper.SongsMapper;
import com.music.music_java.service.SongsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 歌曲 服务实现类
 * </p>
 *
 * @since 2022-11-03
 */
@Service
public class SongsServiceImpl  implements SongsService {

    @Autowired
    private SongsMapper songsMapper;

    @Override
    public boolean addSongs(Long userId,String singerName,MultipartFile file) {

        String originalFilename = file.getOriginalFilename();

        String type = originalFilename.substring(originalFilename.indexOf('.') + 1);

        HashMap<String,String > hashMap = MusicFileUtil.uploadFile(type, file);

        if (hashMap.get("error") != (null)){
            return false;
        }

        Songs songs = new Songs();

        songs.setUserId(userId);
        songs.setSong(originalFilename);
        songs.setSingerName(singerName);
        songs.setSingerId(1L);
        songs.setFilePath(hashMap.get("filePath"));
        songs.setSavePath(hashMap.get("savePath"));

        int i = songsMapper.insertSongs(songs);
        if (i > 0)
            return true;
        else
            return false;


    }

    @Override
    public List<Songs> selectAllSongs(Long id) {

        return songsMapper.selectAllSongs(id);
    }
}
