package com.di.snake;

import java.net.URL;

import javax.swing.*;

//����ⲿ����
public class Data {
	
	//ͷ���������ͼƬ   URL: ��λͼƬ�ĵ�ַ     ImageIcon: ͼƬ
	public static URL advertisingURL = Data.class.getResource("/com/di/statics/Tirle.png");
	public static ImageIcon advertise = new ImageIcon(advertisingURL);
	
	//ʳ��
	public static URL foodURL = Data.class.getResource("/com/di/statics/food.png");
	public static ImageIcon food = new ImageIcon(foodURL);
	
	//�ߵ�ͷ��(����)
	public static URL downURL = Data.class.getResource("/com/di/statics/head.png");
	public static ImageIcon down = new ImageIcon(downURL);
			
	//��ͷ����
	public static URL upURL = Data.class.getResource("/com/di/statics/up.png");
	public static ImageIcon up = new ImageIcon(upURL);
			
	//��ͷ����
	public static URL leftURL = Data.class.getResource("/com/di/statics/left.png");
	public static ImageIcon left = new ImageIcon(leftURL);
			
	//��ͷ����
	public static URL rightURL = Data.class.getResource("/com/di/statics/right.png");
	public static ImageIcon right = new ImageIcon(rightURL);
			
	//����
	public static URL bodyURL = Data.class.getResource("/com/di/statics/body.png");
	public static ImageIcon body = new ImageIcon(bodyURL);

	//--------------����(����)-------------------------
	
	public static URL down2URL = Data.class.getResource("/com/di/statics/down2.jpg");
	public static ImageIcon down2 = new ImageIcon(down2URL);
	
	//��ͷ����
	public static URL up2URL = Data.class.getResource("/com/di/statics/up2.jpg");
	public static ImageIcon up2 = new ImageIcon(up2URL);
	
	//��ͷ����
	public static URL left2URL = Data.class.getResource("/com/di/statics/left2.jpg");
	public static ImageIcon left2 = new ImageIcon(left2URL);
	
	//��ͷ����
	public static URL right2URL = Data.class.getResource("/com/di/statics/right2.jpg");
	public static ImageIcon right2 = new ImageIcon(right2URL);
	
	//����
	public static URL body2URL = Data.class.getResource("/com/di/statics/body2.jpg");
	public static ImageIcon body2 = new ImageIcon(body2URL);

}
