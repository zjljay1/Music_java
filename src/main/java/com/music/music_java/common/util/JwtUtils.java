package com.music.music_java.common.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/*
*@author 枫梧
*@Description token生成
*@Date 21:07 2022/9/29
*@Param
*@Return
**/
public class JwtUtils {
    /**
     * token的失效时间
     */
    private final static long TIME_OUT = 60 * 1000;
    /*
     * 请求头
     * */
    public static final String tokenHeard = "token";
    /**
     * token的密钥
     */
    private final static String SECRET = "feng";

    public static String createToken(String username){

        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, SECRET);

        return builder.compact();
    }

    public static Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwtStr)
                .getBody();
    }


}
