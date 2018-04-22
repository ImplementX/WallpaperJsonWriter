package com.wallpaper.json.service.impl;


import com.sun.org.apache.regexp.internal.RE;
import com.wallpaper.json.service.FileService;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService{
    public String fileRead(String pathName){
        Path file = Paths.get(pathName);
        BufferedReader bf;
        try {
             bf = new BufferedReader(new FileReader(file.toFile()),1024);
            String result =  bf.readLine();
            bf.close();
            return result;
        }  catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


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
