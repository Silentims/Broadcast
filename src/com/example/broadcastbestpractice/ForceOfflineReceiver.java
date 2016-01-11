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
		//��AlertDialog.Builder ������һ���Ի���
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("����");
		dialogBuilder.setMessage("���ѱ�ǿ�����ߣ������µ�½��");
		dialogBuilder.setCancelable(false);		//���öԻ��򲻿�ȡ��
		dialogBuilder.setPositiveButton("ȷ��", new OnClickListener() {
			//���Ի���ע��ȷ����ť
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ActivityCollector.finshAll(); 	//�������л
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);	//�������ڹ㲥���������������
				context.startActivity(intent); 		//��������LoginActivity
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();// ��Ҫ����AlertDialog������,��֤�ڹ㲥�������п�����������
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);	//��֤�Ի����ڹ㲥�������ﵯ��
		alertDialog.show();
	}
}
