package com.rdd.pia.model;


import java.io.Serializable;

/**
 * @author mic
 */
public enum Gender implements Serializable {
    /**
     * 男
     */
    FEMALE(2), MALE(1), OTHER(0);
    private static final long serialVersionUID = -9102021104172019998L;
    private Integer value;

    Gender(Integer value) {
        this.value = value;
    }

}
