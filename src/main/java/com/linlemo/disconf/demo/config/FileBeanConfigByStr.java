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
@DisconfFile(filename = "fileBeanConfig.properties")
public class FileBeanConfigByStr {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileBeanConfigByStr.class);

    //  FIXME   disconf 不支持bean结构的注入,需要自行处理
    private Apple apple;

    private String annotationApple;

    @DisconfFileItem(name = "file.apple")
    public String getAnnotationApple() {
        return StringUtils.EMPTY;
    }

    public void setAnnotationApple(String annotationApple) {
        this.annotationApple = annotationApple;
        setApple(annotationApple);
    }

    @Override
    public String toString() {
        return "FileBeanConfigByStr{" +
                "apple=" + apple +
                ", annotationApple='" + annotationApple + '\'' +
                '}';
    }

    private void setApple(String content) {
        try {
            LOGGER.info("================== FileBeanConfigByStr disconf init apple content  = {}", content);
            this.apple = JsonUtil.getObjectMapperInstance().readValue(content, Apple.class);
        } catch (Exception e) {
            LOGGER.error("init apple exception", e);
        }
    }

}
