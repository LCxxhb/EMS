package com.longcheng.xxh.energycenter.entity.basepo;

public class PageResults{
    private int total;//总页数
    private Object rows;//总数据

    public PageResults() {
    }

    @Override
    public String toString() {
        return "PageResults{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }


    public PageResults(String errCode, String errMsg, Object result, String apiDesc, int total, Object rows) {
        this.total = total;
        this.rows = rows;
    }
}
