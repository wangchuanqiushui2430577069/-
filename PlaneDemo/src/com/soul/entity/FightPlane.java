package com.soul.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import com.soul.tools.AddImage;
import com.soul.view.GramePanel;



public class FightPlane extends GameObject{
	List<Bullet> arrayList = new LinkedList<>();
	public static Image image = AddImage.getimage("images/my.jpg");
	public static Image bullet = AddImage.getimage("images/mybullet.jpg");
	
	boolean flag = true;
	
	public FightPlane() {
		x = 300;
		y = 300;
		width = 120;
		height = 120;
		new CreateBullet().start();  //�����߳� ,  �����ӵ�
	}
	
	@Override
	public  void DrawMe(Graphics g) {
		g.drawImage(image,x,y,width,height,null);
		//�����ӵ�
		for(int i = 0; i < arrayList.size(); i++) {
			for(int j = 0; j < GramePanel.enemyList.size(); j++) {
				if(GramePanel.enemyList.get(j).GetRect().intersects(arrayList.get(i).GetRect())) {
					//����л�
					GramePanel.enemyList.get(j).x = (int)(Math.random() * 600);
					GramePanel.enemyList.get(j).y = -150;
				}
					
			}
			if(arrayList.get(i).y < 0) {
				arrayList.remove(i);
			}
			arrayList.get(i).DrawMe(g);
		}
		
	}
	
	@Override
	public  Rectangle GetRect() {	
		return new Rectangle(x,y,width,height);
	}
	
	//�ӵ��ڲ���
	class Bullet extends GameObject{   
		
		public Bullet(){
			
			width = 30; //120
			height = 40; //80
			
		}
		
		@Override
		public  void DrawMe(Graphics g) {
			g.drawImage(bullet,x,y,width,height,null);//��ʾͼƬ
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
					bullet.x = x + 48;
					bullet.y = y - 30;
					arrayList.add(bullet);
					Thread.sleep(100);  //�ӵ��Ĵ������
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	

}
