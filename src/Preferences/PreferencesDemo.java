package Preferences;

import java.util.prefs.Preferences;

public class PreferencesDemo {//在window下就是注册信息表存储了信息，在别的操作系统下存储的方式都不一样，很神奇

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);//通过类名来创建这个节点，将信息存储在这个节点中
		prefs.put("Location", "Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are there witches", true);
		int usageCount = prefs.getInt("UsageCount", 0);//提供一个默认值
		usageCount++;
		prefs.putInt("UsageCount", usageCount);
		for(String key:prefs.keys())
			System.out.println(key+":"+prefs.get(key, null));//确保迭代中的条目是存在的，用null作为默认值是安全的
		System.out.println("How many Companions does Dorothy have?"+prefs.getInt("Companions", 0));
	}

}
