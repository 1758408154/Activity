package com.changes.enums;

import lombok.Getter;

/**
 * ActivitiKey
 *
 * @author LiuJunJie
 * @Since 2020/10/30
 */
@Getter
public enum ActivitiKey {

    HELLOWORLD("helloworld");

    private String key;

    ActivitiKey(String key){
        this.key = key;
    }

}
