package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.UserDao;
import com.ykp.snacks.Service.UserService;
import com.ykp.snacks.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<user> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(user user) {
        userDao.addUser(user);
    }

    @Override
    public user getUserBynickName(String nickName) {
        return null;
    }

    @Override
    public user getUserByOpenid(String openid){
        return userDao.getUserByOpenid(openid);
    }

    @Override
    public void updateUser(String phone,String openid){
        userDao.updateUser(phone,openid);
    }

    @Override
    public void updateAddress(String address,String openid){
        userDao.updateAddress(address, openid);
    }

    @Override
    public void updatePWDADD(user user) {
        userDao.updatePWDADD(user);
    }
}
