package com.wjn.swagger.controller;

import com.wjn.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wjn")
@Api(tags = "HelloController模块")
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/getUser")
    public User getUser(){
        return new User();
    }

    @ApiOperation("wjn的接口")
    @PostMapping("/wjn")
    @ResponseBody
    public String kuang(@ApiParam("这个名字会被返回")String username){
        return username;
    }

}
