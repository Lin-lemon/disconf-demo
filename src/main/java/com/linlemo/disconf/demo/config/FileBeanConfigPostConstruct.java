package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.linlemo.disconf.demo.bean.Apple;
import com.linlemo.disconf.demo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/13
 * Time: 00:39
 */
@Service
@DisconfUpdateService(classes = {FileBeanConfigPostConstruct.class})
public class FileBeanConfigPostConstruct implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileBeanConfigPostConstruct.class);

    private Apple apple;

    @Override
    public String toString() {
        return "FileBeanConfigPostConstruct{" +
                "apple=" + apple +
                '}';
    }

    @PostConstruct
    private void setApple() {
        try {
            String content = DisconfDataGetter.getByFile("fileBeanConfig.properties").get("file.apple").toString();
            LOGGER.info("================== FileBeanConfigPostConstruct disconf init apple content  = {}", content);
            this.apple = JsonUtil.getObjectMapperInstance().readValue(content, Apple.class);
        } catch (Exception e) {
            LOGGER.error("init apple exception", e);
        }
    }

    @Override
    public void reload() throws Exception {
        setApple();
    }

}
