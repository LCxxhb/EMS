package com.longcheng.xxh.energycenter.service.act.serviceImpl;

import com.longcheng.xxh.energycenter.dao.act.GasMapper;
import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Gas;
import com.longcheng.xxh.energycenter.service.act.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GasServiceImpl implements GasService {
    @Autowired
    private GasMapper gasMapper;

   /* @Override
    public List<Enti> find(String param1, String param2) {
        List<Enti> list = gasMapper.find(param1,param2);
        System.out.println(list);
        return list;
    }*/

    /**
     * 不定参数查询
     * @param sql
     * @param areaname
     * @param factory
     * @param tagtype
     * @param begintime
     * @param endtime
     * @param datatype
     * @return
     */
    public List<Enti> find_id(String sql,String areaname, String factory, String tagtype, String begintime, String endtime,String datatype) {
        double sum = 0;
        double avg;
        List<Enti> entilist = gasMapper.find_id(sql, areaname,  factory,tagtype,  begintime,  endtime, datatype);
        System.out.println(entilist);
        if (entilist.size() != 0) {
            for (int i = 0; i < entilist.size(); i++) {
                sum += Double.parseDouble(entilist.get(i).getTagVal());
            }
            avg = sum / entilist.size();
            entilist.get(0).setSum(sum);
            entilist.get(0).setAve(avg);
            entilist.get(0).setMax(Double.parseDouble((entilist.get(entilist.size() - 1).getTagVal())));
            entilist.get(0).setMin(Double.parseDouble((entilist.get(0).getTagVal())));
        } else {
            System.out.println("数据库暂无此数据!");
        }
        return entilist;
    }
   /* @Override
    public Enti findById(int id) {
        return gasMapper.findById(id);
    }*/

    @Override
    public List<Enti> findAllPoint() {
        return gasMapper.findAllPoint();
    }

    @Override
    public Results pageList(int count, int pagesize) {
        List<Enti> pageList = gasMapper.pageList(count, pagesize);
        int totalCount = gasMapper.pageListCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return new Results(Code.success, "查询成功！！", result, "分页查询部分气体信息");

    }

    @Override
    public List<Enti> findAll() {
        return gasMapper.findall();
    }

    @Override
    public List<Enti> findparams(String sql, String datatype,String areaname, String factory, String tagtype) {
        double sum = 0;
        double avg;
        List<Enti> entilist = gasMapper.findparams(sql, datatype, areaname,  factory, tagtype);
        System.out.println(entilist);
        if (entilist.size() != 0) {
            for (int i = 0; i < entilist.size(); i++) {
                sum += Double.parseDouble(entilist.get(i).getTagVal());
            }
            avg = sum / entilist.size();
            entilist.get(0).setSum(sum);
            entilist.get(0).setAve(avg);
            entilist.get(0).setMax(Double.parseDouble((entilist.get(entilist.size() - 1).getTagVal())));
            entilist.get(0).setMin(Double.parseDouble((entilist.get(0).getTagVal())));
        } else {
            System.out.println("数据库暂无此数据!");
        }
        return entilist;
    }

//    @Override
//    public List<Enti> findallmedium(String tagtype) {
//        return gasMapper.findallmedium(tagtype);
//    }
//
//    @Override
//    public List<Enti> findallareaname(String areaname) {
//        return gasMapper.findallareaname(areaname);
//    }
//
//    @Override
//    public List<Enti> findallfactory(String factory) {
//        return gasMapper.findallfactory(factory);
//    }
//
//    @Override
//    public List<Enti> findallpoint(String point) {
//        return gasMapper.findallcollpoint(point);
//    }
}
