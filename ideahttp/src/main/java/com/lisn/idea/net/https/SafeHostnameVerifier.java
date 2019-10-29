package com.lisn.idea.net.https;


import com.lisn.idea.net.common.Constants;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


/**
 * Author: LiShan
 * Time: 2019-10-29
 * Description:
 */
public class SafeHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        if (Constants.IP.equals(hostname)) {//校验hostname是否正确，如果正确则建立连接
            return true;
        }
        return false;
    }
}
