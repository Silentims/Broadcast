package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(final Context context, Intent intent) {
		//用AlertDialog.Builder 来构建一个对话框
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("警告");
		dialogBuilder.setMessage("您已被强制下线，请重新登陆！");
		dialogBuilder.setCancelable(false);		//设置对话框不可取消
		dialogBuilder.setPositiveButton("确定", new OnClickListener() {
			//给对话框注册确定按钮
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ActivityCollector.finshAll(); 	//销毁所有活动
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);	//表明是在广播接收器里启动活动的
				context.startActivity(intent); 		//重新启动LoginActivity
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();// 需要设置AlertDialog的类型,保证在广播接收器中可以正常弹出
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);	//保证对话框在广播接收器里弹出
		alertDialog.show();
	}
}
