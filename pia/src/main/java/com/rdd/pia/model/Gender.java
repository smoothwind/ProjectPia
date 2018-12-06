package com.rdd.pia.model;


/**
 * @author mic
 */
public enum Gender {
    MALE(1),FEMALE(2),OTHER(0);


    private  Integer value;

    Gender(Integer value) {
        this.value = value;
    }

}
