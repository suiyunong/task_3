package cn.syn.chuilun.dao;

import cn.syn.chuilun.model.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {
    int deleteById(Long id);

    int insert(Title title);

    Title selectById(Long id);

    int update(Title title);

    int updateTitleValue(@Param("queryKey") String queryKey, @Param("queryValue") Object queryValue, @Param("key") String key, @Param("value") Object value);

    List<Title> selectTitleList();
}