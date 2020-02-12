package com.soul.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import com.soul.entity.CreateEnemy;
import com.soul.entity.EnemyPlane;
import com.soul.entity.FightPlane;
import com.soul.tools.tool_1;

public class GramePanel extends JPanel{
	
	public static List<EnemyPlane> enemyList = new LinkedList<>();
	private FightPlane my;
	boolean flag = true;
	
	public GramePanel(FightPlane my) {
		this.my = my;
		
		new updateGame().start();  //�����ػ�
		new CreateEnemy().start();	//����10�ܵл�
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, tool_1.Width, tool_1.Height);
		//����ս����
		if(my != null) {
			my.DrawMe(g);
		}
		//�����л�
		for(int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).DrawMe(g);
		}
	}
	
	public GramePanel() {
		
	}
	
	class updateGame extends Thread{  //�߳�
		@Override
		public void run() {
			while(flag) {
				repaint();//��ͣ�ص���
			}
		}
	}
}
