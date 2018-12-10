package cn.syn.chuilun.service;

import cn.syn.chuilun.model.Work;

import java.util.List;

public interface WorkService {
    boolean deleteById(Long id);

    Long insert(Work work);

    Work selectById(Long id);

    boolean update(Work work);

    void setUp(Long id);

    void setDown(Long id);

    List<Work> selectAllWorks();

    List<Work> selectBannerWorks();

    void setUpBanner(Long id);

    void setDownBanner(Long id);

    List<Work> selectWorkListByKeyValue(String key, int value);

    void updateWorkIntro(Long id, String intro);


}
