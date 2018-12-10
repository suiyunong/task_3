package cn.syn.chuilun.service.impl;


import cn.syn.chuilun.dao.CollecMapper;
import cn.syn.chuilun.dao.WorkMapper;
import cn.syn.chuilun.model.Collec;
import cn.syn.chuilun.model.Work;
import cn.syn.chuilun.service.CollecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("collecService")
public class CollecServiceImpl implements CollecService {
    @Autowired
    private CollecMapper collecMapper;

    @Autowired
    private WorkMapper workMapper;


    @Override
    public boolean deleteById(Long id) {
        Boolean bool = collecMapper.deleteById(id) == 1 ? true : false;
        return bool;
    }

    @Override
    public Long insert(Collec collec) {
        int result = collecMapper.insert(collec);
        return collec.getId();
    }

    @Override
    public Collec selectById(Long id) {
        Collec collec = collecMapper.selectById(id);
        return collec;
    }

    @Override
    public boolean update(Collec collec) {
        boolean bool = collecMapper.update(collec) == 1 ? true : false;
        return bool;
    }

    @Override
    public void setUp(Long id) {
        collecMapper.setUp(id);
    }

    @Override
    public void setDown(Long id) {
        collecMapper.setDown(id);
    }

    @Override
    public List<Collec> selectCollecListByName(String name) {
        List<Collec> collecList = collecMapper.selectCollecListByName(name);
        return collecList;
    }

    @Override
    public List<Work> searchByKey(String key) {
        // 给 longs 去重
        List<Long> longs = collecMapper.searchByKey("%" + key + "%");
        Set longsSet = new HashSet(longs);
        longs.clear();
        longs.addAll(longsSet);

        List<Work> workList = new ArrayList<>();
        for (Long aLong : longs) {
            workList.add(workMapper.selectById(aLong));
        }
        return workList;
    }

}
