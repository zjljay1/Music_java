package com.music.music_java.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaResult;
import com.music.music_java.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName MyGlobalExceptionHandler
 * @Description TODO    捕获全局异常
 * @Date 2022/10/13 22:08
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler({SaTokenException.class})
    public SaResult saTokenException(SaTokenException e) {
        log.error("SaTokenException: ", e);
        return SaResult.error(e.getMessage());
    }

    @ExceptionHandler({NotLoginException.class})
    public CommonResult<Object> notLoginException(NotLoginException e) {
        log.error("NotLoginException: ", e);
        return CommonResult.failed("用户未登录，请登录");
    }

}
