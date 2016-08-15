package com.linlemo.disconf.demo.service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.linlemo.disconf.demo.config.JedisConfig;
import com.linlemo.disconf.demo.util.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by linzhao on 16/8/8.
 */
@Service
@DisconfUpdateService(classes = {JedisConfig.class})
public class SimpleRedisService implements InitializingBean, DisposableBean, IDisconfUpdate {
    protected static final Logger LOGGER = LoggerFactory.getLogger(SimpleRedisService.class);

    // jedis实例
    private Jedis jedis;

    // 分布式配置
    @Autowired
    private JedisConfig jedisConfig;


    @Override
    public void afterPropertiesSet() throws Exception {
        jedis = JedisUtil.createJedis(jedisConfig.getHost(), jedisConfig.getPort(), jedisConfig.getPassword());
    }

    @Override
    public void reload() throws Exception {
        LOGGER.info("================== SimpleRedisService reload start jedis hosts=[] port=[] ", jedisConfig.getHost(), jedisConfig.getPort());

        jedis = JedisUtil.createJedis(jedisConfig.getHost(), jedisConfig.getPort());

        LOGGER.info("================== SimpleRedisService reload end.");
    }

    public String getKey(String key) {
        if (jedis != null) {
            return jedis.get(key);
        }
        return null;
    }

    @Override
    public void destroy() throws Exception {
        if (jedis != null) {
            jedis.disconnect();
        }
    }


}

