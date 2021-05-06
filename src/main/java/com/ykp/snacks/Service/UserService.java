package com.ykp.snacks.Service;

import com.ykp.snacks.domain.user;

import java.util.List;

public interface UserService {
    public List<user> getAllUser();
    public void addUser(user user);
    public user getUserBynickName(String nickName);
    public user getUserByOpenid(String openid);
    public void updateUser(String phone,String openid);
    public void updateAddress(String address,String openid);
    public void updatePWDADD(user user);
}
