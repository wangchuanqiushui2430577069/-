package com.di.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
		
	int length;//�ߵĳ���
	int[] SX = new int[600];  //�ߵ�����X
	int[] SY = new int[500];  //�ߵ�����Y
	String Direction; //�ұ� 
	boolean ifStart = false; //��Ϸ�Ƿ�ʼ
	Timer timer = new Timer(150,this); //��ʱ��
	
	//����һ������
	int length2;//�ߵĳ���
	int[] SX2 = new int[600];  //�ߵ�����X
	int[] SY2 = new int[500];  //�ߵ�����Y
	String Direction2; //�ұ� 
	String[] DR = {"U","D","L","R"};
	
	//����һ��ʳ��
	int foodx;
	int foody;
	int foodx2;
	int foody2;
	Random random = new Random();
	Random random2 = new Random();
	
	//�ж�����
	boolean ifFail = false;
	boolean ifFail2 = false;
	
	//����ϵͳ
	int score;
	
	//������
	public GamePanel() {
		init();
		//��ȡ���̵ļ����¼�
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
	}
	
	
	//��ʼ��
	public void init() {
		length = 3;
		score = 0;  //����Ϊ 0
		SX[0] = 100; SY[0] = 100; //ͷ������
		SX[1] = 75;  SY[1] = 100; //��һ������
		SX[2] = 50;  SY[2] = 100; //�ڶ�������
		Direction = "R";
		// ����
		initEmeny();
		
		foodx = 25 + 25 * random.nextInt(34); //����Ϸ����Ļ����������ʳ��
		foody = 75 + 25 * random.nextInt(24);
		foodx2 = 125 + 25 * random2.nextInt(30); //����Ϸ����Ļ����������ʳ��
		foody2 = 175 + 25 * random2.nextInt(20);
	}
	
	//���壺 �����棬����
	//Graphics�� ����
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //����
		this.setBackground(Color.BLACK);//���ñ�����ɫ
		
		//����ͷ���Ĺ����
		Data.advertise.paintIcon(this, g, 25, 11);	
		
		//������Ϸ����
		g.fillRect(25, 75, 850, 600);
		
		//��һ����̬��С��
		if(Direction.equals("R"))
			Data.right.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("L"))
			Data.left.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("U"))
			Data.up.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("D"))
			Data.down.paintIcon(this, g, SX[0], SY[0]);
		for(int i = 1; i < length; i++) {
			Data.body.paintIcon( this, g, SX[i], SY[i]); //���峤��ͨ��length����
		}
		//����
		if(Direction2.equals("R"))
			Data.right2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("L"))
			Data.left2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("U"))
			Data.up2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("D"))
			Data.down2.paintIcon(this, g, SX2[0], SY2[0]);
		for(int i = 1; i < length2; i++) {
			Data.body2.paintIcon( this, g, SX2[i], SY2[i]); //���峤��ͨ��length����
		}
		
		//��ʳ��
		Data.food.paintIcon(this, g, foodx, foody);
		Data.food.paintIcon(this, g, foodx2, foody2);
		
		//������
		g.setColor(Color.BLACK);
		g.setFont(new Font("�п�",Font.BOLD,18));
		g.drawString("����" + length, 750, 35);
		g.drawString("�÷�" + score , 750, 50);
		
		//��Ϸ��ʾ���Ƿ�ʼ
		if(ifStart == false) {
			//��һ�����֣�String
			g.setColor(Color.WHITE);
			g.setFont(new Font("�п�",Font.BOLD,40));
			g.drawString("���¿ո�ʼ��Ϸ", 300, 300);
		}
		
		//ʧ������
		if(ifFail) {
			g.setColor(Color.RED);
			g.setFont(new Font("�п�",Font.BOLD,40));
			g.drawString("��Ϸʧ�ܣ����ո����¿�ʼ", 300, 300);
		}
		
	}
	
	// ���ռ��̵����룺����
	@Override
	public void keyPressed(KeyEvent e) {
		//��ȡ���µļ������ĸ���
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) {
			if(ifFail) {  //��Ϸʧ�ܣ����¿�ʼ
				ifFail = false;
				init(); //���³�ʼ��
			}else { //��ͣ��Ϸ
				ifStart = !ifStart;
				
			}
			///*********
			repaint(); //ˢ�½���
		}
		//���̿�������
		if(keyCode == KeyEvent.VK_LEFT) {
			Direction = "L";
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			Direction = "R";
		}else if(keyCode == KeyEvent.VK_UP) {
			Direction = "U";
		}else if(keyCode == KeyEvent.VK_DOWN) {
			Direction = "D";
		}
		
		
	}
	
	//��ʱ���� ����ʱ��,  ֡��ִ�ж�ʱ����
	public void actionPerformed(ActionEvent e) {
	
		//�����Ϸ���ڿ�ʼ״̬,������Ϸû�н���
		if(ifStart && !ifFail) {
			if(length > length2) {
				length2 = length;
			}
			//����
			for(int i = length - 1; i > 0; i--) { //�����Դ������嶼�����ƶ�
				SX[i] = SX[i-1];
				SY[i] = SY[i-1];			
			}

			//ͨ�����Ʒ�����ͷ���ƶ�
			if(Direction.equals("R")) {
				SX[0] += 25;
				if(SX[0] > 850) //�߽��ж�
					//ifFail = true;
					SX[0] = 25;
			}else if(Direction.equals("L")) {
				SX[0] -= 25;
				if(SX[0] < 25) //�߽��ж�
					//ifFail = true;
					SX[0] = 850;
			}else if(Direction.equals("U")) {
				SY[0] -= 25;
				if(SY[0] < 75) //�߽��ж�
					//ifFail = true;
					SY[0] = 650;
			}else if(Direction.equals("D")) {
				SY[0] += 25;
				if(SY[0] >  650) //�߽��ж�
					//ifFail = true;
					SY[0] = 75;
			}
			
			
			
			//���С�ߵ�ͷ��������ʳ���غ�
			if(foodx == SX[0] && foody == SY[0]) {
				//���ȼ�һ,�÷ּ�10
				length++;
				score += 10;
				
				//��������ʳ��
				foodx = 25 + 25 * random.nextInt(34); //����Ϸ����Ļ����������ʳ��
				foody = 75 + 25 * random.nextInt(24);
				while(foodx == foodx2 && foody == foody2) {
					//����ʳ���ص�
					foodx = 25 + 25 * random.nextInt(34); 
					foody = 75 + 25 * random.nextInt(24);
				}
			}else if(foodx2 == SX[0] && foody2 == SY[0]) {
				//���ȼ�һ,�÷ּ�10
				length++;
				score += 10;
				
				//��������ʳ��
				foodx2 = 125 + 25 * random2.nextInt(30); //����Ϸ����Ļ����������ʳ��
				foody2 = 175 + 25 * random2.nextInt(20);
				while(foodx == foodx2 && foody == foody2) {
					//����ʳ���ص�
					foodx2 = 125 + 25 * random2.nextInt(30); 
					foody2 = 175 + 25 * random2.nextInt(20);
				}
			}
			//---------------------------------------------------
			//��������ж�
			int d;
			d = (int)(Math.random()*4);
				if(DR[d].equals("R")) {
					for(int i = 1; i < length2; i++) {
						if((SX2[0]+25) == SX2[i] && SY2[0] == SY2[i]) {
							d = (int)(Math.random()*4);
							break;
						}
							
					}
				}else if(DR[d].equals("L")) {
					for(int i = 1; i < length2; i++) {
						if((SX2[0]-25) == SX2[i] && SY2[0] == SY2[i]) {
							d = (int)(Math.random()*4);
							break;
						}
							
					}
				}else if(DR[d].equals("U")) {
					for(int i = 1; i < length2; i++) {
						if(SX2[0] == SX2[i] && (SY2[0]-25) == SY2[i]) {
							d = (int)(Math.random()*4);
							break;
						}
							
					}
				}else if(DR[d].equals("D")) {
					for(int i = 1; i < length2; i++) {
						if(SX2[0] == SX2[i] && (SY2[0]+25) == SY2[i]) {
							d = (int)(Math.random()*4);
							break;
						}
							
					}
				}		
			Direction2 = DR[d];
			//�����ƶ�
			for(int i = length2 - 1; i > 0; i--) { //�����Դ������嶼�����ƶ�
				SX2[i] = SX2[i-1];
				SY2[i] = SY2[i-1];			
			}
			
			//����ͷ���ƶ�
			if(Direction2.equals("R")) {
				SX2[0] += 25;
				if(SX2[0] > 850) //�߽��ж�
					SX2[0] = 25;
			}else if(Direction2.equals("L")) {
				SX2[0] -= 25;
				if(SX2[0] < 25) //�߽��ж�
					SX2[0] = 850;
			}else if(Direction2.equals("U")) {
				SY2[0] -= 25;
				if(SY2[0] < 75) //�߽��ж�
					SY2[0] = 650;
			}else if(Direction2.equals("D")) {
				SY2[0] += 25;
				if(SY2[0] >  650) //�߽��ж�
					SY2[0] = 75;
			}
			
			//������˵�ͷ��������ʳ���غ�
			if(foodx == SX2[0] && foody == SY2[0]) {
				//���ȼ�һ,�÷ּ�10
				length2++;
				score -= 50;
				
				//��������ʳ��
				foodx = 25 + 25 * random.nextInt(34); //����Ϸ����Ļ����������ʳ��
				foody = 75 + 25 * random.nextInt(24);
				while(foodx == foodx2 && foody == foody2) {
					//����ʳ���ص�
					foodx = 25 + 25 * random.nextInt(34); 
					foody = 75 + 25 * random.nextInt(24);
				}
			}else if(foodx2 == SX2[0] && foody2 == SY2[0]) {
				//���ȼ�һ,�÷ּ�10
				length2++;
				score -= 50;
				
				//��������ʳ��
				foodx2 = 125 + 25 * random2.nextInt(30); //����Ϸ����Ļ����������ʳ��
				foody2 = 175 + 25 * random2.nextInt(20);
				while(foodx == foodx2 && foody == foody2) {
					//����ʳ���ص�
					foodx2 = 125 + 25 * random2.nextInt(30); 
					foody2 = 175 + 25 * random2.nextInt(20);
				}
			}	
			//-------------------------------------------------------
			
			//�����ж�
			//1.�Ե��Լ�������
			for(int i = 1; i < length; i++) {
				if(SX[i] == SX[0] && SY[i] == SY[0]) {
					ifFail = true;
				}
			}
			//2.�Ե����˵�����
			for(int i = 1; i < length2; i++) {
				if(SX[0] == SX2[i] && SY[0] == SY2[i])
					ifFail = true;
			}	
			//3.���˳Ե��ҷ�������
			for(int i = 1; i < length; i++) {
				if(SX2[0] == SX[i] && SY2[0] == SY[i])
					ifFail2 = true;
			}
			//��������
			if(ifFail2) { 
				initEmeny();
				ifFail2 = false;
			}
			//ˢ�½���
			repaint();
		}	
		timer.start(); //��ʱ�䶯����	
	}
	
	//��ʼ������
	public void initEmeny() {
		length2 = length + 2;
		SX2[0] = 175; SY2[0] = 500; //ͷ������
		SX2[1] = 150;  SY2[1] = 500; //��һ������
		SX2[2] = 125;  SY2[2] = 500; //�ڶ�������
		SX2[3] = 100;  SY2[1] = 500; //��һ������
		SX2[4] = 75;  SY2[2] = 500; //�ڶ�������
		Direction2 = "R";
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		//�ͷ�ĳ����
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
