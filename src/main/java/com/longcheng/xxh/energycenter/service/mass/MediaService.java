package com.longcheng.xxh.energycenter.service.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Media;


/**
     * media
     * @author yangbo
     * @date 2019/10/16
     */
    public interface MediaService {

        /**
         * 新增
         */
        public Results insert(Media media);

        /**
         * 删除
         */
        public Results delete(String id);

        /**
         * 更新
         */
        public Results update(Media media);

        /**
         * 根據主鍵 id 查詢
         */
        public Results load(int id);

        /**
         * 分页查询
         */
        public Results pageList(int offset, int pagesize);

    /**
     * 查詢所有介质
     */
    public Results findAllMedia();

    /**
     * 通过pid查询介质
     */
    public Results findByPidMedia(String pid);


    /**
     * 查询一级介质
     */
    public Results findByOneMedia();

    }





