package com.henryxi.serialize;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.File;
import java.io.IOException;

public class TestSerialize {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("henry");
        user.setAddress("beijing");
//        user.setAge("27");
        FileUtils.writeByteArrayToFile(new File("/user_version1.txt"), SerializationUtils.serialize(user));
    }
}
