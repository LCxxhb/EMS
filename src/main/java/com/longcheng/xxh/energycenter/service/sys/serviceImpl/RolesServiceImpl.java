package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.RolesMapper;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.entity.sys.RolesExample;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<Roles> findAllRoles() {
        RolesExample example = new RolesExample();
        List<Roles> rolesList = rolesMapper.selectByExample(example);
        return rolesList;
    }

    @Override
    public Roles findByAid(int id) {
        Roles roles = rolesMapper.selectByPrimaryKey(new BigDecimal(id));
        return roles;
    }

    @Override
    public boolean addRoles(Roles roles) {
        int i = rolesMapper.insertSelective(roles);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateRoles(Roles roles) {
        RolesExample example = new RolesExample();
        example.createCriteria().andIdEqualTo(roles.getId());
        int i = rolesMapper.updateByExampleSelective(roles,example);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteRoles(String[] aids) {
        RolesExample example = new RolesExample();
        List<BigDecimal> list = new ArrayList<>();
        for (int i = 0; i <aids.length ; i++) {
            list.add(new BigDecimal(aids[i]));
        }
        example.createCriteria().andIdIn(list);
        int i = rolesMapper.deleteByExample(example);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
