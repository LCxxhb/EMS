package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.UserMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;

import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user
 *
 * @author shadow
 * @date 2019/09/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public Results login(User user) {
        return null;
    }

    @Override
    public Results insert(User user) {

        // valid
        if (user == null) {
            return new Results();
        }

        userMapper.insert(user);
        return new Results();
    }


    @Override
    public Results delete(int id) {
        int ret = userMapper.delete(id);
//        return ret>0?ReturnT.SUCCESS:ReturnT.FAIL;
        return new Results();
    }


    @Override
    public Results update(User user) {
        int ret = userMapper.update(user);
//        ret > 0 ? ReturnT.SUCCESS : ReturnT.FAIL;
        return new Results();
    }


    @Override
    public Results load(int id) {
        userMapper.load(id);
        return new Results();
    }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<User> pageList = userMapper.pageList(offset, pagesize);
        int totalCount = userMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }

}
