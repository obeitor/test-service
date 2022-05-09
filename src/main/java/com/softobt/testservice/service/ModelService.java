package com.softobt.testservice.service;

import com.softobt.testservice.apimodel.TestModel;
import com.softobt.testservice.aspect.TestAnnotate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author aobeitor
 * @since 3/6/20
 */
@Service
public class ModelService{

    @Autowired
    HttpServletResponse response;

    public void setHeader(){
        response.setHeader("test","testing o");
    }


    public TestModel getTestModel(){
        return getIt();
    }
    @TestAnnotate()
    private TestModel getIt(){
        TestModel model = new TestModel();
        model.setFirstname("Abdul");
        model.setAge(26);
        model.setEmail("aobeitor@yahoo.com");
        model.setSurname("Obeitor");

        return model;
    }


}
