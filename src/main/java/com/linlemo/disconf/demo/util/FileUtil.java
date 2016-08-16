package com.linlemo.disconf.demo.util;

import com.baidu.disconf.client.config.DisClientConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: lin.zhao
 * Email: linlemo@gmail.com
 * Date: 16/8/15
 * Time: 12:03
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static String readDisConfFile(String fileName) {
        try {
            return FileUtils.readFileToString(new File(DisClientConfig.getInstance().userDefineDownloadDir, fileName), "utf8");
        } catch (Exception e) {

        }
        return StringUtils.EMPTY;
    }
}
