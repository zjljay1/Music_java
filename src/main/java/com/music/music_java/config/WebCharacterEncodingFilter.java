package com.music.music_java.config;

/**
 * @ClassName WebCharacterEncodingFilter
 * @Description TODO
 * @Author 枫梧
 * @Date 2022/11/16 15:51
 * @Version 1.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 说明：解决以下问题
 * <p>
 *     因使用WebMvcConfigurer加载静态时 url encode编码无法解析为正常中文问题
 * </p>
 *
 */

@EnableWebMvc
@Configuration
public class WebCharacterEncodingFilter implements WebMvcConfigurer {

    /**
     * 乱码处理
     */
    public HttpMessageConverter<String> responseBodyConverter() {
        final StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converter.setWriteAcceptCharset(false);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (!converters.isEmpty()) {
            converters.add(converters.get(0));
            converters.set(0, responseBodyConverter());
        } else {
            converters.add(responseBodyConverter());
        }
    }
}

