package cn.syn.chuilun.web.controller;

import cn.syn.chuilun.model.Artist;
import cn.syn.chuilun.service.ArtistService;
import cn.syn.chuilun.utils.Page;
import cn.syn.chuilun.web.ResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  HelloController是一个基于注解的控制器,
 *  可以同时处理多个请求动作，并且无须实现任何接口。
 *  org.springframework.stereotype.Controller注解用于指示该类是一个控制器
 */
@Controller
@RequestMapping("/v1")
public class ArtistController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArtistService artistService;

    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }
    @Autowired
    private ResponseTo responseTo;
    @Autowired
    Page p;

    /**
     * 添加用户并重定向
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/addArtist",method = RequestMethod.POST)
    public Map insertArtist(Artist artist) {
        String msg = "success";
        try {
            artistService.insert(artist);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg,artist);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/{email}", method = RequestMethod.GET)
    public Map selectArtist(@PathVariable String email) {
        logger.warn("email = {}", email);
        Artist artist = null;
        try {
            artist = artistService.getArtistByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (artist == null) {
                return responseTo.msg("failed");
            } else {
                return responseTo.msg("success");
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/address", method = RequestMethod.PUT)
    public Map updateAddress(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String address = (String) map.get("address");
        try {
            artistService.updateAddress(email, address);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/artist/email", method = RequestMethod.PUT)
    public Map updateEmail(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String oldEmail = (String) map.get("oldEmail");
        String newEmail = (String) map.get("newEmail");
        try {
            artistService.updateEmail(oldEmail, newEmail);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/phoneNumber", method = RequestMethod.PUT)
    public Map updatePhoneNumber(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String phoneNumber = (String) map.get("phoneNumber");
        try {
            artistService.updatePhoneNumber(email, phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/career2", method = RequestMethod.PUT)
    public Map updateCareer2(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String career = (String) map.get("career");
        try {
            artistService.updateCareer(email, career);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist/career", method = RequestMethod.PUT)
    public String updateCareer(String email,String career) {
        String msg = "success";
//        String email = (String) map.get("email");
//        String career = (String) map.get("career");
        try {
            artistService.updateCareer(email, career);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
//        return responseTo.msg(msg);

        return "lallla";
    }
    @ResponseBody
    @RequestMapping(value = "/artist/career1", method = RequestMethod.PUT)
    public Map updateCareer1(String email,String career) {
        String msg = "success";
//        String email = (String) map.get("email");
//        String career = (String) map.get("career");
        try {
            artistService.updateCareer(email, career);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);

//        return "lallla";
    }
    @ResponseBody
    @RequestMapping(value = "/artist/imgUrl", method = RequestMethod.PUT)
    public Map updateImgUrl(@RequestBody Map<String, Object> map) {
        String msg = "success";
        String email = (String) map.get("email");
        String imgUrl = (String) map.get("imgUrl");
        try {
            artistService.updateImgUrl(email, imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
            msg = "failed";
        }
        return responseTo.msg(msg);
    }

    @ResponseBody
    @RequestMapping(value = "/artist", method = RequestMethod.DELETE)
    public Map deleteArtistByEmail(@RequestBody Map<String,Object> map){
        String msg = "success";
        String email = (String) map.get("email");
        try {
            Long id = artistService.getIdByEmail(email);
            artistService.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
            msg = "failed";
        } finally {
            return responseTo.msg(msg);
        }
    }



}
