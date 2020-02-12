package com.soul.entity;

import java.util.Random;

import com.soul.view.GramePanel;

public class CreateEnemy extends Thread{  //Ïß³Ì
	Random random = new Random();
	public void run() {
		for(int i = 0; i < 3; i++) {
			try {
				EnemyPlane e = new EnemyPlane();
				e.x = random.nextInt(600) + 120;
				e.y = -150;
				GramePanel.enemyList.add(e);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
