
package com.lisn.idea.net.exception;

import com.lisn.idea.net.common.ErrorCode;

/**
 * Author: LiShan
 * Time: 2019-10-29
 * Description:
 */
public class RemoteLoginExpiredException extends RuntimeException {
    private int errorCode;

    public RemoteLoginExpiredException(int errorCode, String cause) {
        super(ErrorCode.getErrorMessage(errorCode), new Throwable(cause));
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}