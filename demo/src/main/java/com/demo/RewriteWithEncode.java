package com.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import java.lang.annotation.*;

class RewriteWithEncode {
    public static final Logger logger = LoggerFactory.getLogger(RewriteWithEncode.class);

    public static void main(String[] args) {
        String srcFileName = "/home/wangke/WorkSpace/github/java-code/demo/src/main/resources/GBKTestFile.txt";
        String targetFilename = "/home/wangke/WorkSpace/github/java-code/demo/src/main/resources/UTFTestFile.txt";
        String charSet = System.getProperty("file.encoding");

        try {
            fileRecoverGBKToUTF(srcFileName, targetFilename);
//            fileReadlineRecover(srcFileName, targetFilename, charSet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Deprecated
    public static void fileRecoverGBKToUTF(String srcFileName, String targetFilename) throws IOException{
        InputStreamReader gbkFile = new InputStreamReader(new FileInputStream(srcFileName), "GBK");
        OutputStreamWriter utfFile = new OutputStreamWriter(new FileOutputStream(targetFilename), "UTF-8");

        int len = 0;
        while ((len = gbkFile.read()) != -1) {
            utfFile.write(len);
        }
        gbkFile.close();
        utfFile.close();
    }

    public static void fileReadlineRecover(String srcFileName, String targetFilename, String charSet) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFileName), "gbk");
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter isw = new OutputStreamWriter(new FileOutputStream(targetFilename), "utf-8");
        BufferedWriter bw = new BufferedWriter(isw);
        String line;

        while ((line = br.readLine()) != null) {
            bw.write(line + "\n");
        }

        br.close();
        bw.close();
    }

    public static String gbkToUtf(String str) throws IOException {
        if (!str.equals(new String(str.getBytes(), "GBK"))) {
            System.out.println(str);
            str = new String(str.getBytes("GBK"), "UTF-8");
            System.out.println(str);
            System.out.println("-----****----\n");
        }
        System.out.println(str);
        return str;
    }
}
