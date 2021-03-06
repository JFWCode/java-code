package com.wk.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestMapper {

    @RequestMapping("/say")
    @ResponseBody
    public String sayWhat(@RequestParam(required = false, defaultValue = "") String words) {
        return "say " + words;
    }
}
