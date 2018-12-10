package cn.syn.chuilun.service.impl;

import cn.syn.chuilun.dao.UserMapper;
import cn.syn.chuilun.model.User;
import cn.syn.chuilun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Long add(User user) {
        int result = userMapper.add(user);
        return user.getId();
    }

    @Override
    public boolean update(User user) {
        int result = userMapper.update(user);
        boolean bool = result == 1 ? true : false;
        return bool;
    }

    @Override
    public boolean delete(long id) {
        int result = userMapper.delete(id);
        boolean bool = result == 1 ? true : false;
        return bool;
    }

    @Override
    public User findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findUsersByPage(int start, int perPageUsers) {
        List<User> list = userMapper.findUsersByPage(start, perPageUsers);
        return list;
    }

}
