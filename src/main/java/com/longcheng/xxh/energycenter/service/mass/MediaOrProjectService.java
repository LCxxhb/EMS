package com.longcheng.xxh.energycenter.service.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.MediaOrProject;
import com.longcheng.xxh.energycenter.entity.mass.Project;


/**
     * Project
     * @author yangbo
     * @date 2019/10/28
     */
    public interface MediaOrProjectService {

        /**
         * 新增
         */
        public Results insert(MediaOrProject mediaOrProject);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(MediaOrProject mediaOrProject);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);


        /**
         * 查詢所有配置
         */
        public Results findAllMediaOrProject();


        /**
         * 通过Mid查詢所有配置
         */
        public Results findByMidMediaOrProject(String mid);

    }





