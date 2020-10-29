package com.changes.controller;

import com.changes.service.ProcessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiuJunJie
 */
@RestController
public class ProcessController {

    @Resource
    private ProcessService processService;


    @GetMapping("startProcess")
    public void startProcess(){
        processService.getTask();
    }
}
