package com.music.music_java.service;

import com.music.music_java.entity.mbg.User;
import com.music.music_java.entity.vo.UserVo;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @since 2022-11-03
 */
public interface UserService {

    User login(UserVo userVo);

}
