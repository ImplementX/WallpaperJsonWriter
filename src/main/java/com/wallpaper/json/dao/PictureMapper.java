package com.wallpaper.json.dao;

import com.sun.scenario.effect.Offset;
import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer picId);

    int insert(Picture record);

    Picture selectByPrimaryKey(Integer picId);

    List<Picture> selectAll(@Param("sortElem") String sortElem, @Param("order") String order, @Param("limit") Integer limit, @Param("offset") Integer offset);

    int updateByPrimaryKey(Picture record);

    List<Picture> selectByTag(@Param("tag") Tag tag, @Param("sortElem") String sortElem, @Param("order") String order, @Param("limit") Integer limit, @Param("offset") Integer offset);
}