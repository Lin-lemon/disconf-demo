package com.linlemo.disconf.demo.task;

import com.linlemo.disconf.demo.config.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 演示分布式配置文件、分布式配置的更新Demo
 *
 * @author liaoqiqi
 * @version 2014-6-17
 */
@Service
public class DisconfDemoTask {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoTask.class);

    @Autowired
    FileBeanConfig fileBeanConfig;

    @Autowired
    FileBeanConfigPostConstruct fileBeanConfigPostConstruct;

    @Autowired
    FileConfig fileConfig;

    @Autowired
    ItemContentConfig itemContentConfig;

    @Autowired
    ItemContentConfigPostConstruct itemContentConfigPostConstruct;

    @Autowired
    JedisConfig jedisConfig;

    public int run() {

        try {
            while (true) {
                LOGGER.info(fileBeanConfig.toString());
                LOGGER.info(fileBeanConfigPostConstruct.toString());
                LOGGER.info(fileConfig.toString());
                LOGGER.info(itemContentConfig.toString());
                LOGGER.info(itemContentConfigPostConstruct.toString());
                LOGGER.info(jedisConfig.toString());
                System.out.println();
                System.out.println();
                Thread.sleep(60000);
            }
        } catch (Exception e) {
            LOGGER.error(e.toString(), e);
        }

        return 0;
    }
}
