package com.soul.view;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.soul.controller.PlaneController;
import com.soul.entity.EnemyPlane;
import com.soul.entity.FightPlane;
import com.soul.tools.tool_1;

public class FrameWindow {

	public FrameWindow() {
		System.out.println("开始执行....");
		launch();
	}
	
	public void launch() {
		
		FightPlane my = new FightPlane();
		PlaneController controller = new PlaneController(my);
		
		GramePanel gramepanel = new GramePanel(my);
		
		JFrame jframe = new JFrame();
		jframe.add(gramepanel);

		jframe.addKeyListener(controller);
		//jframe.addMouseListener(controller);
		
		jframe.setTitle("飞机大战");
		jframe.setSize(tool_1.Width, tool_1.Height);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
