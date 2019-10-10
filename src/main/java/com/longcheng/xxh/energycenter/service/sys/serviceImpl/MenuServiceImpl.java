package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.MenuMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.service.sys.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * menu
 * @author shadow
 * @date 2019/10/10
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;


    @Override
    public Results insert(Menu menu) {

        // valid
        if (menu == null) {

        }

        menuMapper.insert(menu);
        return new Results();
    }


    @Override
    public Results delete(int id) {
        int ret = menuMapper.delete(id);
        return new Results();
    }


    @Override
    public Results update(Menu menu) {
        int ret = menuMapper.update(menu);
        return new Results();
    }


    @Override
    public Results load(int id) {
         menuMapper.load(id);
        return new Results();
    }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<Menu> pageList = menuMapper.pageList(offset, pagesize);
        int totalCount = menuMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }

}

