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

    /**
     * 添加歌曲
     * @param songs
     * @return
     */
    @Insert("insert into songs (user_id,song,singer_name,singer_id,save_path,file_path) values (#{userId},#{song},#{singerName},#{singerId},#{savePath},#{filePath})")
    int insertSongs(Songs songs);

    /**
     * 删除歌曲
     * @param id
     * @param userId
     * @return
     */
    @Delete("delete from songs where id = #{id} && user_id = #{userId}")
    int deleteSongs(Long id,Long userId);

    /**
     * 查找所有歌曲
     * @param id
     * @return
     */
    @Select("select * from songs where id = #{id}")
    List<Songs> selectAllSongs(Long id);


    int updateSongs(Songs songs);


    int insertSongsList(List<Songs> songsList);

}
