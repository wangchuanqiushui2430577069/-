package com.di.snake;

import javax.swing.*;

public class StartGames {

	public static void main(String[] args) {
		//1.����һ����̬����	JFrame
		JFrame frame = new JFrame("������ˮ��̰����");
		//���ý����С
		frame.setBounds(10,10,900,720);
		//���ڴ�С���ɸı�
		frame.setResizable(false);
		//���ùر��¼���ʹ��Ϸ���Թر�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2.���  JPanel	�ɼ��뵽JFrame
		frame.add(new GamePanel());

		//չ�ִ���
		frame.setVisible(true);
	}

}
