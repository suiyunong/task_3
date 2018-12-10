package cn.syn.chuilun.service.impl;

import cn.syn.chuilun.dao.ArtistMapper;
import cn.syn.chuilun.model.Artist;
import cn.syn.chuilun.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    public void setArtistMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }


    @Override
    public long insert(Artist artist) {
        int result = artistMapper.insert(artist);
        return artist.getId();
    }

    @Override
    public boolean deleteById(Long id) {
        boolean bool = artistMapper.deleteById(id) == 1 ? true : false;
        return bool;
    }

    @Override
    public boolean update(Artist artist) {
        boolean bool = artistMapper.update(artist) == 1 ? true : false;
        return bool;
    }

    @Override
    public Long getIdByEmail(String email) {
        Long id = artistMapper.getIdByEmail(email);
        return id;
    }

    @Override
    public Artist getArtistByEmail(String email) {
        Long id = artistMapper.getIdByEmail(email);
        Artist artist = artistMapper.selectById(id);
        return artist;
    }

    @Override
    public void updateEmail(String oldEmail, String newEmail) {
        artistMapper.updateArtistValue("email", oldEmail, "email", newEmail);

    }

    @Override
    public void updateAddress(String email, String address) {
        artistMapper.updateArtistValue("email", email, "address", address);

    }

    @Override
    public void updateName(String email, String name) {
        artistMapper.updateArtistValue("email", email, "name", name);

    }

    @Override
    public void updatePhoneNumber(String email, String phoneNumber) {
        artistMapper.updateArtistValue("email",email, "phone_num", phoneNumber);

    }

    @Override
    public void updateCareer(String email, String career) {
        artistMapper.updateArtistValue("email",email, "career", career);
    }

    @Override
    public void updateImgUrl(String email, String imgUrl) {
        artistMapper.updateArtistValue("email",email, "img_url", imgUrl);
    }

    @Override
    public Artist selectById(Long id) {
        Artist artist = artistMapper.selectById(id);
        return artist;
    }
}
