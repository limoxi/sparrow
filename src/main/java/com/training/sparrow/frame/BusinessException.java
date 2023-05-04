package com.training.sparrow.frame;

public class BusinessException extends Exception {
    String errCode;
    String errMsg;

    public static BusinessException NewBusinessException(String errCode, String errMsg) {
        BusinessException inst = new BusinessException();
        inst.errCode = errCode;
        inst.errMsg = errMsg;
        return inst;
    }
}
