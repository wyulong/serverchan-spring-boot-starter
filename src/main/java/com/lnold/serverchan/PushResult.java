package com.lnold.serverchan;

import java.util.Objects;

/**
 * 成功：
 * {
 * "errno": 0,
 * "errmsg": "success",
 * "dataset": "done"
 * }
 * <p>
 * 失败：
 * {
 * "errno": 1024,
 * "errmsg": "不要重复发送同样的内容"
 * }
 */
public class PushResult {


    private Integer errno;
    private String errmsg;
    private String dataset;


    public boolean isSuccess() {
        return Objects.equals(errno, 0);
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", dataset='" + dataset + '\'' +
                '}';
    }
}
