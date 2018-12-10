package cn.syn.chuilun.dao;

import cn.syn.chuilun.model.Artist;
import org.apache.ibatis.annotations.Param;

public interface ArtistMapper {
    int deleteById(Long id);

    int insert(Artist artist);

    int update(Artist artist);

    Artist selectById(Long id);

    void updateArtistValueById(@Param("id") long id, @Param("key") String key, @Param("value") Object object);

    void updateArtistValue(@Param("queryKey") String queryKey, @Param("queryValue") Object queryValue, @Param("key") String key, @Param("value") Object value);

    long getIdByEmail(@Param("email") String email);


}