package cn.besbing.controller;

import cn.besbing.mapper.primary.PrimaryCustom;
import cn.besbing.service.primary.impl.IPrimaryCustomServiceImpl;
import cn.besbing.service.slave.impl.ISlaveCustomServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    IPrimaryCustomServiceImpl iPrimaryCustomService;

    @Autowired
    ISlaveCustomServiceImpl iSlaveCustomService;


    @RequestMapping(value = "/tt")
    @ResponseBody
    public void TestPost(){
        JSONObject jsonObject = new JSONObject();
        String s = iPrimaryCustomService.TestConnection();
        logger.info("===primary===================" + s);
        String k = iSlaveCustomService.TestConnection();
        logger.info("===slave===================" + k);

    }


}
