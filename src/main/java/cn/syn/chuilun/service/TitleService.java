package cn.syn.chuilun.service;

import cn.syn.chuilun.model.Title;

import java.util.List;

public interface TitleService {

    Long insert(Title title);

    boolean updateTitleName(String oldName, String newName);

    boolean updateTitleUrl(String name, String url);

    boolean updateTitleLevel(String name, int level);

    List<Title> getTitleList();

}
