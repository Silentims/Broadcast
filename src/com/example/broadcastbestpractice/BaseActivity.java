package com.example.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{
	
	/**
	 * �����ʱ����ActivityCollector�е����activity�ķ���
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
	}
	/**
	 * ���ٻʱ����ActivityCollector�е��Ƴ�activity�ķ���
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	
}
