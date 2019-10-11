package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.RolesMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Menu;
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
    public Results findAll() {
        String apiDesc = "查询所有角色接口";
        try {
            List<Roles> lists = rolesMapper.findAll();
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询角色列表失败", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询角色列表成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
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

