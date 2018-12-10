package cn.syn.chuilun.service.impl;

import cn.syn.chuilun.dao.WorkMapper;
import cn.syn.chuilun.model.Work;
import cn.syn.chuilun.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("workService")
public class WorkServiceImpl implements WorkService{
    @Autowired
    private WorkMapper workMapper;

    public void setWorkMapper(WorkMapper workMapper) {
        this.workMapper = workMapper;
    }


    @Override
    public boolean deleteById(Long id) {
        boolean bool = workMapper.deleteById(id) == 1 ? true : false;
        return bool;
    }

    @Override
    public Long insert(Work work) {
        workMapper.insert(work);
        return work.getId();
    }

    @Override
    public Work selectById(Long id) {
        Work work = workMapper.selectById(id);
        return work;
    }

    @Override
    public boolean update(Work work) {
        boolean bool = workMapper.update(work) == 1 ? true : false;
        return bool;
    }

    @Override
    public void setUp(Long id) {
        workMapper.setUp(id);
    }

    @Override
    public void setDown(Long id) {
        workMapper.setDown(id);

    }

    @Override
    public List<Work> selectAllWorks() {
        List<Work> workList = workMapper.selectAllWorks();
        return workList;
    }

    @Override
    public List<Work> selectBannerWorks() {
        List<Work> workList = workMapper.selectBannerWorks();
        return workList;
    }

    @Override
    public void setUpBanner(Long id) {
        workMapper.setUpBanner(id);

    }

    @Override
    public void setDownBanner(Long id) {
        workMapper.setDownBanner(id);

    }

    @Override
    public List<Work> selectWorkListByKeyValue(String key, int value) {
        List<Work> workList = workMapper.selectWorkListByKeyValue(key, value);
        return workList;
    }

    @Override
    public void updateWorkIntro(Long id, String intro) {
        workMapper.updateValueById(id, "intro", intro);
    }
}
