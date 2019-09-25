package com.longcheng.xxh.energycenter.entity.basepo;

/**
 * 结果返回对象固定
 */
public class Result {

    private String code; //返回code码值
    private String message;//定义message信息
    private Object data; //返回的数据信息
    private String apiDescription;//接口描述描述这个接口是干什么的

    public Result(String code, String message, Object data, String apiDescription) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.apiDescription = apiDescription;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", apiDescription='" + apiDescription + '\'' +
                '}';
    }
}
