package com.music.music_java.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 歌手
 * </p>
 *
 * @author ${author}
 * @since 2022-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Sings implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 歌手名
     */
      private String singName;

      /**
     * 所在地
     */
      private String localtion;

      /**
     * 介绍
     */
      private String introduce;

      /**
     * 性别：男->1;女->0
     */
      private Integer sex;

      /**
     * 头像
     */
      private String icon;

      /**
     * 生日
     */
      private LocalDateTime birthday;


}
