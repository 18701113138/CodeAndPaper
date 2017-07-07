package java_我的迷宫生成_随机Lise;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sun.audio.*;

public class Start extends JFrame{
	Container contentpane;
	myPanel myp;
	Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
	int WIDTH = (int)screensize.getWidth();
	int HEIGH = (int)screensize.getHeight();
	int X = 0;
	int Y = 1;
	private List<Point> Lise;
	boolean ShengYin = true;
	boolean YouXi = false;
	boolean LJ = false;
	boolean ArrayMaze[][];//存放迷宫地图
	Point origin = new Point();
	JButton ExitButton = new JButton();//退出按钮
	JButton CXButton = new JButton();//重新生成按钮
	JButton LJButton = new JButton();//获取迷宫路径按钮
	JButton SYButton = new JButton();//声音按钮
	JButton StartButton = new JButton();//开始游戏按钮
	JButton CZButton = new JButton();//操作方式按钮
	JButton MazeButton = new JButton(new ImageIcon(getClass().getResource("/image/迷宫.png")));//“迷宫”
	JButton ZCZButton = new JButton(new ImageIcon(getClass().getResource("/image/左操作.jpg")));//左操作
	JButton ZJJButton = new JButton(new ImageIcon(getClass().getResource("/image/左简介.jpg")));//左简介
	JButton ZMGButton = new JButton(new ImageIcon(getClass().getResource("/image/左迷宫.jpg")));//左迷宫
	JButton TXButton = new JButton(new ImageIcon(getClass().getResource("/image/小头.png")));//头像按钮
	
	ImageIcon ExitImage1 = new ImageIcon(getClass().getResource("/image/退出.png"));
	ImageIcon CXImage1 = new ImageIcon(getClass().getResource("/image/重新生成.png"));
	ImageIcon LJImage1 = new ImageIcon(getClass().getResource("/image/路径.png"));
	ImageIcon StartImage1 = new ImageIcon(getClass().getResource("/image/开始游戏.png"));
	ImageIcon CZImage1 = new ImageIcon(getClass().getResource("/image/操作方法.png"));
	ImageIcon SYImage1 = new ImageIcon(getClass().getResource("/image/音乐.png"));
	
	@SuppressWarnings("restriction")
	//AudioStream ButtonSound1 = new AudioStream(new FileInputStream("/音乐/点.wav"));

	AudioStream bj ,button1;  
	@SuppressWarnings("restriction")
	AudioData ad;
	@SuppressWarnings("restriction")
	ContinuousAudioDataStream cads;
	@SuppressWarnings("restriction")
	public void MyStart()
	{	
		try {  
		    bj = new AudioStream(Start.class.getClassLoader().getResourceAsStream("Music/背景.wav"));  
		    ad = bj.getData();
		} catch (IOException e) {e.printStackTrace();}  
		//设置循环播放  
		cads = new ContinuousAudioDataStream(ad);  
		//循环播放开始哦  
		AudioPlayer.player.start(cads);
		//循环播放停止  
		//AudioPlayer.player.stop(cads);
		contentpane = (JPanel)getContentPane();
		myp = new myPanel();
		setUndecorated(true);//去掉窗口边框
		setBounds(WIDTH/2-400,HEIGH/2-300,800,600);//显示在屏幕正中心
		setVisible(true);
		contentpane.add(myp);
		myp.setLayout(null);
		myp.add(ExitButton);
			ExitButton.setBounds(730, 10, ExitImage1.getIconWidth(), ExitImage1.getIconHeight());
			ExitButton.setIcon(ExitImage1);
			ExitButton.setContentAreaFilled(false); // 取消填充区域
			ExitButton.setBorder(null); // 取消边框
			//ExitButton.setToolTipText("退出游戏");
		myp.add(CXButton);
			CXButton.setBounds(690, 490, CXImage1.getIconWidth(), CXImage1.getIconHeight());
			CXButton.setIcon(CXImage1);
			CXButton.setContentAreaFilled(false); // 取消填充区域
			CXButton.setBorder(null); // 取消边框
		myp.add(LJButton);
			LJButton.setBounds(250, 490, LJImage1.getIconWidth(), LJImage1.getIconHeight());
			LJButton.setIcon(LJImage1);
			LJButton.setContentAreaFilled(false); // 取消填充区域
			LJButton.setBorder(null); // 取消边框
		myp.add(SYButton);
			SYButton.setBounds(20, 10, SYImage1.getIconWidth(), SYImage1.getIconHeight());
			SYButton.setIcon(SYImage1);
			SYButton.setContentAreaFilled(false); // 取消填充区域
			SYButton.setBorder(null); // 取消边框
		myp.add(StartButton);
			StartButton.setBounds(540, 320, StartImage1.getIconWidth(), StartImage1.getIconHeight());
			StartButton.setIcon(StartImage1);
			StartButton.setContentAreaFilled(false); // 取消填充区域
			StartButton.setBorder(null); // 取消边框
		myp.add(CZButton);
			CZButton.setBounds(250, 320, CZImage1.getIconWidth(), CZImage1.getIconHeight());
			CZButton.setIcon(CZImage1);
			CZButton.setContentAreaFilled(false); // 取消填充区域
			CZButton.setBorder(null); // 取消边框
		myp.add(MazeButton);
			MazeButton.setBounds(325, 70, 330, 130);
			MazeButton.setContentAreaFilled(false); // 取消填充区域
			MazeButton.setBorder(null); // 取消边框
		//myp.add(ZCZButton);
			ZCZButton.setBounds(25, 45, 190, 414);
			ZCZButton.setContentAreaFilled(false); // 取消填充区域
			ZCZButton.setBorder(null); // 取消边框
			myp.add(ZJJButton);
			ZJJButton.setBounds(25, 45, 190, 414);
			ZJJButton.setContentAreaFilled(false); // 取消填充区域
			ZJJButton.setBorder(null); // 取消边框
		//myp.add(ZMGButton);
			ZMGButton.setBounds(25, 45, 190, 414);
			ZMGButton.setContentAreaFilled(false); // 取消填充区域
			ZMGButton.setBorder(null); // 取消边框

		//退出按钮的监听事件
		ExitButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				ExitButton.setIcon(new ImageIcon(getClass().getResource("/image/退出无阴影.png")));
				new Sound();
			}
			public void mouseExited(MouseEvent e){
				ExitButton.setIcon(ExitImage1);
			}
			public void mouseReleased(MouseEvent e){
				ExitButton.setIcon(ExitImage1);
				if(e.getX()>0 && e.getX() < ExitImage1.getIconWidth() && e.getY() > 0 && e.getY() < ExitImage1.getIconHeight())
				{
				System.exit(0);
				}
			}
		});
		//声音按钮的监听事件
		SYButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(ShengYin)
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/音乐无阴影.png")));
				}
				else
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/静音无阴影.png")));
				}
				ShengYin = !ShengYin;
			}
			public void mouseReleased(MouseEvent e){
				if(ShengYin)
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/音乐.png")));
					AudioPlayer.player.start(cads);
				}
				else
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/静音.png")));
					AudioPlayer.player.stop(cads);
				}
				TXButton.requestFocus(); // 使按钮获取焦点
			}
		});
		//重新生成地图的监听事件
		CXButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CXButton.setIcon(new ImageIcon(getClass().getResource("/image/重新无阴影.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				CXButton.setIcon(CXImage1);
				if(YouXi)
				{
				PrimMaze PM = new PrimMaze();
				ArrayMaze = PM.ArrayMaze;
				LJ = false;
				repaint(225,45,550,415);
				}
				TXButton.setBounds(235 , 60, 10, 10);
				X = 0 ; Y = 1 ;
				TXButton.requestFocus(); // 使按钮获取焦点
			}
		});
		//自动获取迷宫路径的监听事件
		LJButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				LJButton.setIcon(new ImageIcon(getClass().getResource("/image/路径无阴影.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				LJButton.setIcon(LJImage1);
				TXButton.requestFocus(); // 使按钮获取焦点
				if(YouXi)
				{
					LjMaze Ljmaze = new LjMaze();
					Ljmaze.arry = ArrayMaze;
					Ljmaze.myLjMaze();
					LJ = !LJ;
					Lise = Ljmaze.Lise;
					repaint(225,45,550,415);
				}
			}
		});
		//操作方法按钮的监听事件
		CZButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CZButton.setIcon(new ImageIcon(getClass().getResource("/image/操作方法无阴影.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				CZButton.setIcon(CZImage1);
				myp.remove(ZJJButton);
				myp.remove(ZMGButton);
				myp.add(ZCZButton);
				//ZCZButton.requestFocus(); // 使按钮获取焦点
				repaint(25,45,200,415);
				Thread1 Th = new Thread1();
				Th.start();
				TXButton.requestFocus(); // 使按钮获取焦点
			}
		});
		//开始游戏按钮的监听事件
		StartButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				StartButton.setIcon(new ImageIcon(getClass().getResource("/image/开始游戏无阴影.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				YouXi = true;
				StartButton.setIcon(null);
				myp.remove(ZJJButton);
				myp.remove(ZCZButton);
				MazeButton.setIcon(null);
				CZButton.setBounds(400, 490, CZImage1.getIconWidth(), CZImage1.getIconHeight());
				myp.add(ZMGButton);
				myp.add(TXButton);
					TXButton.setBounds(235, 60, 10, 10);
					TXButton.setContentAreaFilled(false); // 取消填充区域
					TXButton.setBorder(null); // 取消边框
					TXButton.requestFocus(); // 使按钮获取焦点
				PrimMaze PM = new PrimMaze();
				ArrayMaze = PM.ArrayMaze;
				repaint();
			}
		});
		TXButton.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP){
					if(Y - 1 >= 0 && ArrayMaze[X][Y-1] == true){
						Y--;
						//System.out.println(ArrayMaze[X][Y]);
						TXButton.setBounds(235 + X*10, 50 + Y*10, 10, 10);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					if(Y + 1 < 41 && ArrayMaze[X][Y+1]){
						Y++;
						TXButton.setBounds(235 + X*10, 50 + Y*10, 10, 10);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					if(X - 1 >= 0 && ArrayMaze[X-1][Y]){
						X--;
						TXButton.setBounds(235 + X*10, 50 + Y*10, 10, 10);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					if(X + 1 < 53 && ArrayMaze[X+1][Y]){
						X++;
						TXButton.setBounds(235 + X*10, 50 + Y*10, 10, 10);
						if(X == 52)
						{
							JOptionPane.showMessageDialog(null, "恭喜！ 您走出了迷宫");
							TXButton.setBounds(235 , 60, 10, 10);
							X = 0 ; Y = 1 ;
						}
					}
				}
			}
			
			
		});
		
		
		addMouseListener(new MouseAdapter() {
			// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {
				// 当鼠标按下的时候获得窗口当前的位置
				//System.out.println(e.getX());
				origin.x = e.getX();
				origin.y = e.getY();
				}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent b) {
				// 当鼠标拖动时判断是否在窗口四周
				if(origin.x < 27 || origin.x > 773 || origin.y < 50 || origin.y > 565)
				{
					//获取窗口坐标
					Point p = getLocation();
				// 设置窗口的位置
				// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
				setLocation(p.x + b.getX() - origin.x, p.y + b.getY()- origin.y);
				}
			}
		});
		
	}
		
		
		//线程
		class Thread1 extends Thread
		{
			public void run()
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				myp.remove(ZCZButton);
				if(YouXi)
				{
					myp.add(ZMGButton);
					//ZMGButton.requestFocus(); // 使按钮获取焦点
					repaint(25,45,200,415);
				}
				else
				{
					myp.add(ZJJButton);
					//ZJJButton.requestFocus(); // 使按钮获取焦点
					repaint(25,45,200,415);
				}
			}
		}
		
		
		
			
		
		
	////////////////
	class myPanel extends JPanel{
		ImageIcon myimage;
		myPanel(){
		myimage = new ImageIcon(getClass().getResource("/image/迷宫界面.jpg"));
		}
		public void paintComponent(Graphics g){
		g.drawImage(myimage.getImage(),0,0,null);
		if(YouXi)
		{
		URL url = getClass().getResource("/image/墙.jpg"); // 指定图片路径
		ImageIcon image = new ImageIcon(url); // 创建ImageIcon对象
		for(int i=0;i<53;i++)
	        for(int j=0;j<41;j++)
	        {
	          if (ArrayMaze[i][j] == false)
	          {
	        	g.drawImage(image.getImage(), 235+ i * 10 , 50 + j* 10,10, 10, this); // 将图片绘制到面板上
	          }
	        }
		//g.drawImage(image.getImage(), 50, 50, this); // 将图片绘制到面板上
		}
		if(LJ)
		{
			for(int i = 0 ; i < Lise.size() ; i++)
			{
				g.setColor(Color.red);
				g.fillRect(235 + Lise.get(i).x * 10, 50 + Lise.get(i).y* 10, 10, 10);
			}
		}
		}
		}
	public static void main(String[] args) {
		Start St =new Start();
		St.MyStart();
		
	}
}


class Sound
{
	FileInputStream file1;
	BufferedInputStream buf1;
	@SuppressWarnings("restriction")
	AudioStream audio1;
	@SuppressWarnings("restriction")
	public Sound()
	{
		try {
			file1 = new FileInputStream(".\\src\\Music\\点.wav");
			buf1 = new BufferedInputStream(file1);
			audio1 = new AudioStream(buf1);
			AudioPlayer.player.start(audio1);
		} catch (Exception e) {
			System.out.println("音频文件读取失败！");
		}
	}
}