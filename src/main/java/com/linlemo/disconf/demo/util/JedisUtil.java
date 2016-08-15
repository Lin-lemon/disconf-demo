package com.linlemo.disconf.demo.util;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * @author liaoqiqi
 * @version 2014-6-17
 */
public class JedisUtil {

    public static Jedis createJedis(String host, int port) {
        return new Jedis(host, port);
    }

    public static Jedis createJedis(String host, int port, String password) {
        Jedis jedis = new Jedis(host, port);

        if (StringUtils.isNotBlank(password)) {
            jedis.auth(password);
        }

        return jedis;
    }
}
