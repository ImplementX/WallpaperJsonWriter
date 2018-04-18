package com.wallpaper.json.service.impl;

import com.wallpaper.json.dao.PictureMapper;
import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;
import com.wallpaper.json.service.PictureService;
import com.wallpaper.json.util.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PictureServiceImpl implements PictureService {

    SqlSession sqlSession = null;
    PictureMapper pictureMapper = null;
    public PictureServiceImpl() {
        this.sqlSession = DBUtils.getSqlSession();
        pictureMapper = sqlSession.getMapper(PictureMapper.class);
    }

    public List<Picture> listPicturesAsc() {
        return pictureMapper.selectAllAsc();
    }

    public List<Picture> listPicturesDesc() {
        return pictureMapper.selectAllDesc();
    }


    public List<Picture> listPicturesByTag(Tag tag){
        return  pictureMapper.selectByTag(tag);
    }



}
