package com.longcheng.xxh.energycenter.entity.basepo;

public class Results {
    private String ErrCode; //返回code码值
    private String ErrMsg;//定义message信息
    private Object Result; //返回的数据信息
    private String ApiDesc;//接口描述描述这个接口是干什么的

    public Results() {
    }

    public Results(String ErrCode, String ErrMsg, Object Result, String ApiDesc) {
        this.ErrCode = ErrCode;
        this.ErrMsg = ErrMsg;
        this.Result = Result;
        this.ApiDesc = ApiDesc;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String ErrCode) {
        this.ErrCode = ErrCode;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public Object getResult() {
        return Result;
    }

    public void setResult(Object Result) {
        this.Result = Result;
    }

    public String getApiDesc() {
        return ApiDesc;
    }

    public void setApiDesc(String ApiDesc) {
        this.ApiDesc = ApiDesc;
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
