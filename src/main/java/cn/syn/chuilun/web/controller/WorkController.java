package cn.syn.chuilun.web.controller;

import cn.syn.chuilun.model.Collec;
import cn.syn.chuilun.model.Work;
import cn.syn.chuilun.service.WorkService;
import cn.syn.chuilun.web.ResponseTo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/work")
public class WorkController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WorkService workService;

    @Autowired
    private ResponseTo responseTo;

    @ResponseBody
    @RequestMapping(value = "/addWork", method = RequestMethod.POST)
    public Map insertWork(@RequestBody Work work) {
        String msg = "success";
        try {
            workService.insert(work);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map selectWorkById(int id) {
        String msg = "success";
        Work work = new Work();
        try {
            long workId = Long.valueOf(id);
            work = workService.selectById(workId);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            if (work == null) {
                return responseTo.msg(msg);
            } else {
                return responseTo.msg(msg, work);
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/intro", method = RequestMethod.PUT)
    public Map updateProductionIntro(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            workService.updateWorkIntro(Long.valueOf((int) map.get("id")), (String) map.get("intro"));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delWork", method = RequestMethod.DELETE)
    public Map deleteProductionById(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            workService.deleteById(Long.valueOf((int) map.get("id")));
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
            workService.setUp(Long.valueOf((int) map.get("id")));
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
            workService.setDown(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "banner/up", method = RequestMethod.PUT)
    public Map setUpBanner(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            workService.setUpBanner(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/banner/down", method = RequestMethod.PUT)
    public Map setDownBanner(@RequestBody Map<String, Object> map) {
        String msg = "success";
        try {
            workService.setDownBanner(Long.valueOf((int) map.get("id")));
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public Map sselectAllWorks() {
        logger.warn("TAG = request,接收到请求");
        String msg = "success";
        List<Work> workList = new ArrayList<>();

        try {
            workList = workService.selectAllWorks();
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

    @ResponseBody
    @RequestMapping(value = "/list/banner", method = RequestMethod.GET)
    public Map selectBannerWorks() {
        String msg = "success";
        List<Work> workList = new ArrayList<>();

        try {
            workList = workService.selectBannerWorks();
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
