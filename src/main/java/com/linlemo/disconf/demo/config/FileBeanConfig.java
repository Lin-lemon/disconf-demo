package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.linlemo.disconf.demo.bean.Apple;
import com.linlemo.disconf.demo.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/13
 * Time: 00:39
 */
@Service
@DisconfFile(filename = "fileBeanApple.properties")
public class FileBeanConfig {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileBeanConfig.class);

    //  FIXME  disconf 不支持bean结构的注入,需要自行处理
    private Apple apple;

    // FIXME disconf内部存储是key value结构，不支持复杂的bean结构
    // FIXME 这里的get方法实际经过aop处理处理后，取到的值是String类型的，如果返回Apple，会报类转换异常
    @DisconfFileItem(name = "filebean.apple")
    public String getApple() {
        return StringUtils.EMPTY;
    }


    public Apple getActualApple() {
        return apple;
    }


    public void setApple(String content) {
        try {
            LOGGER.info("================== FileBeanConfig disconf init apple content  = {}", content);
            this.apple = JsonUtil.getObjectMapperInstance().readValue(content, Apple.class);
        } catch (Exception e) {
            LOGGER.error("init apple exception", e);
        }
    }

    @Override
    public String toString() {
        return "FileBeanConfig{" +
                "apple=" + apple +
                '}';
    }

}
