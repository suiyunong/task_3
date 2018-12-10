package cn.syn.chuilun;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D://msg.properties"));
//        String str = (String) properties.get("failed");
        String str = (String) properties.get("success");
        System.out.println(str);
        logger.warn("get str = {}", str);
    }
}
