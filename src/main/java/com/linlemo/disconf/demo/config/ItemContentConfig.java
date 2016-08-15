package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.linlemo.disconf.demo.util.JsonUtil;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/13
 * Time: 00:16
 */
@Service
public class ItemContentConfig {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileConfig.class);

    private String itemContent;

    private Map<String, String> stringMap;

    @DisconfItem(key = "itemContent")
    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
        setStringMap(itemContent);
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    private void setStringMap(String content) {
        try {
            LOGGER.info("================== ItemContentConfig disconf init stringMap  content = {}", content);
            this.stringMap = JsonUtil.getObjectMapperInstance().readValue(content,
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (Exception e) {
            LOGGER.error("init stringMap exception", e);
        }
    }

    @Override
    public String toString() {
        return "ItemContentConfig{" +
                "itemContent='" + itemContent + '\'' +
                ", stringMap=" + stringMap +
                '}';
    }
}
