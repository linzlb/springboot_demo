package com.linzlb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * 返回到freemaker视图
 * @author user
 *
 */
@Controller //普通全页面刷新的时候用这个
@RequestMapping("/freemarker")
public class HelloWorldFreemakerController {
 
    /**
     * 设置数据，返回到freemarker视图
     * @return
     */
    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message", "SpringBoot，你好！");
        mav.setViewName("helloWorld");
        return mav;
    }
}
