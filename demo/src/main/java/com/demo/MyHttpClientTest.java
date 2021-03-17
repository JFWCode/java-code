package com.demo;

import okhttp3.*;

import java.io.IOException;

public class MyHttpClientTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("content_type","testplans.TestPlan")
                .addFormDataPart("obj_pk","697")
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.174.57:8081/usercollections/post/")
                .method("POST", body)
                .addHeader("Cookie", "XXL_JOB_LOGIN_IDENTITY=6333303830376536353837616465323835626137616465396638383162336437; experimentation_subject_id=eyJfcmFpbHMiOnsibWVzc2FnZSI6IklqTTNObVZrWVdReUxUQmxNek10TkdFek9DMDRZbVEzTFRjMk1UYzFPVFptWVRJd015ST0iLCJleHAiOm51bGwsInB1ciI6ImNvb2tpZS5leHBlcmltZW50YXRpb25fc3ViamVjdF9pZCJ9fQ%3D%3D--22c1c1bce660770bc9f04333caf532434baed9a4; sidebar_collapsed=false; event_filter=all; known_sign_in=N2Mva29UWXowa1JRY29iY1hGNGU0dUZYekFseUFRQmVVL2wzbDBpVXRYeDVieE1FemJURGFJR3dYU1NMT3JmdWZISnNZd2JZSmFnV2YvY1ArVDRQVUpuSEZTU1JiV1Vpd1FSREJyT01GK3VYWEFzVHZUbVUxZXl4OEJzVFc0bUctLVZMUDl6NTloY1RGK2V4b2VkSWs5RWc9PQ%3D%3D--1f4560da029bdc9ae96dc64df4ffa471061922ba; _gitlab_session=ff6401c24a5fedacc7f78fd3364dcbad; _ga=GA1.1.226265458.1615447751; metabase.SESSION=d292b658-277b-4a99-9bc0-c5ed998859b0; csrftoken=Dd1c3xtTpsTnwombUE2Odd9CsrhWqBl9PzRONC9aWHwcEo5H2ODTXli1UF3jX3XQ; sessionid=dw6uir833krj75ff0crsuckg5r1vv2jn")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
