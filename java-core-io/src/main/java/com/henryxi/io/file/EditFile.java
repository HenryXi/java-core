package com.henryxi.io.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditFile {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        String line = null;
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\reading.txt");
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            if (line.startsWith("注: ")) {
                line = "\n\n" + line;
                lines.add(line);
                continue;
            }
            if (line.startsWith("20")) {
                line = "\n\n" + line;
                lines.add(line);
                continue;
            }
            line = "\n> " + line;
            lines.add(line);
        }
        fr.close();
        br.close();

        FileWriter fw = new FileWriter(f1);
        BufferedWriter out = new BufferedWriter(fw);
        for (String s : lines) {
            out.write(s);
        }
        out.flush();
        out.close();

    }
}
