package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.linlemo.disconf.demo.util.FileUtil;
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
 * Time: 00:39
 */
@Service
@DisconfFile(filename = "fileMap.json")
@DisconfUpdateService(classes = {FileBeanConfigJson.class})
public class FileBeanConfigJson implements IDisconfUpdate {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileBeanConfigJson.class);

    private Map<String, String> stringMap;

    @PostConstruct
    private void setStringMap() {
        try {
            String content = FileUtil.readDisConfFile("fileMap.json");
            LOGGER.info("==================FileBeanConfigJson disconf init stringMap  content = {}", content);
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
        return "FileBeanConfigJson{" +
                "stringMap=" + stringMap +
                '}';
    }
}
