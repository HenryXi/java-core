package com.henryxi.io.serialize;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDeserialize {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/user_version1.txt");
        byte[] data = Files.readAllBytes(path);
        User user = SerializationUtils.deserialize(data);
        System.out.println(user);
    }
}
