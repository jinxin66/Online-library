package com.example.onlinelibrary.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 生成验证码配置
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2.1.0 2017-04-20
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        //properties.setProperty("kaptcha.border", "yes");//默认yes
        // 图片宽
        //properties.setProperty("kaptcha.image.width", "340");//默认200
        // 图片高
        //properties.setProperty("kaptcha.image.height", "80");//默认50
        // 字体大小
        //properties.setProperty("kaptcha.textproducer.font.size", "60");//默认40
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");//默认黑
        // 字体
        //properties.setProperty("kaptcha.textproducer.font.names", "宋体,微软雅黑");//默认Arial, Courier
        // session key
        //properties.setProperty("kaptcha.session.key", "KAPTCHA_SESSION_KEY");//默认KAPTCHA_SESSION_KEY
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");//默认5
        // 字间距
        properties.setProperty("kaptcha.textproducer.char.space", "6");//默认2

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
