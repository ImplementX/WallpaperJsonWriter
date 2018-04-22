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
    public List<Picture> listPicturesAsc(){
        return pictureMapper.selectAll("pic_id","asc",null,null);
    }

    public List<Picture> listPicturesDesc(){
        return pictureMapper.selectAll("pic_id","asc",null,null);
    }

    public List<Picture> listPicturesAsc(int limit) {
        return pictureMapper.selectAll("pic_id","asc",limit,null);
    }

    public List<Picture> listPicturesAsc(int limit, int offset) {
        return pictureMapper.selectAll("pic_id","asc",limit,offset);
    }


    public List<Picture> listPicturesDesc(int limit) {
        return pictureMapper.selectAll("pic_id","desc",limit,null);
    }
    public List<Picture> listPicturesDesc(int limit, int offset) {
        return pictureMapper.selectAll("pic_id","desc",limit,offset);
    }


    public List<Picture> listPicturesByTag(Tag tag){
        return  pictureMapper.selectByTag(tag,null,null,null,null);
    }

    public List<Picture> listPicturesByTagDesc(Tag tag, int limit, int offset){
        return pictureMapper.selectByTag(tag,"pic_id","desc",limit,offset);
    }

    public List<Picture> listPicturesByTagAsc(Tag tag, int limit, int offset){
        return pictureMapper.selectByTag(tag,"pic_id","asc",limit,offset);
    }




}
