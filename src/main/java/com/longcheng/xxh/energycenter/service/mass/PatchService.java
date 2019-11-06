package com.longcheng.xxh.energycenter.service.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Media;
import com.longcheng.xxh.energycenter.entity.mass.Patch;


/**
     * media
     * @author yangbo
     * @date 2019/10/31
     */
    public interface PatchService {

        /**
         * 新增
         */
        public Results insert(Patch patch);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(Patch patch);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);

        /**
         * 查詢所有采集点名
         */
        public Results findAllPatch();


    }





