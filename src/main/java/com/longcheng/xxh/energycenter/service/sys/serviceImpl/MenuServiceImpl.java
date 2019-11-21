package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.MenuMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.service.sys.MenuService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * menu
 *
 * @author shadow
 * @date 2019/10/10
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private BaseServiceImpl baseServiceImpl;
    private final static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Override
    public Results insert(Menu menu) {
        String apiDesc = "添加菜单接口";
        // valid
        menu.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
        menu.setLastUpdateBy(baseServiceImpl.getCurrentUserName());
        if (StringUtils.isEmpty(menu.getMenuname()) || StringUtils.isEmpty(menu.getMunuurl())) {
            return new Results(Code.param, "菜单不能为空", "", apiDesc);
        } else {
            try {
                if (menuMapper.insert(menu) > 0) {
                    return new Results(Code.success, "添加菜单成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "添加菜单失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results delete(String id) {
        String apiDesc = "删除菜单接口";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "菜单id不能为空!!", "", apiDesc);
        } else {
            try {
                String[] ids = id.split(",");
                int count = 0;
                for (int i = 0; i < ids.length; i++) {
                    menuMapper.delete(ids[i]);
                    count++;
                }
                logger.info("删除的菜单条数为{}条", count);
                if (count > 0) {
                    return new Results(Code.success, "删除菜单成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "删除菜单失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results update(Menu menu) {
        String apiDesc = "修改菜单信息接口";
        // valid
        if (StringUtils.isEmpty(String.valueOf(menu.getId())) || StringUtils.isEmpty(menu.getMenuname())) {
            return new Results(Code.param, "菜单id或菜单名称不能为空", "", apiDesc);
        } else {
            menu.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
            menu.setLastUpdateBy(baseServiceImpl.getCurrentUserName());
            try {
                if (menuMapper.update(menu) > 0) {
                    return new Results(Code.success, "编辑菜单成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "编辑菜单失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results findAll() {
        String apiDesc = "查询所有菜单接口";
        try {
            List<Menu> lists = menuMapper.findAll();
            List menulist = new ArrayList();
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询菜单列表失败", lists, apiDesc);
            } else {
                for (Menu menu : lists) {
                    Map map = new HashMap();
                    map.put("id", menu.getId());
                    map.put("pid", menu.getPid());
                    map.put("name", menu.getMenuname());
                    map.put("menuname", menu.getMenuname());
                    map.put("munuurl", menu.getMunuurl());
                    menulist.add(map);
                }
                return new Results(Code.success, "查询菜单列表成功", menulist, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findParentMenu() {
        String apiDesc = "查询父级菜单接口";
        try {
            List<Menu> lists = menuMapper.findParentMenu();
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询父级菜单列表失败", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询父级菜单列表成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }


    @Override
    public Results load(int pid) {
        String apiDesc = "根据父级菜单id查询子菜单！";
        try {
            List<Menu> lists = menuMapper.load(pid);
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "根据父级菜单id查询子菜单失败", lists, apiDesc);
            } else {
                return new Results(Code.success, "根据父级菜单id查询子菜单成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "根据父级菜单id查询子菜单捕获到异常" + e.toString(), "", apiDesc);
        }
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

