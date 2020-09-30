package com.utils.testutils.controller;

import com.utils.testutils.entity.vo.BaseResponseVO;
import com.utils.testutils.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/getToken")
    @ResponseBody
    public BaseResponseVO getToken(@RequestParam(value = "type",defaultValue = "2") int type){
        String token = tokenService.getToken(type);
        return BaseResponseVO.success(token);
    }
}
