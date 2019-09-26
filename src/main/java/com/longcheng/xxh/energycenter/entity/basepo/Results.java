package com.longcheng.xxh.energycenter.entity.basepo;

public class Results {
    private String ErrCode; //返回code码值
    private String ErrMsg;//定义message信息
    private Object Result; //返回的数据信息
    private String ApiDesc;//接口描述描述这个接口是干什么的

    public Results() {
    }

    public Results(String errCode, String errMsg, Object result, String apiDesc) {
        ErrCode = errCode;
        ErrMsg = errMsg;
        Result = result;
        ApiDesc = apiDesc;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String errCode) {
        ErrCode = errCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }

    public Object getResult() {
        return Result;
    }

    public void setResult(Object result) {
        Result = result;
    }

    public String getApiDesc() {
        return ApiDesc;
    }

    public void setApiDesc(String apiDesc) {
        ApiDesc = apiDesc;
    }

    @Override
    public String toString() {
        return "Results{" +
                "ErrCode='" + ErrCode + '\'' +
                ", ErrMsg='" + ErrMsg + '\'' +
                ", Result=" + Result +
                ", ApiDesc='" + ApiDesc + '\'' +
                '}';
    }
}
