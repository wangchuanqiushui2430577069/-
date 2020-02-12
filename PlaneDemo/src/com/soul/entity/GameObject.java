package com.soul.entity;

import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class GameObject {
		public int x, y, width, height;
		public abstract void DrawMe(Graphics g);
		public abstract Rectangle GetRect(); 
	
	

	
}
