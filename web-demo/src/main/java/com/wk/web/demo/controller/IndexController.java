package com.wk.web.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "greeting");
        return "index";
    }

    @RequestMapping("/showMaker")
    public String showMarker(Model model) {
        List<HashMap<String, Object>> mapList = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            HashMap<String, Object> map = new HashMap<String, Object>() {
                {
                    put("name", "json" + finalI);
                    put("age", finalI + 20);
                }
            };
            mapList.add(map);
        }

        System.out.println(mapList.toString());
        String[] titles = new String[]{"name", "age"};
        model.addAttribute("titles", titles);
        model.addAttribute("values", mapList);
        return "showMaker";
    }
}
