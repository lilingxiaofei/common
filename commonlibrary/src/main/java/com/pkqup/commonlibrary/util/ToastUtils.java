package com.pkqup.commonlibrary.util;

import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.pkqup.commonlibrary.net.exception.ApiException;

/**
 * @CreatedbBy: liucun on 2018/6/24.
 * @Describe:
 */
public class ToastUtils {

    private static Toast toast;

    public static void showShort(String msg) {
        if (AppUtils.getContext() != null) {
            if (toast == null) {
                toast = Toast.makeText(AppUtils.getContext(), msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    public static void showNetErrorMsg(Throwable throwable) {
        if (throwable instanceof ApiException) {
            ApiException apiException = (ApiException) throwable;
            if (apiException.getCode() == ApiException.NO_NETWORK) {
                ToastUtils.showShort(apiException.getMessage());
            }
        }
    }

    public static void showErrorMsg(Throwable throwable) {
        if (throwable instanceof ApiException) {
            ApiException apiException = (ApiException) throwable;
            String msg = TextUtils.isEmpty(apiException.getMessage())?"请求失败，请稍后重试":apiException.getMessage();
            ToastUtils.showShort(msg);
        }
    }


}
