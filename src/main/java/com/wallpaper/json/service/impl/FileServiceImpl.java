package com.wallpaper.json.service.impl;


import com.wallpaper.json.service.FileService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService{
    public void fileWrite(String path, String fileName, String content){
        Path dictionary = Paths.get(path);
        Path file = Paths.get(path + "/" + fileName);

        try {
            if(!Files.exists(dictionary)) {
                Files.createDirectories(dictionary);
            }
            if(!Files.exists(file)) {

                Files.createFile(file);
                System.out.println("created");
            }
            FileOutputStream outputStream = new FileOutputStream(file.toFile());
            FileChannel channel = outputStream.getChannel();
            byte[] contentBytes = content.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(contentBytes);
            buffer.put(contentBytes);
            buffer.flip();     //此处必须要调用buffer的flip方法
            channel.write(buffer);
            channel.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
