package cn.syn.chuilun.web.controller;

import cn.syn.chuilun.model.Collec;
import cn.syn.chuilun.model.Work;
import cn.syn.chuilun.service.CollecService;
import cn.syn.chuilun.web.ResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value ="/collec")
public class CollecController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CollecService collecService;
    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/addCollec", method = RequestMethod.POST)
    public Map insertShowreel(@RequestBody Collec collec) {
        String msg = "success";
        try {
            collecService.insert(collec);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delCollec", method = RequestMethod.DELETE)
    public Map deleteShowreel(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            long workId = Long.valueOf((int) map.get("id"));
            collecService.deleteById(workId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/up", method = RequestMethod.PUT)
    public Map setUpShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            long workId = Long.valueOf((int) map.get("id"));
            collecService.setUp(workId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "down", method = RequestMethod.PUT)
    public Map setDownShow(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            long workId = Long.valueOf((int) map.get("id"));
            collecService.setDown(workId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Map searchByKey(@RequestBody Map<String, Object> map) {
        String msg = "success";
        List<Work> workList = new ArrayList<>();
        try {
            workList = collecService.searchByKey((String) map.get("key"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            if (workList == null) {
                return responseTo.msg(msg);
            } else {
                return responseTo.msg(msg, workList);
            }
        }
    }

}
