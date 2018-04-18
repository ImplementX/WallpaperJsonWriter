package com.wallpaper.json.main;

import com.google.gson.Gson;
import com.wallpaper.json.pojo.Picture;
import com.wallpaper.json.pojo.Tag;
import com.wallpaper.json.service.FileService;
import com.wallpaper.json.service.PictureService;
import com.wallpaper.json.service.TagService;
import com.wallpaper.json.service.impl.FileServiceImpl;
import com.wallpaper.json.service.impl.PictureServiceImpl;
import com.wallpaper.json.service.impl.TagServiceImpl;
import com.wallpaper.json.util.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


public class MainClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainClass.class);
    private static final String path = "/data/wallpaper-spider/wallpaper_api";
//    final static String path = "d:/test";
    public static void main(String[] args) {
        LOGGER.info("**************************************************");
        LOGGER.info("txt文件写入开始");
        PictureService pictureService = new PictureServiceImpl();
        FileService fileService = new FileServiceImpl();
        TagService tagService = new TagServiceImpl();

        Gson gson = new Gson();
        List<Tag> tagList = tagService.listTags();
        List<Picture> list1 = pictureService.listPicturesAsc();
        List<Picture> list2 = pictureService.listPicturesDesc();
        String popularList = gson.toJson(list1);
        String latestList = gson.toJson(list2);
        for(Tag tag :tagList){
           String json = gson.toJson(pictureService.listPicturesByTag(tag));
            LOGGER.info("写入"+tag.getTagName());
            String tagPinYin = tag.getTagPinyin();
            fileService.fileWrite(path, tagPinYin, json);
        }
//        System.out.println(popularList);
        LOGGER.info("写入popularList.txt");
        fileService.fileWrite(path, "popularList", popularList);
        LOGGER.info("写入latestList.txt");
        fileService.fileWrite(path, "latestList", latestList);



        DBUtils.closeSqlSession();
        LOGGER.info("txt文件写入结束");
        LOGGER.info("**************************************************\n");
    }
}
