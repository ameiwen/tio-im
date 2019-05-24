package com.yaa.tio.tioim.web.controller.base;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    /**
     * 组装参数
     */
    protected Map<String,Object> buildParam(HttpServletRequest request){
        Map<String,Object> params = new HashMap<>();
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            if(StringUtils.isNotBlank(value)){
                params.put(name,value);
                request.setAttribute(name,value);
            }
        }
        return params;
    }

}
