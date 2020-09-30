package com.utils.testutils;

import com.utils.testutils.commons.redisUtils.RedisUtil;
import org.junit.jupiter.api.Test;

public class RedisUtilsTest {

    RedisUtil redisUtil = new RedisUtil();

    @Test
    void test(){

        String res = (String) redisUtil.get("sss");

    }
}
