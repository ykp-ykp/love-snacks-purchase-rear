package com.ykp.snacks.Service;

import com.ykp.snacks.domain.admin;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminService {
    public admin vertifyAdmin(String name,String password);
    public admin getAdminByName(String name);
    public List<admin> getAllAdmin();
    public String addAdmin(admin admin);
    public void update(admin admin);

}
