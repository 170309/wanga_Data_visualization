package com.wa.common;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {

    /**
     * 响应状态:
     * 1:失败
     * 0:成功
     */
    private int status;

    /**
     * 响应消息:
     * 返回给前端的提示
     */
    private String msg;

    /**
     * 返回给前端的数据
     */
    private T data;

    /**
     * 获取响应状态码
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * 获取携带的消息
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 获取携带的数据
     * @return
     */
    public T getData() {
        return data;
    }


    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回一个成功标记
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>( ResponseCode.SUCCESS.getCode());
    }

    /**
     * 一个带消息的成功返回
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    /**
     * 一个带数据的成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    /**
     * 即带消息也带数据的成功返回
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    /**
     * 错误返回
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     * 带消息错误返回
     * @param errormsg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(String errormsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errormsg);
    }

    /**
     * 自定义消息代码返回
     * @param status
     * @param errormsg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(int status,String errormsg){
        return new ServerResponse<T>(status,errormsg);
    }

}
