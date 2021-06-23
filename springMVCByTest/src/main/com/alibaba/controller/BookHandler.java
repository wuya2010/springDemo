package main.com.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kylinWang
 * @data 2021/5/23 16:53
 */

@Controller
public class BookHandler {

    @RequestMapping
    public String getBooke(){
        return "";
    }

    @RequestMapping
    public String deleteBook(){
        return "";
    }

    @RequestMapping
    public String updateBooke(){
        return "";
    }

    @ResponseBody
    public String addBook(){
        return "";
    }

}
