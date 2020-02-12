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
		
		new updateGame().start();  //不断重画
		new CreateEnemy().start();	//画出10架敌机
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, tool_1.Width, tool_1.Height);
		//画出战斗机
		if(my != null) {
			my.DrawMe(g);
		}
		//画出敌机
		for(int i = 0; i < enemyList.size(); i++) {
			enemyList.get(i).DrawMe(g);
		}
	}
	
	public GramePanel() {
		
	}
	
	class updateGame extends Thread{  //线程
		@Override
		public void run() {
			while(flag) {
				repaint();//不停地调用
			}
		}
	}
}
