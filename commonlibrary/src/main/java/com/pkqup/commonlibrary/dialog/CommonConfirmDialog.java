package com.pkqup.commonlibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pkqup.commonlibrary.R;


public class CommonConfirmDialog extends Dialog {

    private Context context;
    private String content;
    private CallBack callBack;

    private TextView tv_content;
    private TextView tv_confirm;
    private TextView tv_cancel;

    public CommonConfirmDialog(Context context, String content) {
        super(context, R.style.dialog_transparent);
        this.context = context;
        this.content = content;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        initView();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    private void initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_common_confirm, null);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        window.setAttributes(params);
        window.setGravity(Gravity.CENTER);

        setContentView(view);// 设置布局

        tv_content = findViewById(R.id.tv_content);
        tv_confirm = findViewById(R.id.tv_confirm);
        tv_cancel = findViewById(R.id.tv_cancel);

        tv_content.setText(content);
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (null != callBack) {
                    callBack.onConfirm();
                }
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (null != callBack) {
                    callBack.onCancel();
                }
            }
        });
    }

    public void setDialogStr(String cancelStr,String confirmStr){
        tv_cancel.setText(cancelStr);
        tv_confirm.setText(confirmStr);
    }

    public interface CallBack {
        void onConfirm();

        void onCancel();
    }
}
