package cn.syn.chuilun.web.controller;

import cn.syn.chuilun.model.User;
import cn.syn.chuilun.service.UserService;
import cn.syn.chuilun.utils.Page;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *  HelloController是一个基于注解的控制器,
 *  可以同时处理多个请求动作，并且无须实现任何接口。
 *  org.springframework.stereotype.Controller注解用于指示该类是一个控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    Page p;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String findUsersByPage(int page, Model model) {
        try {
            p.setTotalUsers(userService.findAll().size());
            p.setCurrentPage(page);
            List<User> userList = userService.findUsersByPage((page - 1) * p.getPageSize(), p.getPageSize());
            if (userList == null || userList.size() == 0) {
                logger.info("查询失败");
                model.addAttribute("code",110);
                model.addAttribute("message","查询用户失败");
            }else{
                logger.info("查询成功");
                model.addAttribute("code", 200);
                model.addAttribute("message","查询用户成功");
                model.addAttribute("userList", userList);
                model.addAttribute("page", p);
            }
            return "allUser";
        } catch (Exception e) {
            model.addAttribute("error", "未能获取数据");
            return "errors";
        }
    }
    @RequestMapping(value = "/firstPage", method = RequestMethod.GET)
    public String findUsersByPage( Model model) {
        try {
            p.setTotalUsers(userService.findAll().size());
            List<User> userList = userService.findUsersByPage(0, p.getPageSize());
            if (userList == null || userList.size() == 0) {
                logger.info("查询失败");
                model.addAttribute("code",110);
                model.addAttribute("message","查询用户失败");
            }else{
                logger.info("查询成功");
                model.addAttribute("code", 200);
                model.addAttribute("message","查询用户成功");
                model.addAttribute("userList", userList);
                model.addAttribute("page", p);
            }
            return "allUser";
        } catch (Exception e) {
            model.addAttribute("error", "未能获取数据");
            return "errors";
        }
    }
    /**
     * 跳转到添加用户界面
     * @return
     */
    @RequestMapping("toAddUser")
    public String toAddUser(){
        return "addUser";
    }


    /**
     * 添加用户并重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "addUser",method=RequestMethod.POST)
    public String addUser(Model model,@Valid User user,BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors
                    ) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors", allErrors);
            return "errors";
        }
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        userService.add(user);
        System.out.println(user);
        return "redirect:/user/firstPage";
    }

    /**
     * 查询全部用户
     * @param model
     * @return
     */
    @RequestMapping("getAllUser")
    public String getAllUser(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("userList",user);
        return "allUser";
    }

    /**
     *
     * @param id
     * @param model
     * @return 跳转到更新用户页面
     */
    @RequestMapping("toDelete")
    public String toDelete(@RequestParam(value = "id")Integer id, Model model){
        model.addAttribute("user",userService.findById(id));
        System.out.println(userService.findById(id));
        return "deleteUser";
    }
    /**
     * 删除用户
     * @param
     * @param id
     * @return
     */
    @RequestMapping(value = "delUser",method = RequestMethod.DELETE)
    public String removeUser(@RequestParam(value = "id")long id,Model model){
       boolean flag= userService.delete(id);
        if (flag) {
            logger.info("删除成功");
            model.addAttribute("code", 200);
            model.addAttribute("message", "删除成功");
        }else {
            logger.info("删除失败");
            model.addAttribute("code", 200);
            model.addAttribute("message", "删除失败");
        }
            return "redirect:/user/firstPage";
        }


    /**
     * 跳转到更新用户页面
     */
    @RequestMapping("toUpdate")
    public String toUpdate(@RequestParam(value = "id")Integer id, Model model){
        model.addAttribute("user",userService.findById(id));
        System.out.println(userService.findById(id));
        return "updateUser";
    }

    /**
     * 更新用户
     * @param
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.PUT)
    public String updateUser(User user, Model model, @RequestParam(value = "id") Integer id){
        System.out.println(id);
        user.setUpdateAt(System.currentTimeMillis());
        boolean flag=userService.update(user);
        if (flag) {
            logger.info("更新成功");
            model.addAttribute("code", 200);
            model.addAttribute("message", "更新成功");
        }else {
            logger.info("更新失败");
            model.addAttribute("code", 110);
            model.addAttribute("message", "更新失败");
        }
        return "redirect:/user/firstPage";
    }

    /**
     * 跳转到查询用户界面
     * @return
     */
    @RequestMapping("toFindById")
    public String toFindById(){
        return "findUserById";
    }
    /**
     * 根据id查询学生,增加接口校验功能
     * @param id
     * @return
     */
    @RequestMapping(value="/findById",method=RequestMethod.GET)
    public String findById(Model model,Integer id){

        if (id==null){
            logger.info("查询失败");
            model.addAttribute("code", 110);
            model.addAttribute("message", "查询失败");
            String error = "id不能为空，请输入id查询";
            model.addAttribute("error", error);
            return "errors";
        }else {
            User user = userService.findById(id);
            if (user == null) {
                logger.info("查询失败");
                model.addAttribute("code", 110);
                model.addAttribute("message", "查询失败");
                String error = "您所查询的用户不存在";
                model.addAttribute("error", error);
                return "errors";
            } else {
                logger.info("查询成功");
                model.addAttribute("code", 200);
                model.addAttribute("message", "查询成功");
                List<User> userList = new ArrayList<>();
                userList.add(user);
                model.addAttribute("userList", userList);
                return "userMatchId";

            }
        }
    }


    /**
     * taglib 返回json数据
     * @param model
     * @return
     */
 @RequestMapping("json")
    public String returnJson(Model model) {
     User user = userService.findById(9);
//     JSONObject userJson = JSONObject.fromObject(user);
     model.addAttribute("user", user);
     return "json";
 }

    @RequestMapping("json2")
    //可以直接在返回的方法上添加@ResponseBody 实现对象自动转换json格式
    public String returnJson2(Model model) {
        User user = userService.findById(9);
        JSONObject userJson = JSONObject.fromObject(user);
        model.addAttribute("userJson", userJson);
        return "json2";
    }

    /**
     * @ResponseBod直接返回json数据
     * @return
     */
    @RequestMapping("json3")
    @ResponseBody
    public User  returnJson3(long id)
    {
        User user = userService.findById(id);
        return user;
    }




}
