package com.utils.testutils.service.impl;

import com.utils.testutils.commons.httpUtils.OkHttpUtil;
import com.utils.testutils.commons.redisUtils.RedisUtil;
import com.utils.testutils.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private OkHttpUtil httpUtil;

    @Override
    public String getToken(int type) {

        String accountToken;
        switch (type){
            case 1:
                if (redisUtil.get("l1Token") == null){
                    accountToken = getTokenWithoutCache(type);
                }else {
                    accountToken = (String) redisUtil.get("l1Token");
                }
                break;
            case 2:
                if (redisUtil.get("l2Token") == null){
                    accountToken = getTokenWithoutCache(type);
                }else {
                    accountToken = (String) redisUtil.get("l2Token");
                }
                break;
            case 3:
                if (redisUtil.get("tradeToken") == null){
                    accountToken = getTokenWithoutCache(type);
                }else {
                    accountToken = (String) redisUtil.get("tradeToken");
                }
                break;
            default:
                accountToken = "";
        }

        return accountToken;
    }

    private String getTokenWithoutCache(int type){

        String accountToken;
        switch (type){
            case 1:
                accountToken = getTokenByRequest(type);
                redisUtil.set("l1Token",accountToken);
                break;
            case 2:
                accountToken = getTokenByRequest(type);
                redisUtil.set("l2Token",accountToken);
                break;
            case 3:
                accountToken = getTokenByRequest(type);
                redisUtil.set("tradeToken",accountToken);
                break;
            default:
                accountToken = "";
        }

        return accountToken;
    }

    private String getTokenByRequest(int type){
//        httpUtil.postJsonParams();
        return "";
    }
}
