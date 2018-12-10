package cn.syn.chuilun.dao;

import cn.syn.chuilun.model.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteById(Long id);

    int insert(Work work);

    Work selectById(Long id);

    int update(Work work);

    void updateValueById(@Param("id") long id,@Param("key") String key, @Param("value") Object value);

    void setUp(Long id);

    void setDown(Long id);

    List<Work> selectAllWorks();

    List<Work> selectBannerWorks();

    void setUpBanner(Long id);

    void setDownBanner(Long id);

    List<Work> selectWorkListByKeyValue(@Param("key") String key, @Param("value") int value);
}