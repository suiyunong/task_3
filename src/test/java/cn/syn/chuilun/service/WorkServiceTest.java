package cn.syn.chuilun.service;

import cn.syn.chuilun.BaseTest;
import cn.syn.chuilun.model.Work;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorkServiceTest extends BaseTest{
    @Resource
    private WorkService workService;


    @Test
    public void deleteById() {
    }

    @Test
    public void insert() {
        Work work = new Work();
        work.setCreateAt(System.currentTimeMillis());
        work.setArtistId((long) 2);
        work.setStatus(1);
        work.setEditorId((long) 1);
        work.setCollectionId((long) 1);
        Long id=workService.insert(work);
        if (id >0) {
            System.out.println("添加成功！返回ID：" + id);
            System.out.println(work);
        }else{
            System.out.println("添加失败");
        }
    }

    @Test
    public void selectById() {
        Work work = workService.selectById((long) 2);
        System.out.println(work);

    }

    @Test
    public void update() {
        Work work = workService.selectById((long) 2);
        work.setComment("我曹真牛逼");
        workService.update(work);
    }

    @Test
    public void setUp() {
        workService.setUp((long) 2);
    }

    @Test
    public void setDown() {
        workService.setDown((long) 2);

    }

    @Test
    public void selectAllWorks() {

        List<Work> workList = new ArrayList<>();
        workList = workService.selectAllWorks();
        for (Work work:workList
             ) {
            System.out.println(work);

        }
    }

    @Test
    public void selectBannerWorks() {
        List<Work> workList = workService.selectBannerWorks();
        for (Work work:workList
                ) {
            System.out.println(work);

        }
    }

    @Test
    public void setUpBanner() {
        workService.setUpBanner((long) 2);
    }

    @Test
    public void setDownBanner() {
        workService.setDownBanner((long) 2);
    }

    @Test
    public void selectWorkListByKeyValue() {
        List<Work> workList = workService.selectWorkListByKeyValue("status", 1);
        for (Work work:workList
                ) {
            System.out.println(work);

        }
    }
}