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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class MainClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainClass.class);
        private static final String PATH = "/data/wallpaper-spider/wallpaper_api";
//    final static String PATH = "d:/test";

    public static void main(String[] args) {
        LOGGER.info("**************************************************");
        LOGGER.info("txt文件写入开始");
        PictureService pictureService = new PictureServiceImpl();
        FileService fileService = new FileServiceImpl();
        TagService tagService = new TagServiceImpl();

        Gson gson = new Gson();
        List<Tag> tagList = tagService.listTags();
        HashMap<String, Tag> tagMap = new HashMap<>();
        LOGGER.info("写入分类");
        for (Tag tag : tagList) {
            String json = gson.toJson(pictureService.listPicturesByTagDesc(tag, 300, 0));
            LOGGER.info("写入" + tag.getTagName());
            String tagPinYin = tag.getTagPinyin();
            fileService.fileWrite(PATH, tagPinYin, json);
            tagMap.put(tag.getTagPinyin(), tag);
        }

        LOGGER.info("写入popularList");
        List<Picture> list1 = pictureService.listPicturesByTagAsc(tagMap.get("fengjing"), 300, 0);
        list1 = list1.subList(200,300);
        String popularList = gson.toJson(list1);
        fileService.fileWrite(PATH, "popularList", popularList);


        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String today = format.format(new Date());
        if (!Files.exists(Paths.get(PATH + "/count"))) {
            LOGGER.info("创建offset");
            fileService.fileWrite(PATH, "count", today + ":0");
        }
        String fileString = fileService.fileRead(PATH + "/count");
        System.out.println(fileString);

        String date = fileString.substring(0, fileString.indexOf(":"));
        int count = Integer.parseInt(fileString.substring(fileString.indexOf(":") + 1, fileString.length()));


        if (!date.equals(today)) {
            String out = today + ":" + (count + 2);
            LOGGER.info("更新offset");
            fileService.fileWrite(PATH, "count", out);

        }


        LOGGER.info("写入latestList,偏移量："+count);
        List<Picture> list2 = pictureService.listPicturesByTagAsc(tagMap.get("fengjing"), 60, count);
        Collections.reverse(list2);
        String latestList = gson.toJson(list2);
        fileService.fileWrite(PATH, "latestList", latestList);


        DBUtils.closeSqlSession();
        LOGGER.info("txt文件写入结束");
        LOGGER.info("**************************************************\n");
    }
}
