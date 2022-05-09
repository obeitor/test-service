package com.softobt.testservice.controllers;

import com.softobt.logger.services.LoggerService;
import com.softobt.testservice.apimodel.TestModel;
import com.softobt.testservice.service.ModelService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    ModelService modelService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TestModel getTestModel(){
        return modelService.getTestModel();
    }


    @RequestMapping(value = "/response/{type}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getBooleanValue(@PathVariable("type") String type){
        modelService.setHeader();
        LoggerService.info(this.getClass(),"Response type -> "+type);
        if(type.equalsIgnoreCase("time")){
            return LocalDateTime.now();
        }
        if(type.equalsIgnoreCase("bool")){
            boolean[] bools = {true,false};
            return bools[new Random().nextInt(2)];
        }
        if(type.equalsIgnoreCase("number")){
            return Integer.parseInt(RandomStringUtils.random(3,"0123456789"));
        }
        if(type.equalsIgnoreCase("text")){
            return RandomStringUtils.random(6,"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if(type.equalsIgnoreCase("list")){
            List<TestModel> l = new ArrayList<>();
            l.add(TestModel.createDummy());
            return l;
        }
        return TestModel.createDummy();
    }



    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public TestModel validateObject(@Validated @RequestBody TestModel testModel){
        return testModel;
    }

    @RequestMapping(value = "/error/generic", method = RequestMethod.GET)
    public void serviceError()throws Exception{
        throw new Exception("Exception-bla-bla-bla");
    }



    @RequestMapping(value = "/error/runtime", method = RequestMethod.GET)
    public void runtimeError(){
        throw new RuntimeException("Runtime baaaa...");
    }
}
