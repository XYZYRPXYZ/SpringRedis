package com.robin.controller;

import com.robin.model.ResponseModel;
import com.robin.service.RunTestService;
import com.robin.utils.HttpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/test-redis")
public class RunTestController {

    @Autowired
    RunTestService runTestService;

    @RequestMapping(value = "/testRedis", method = RequestMethod.GET)
    public ResponseModel<?> testRedis(HttpServletRequest request) {
        ResponseModel<String> responseModel = new ResponseModel<String>();
        try {
            responseModel.setCode(HttpCode.OK.value());
            responseModel.setData(runTestService.runTestFun());
        } catch (Exception e) {
            responseModel.setCode(HttpCode.INTERNAL_SERVER_ERROR.value());
        }
        return responseModel;
    }
}
