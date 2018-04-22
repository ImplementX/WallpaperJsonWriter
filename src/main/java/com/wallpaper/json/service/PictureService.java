package com.wallpaper.json.service;

import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;

import java.util.List;

public interface PictureService {

    List<Picture> listPicturesAsc();

    List<Picture> listPicturesDesc();

    List<Picture> listPicturesAsc(int limit);

    List<Picture> listPicturesAsc(int limit,int offset);

    List<Picture> listPicturesDesc(int limit);

    List<Picture> listPicturesDesc(int limit,int offset);

    List<Picture> listPicturesByTag(Tag tag);

    List<Picture> listPicturesByTagDesc(Tag tag, int limit,int offset);

    List<Picture> listPicturesByTagAsc(Tag tag, int limit,int offset);




}
