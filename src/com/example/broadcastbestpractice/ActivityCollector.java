package com.example.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	
	public static List<Activity> activities = new ArrayList<Activity>();
	
	/**
	 * 添加启动的活动
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	
	/**
	 * 移除启动的活动
	 * @param activity
	 */
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	
	/**
	 * 结束所有启动的活动
	 */
	public static void finshAll(){
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
}
