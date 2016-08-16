package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@DisconfFile(filename = "redis.properties")
public class JedisConfig {

    protected static final Logger LOGGER = LoggerFactory.getLogger(JedisConfig.class);

    private String host;

    private int port;

    private String password;

    @DisconfFileItem(name = "redis.host")
    public String getHost() {
        return host;
    }

    @DisconfFileItem(name = "redis.port")
    public int getPort() {
        return port;
    }

    @DisconfFileItem(name = "redis.password")
    public String getPassword() {
        return password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JedisConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                '}';
    }
}
