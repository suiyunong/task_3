package cn.syn.chuilun.dao;

import cn.syn.chuilun.model.Collec;

import java.util.List;

public interface CollecMapper {
    int deleteById(Long id);

    int insert(Collec collec);

    Collec selectById(Long id);

    void setUp(Long id);
    //下架
    void setDown(Long id);
    int update(Collec collec);

    List<Collec> selectCollecListByName(String name);


    /**
     * 模糊匹配查询
     *
     * @param key 搜索关键字
     * @return productionId
     */
    List<Long> searchByKey(String key);

}