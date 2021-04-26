package com.demo;


import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class Base64Transform {
    @Test
    public void changeCode() throws Exception {
        String paramsChinese = "{\"key1\": \"StrongTest/01_OnStart/OnStart_TBOX-QQ音乐_B+\", \"key2\":\"StrongTest/01_OnStart/OnStart_TBOX-QQ音乐_acc\", \"key3\": \"StrongTest/01_OnStart/OnStart_TBOX-QQ音乐_wakeup\", \"casearr\":[{\"case_addr\":\"git_url: https://gitlab.office.iauto.com/testing/autost/tcs/demo.git\",\"case_branch\":\"master\",\"case_name\":\"autotest/wk_demo_case_listdir.tcs\",\"case_repo_path\":\"gitlab.office.iauto.com/testing/autost/tcs/demo\",\"case_run_id\":10757139,\"protocol\":\"git\"},{\"case_addr\":\"git_url: https://gitlab.office.iauto.com/testing/autost/tcs/demo.git\",\"case_branch\":\"master\",\"case_name\":\"autotest/测试中文-字符_case.tcs\",\"case_repo_path\":\"gitlab.office.iauto.com/testing/autost/tcs/demo\",\"case_run_id\":10757140,\"protocol\":\"git\"},{\"case_addr\":\"git_url: https://gitlab.office.iauto.com/testing/autost/tcs/demo.git\",\"case_branch\":\"master\",\"case_name\":\"autotest/测试中文字符case.tcs\",\"case_repo_path\":\"gitlab.office.iauto.com/testing/autost/tcs/demo\",\"case_run_id\":10757141,\"protocol\":\"git\"}],\"report_dir\":\"http://192.168.174.57:9999/monitor_disk/getStoragePath/\",\"testrun_id\":40649,\"type\":\"Common\",\"upload_url\":\"http://192.168.174.57:80/upload\"}";
        String encodeStr = Base64.encodeBase64URLSafeString(paramsChinese.getBytes());
        System.out.println(new String(Base64.decodeBase64URLSafe(encodeStr)));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/wangke/WorkSpace/github/java-app/demo/src/main/resources/test.txt"));
        bufferedWriter.write(encodeStr);
        bufferedWriter.close();
    }


    @Test
    public void changeCodeFromFile() throws Exception {
        FileReader fileReader = new FileReader("/home/wangke/WorkSpace/github/java-app/demo/src/main/resources/params.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder strBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            strBuilder.append(line);
        }
        bufferedReader.close();

        strBuilder.append("==");
        String content = strBuilder.toString();
        System.out.println(content);
        System.out.println(new String(Base64.decodeBase64URLSafe(content)));
    }
}