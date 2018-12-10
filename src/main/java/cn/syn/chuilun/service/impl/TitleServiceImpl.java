package cn.syn.chuilun.service.impl;

import cn.syn.chuilun.dao.TitleMapper;
import cn.syn.chuilun.model.Title;
import cn.syn.chuilun.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("titleService")
public class TitleServiceImpl implements TitleService{
    @Autowired
    private TitleMapper titleMapper;

    public void setTitleMapper(TitleMapper titleMapper) {
        this.titleMapper = titleMapper;
    }

    @Override
    public Long insert(Title title) {
        titleMapper.insert(title);
        return title.getId();
    }

    @Override
    public boolean updateTitleName(String oldName, String newName) {
        boolean bool = titleMapper.updateTitleValue("name",oldName,"name",newName) == 1 ? true : false;
        return bool;
    }

    @Override
    public boolean updateTitleUrl(String name, String url) {
        boolean bool = titleMapper.updateTitleValue("name",name,"url",url) == 1 ? true : false;
        return bool;

    }

    @Override
    public boolean updateTitleLevel(String name, int level) {
        boolean bool = titleMapper.updateTitleValue("name",name,"level",level) == 1 ? true : false;
        return bool;
    }

    @Override
    public List<Title> getTitleList() {
        List<Title> titleList = titleMapper.selectTitleList();
        return titleList;
    }
}
