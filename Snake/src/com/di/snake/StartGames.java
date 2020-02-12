package com.di.snake;

import javax.swing.*;

public class StartGames {

	public static void main(String[] args) {
		//1.绘制一个静态窗口	JFrame
		JFrame frame = new JFrame("忘川秋水的贪吃蛇");
		//设置界面大小
		frame.setBounds(10,10,900,720);
		//窗口大小不可改变
		frame.setResizable(false);
		//设置关闭事件，使游戏可以关闭
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2.面板  JPanel	可加入到JFrame
		frame.add(new GamePanel());

		//展现窗口
		frame.setVisible(true);
	}

}
