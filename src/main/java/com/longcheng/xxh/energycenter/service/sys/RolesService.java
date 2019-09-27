package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.sys.Roles;

import java.util.List;

public interface RolesService {
    //查询所有的角色
    public List<Roles> findAllRoles();

    //通过id查询角色
    public Roles findByAid(int id);

    //添加角色
    public boolean addRoles(Roles roles);

    //修改角色
    public boolean updateRoles(Roles roles);

    //删除角色
    public boolean deleteRoles(String[] aids);
}
