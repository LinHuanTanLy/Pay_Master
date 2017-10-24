package com.luwei.borderless.net;

import java.io.Serializable;

/**
 *
 * @author Ly
 * @date 2017/10/24
 * 最基础的baseBean
 */

public class BaseBean implements Serializable {
    @Override
    public String toString() {
        return "BaseBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
