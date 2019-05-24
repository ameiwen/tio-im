package com.yaa.tio.tioim.web.controller;

import com.yaa.tio.tioim.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController extends BaseController {

    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

}
