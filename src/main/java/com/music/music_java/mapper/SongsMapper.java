package com.music.music_java.mapper;

import com.music.music_java.entity.mbg.Songs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 歌曲 Mapper 接口
 * </p>
 *
 * @since 2022-11-03
 */
public interface SongsMapper {

    @Insert("")
    int insertSongs(Songs songs);

    @Delete("")
    int deleteSongs(Songs songs);

    @Select("")
    Songs selectSongs(HashMap<String ,Object> hashMap);

    @Update("")
    int updateSongs(Songs songs);

    int insertSongsList(List<Songs> songsList);

}
