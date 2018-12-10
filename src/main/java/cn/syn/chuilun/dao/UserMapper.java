package cn.syn.chuilun.dao;

import cn.syn.chuilun.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //    添加方法，添加成功返回id
    int add(User user);

    //更新方法
    int update(User user);


    //删除方法
    int delete(Long id);

    //    查找方法
    User findById(Long id);

    //查找所有
    List<User> findAll();

    List<User> findUsersByPage(@Param("start") int start, @Param("perPageUsers") int perPageUsers) ;
}