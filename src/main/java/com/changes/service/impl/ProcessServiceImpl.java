package com.changes.service.impl;

import com.changes.service.ProcessService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author LiuJunJie
 */
@Service
public class ProcessServiceImpl implements ProcessService {



    @Resource
    private ProcessEngine processEngine ;


    public void getTask() {

        //部署流程文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService
                .createDeployment()
                .name("请假流程表")
                .addClasspathResource("process/helloworld.bpmn")
                .addClasspathResource("process/helloworld.bpmn.png")
                .enableDuplicateFiltering()
                .deploy();



        //验证已部署流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("helloworld").singleResult();
        String key = processDefinition.getKey();
        System.out.println(key);


        //启动流程并返回实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        System.out.println(processInstance.getId() + ",pdId="+processInstance.getProcessDefinitionId());

    }
}
