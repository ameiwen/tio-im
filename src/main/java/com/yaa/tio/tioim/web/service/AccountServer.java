package com.yaa.tio.tioim.web.service;


import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.yaa.tio.tioim.db.DBAccess;
import com.yaa.tio.tioim.web.model.Account;
import com.yaa.tio.tioim.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AccountServer {

    @Autowired
    private DBAccess dbAccess;

    public ResponseVo register(Account account){
        if(null == account){
            return ResponseVo.fail();
        }
        if(null == account.getUsername()){
            return ResponseVo.fail("username is not null");
        }
        if(null == account.getPassword()){
            return ResponseVo.fail("password is not null");
        }
        account.setUid(IdUtil.randomUUID());
        account.setPassword(SecureUtil.md5(account.getPassword()));
        dbAccess.putAccount(account);
        ResponseVo responseVo = ResponseVo.success();
        responseVo.addItem("account",account);
        return responseVo;
    }

    public ResponseVo login(Map<String,Object> params){
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String uid = dbAccess.getAccountUid(username,SecureUtil.md5(password));
        if(uid == null){
            return ResponseVo.fail("account not exist");
        }
        ResponseVo responseVo = ResponseVo.success();
        responseVo.addItem("uid",uid);
        return responseVo;
    }

}
