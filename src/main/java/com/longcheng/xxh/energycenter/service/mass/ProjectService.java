package com.longcheng.xxh.energycenter.service.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Project;


/**
     * Project
     * @author yangbo
     * @date 2019/10/28
     */
    public interface ProjectService {

        /**
         * 新增
         */
        public Results insert(Project project);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(Project project);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);


        /**
         * 查詢所有属性
         */
        public Results findAllProject();

    }





