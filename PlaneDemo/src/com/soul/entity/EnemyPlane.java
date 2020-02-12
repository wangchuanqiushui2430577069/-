package com.soul.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import com.soul.tools.AddImage;
import com.soul.tools.tool_1;



public class EnemyPlane extends GameObject{
	//List<Bullet> arrayList = new LinkedList<>();
	
	public static Image image = AddImage.getimage("images/enemy.jpg");
	//public static Image bullet = AddImage.getimage("images/enemybullet.jpg");
	
	boolean flag = true;
	
	public EnemyPlane() {
		x = 120 + (int)(Math.random() * 600);
		y = 120;
		width = 120;
		height = 120;
		//new CreateBullet().start();  //增加线程 ,  创建子弹
	}
	
	@Override
	public  void DrawMe(Graphics g) {
		g.drawImage(image,x,y,width,height,null);
		y++;
		if(y > tool_1.Height) {
			y = -150;
		x = 120 + (int)(Math.random() * 600);
		}
		//画出子弹
//		for(int i = 0; i < arrayList.size(); i++) {
//			arrayList.get(i).DrawMe(g);
//		}
		
	}
	
	@Override
	public  Rectangle GetRect() {	
		return new Rectangle(x,y,width,height);
	}
	/*
	//子弹内部类
	class Bullet extends GameObject{   
		
		public Bullet(){
			
			width = 30; //120
			height = 40; //80
			
		}
		
		@Override
		public  void DrawMe(Graphics g) {
			g.drawImage(bullet,x,y,width,height,null);//显示图片
			y--;
		}
		
		@Override
		public  Rectangle GetRect() {	
			return new Rectangle(x,y,width,height);
		}
		
	}
	
	class CreateBullet extends Thread{  
		@Override
		public void run() {
			while(true) {
				try {
					Bullet bullet = new Bullet();
					bullet.x = x + 50;
					bullet.y = y - 30;
					arrayList.add(bullet);
					Thread.sleep(200);  //子弹的创建间隔
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	*/

}
