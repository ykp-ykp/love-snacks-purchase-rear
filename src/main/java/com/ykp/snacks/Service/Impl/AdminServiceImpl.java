package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.AdminDao;
import com.ykp.snacks.Service.AdminService;
import com.ykp.snacks.domain.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public admin vertifyAdmin(String name,String password){
        return adminDao.vertifyAdmin(name,password );
    }

    @Override
    public admin getAdminByName(String name){
        return adminDao.getAdminByName(name);
    }

    @Override
    public List<admin> getAllAdmin() {
        return null;
    }

    @Override
    public String addAdmin(admin admin) {
        return null;
    }

    @Override
    public void update(admin admin) {
        adminDao.update(admin);
    }
}
