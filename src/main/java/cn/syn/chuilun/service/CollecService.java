package cn.syn.chuilun.service;

import cn.syn.chuilun.model.Collec;
import cn.syn.chuilun.model.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollecService {
    boolean deleteById(Long id);

    Long insert(Collec collec);

    Collec selectById(Long id);

    boolean update(Collec collec);
    //上架
    void setUp(Long id);
    //下架
    void setDown(Long id);

    List<Collec> selectCollecListByName(String name);

    List<Work> searchByKey(String key);
}
