package com.longcheng.xxh.energycenter.service.mass;

import com.alibaba.fastjson.JSONObject;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.MediaData;
import com.longcheng.xxh.energycenter.entity.mass.Patch;


/**
     * mediaData
     * @author yangbo
     * @date 2019/10/31
     */
    public interface MediaDataService {

        /**
         * 新增
         */
        public Results insert(MediaData mediaData);

        /**
         * 新增
         */
        public Results insertAll(JSONObject obj);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(MediaData mediaData);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);

        /**
         * 查詢所有数据
         */
        public Results findAllMediaData();



        public Results findByMidOrPidMediaData(int mid,int pid);

    }





