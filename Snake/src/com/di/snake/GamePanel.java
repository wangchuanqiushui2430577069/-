package com.di.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
		
	int length;//蛇的长度
	int[] SX = new int[600];  //蛇的坐标X
	int[] SY = new int[500];  //蛇的坐标Y
	String Direction; //右边 
	boolean ifStart = false; //游戏是否开始
	Timer timer = new Timer(150,this); //定时器
	
	//定义一个敌人
	int length2;//蛇的长度
	int[] SX2 = new int[600];  //蛇的坐标X
	int[] SY2 = new int[500];  //蛇的坐标Y
	String Direction2; //右边 
	String[] DR = {"U","D","L","R"};
	
	//定义一个食物
	int foodx;
	int foody;
	int foodx2;
	int foody2;
	Random random = new Random();
	Random random2 = new Random();
	
	//判定死亡
	boolean ifFail = false;
	boolean ifFail2 = false;
	
	//积分系统
	int score;
	
	//构造器
	public GamePanel() {
		init();
		//获取键盘的监听事件
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
	}
	
	
	//初始化
	public void init() {
		length = 3;
		score = 0;  //积分为 0
		SX[0] = 100; SY[0] = 100; //头部坐标
		SX[1] = 75;  SY[1] = 100; //第一个身体
		SX[2] = 50;  SY[2] = 100; //第二个身体
		Direction = "R";
		// 敌人
		initEmeny();
		
		foodx = 25 + 25 * random.nextInt(34); //在游戏的屏幕坐标内生成食物
		foody = 75 + 25 * random.nextInt(24);
		foodx2 = 125 + 25 * random2.nextInt(30); //在游戏的屏幕坐标内生成食物
		foody2 = 175 + 25 * random2.nextInt(20);
	}
	
	//画板： 画界面，画蛇
	//Graphics： 画笔
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //清屏
		this.setBackground(Color.BLACK);//设置背景颜色
		
		//绘制头部的广告栏
		Data.advertise.paintIcon(this, g, 25, 11);	
		
		//绘制游戏区域
		g.fillRect(25, 75, 850, 600);
		
		//画一条静态的小蛇
		if(Direction.equals("R"))
			Data.right.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("L"))
			Data.left.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("U"))
			Data.up.paintIcon(this, g, SX[0], SY[0]);
		else if(Direction.equals("D"))
			Data.down.paintIcon(this, g, SX[0], SY[0]);
		for(int i = 1; i < length; i++) {
			Data.body.paintIcon( this, g, SX[i], SY[i]); //身体长度通过length控制
		}
		//敌人
		if(Direction2.equals("R"))
			Data.right2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("L"))
			Data.left2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("U"))
			Data.up2.paintIcon(this, g, SX2[0], SY2[0]);
		else if(Direction2.equals("D"))
			Data.down2.paintIcon(this, g, SX2[0], SY2[0]);
		for(int i = 1; i < length2; i++) {
			Data.body2.paintIcon( this, g, SX2[i], SY2[i]); //身体长度通过length控制
		}
		
		//画食物
		Data.food.paintIcon(this, g, foodx, foody);
		Data.food.paintIcon(this, g, foodx2, foody2);
		
		//画积分
		g.setColor(Color.BLACK);
		g.setFont(new Font("行楷",Font.BOLD,18));
		g.drawString("长度" + length, 750, 35);
		g.drawString("得分" + score , 750, 50);
		
		//游戏提示：是否开始
		if(ifStart == false) {
			//画一个文字：String
			g.setColor(Color.WHITE);
			g.setFont(new Font("行楷",Font.BOLD,40));
			g.drawString("按下空格开始游戏", 300, 300);
		}
		
		//失败提醒
		if(ifFail) {
			g.setColor(Color.RED);
			g.setFont(new Font("行楷",Font.BOLD,40));
			g.drawString("游戏失败，按空格重新开始", 300, 300);
		}
		
	}
	
	// 接收键盘的输入：监听
	@Override
	public void keyPressed(KeyEvent e) {
		//获取按下的键盘是哪个键
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE) {
			if(ifFail) {  //游戏失败，重新开始
				ifFail = false;
				init(); //重新初始化
			}else { //暂停游戏
				ifStart = !ifStart;
				
			}
			///*********
			repaint(); //刷新界面
		}
		//键盘控制走向
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
	
	//定时器： 监听时间,  帧：执行定时操作
	public void actionPerformed(ActionEvent e) {
	
		//如果游戏处于开始状态,并且游戏没有结束
		if(ifStart && !ifFail) {
			if(length > length2) {
				length2 = length;
			}
			//右移
			for(int i = length - 1; i > 0; i--) { //除了脑袋，身体都向右移动
				SX[i] = SX[i-1];
				SY[i] = SY[i-1];			
			}

			//通过控制方向让头部移动
			if(Direction.equals("R")) {
				SX[0] += 25;
				if(SX[0] > 850) //边界判断
					//ifFail = true;
					SX[0] = 25;
			}else if(Direction.equals("L")) {
				SX[0] -= 25;
				if(SX[0] < 25) //边界判断
					//ifFail = true;
					SX[0] = 850;
			}else if(Direction.equals("U")) {
				SY[0] -= 25;
				if(SY[0] < 75) //边界判断
					//ifFail = true;
					SY[0] = 650;
			}else if(Direction.equals("D")) {
				SY[0] += 25;
				if(SY[0] >  650) //边界判断
					//ifFail = true;
					SY[0] = 75;
			}
			
			
			
			//如果小蛇的头部坐标与食物重合
			if(foodx == SX[0] && foody == SY[0]) {
				//长度加一,得分加10
				length++;
				score += 10;
				
				//重新生成食物
				foodx = 25 + 25 * random.nextInt(34); //在游戏的屏幕坐标内生成食物
				foody = 75 + 25 * random.nextInt(24);
				while(foodx == foodx2 && foody == foody2) {
					//两个食物重叠
					foodx = 25 + 25 * random.nextInt(34); 
					foody = 75 + 25 * random.nextInt(24);
				}
			}else if(foodx2 == SX[0] && foody2 == SY[0]) {
				//长度加一,得分加10
				length++;
				score += 10;
				
				//重新生成食物
				foodx2 = 125 + 25 * random2.nextInt(30); //在游戏的屏幕坐标内生成食物
				foody2 = 175 + 25 * random2.nextInt(20);
				while(foodx == foodx2 && foody == foody2) {
					//两个食物重叠
					foodx2 = 125 + 25 * random2.nextInt(30); 
					foody2 = 175 + 25 * random2.nextInt(20);
				}
			}
			//---------------------------------------------------
			//敌人随机行动
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
			//敌人移动
			for(int i = length2 - 1; i > 0; i--) { //除了脑袋，身体都向右移动
				SX2[i] = SX2[i-1];
				SY2[i] = SY2[i-1];			
			}
			
			//敌人头部移动
			if(Direction2.equals("R")) {
				SX2[0] += 25;
				if(SX2[0] > 850) //边界判断
					SX2[0] = 25;
			}else if(Direction2.equals("L")) {
				SX2[0] -= 25;
				if(SX2[0] < 25) //边界判断
					SX2[0] = 850;
			}else if(Direction2.equals("U")) {
				SY2[0] -= 25;
				if(SY2[0] < 75) //边界判断
					SY2[0] = 650;
			}else if(Direction2.equals("D")) {
				SY2[0] += 25;
				if(SY2[0] >  650) //边界判断
					SY2[0] = 75;
			}
			
			//如果敌人的头部坐标与食物重合
			if(foodx == SX2[0] && foody == SY2[0]) {
				//长度加一,得分加10
				length2++;
				score -= 50;
				
				//重新生成食物
				foodx = 25 + 25 * random.nextInt(34); //在游戏的屏幕坐标内生成食物
				foody = 75 + 25 * random.nextInt(24);
				while(foodx == foodx2 && foody == foody2) {
					//两个食物重叠
					foodx = 25 + 25 * random.nextInt(34); 
					foody = 75 + 25 * random.nextInt(24);
				}
			}else if(foodx2 == SX2[0] && foody2 == SY2[0]) {
				//长度加一,得分加10
				length2++;
				score -= 50;
				
				//重新生成食物
				foodx2 = 125 + 25 * random2.nextInt(30); //在游戏的屏幕坐标内生成食物
				foody2 = 175 + 25 * random2.nextInt(20);
				while(foodx == foodx2 && foody == foody2) {
					//两个食物重叠
					foodx2 = 125 + 25 * random2.nextInt(30); 
					foody2 = 175 + 25 * random2.nextInt(20);
				}
			}	
			//-------------------------------------------------------
			
			//结束判断
			//1.吃到自己的身体
			for(int i = 1; i < length; i++) {
				if(SX[i] == SX[0] && SY[i] == SY[0]) {
					ifFail = true;
				}
			}
			//2.吃到敌人的身体
			for(int i = 1; i < length2; i++) {
				if(SX[0] == SX2[i] && SY[0] == SY2[i])
					ifFail = true;
			}	
			//3.敌人吃到我方的身体
			for(int i = 1; i < length; i++) {
				if(SX2[0] == SX[i] && SY2[0] == SY[i])
					ifFail2 = true;
			}
			//敌人死亡
			if(ifFail2) { 
				initEmeny();
				ifFail2 = false;
			}
			//刷新界面
			repaint();
		}	
		timer.start(); //让时间动起来	
	}
	
	//初始化敌人
	public void initEmeny() {
		length2 = length + 2;
		SX2[0] = 175; SY2[0] = 500; //头部坐标
		SX2[1] = 150;  SY2[1] = 500; //第一个身体
		SX2[2] = 125;  SY2[2] = 500; //第二个身体
		SX2[3] = 100;  SY2[1] = 500; //第一个身体
		SX2[4] = 75;  SY2[2] = 500; //第二个身体
		Direction2 = "R";
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		//释放某个键
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
