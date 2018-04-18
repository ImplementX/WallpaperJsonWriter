package com.wallpaper.json.dao;

import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;

import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer picId);

    int insert(Picture record);

    Picture selectByPrimaryKey(Integer picId);

    List<Picture> selectAllAsc();

    List<Picture> selectAllDesc();

    int updateByPrimaryKey(Picture record);

    List<Picture> selectByTag(Tag tag);
}