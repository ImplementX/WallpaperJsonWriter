package com.wallpaper.json.service;


public interface FileService {

    void fileWrite(String path, String fileName, String content);

    String fileRead(String pathName);

}
