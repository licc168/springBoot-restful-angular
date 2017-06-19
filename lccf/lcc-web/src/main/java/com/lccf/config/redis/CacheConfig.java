package com.lccf.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lccf.util.Collections3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
    @Value("${spring.redis.cluster.nodes}")
    private String nodes;

  @Bean
  public KeyGenerator wiselyKeyGenerator(){
      return new KeyGenerator() {
          @Override
          public Object generate(Object target, Method method, Object... params) {
              StringBuilder sb = new StringBuilder();
              sb.append(target.getClass().getName());
              sb.append(method.getName());
              for (Object obj : params) {
                  sb.append(obj.toString());
              }
              return sb.toString();
          }
      };
  }

  @Bean

  public JedisConnectionFactory redisConnectionFactory() {
       JedisConnectionFactory factory = new JedisConnectionFactory(
               new RedisClusterConfiguration(Collections3.transStringToList(nodes,",")));
      return factory;
  }
  @Bean
  public CacheManager cacheManager(RedisTemplate redisTemplate) {
      RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
      // Number of seconds before expiration. Defaults to unlimited (0)
      cacheManager.setDefaultExpiration(10); //设置key-value超时时间
      return cacheManager;
  }
  @Bean
  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
      StringRedisTemplate template = new StringRedisTemplate(factory);
      setSerializer(template); //设置序列化工具，这样ReportBean不需要实现Serializable接口
      template.afterPropertiesSet();
      return template;
  }
  private void setSerializer(StringRedisTemplate template) {
      Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
      jackson2JsonRedisSerializer.setObjectMapper(om);
      template.setValueSerializer(jackson2JsonRedisSerializer);
  }
}