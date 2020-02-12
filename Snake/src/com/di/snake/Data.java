package com.di.snake;

import java.net.URL;

import javax.swing.*;

//存放外部数据
public class Data {
	
	//头部广告栏的图片   URL: 定位图片的地址     ImageIcon: 图片
	public static URL advertisingURL = Data.class.getResource("/com/di/statics/Tirle.png");
	public static ImageIcon advertise = new ImageIcon(advertisingURL);
	
	//食物
	public static URL foodURL = Data.class.getResource("/com/di/statics/food.png");
	public static ImageIcon food = new ImageIcon(foodURL);
	
	//蛇的头部(向下)
	public static URL downURL = Data.class.getResource("/com/di/statics/head.png");
	public static ImageIcon down = new ImageIcon(downURL);
			
	//蛇头向上
	public static URL upURL = Data.class.getResource("/com/di/statics/up.png");
	public static ImageIcon up = new ImageIcon(upURL);
			
	//蛇头向左
	public static URL leftURL = Data.class.getResource("/com/di/statics/left.png");
	public static ImageIcon left = new ImageIcon(leftURL);
			
	//蛇头向右
	public static URL rightURL = Data.class.getResource("/com/di/statics/right.png");
	public static ImageIcon right = new ImageIcon(rightURL);
			
	//蛇身
	public static URL bodyURL = Data.class.getResource("/com/di/statics/body.png");
	public static ImageIcon body = new ImageIcon(bodyURL);

	//--------------敌人(向下)-------------------------
	
	public static URL down2URL = Data.class.getResource("/com/di/statics/down2.jpg");
	public static ImageIcon down2 = new ImageIcon(down2URL);
	
	//蛇头向上
	public static URL up2URL = Data.class.getResource("/com/di/statics/up2.jpg");
	public static ImageIcon up2 = new ImageIcon(up2URL);
	
	//蛇头向左
	public static URL left2URL = Data.class.getResource("/com/di/statics/left2.jpg");
	public static ImageIcon left2 = new ImageIcon(left2URL);
	
	//蛇头向右
	public static URL right2URL = Data.class.getResource("/com/di/statics/right2.jpg");
	public static ImageIcon right2 = new ImageIcon(right2URL);
	
	//蛇身
	public static URL body2URL = Data.class.getResource("/com/di/statics/body2.jpg");
	public static ImageIcon body2 = new ImageIcon(body2URL);

}
