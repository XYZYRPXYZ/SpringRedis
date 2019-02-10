package com.robin.service;

import com.robin.manager.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTestService {

    @Autowired
    RedisCacheManager redisCacheManager;

    public String runTestFun() {
        redisCacheManager.set("robin","2B");
        return redisCacheManager.get("robin").toString();
    }
}
