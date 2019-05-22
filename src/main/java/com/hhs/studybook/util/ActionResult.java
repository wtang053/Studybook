package com.hhs.studybook.util;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

//
// Dear maintainer:
//
// Once you are done trying to 'optimize' this routine,
// and have realized what a terrible mistake that was,
// please increment the following counter as a warning
// to the next guy:
//
// total_hours_wasted_here = 180
//
public class ActionResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    /**
     * @param returnCode
     * @return
     */
    public static ActionResult genActionResult(ResultCode returnCode) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        return actionResult;
    }

    public static ActionResult genActionResultByOk() {
        ResultCode returnCode = ResultCode.CODE_OK;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        return actionResult;
    }

    public static ActionResult genActionResultByOk(Object data) {
        ResultCode returnCode = ResultCode.CODE_OK;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult genActionResultByOk(ResultCode resultCode, Object data) {
        ResultCode returnCode = resultCode;
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }

    public static ActionResult genActionResult(ResultCode returnCode, Object data) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        actionResult.setMessage(returnCode.getMsg());
        actionResult.setData(data);
        return actionResult;
    }


    public static ActionResult genActionResultWithMsgData(ResultCode returnCode, Object... msgData) {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode(returnCode.getCode());
        if (msgData != null && msgData.length > 0 && returnCode.getMsg() != null) {
            actionResult.setMessage(String.format(returnCode.getMsg(), msgData));
        } else {
            actionResult.setMessage(returnCode.getMsg());
        }
        return actionResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Object toJSONObject() {
        return JSONObject.toJSON(this);
    }
}
