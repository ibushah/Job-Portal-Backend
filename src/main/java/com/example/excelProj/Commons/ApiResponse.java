package com.example.excelProj.Commons;

public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;
    private Double rating;
    private Boolean already;

    public ApiResponse(int status, String message, Object result, Double rating, Boolean already) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.rating = rating;
        this.already = already;
    }

    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(int status, String message, Object result, Double rating) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Boolean getAlready() {
        return already;
    }

    public void setAlready(Boolean already) {
        this.already = already;
    }
}
