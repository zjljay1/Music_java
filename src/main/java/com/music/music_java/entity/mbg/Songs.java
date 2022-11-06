package com.music.music_java.entity.mbg;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 歌曲
 * </p>
 *
 * @author ${author}
 * @since 2022-11-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Songs implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
        private Long id;

      /**
     * 歌曲名称
     */
      private String song;

      /**
     * 作曲
     */
      private String compose;

      /**
     * 作词
     */
      private String writeWords;

      /**
     * 编曲
     */
      private String arrangement;

      /**
     * 制作人
     */
      private String producer;

      /**
     * 歌词
     */
      private String lyric;

      /**
     * 喜欢
     */
      private String like;

      /**
     * 歌单id
     */
      private Long songListId;

      /**
     * 专辑id
     */
      private Long albumId;

      /**
     * 专辑名称
     */
      private String albumName;

      /**
     * 歌手id
     */
      private Long singerId;

      /**
     * 歌手名字
     */
      private String singerName;

      /**
     * 歌曲图片
     */
      private String songImg;

      /**
     * 歌曲时长
     */
      private LocalDateTime songTime;


}
