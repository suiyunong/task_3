package cn.syn.chuilun.service;

import cn.syn.chuilun.BaseTest;
import cn.syn.chuilun.model.Collec;
import cn.syn.chuilun.model.Work;
import cn.syn.chuilun.web.ResponseTo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;



public class CollecServiceTest extends BaseTest{
    @Resource
    private CollecService collecService;
    @Autowired
    private ResponseTo responseTo;

    @Test
    public void deleteById() {

    }

    @Test
    public void insert() {
        Collec collec = new Collec();
        collec.setType("人物");
        collec.setCreateAt(System.currentTimeMillis());
        collec.setName("我的第一幅作品");
        collec.setStatus(0);
        collec.setEditorId((long) 1);
        collec.setArtistId((long) 1);
        Long id=collecService.insert(collec);
        if (id >0) {
            System.out.println("添加成功！返回ID：" + id);
            System.out.println(collec);
        }else{
            System.out.println("添加失败");
        }
    }

    @Test
    public void selectById() {
        Collec collec = collecService.selectById((long) 1);
        if (collec == null) {
            System.out.println("查询用户不存在");
        }else{
            System.out.println(collec);
        }
    }

    @Test
    public void update() {
        Collec collec = collecService.selectById((long) 2);
        collec.setName("咱当兵的人");
        collecService.update(collec);
    }

    @Test
    public void setUp() {
        collecService.setUp((long) 2);
    }

    @Test
    public void setDown() {
        collecService.setDown((long) 2);
    }

    @Test
    public void selectCollecListByName() {
        List<Collec> collecList = collecService.selectCollecListByName("遇见草原");
        for (Collec collec:collecList
                ) {System.out.println(collec);

        }
    }

    @Test
    public void searchByKey() {

        List<Work> workList = new ArrayList<>();
        workList = collecService.searchByKey("真好");
        for (Work work:workList
             ) {System.out.println(work);

        }
    }
}