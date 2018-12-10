package cn.syn.chuilun.service;

import cn.syn.chuilun.BaseTest;
import cn.syn.chuilun.model.Artist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
public class ArtistServiceTest extends BaseTest{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ArtistService artistService;


    @Test
    public void insert() {
        Artist artist = new Artist();
        artist.setEmail("5728273@qq.com");
        artist.setCreateAt(System.currentTimeMillis());
        artist.setName("李健2");
        Long id=artistService.insert(artist);
        if (id >0) {
            System.out.println("添加成功！返回ID：" + id);
            logger.info(artist.toString());
            System.out.println(artist);
        }else{
            System.out.println("添加失败");
        }

    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
        Artist artist = artistService.selectById((long) 2);
        artist.setAddress("沈阳市张概念区");
        artistService.update(artist);
    }

    @Test
    public void getIdByEmail() {
        String email = "294157557@qq.com";
        Long id = artistService.getIdByEmail(email);
        if (id ==null) {

            System.out.println("查询数据不存在");
        }else{
            logger.info("id:"+id+"  email:"+email);
            System.out.println("id:"+id+"  email:"+email);
        }

    }
    @Test
    public void getArtistByEmail(){
        String email = "294157557@qq.com";
        Artist artist= artistService.getArtistByEmail(email);
        if (artist ==null) {

            System.out.println("查询数据不存在");
        }else{
            logger.info("artist:"+artist+"  email:"+email);
            System.out.println("artist:"+artist+"  email:"+email);
        }
    }

    @Test
    public void updateEmail() {
        String oldEmail = "294157557@qq.com";
        String newEmail = "294157557@qq.com";
        artistService.updateEmail(oldEmail,newEmail);
    }

    @Test
    public void updateAddress() {
        String email = "294157557@qq.com";
        String address = "朝阳区238号";
        artistService.updateAddress(email,address);
    }

    @Test
    public void updateName() {
        String email = "294157557@qq.com";
        String name = "张大炮";
        artistService.updateName(email,name);
    }

    @Test
    public void updatePhoneNumber() {
        String email = "294157557@qq.com";
        String phoneNumber = "17664236789";
        artistService.updatePhoneNumber(email,phoneNumber);
    }

    @Test
    public void updateCareer() {
        String email = "294157557@qq.com";
        String career = "牙医";
        artistService.updateCareer(email,career);
    }

    @Test
    public void updateImgUrl() {
        String email = "294157557@qq.com";
        String imgUrl = "https://blog.csdn.net/Tomwildboar/article/details/82560264?utm_source=blogxgwz2";
        artistService.updateImgUrl(email,imgUrl);
    }

    @Test
    public void selectById() {
        Artist artist = artistService.selectById((long) 1);
        if (artist == null) {
            System.out.println("查询用户不存在");
        }else{
            System.out.println(artist);
        }
    }
}