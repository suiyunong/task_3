package cn.syn.chuilun.web.controller;


import cn.syn.chuilun.model.Title;
import cn.syn.chuilun.service.TitleService;
import cn.syn.chuilun.web.ResponseTo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/title")
public class TitleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TitleService titleService;
    @Autowired
    private ResponseTo responseTo;


    @ResponseBody
    @RequestMapping(value = "/addTitle",method = RequestMethod.POST)
    public Map insertTitle(@RequestBody Title title) {
        String msg = "success";
        try {
            titleService.insert(title);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }finally {
            return responseTo.msg(msg,title);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/name", method = RequestMethod.PUT)
    public Map updateTitleName(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleName((String) map.get("oldName"), (String) map.get("newName"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/url", method = RequestMethod.PUT)
    public Map updateTitleUrl(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleUrl((String) map.get("name"), (String) map.get("url"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/level", method = RequestMethod.PUT)
    public Map updateTitleLevel(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            titleService.updateTitleLevel((String) map.get("name"), (int) map.get("level"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public Map getTitleList() {
        List<Title> titleList = null;
        try {
            titleList = titleService.getTitleList();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (titleList.size() == 0){
                return responseTo.msg("failed");
            } else {
                return responseTo.msg("success",titleList);
            }
        }
    }
}
