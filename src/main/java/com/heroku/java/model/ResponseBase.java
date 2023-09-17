package com.heroku.java.model;

public class ResponseBase {
    private boolean Status;
    private Object Result;
    private String Message;

    public ResponseBase(boolean status, String message, Object result) {
        this.Status = status;
        this.Result = result;
        this.Message = message;
    }
    
    public ResponseBase(boolean status, String message) {
        this.Status = status;
        this.Message = message;
    }


    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Object getResult() {
        return Result;
    }

    public void setResult(Object result) {
        this.Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public ResponseBase(){};

    public ResponseBase Error(String message) {
        this.Status = false;
        this.Message = message;
        return this;
    }

    public ResponseBase Sucesso() {
        this.Status = true;
        this.Message = "ok";
        return this;
    }
}