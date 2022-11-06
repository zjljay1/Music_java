package com.music.music_java.mapper;

import com.music.music_java.entity.mbg.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.music.music_java.entity.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @since 2022-11-03
 */
public interface UserMapper{

    @Select("select count(*) from user where username = #{name}")
    int selectExit(String name);

    @Select("select * from user where username = #{username} && password = #{password}")
    User login(UserVo userVo);


}
