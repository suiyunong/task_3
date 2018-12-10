package cn.syn.chuilun.service;

import cn.syn.chuilun.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //    添加方法，添加成功返回id
    Long add(User user);


    //更新方法
    boolean update(User user);


    //删除方法
    boolean delete(long id);

    //    查找方法
    User findById(long id);

    //查找所有
    List<User> findAll();

    List<User> findUsersByPage(int start, int perPageUsers) ;


}

