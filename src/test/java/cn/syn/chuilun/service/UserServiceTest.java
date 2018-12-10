package cn.syn.chuilun.service;

import cn.syn.chuilun.BaseTest;
import cn.syn.chuilun.model.User;
import cn.syn.chuilun.web.ResponseTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class UserServiceTest extends BaseTest{

    @Resource
    private UserService userService;

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setName("盐23注解");
        user.setPassword("syan1234");
       user.setCreateAt(System.currentTimeMillis());
        user.setEditorId((long) 2);
        Long id = userService.add(user);
        if (id >0) {
            System.out.println("添加成功！返回ID：" + id);
            System.out.println(user);
        }else{
            System.out.println("添加失败");
        }
    }

    @Test
    public void update() throws Exception {
        User user = userService.findById(2);
        user.setName("南宫红鸡");
        boolean bool=userService.update(user);
        if (bool) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
    }

    @Test
    public void delete() throws Exception {
        boolean bool = userService.delete(61);
        if (bool) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void findById() throws Exception {
        User user = userService.findById(2);
        if (user == null) {
            System.out.println("查询用户不存在");
        }else{
            System.out.println(user);
        }
        ResponseTo responseTo = new ResponseTo();
        String msg = "success";
        Map map = responseTo.msg(msg);
        Object value = map.get("msg");
        System.out.println(value);


    }

    @Test
    public void findAll() throws Exception {
        List<User> userList = userService.findAll();
        if (userList == null) {
            System.out.println("查询用户不存在");
        }else{
            for (User u : userList
                    ) {
                System.out.println(u);
            }
        }
    }
    @Test
    public void findUsersByPage() throws Exception {
        List<User> userList = userService.findUsersByPage(0, 5);
        if (userList == null) {
            System.out.println("查询用户不存在");
        }else{
            for (User u : userList
                    ) {
                System.out.println(u);
            }
        }
    }
}