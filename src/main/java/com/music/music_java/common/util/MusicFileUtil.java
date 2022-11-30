package com.music.music_java.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

/**
 * 文件上传方法， 该类可以传 视频， 文件， 音频， 图片
 * @author Zyred
 */
public class MusicFileUtil {

    static Logger logger = LoggerFactory.getLogger(MusicFileUtil.class);

    /**
     * 上传文件方法
     * @return
     */
    public static HashMap<String,String> uploadFile(String type,MultipartFile file){

        HashMap<String,String> hashMap = new HashMap<>();

        String resultPath;

        logger.info("上传文件类型：" + type);

        String save_path = null;
        InputStream is = null;
        FileOutputStream os = null;

        //判断文件不为空
        if (file == null && file.isEmpty()) {
            hashMap.put("error","上传的文件为空");
            return hashMap;
        }

        if(type != null && !type.isEmpty()){
            //通过key获取到存储的路径
            save_path = "../Music_file/";
        }


        //获取到文件的名字
        String oldFileName = file.getOriginalFilename();
        logger.info("上传文件名称：" + oldFileName);
        String oldFileNameSufix = oldFileName.substring(oldFileName.lastIndexOf("."));

        //得到文件的新名字
        String newFileName = UUID.randomUUID() + oldFileNameSufix;
        logger.info("上传文件新名称：" + newFileName);

        //保存后的文件路径
        String affterPath = save_path + type + "/" + newFileName;
        hashMap.put("savePath",affterPath);
        logger.info("文件保存位置：" + affterPath);

        //创建文件对象
        File dest = new File(affterPath);

        if (!dest.getParentFile().getParentFile().exists()) {
            dest.getParentFile().getParentFile().mkdir();
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        //文件或目录是否存在
        if (dest.exists()) {
            dest.mkdir();
        }


        //保存文件
        try {
            //获取输入流
            is = file.getInputStream();
            //创建输出流
            os = new FileOutputStream(dest);
            int len = 0;
            byte[] buffer = new byte[2048*512];
            //往输出流中写入字节流
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            InetAddress localHost = InetAddress.getLocalHost();
            //获取本地目录
            String bendi1 = System.getProperty("user.dir");
            String[] strings = bendi1.split("\\\\");
            String bendi2 = "";
            for (int i = 0; i < strings.length; i++) {
                //取上一层目录
                if (i == strings.length - 1)
                    continue;
                bendi2 += strings[i] + "/";
            }
            //请求前缀  http://  https://
            String prefix = "file:///";
            //java项目请求路径 如：/image/download/file
            String middle = "Music_file/";
            resultPath = prefix + bendi2 + middle + newFileName;
            hashMap.put("filePath",resultPath);
            logger.info("文件下载地址：" + resultPath);
        } catch (IOException e) {
            e.printStackTrace();
            hashMap.put("error","服务器异常，请稍后重试");
            return hashMap;
        }finally {
            try{
                if(os != null || os != null){
                    os.close();
                    os.flush();
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                hashMap.put("error","流关闭异常");
                return hashMap;
            }
        }
        return hashMap;
    }
}