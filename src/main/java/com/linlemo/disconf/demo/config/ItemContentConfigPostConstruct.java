package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.linlemo.disconf.demo.util.JsonUtil;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/13
 * Time: 00:16
 */
@Service
@DisconfUpdateService(itemKeys = {"itemContent"})
public class ItemContentConfigPostConstruct implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileConfig.class);

    private Map<String, String> stringMap;


    @PostConstruct
    private void setStringMap() {
        try {
            String content = DisconfDataGetter.getByItem("itemContent").toString();
            LOGGER.info("==================ItemContentConfigPostConstruct disconf init stringMap  content = {}", content);
            this.stringMap = JsonUtil.getObjectMapperInstance().readValue(content,
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (Exception e) {
            LOGGER.error("init stringMap exception", e);
        }
    }

    @Override
    public void reload() throws Exception {
        setStringMap();
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    @Override
    public String toString() {
        return "ItemContentConfigPostConstruct{" +
                "stringMap=" + stringMap +
                '}';
    }
}
