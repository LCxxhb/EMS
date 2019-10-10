package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.RolesMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * roles
 * @author shadow
 * @date 2019/10/10
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Resource
    private RolesMapper rolesMapper;


    @Override
    public Results insert(Roles roles) {

        // valid
        if (roles == null) {

        }

        rolesMapper.insert(roles);
        return new Results();
    }


    @Override
    public Results delete(int id) {
        int ret = rolesMapper.delete(id);
        return new Results();
    }


    @Override
    public Results update(Roles roles) {
        int ret = rolesMapper.update(roles);
        return new Results();
    }


    @Override
    public Results load(int id) {
        rolesMapper.load(id);
        return new Results();
    }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<Roles> pageList = rolesMapper.pageList(offset, pagesize);
        int totalCount = rolesMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }

}

