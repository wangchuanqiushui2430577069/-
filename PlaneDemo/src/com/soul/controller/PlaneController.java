package com.soul.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.soul.entity.FightPlane;

public class PlaneController extends KeyAdapter{
	
	 private FightPlane fight;
	
	public PlaneController(FightPlane fight) {
		this.fight = fight;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		diretion(e.getKeyCode());
		
	}
	
	public void diretion(int code) {
		
		switch(code) {
			case 37:
				if(fight.x >= 10)
					fight.x -= 20;			
				break;
			case 38:
				if(fight.y >= 10)
					fight.y -= 20;
				break;
			case 39:
				if(fight.x < 670)
					fight.x += 20;
				break;
			case 40:
				if(fight.y <= 645)
					fight.y += 20;
				break;
			
		}
	}
}


/*
public class PlaneController extends MouseAdapter{
	
	private FightPlane fight;
	
	public PlaneController(FightPlane fight) {
		this.fight = fight;
	}
	@Override
	public void mouseEntered(MouseEvent m) {
		diretion(m);
	}
	public void diretion(MouseEvent m) {
		fight.x = m.getX();
		fight.y = m.getY();
	}
	
}
*/
