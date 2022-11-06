package com.music.music_java.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 歌单
 * </p>
 *
 * @author ${author}
 * @since 2022-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class SongsList implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 名字
     */
      private String name;

      /**
     * 简介
     */
      private String introduce;

      /**
     * 长度
     */
      private Long length;


}
