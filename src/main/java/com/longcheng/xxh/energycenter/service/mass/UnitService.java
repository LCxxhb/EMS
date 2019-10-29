package com.longcheng.xxh.energycenter.service.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Project;
import com.longcheng.xxh.energycenter.entity.mass.Unit;


/**
     * Project
     * @author yangbo
     * @date 2019/10/28
     */
    public interface UnitService {

        /**
         * 新增
         */
        public Results insert(Unit unit);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(Unit unit);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);


        /**
         * 查詢所有单位
         */
        public Results findAllUnit();

    }





