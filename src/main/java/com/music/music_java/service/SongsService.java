package com.music.music_java.service;

import com.music.music_java.entity.mbg.Songs;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 歌曲 服务类
 * </p>
 *
 * @since 2022-11-03
 */
public interface SongsService  {

    boolean addSongs(Long userId,String singerName,MultipartFile file);

    List<Songs> selectAllSongs(Long id);

}
