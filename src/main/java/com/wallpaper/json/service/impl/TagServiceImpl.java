package com.wallpaper.json.service.impl;

import com.wallpaper.json.dao.TagMapper;
import com.wallpaper.json.pojo.Tag;
import com.wallpaper.json.service.TagService;
import com.wallpaper.json.util.DBUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class TagServiceImpl implements TagService{
    SqlSession sqlSession = null;
    public TagServiceImpl() {
        this.sqlSession = DBUtils.getSqlSession();
    }

    public List<Tag> listTags(){
        TagMapper tagMapper = sqlSession.getMapper(TagMapper.class);
        return tagMapper.selectAll();

    }
}
