package cn.syn.chuilun.service;

import cn.syn.chuilun.model.Artist;


public interface ArtistService {

//    插入返回id
    long insert(Artist artist);

    boolean deleteById(Long id);

    boolean update(Artist artist);

    Long getIdByEmail(String email);

    Artist getArtistByEmail(String email);

    //    注册使用Email，根据Email获取艺术家的所有信息
    void updateEmail(String oldEmail, String newEmail);

    void updateAddress(String email, String address);

    void updateName(String email, String name);

    void updatePhoneNumber(String email, String phoneNumber);

    void updateCareer(String email, String career);

    void updateImgUrl(String email, String imgUrl);

    Artist selectById(Long id);

}
