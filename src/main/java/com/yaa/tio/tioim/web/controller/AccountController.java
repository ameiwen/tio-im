package com.yaa.tio.tioim.web.controller;

import com.yaa.tio.tioim.web.controller.base.BaseController;
import com.yaa.tio.tioim.web.model.Account;
import com.yaa.tio.tioim.web.service.AccountServer;
import com.yaa.tio.tioim.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class AccountController extends BaseController {

    @Autowired
    private AccountServer accountServer;

    @ResponseBody
    @PostMapping(value = "/register")
    public ResponseVo register(Account account){
        return accountServer.register(account);
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public ResponseVo login(HttpServletRequest request){
        Map<String,Object> params = buildParam(request);
        return accountServer.login(params);
    }


}
