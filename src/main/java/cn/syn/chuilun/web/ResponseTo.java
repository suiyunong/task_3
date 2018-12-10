package cn.syn.chuilun.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class ResponseTo {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));


    @Autowired
    public MessageSource messageSource;

    public Map msg(String msg) {
        Map<String,Object> map = new HashMap<String,Object>();
        ResourceBundle resb = ResourceBundle.getBundle("msg", Locale.getDefault());
        map.put("msg",resb.getString(msg));
        return map;
    }

    public Map msg(String msg, Object data) {
        Map<String,Object> map = new HashMap<String,Object>();
        ResourceBundle resb = ResourceBundle.getBundle("msg", Locale.getDefault());
        map.put("msg",resb.getString(msg));
        map.put("data", data);
        return map;
    }
}
