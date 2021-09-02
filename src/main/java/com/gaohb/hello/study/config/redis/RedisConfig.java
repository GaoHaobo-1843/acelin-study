package com.gaohb.hello.study.config.redis;

import com.gaohb.hello.study.config.redis.properties.MyRedisProperties;
import com.gaohb.hello.study.config.redis.properties.RedisClusterProperties;
import com.gaohb.hello.study.config.redis.properties.RedisPoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisPoolProperties redisPoolProperties;
    @Autowired
    private MyRedisProperties myRedisProperties;
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    /* Jedis - 单个实例 */
    @Bean
    public Jedis singleJedis(){
        return new Jedis(myRedisProperties.getHost(),myRedisProperties.getPort());
    }

    /* Jedis - 集群、连接池模式 */
    @Bean
    public JedisCluster jedisCluster(){

        /* 切割节点信息 */
        String[] nodes = redisClusterProperties.getNodes().split(",");
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        for (String node : nodes) {
            int index = node.indexOf(":");
            hostAndPorts.add(new HostAndPort(node.substring(0,index),Integer.parseInt(node.substring(index + 1))));
        }

        /* Jedis连接池配置 */
        JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();

        return new JedisCluster(hostAndPorts,redisClusterProperties.getCommandTimeout(),jedisPoolConfig);

    }

    /* Jedis - 单个实例、连接池模式 */
    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig poolConfig = getJedisPoolConfig(); // 获取连接池配置
        JedisPool jp = new JedisPool(poolConfig, myRedisProperties.getHost(), myRedisProperties.getPort(),
                myRedisProperties.getTimeOut()*1000, myRedisProperties.getPassword(), 0);
        return jp;
    }

    /* Spring-data-redis - RedisTemplate配置 */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        /* 设置value的序列化规则和 key的序列化规则 */
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        redisTemplate.setKeySerializer(stringRedisSerializer);                // key采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);            // hash的key也采用String的序列化方式
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer); // value序列化方式采用jackson
        redisTemplate.setConnectionFactory(connectionFactory);                // 默认使用letttuce，如果想使用Jedis，创建JedisConnectionFactory实例作为参数传入

        return redisTemplate;
    }

//    @Bean
//    public RedisTemplate commonRedisTemplate(RedisConnectionFactory connectionFactory){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        return redisTemplate;
//    }

    /**
     * 连接池配置
     * @return JedisPoolConfig
     **/
    private JedisPoolConfig getJedisPoolConfig(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());       // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxTotal(redisPoolProperties.getMaxActive());    // 最大连接数, 默认8个
        jedisPoolConfig.setMinIdle(redisPoolProperties.getMinIdle());       // 最小空闲连接数, 默认0
        jedisPoolConfig.setMaxWaitMillis(redisPoolProperties.getMaxWait()); // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setTestOnBorrow(true);  // 对拿到的connection进行validateObject校验
        return jedisPoolConfig;
    }


}
