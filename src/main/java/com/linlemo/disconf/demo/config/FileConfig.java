package com.linlemo.disconf.demo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@DisconfFile(filename = "fileConfig.properties")
public class FileConfig {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FileConfig.class);

    private String fileName;

    private String fileVersion;

    @Value("${file.author}")
    private String author;

    private int code;

    /**
     * FIXME 标记associateField是可选的，它表示此get方法相关连的域的名字，如果此标记未填，则系统会自动分析get方法，猜测其相对应于域名。
     * FIXME 强烈建议添加associateField标记，这样就可以避免Eclipse生成的Get/Set方法不符合Java规范的问题
     *
     * @return
     */
    @DisconfFileItem(name = "file.filename", associateField = "fileName")
    public String getFileName() {
        return fileName;
    }

    @DisconfFileItem(name = "file.fileVersion")
    public String getFileVersion() {
        return fileVersion;
    }

    @DisconfFileItem(name = "file.code")
    public int getCode() {
        return code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "FileConfig{" +
                "fileName='" + fileName + '\'' +
                ", fileVersion='" + fileVersion + '\'' +
                ", author='" + author + '\'' +
                ", code=" + code +
                '}';
    }
}
