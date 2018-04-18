package com.wallpaper.json.service;

import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;

import java.util.List;

public interface PictureService {
    List<Picture> listPicturesAsc();

    List<Picture> listPicturesDesc();

    List<Picture> listPicturesByTag(Tag tag);

}
