package com.music.music_java.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author ${author}
 * @since 2022-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class User implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 账户名
     */
      private String username;

      /**
     * 密码
     */
      private String password;

      /**
     * 用户名
     */
      private String accountname;

      /**
     * 头像
     */
      private String icon;

      /**
     * 性别：男-1；女-0
     */
      private Integer sex;

      /**
     * 生日
     */
      private LocalDateTime birthday;

      /**
     * 所在地
     */
      private String localtion;

      /**
     * 介绍
     */
      private String introduce;

      /**
     * 注册时间
     */
      private LocalDateTime createName;


}
