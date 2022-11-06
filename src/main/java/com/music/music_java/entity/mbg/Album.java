package com.music.music_java.entity.mbg;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 专辑
 * </p>
 *
 * @author ${author}
 * @since 2022-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Album implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 专辑名
     */
      private String name;

      /**
     * 描述
     */
      private String description;

      /**
     * 歌手id
     */
      private Long singId;

      /**
     * 创建时间
     */
        @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;


}
