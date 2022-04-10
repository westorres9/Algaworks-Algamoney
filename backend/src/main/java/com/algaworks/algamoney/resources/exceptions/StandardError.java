package com.algaworks.algamoney.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String error;
    private String message;
    private String path;
    private Integer status;
    private Instant timestamp;

    public StandardError() {
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatus() {
        return status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
