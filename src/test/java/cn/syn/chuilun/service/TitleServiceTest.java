package cn.syn.chuilun.service;

import cn.syn.chuilun.BaseTest;
import cn.syn.chuilun.model.Title;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TitleServiceTest extends BaseTest{
    @Resource
    private TitleService titleService;


    @Test
    public void insert() {
        Title title = new Title();
        title.setCreateAt(System.currentTimeMillis());
        title.setName("一级标题");
        title.setLevel(1);
        title.setUrl("http://www.jnshu.com/school/28087/daily");
        title.setEditorId((long) 1);
        Long id=titleService.insert(title);
        if (id >0) {
            System.out.println("添加成功！返回ID：" + id);
            System.out.println(title);
        }else{
            System.out.println("添加失败");
        }
    }

    @Test
    public void updateTitleName() {
        String name="一级标题";
        String newName = "一级标题2";
        titleService.updateTitleName(name, newName);
    }

    @Test
    public void updateTitleUrl() {
        String name = "二级标题";
        String url = "https://blog.csdn.net/shouldnotappearcalm/article/details/54381408";
        titleService.updateTitleUrl(name, url);
    }

    @Test
    public void updateTitleLevel() {
        String name = "二级标题";
        int level = 2;
        titleService.updateTitleLevel(name, level);
    }

    @Test
    public void getTitleList() {
        List<Title> titleList = new ArrayList<>();
        titleList = titleService.getTitleList();
        for (Title title : titleList
                ) {
            System.out.println(title);
        }
    }
}