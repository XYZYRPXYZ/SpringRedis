package com.robin.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jjrs = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jjrs.setObjectMapper(om);
        StringRedisSerializer stringREdisSerializer = new StringRedisSerializer();
        // key采用String的序列化方法
        template.setKeySerializer(stringREdisSerializer);
        // hash的key也采用string 的序列化方式
        template.setHashKeySerializer(stringREdisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jjrs);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jjrs);
        template.afterPropertiesSet();
        return template;
    }
}
