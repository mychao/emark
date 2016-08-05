package com.mychao.emark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author myc
 * @version 2016/8/3
 */
@Controller
@RequestMapping("/front")
public class IndexController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }

}
