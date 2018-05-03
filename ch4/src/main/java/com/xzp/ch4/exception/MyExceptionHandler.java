package com.xzp.ch4.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = Exception.class)  //捕获的异常
    public ModelAndView exception(HttpServletRequest request,Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","错误信息");
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
