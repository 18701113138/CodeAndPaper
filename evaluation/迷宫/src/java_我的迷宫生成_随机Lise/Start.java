package java_�ҵ��Թ�����_���Lise;

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
	boolean ArrayMaze[][];//����Թ���ͼ
	Point origin = new Point();
	JButton ExitButton = new JButton();//�˳���ť
	JButton CXButton = new JButton();//�������ɰ�ť
	JButton LJButton = new JButton();//��ȡ�Թ�·����ť
	JButton SYButton = new JButton();//������ť
	JButton StartButton = new JButton();//��ʼ��Ϸ��ť
	JButton CZButton = new JButton();//������ʽ��ť
	JButton MazeButton = new JButton(new ImageIcon(getClass().getResource("/image/�Թ�.png")));//���Թ���
	JButton ZCZButton = new JButton(new ImageIcon(getClass().getResource("/image/�����.jpg")));//�����
	JButton ZJJButton = new JButton(new ImageIcon(getClass().getResource("/image/����.jpg")));//����
	JButton ZMGButton = new JButton(new ImageIcon(getClass().getResource("/image/���Թ�.jpg")));//���Թ�
	JButton TXButton = new JButton(new ImageIcon(getClass().getResource("/image/Сͷ.png")));//ͷ��ť
	
	ImageIcon ExitImage1 = new ImageIcon(getClass().getResource("/image/�˳�.png"));
	ImageIcon CXImage1 = new ImageIcon(getClass().getResource("/image/��������.png"));
	ImageIcon LJImage1 = new ImageIcon(getClass().getResource("/image/·��.png"));
	ImageIcon StartImage1 = new ImageIcon(getClass().getResource("/image/��ʼ��Ϸ.png"));
	ImageIcon CZImage1 = new ImageIcon(getClass().getResource("/image/��������.png"));
	ImageIcon SYImage1 = new ImageIcon(getClass().getResource("/image/����.png"));
	
	@SuppressWarnings("restriction")
	//AudioStream ButtonSound1 = new AudioStream(new FileInputStream("/����/��.wav"));

	AudioStream bj ,button1;  
	@SuppressWarnings("restriction")
	AudioData ad;
	@SuppressWarnings("restriction")
	ContinuousAudioDataStream cads;
	@SuppressWarnings("restriction")
	public void MyStart()
	{	
		try {  
		    bj = new AudioStream(Start.class.getClassLoader().getResourceAsStream("Music/����.wav"));  
		    ad = bj.getData();
		} catch (IOException e) {e.printStackTrace();}  
		//����ѭ������  
		cads = new ContinuousAudioDataStream(ad);  
		//ѭ�����ſ�ʼŶ  
		AudioPlayer.player.start(cads);
		//ѭ������ֹͣ  
		//AudioPlayer.player.stop(cads);
		contentpane = (JPanel)getContentPane();
		myp = new myPanel();
		setUndecorated(true);//ȥ�����ڱ߿�
		setBounds(WIDTH/2-400,HEIGH/2-300,800,600);//��ʾ����Ļ������
		setVisible(true);
		contentpane.add(myp);
		myp.setLayout(null);
		myp.add(ExitButton);
			ExitButton.setBounds(730, 10, ExitImage1.getIconWidth(), ExitImage1.getIconHeight());
			ExitButton.setIcon(ExitImage1);
			ExitButton.setContentAreaFilled(false); // ȡ���������
			ExitButton.setBorder(null); // ȡ���߿�
			//ExitButton.setToolTipText("�˳���Ϸ");
		myp.add(CXButton);
			CXButton.setBounds(690, 490, CXImage1.getIconWidth(), CXImage1.getIconHeight());
			CXButton.setIcon(CXImage1);
			CXButton.setContentAreaFilled(false); // ȡ���������
			CXButton.setBorder(null); // ȡ���߿�
		myp.add(LJButton);
			LJButton.setBounds(250, 490, LJImage1.getIconWidth(), LJImage1.getIconHeight());
			LJButton.setIcon(LJImage1);
			LJButton.setContentAreaFilled(false); // ȡ���������
			LJButton.setBorder(null); // ȡ���߿�
		myp.add(SYButton);
			SYButton.setBounds(20, 10, SYImage1.getIconWidth(), SYImage1.getIconHeight());
			SYButton.setIcon(SYImage1);
			SYButton.setContentAreaFilled(false); // ȡ���������
			SYButton.setBorder(null); // ȡ���߿�
		myp.add(StartButton);
			StartButton.setBounds(540, 320, StartImage1.getIconWidth(), StartImage1.getIconHeight());
			StartButton.setIcon(StartImage1);
			StartButton.setContentAreaFilled(false); // ȡ���������
			StartButton.setBorder(null); // ȡ���߿�
		myp.add(CZButton);
			CZButton.setBounds(250, 320, CZImage1.getIconWidth(), CZImage1.getIconHeight());
			CZButton.setIcon(CZImage1);
			CZButton.setContentAreaFilled(false); // ȡ���������
			CZButton.setBorder(null); // ȡ���߿�
		myp.add(MazeButton);
			MazeButton.setBounds(325, 70, 330, 130);
			MazeButton.setContentAreaFilled(false); // ȡ���������
			MazeButton.setBorder(null); // ȡ���߿�
		//myp.add(ZCZButton);
			ZCZButton.setBounds(25, 45, 190, 414);
			ZCZButton.setContentAreaFilled(false); // ȡ���������
			ZCZButton.setBorder(null); // ȡ���߿�
			myp.add(ZJJButton);
			ZJJButton.setBounds(25, 45, 190, 414);
			ZJJButton.setContentAreaFilled(false); // ȡ���������
			ZJJButton.setBorder(null); // ȡ���߿�
		//myp.add(ZMGButton);
			ZMGButton.setBounds(25, 45, 190, 414);
			ZMGButton.setContentAreaFilled(false); // ȡ���������
			ZMGButton.setBorder(null); // ȡ���߿�

		//�˳���ť�ļ����¼�
		ExitButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				ExitButton.setIcon(new ImageIcon(getClass().getResource("/image/�˳�����Ӱ.png")));
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
		//������ť�ļ����¼�
		SYButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(ShengYin)
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/��������Ӱ.png")));
				}
				else
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/��������Ӱ.png")));
				}
				ShengYin = !ShengYin;
			}
			public void mouseReleased(MouseEvent e){
				if(ShengYin)
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/����.png")));
					AudioPlayer.player.start(cads);
				}
				else
				{
					SYButton.setIcon(new ImageIcon(getClass().getResource("/image/����.png")));
					AudioPlayer.player.stop(cads);
				}
				TXButton.requestFocus(); // ʹ��ť��ȡ����
			}
		});
		//�������ɵ�ͼ�ļ����¼�
		CXButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CXButton.setIcon(new ImageIcon(getClass().getResource("/image/��������Ӱ.png")));
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
				TXButton.requestFocus(); // ʹ��ť��ȡ����
			}
		});
		//�Զ���ȡ�Թ�·���ļ����¼�
		LJButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				LJButton.setIcon(new ImageIcon(getClass().getResource("/image/·������Ӱ.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				LJButton.setIcon(LJImage1);
				TXButton.requestFocus(); // ʹ��ť��ȡ����
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
		//����������ť�ļ����¼�
		CZButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				CZButton.setIcon(new ImageIcon(getClass().getResource("/image/������������Ӱ.png")));
				new Sound();
			}
			public void mouseReleased(MouseEvent e){
				CZButton.setIcon(CZImage1);
				myp.remove(ZJJButton);
				myp.remove(ZMGButton);
				myp.add(ZCZButton);
				//ZCZButton.requestFocus(); // ʹ��ť��ȡ����
				repaint(25,45,200,415);
				Thread1 Th = new Thread1();
				Th.start();
				TXButton.requestFocus(); // ʹ��ť��ȡ����
			}
		});
		//��ʼ��Ϸ��ť�ļ����¼�
		StartButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				StartButton.setIcon(new ImageIcon(getClass().getResource("/image/��ʼ��Ϸ����Ӱ.png")));
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
					TXButton.setContentAreaFilled(false); // ȡ���������
					TXButton.setBorder(null); // ȡ���߿�
					TXButton.requestFocus(); // ʹ��ť��ȡ����
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
							JOptionPane.showMessageDialog(null, "��ϲ�� ���߳����Թ�");
							TXButton.setBounds(235 , 60, 10, 10);
							X = 0 ; Y = 1 ;
						}
					}
				}
			}
			
			
		});
		
		
		addMouseListener(new MouseAdapter() {
			// ���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {
				// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
				//System.out.println(e.getX());
				origin.x = e.getX();
				origin.y = e.getY();
				}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
			public void mouseDragged(MouseEvent b) {
				// ������϶�ʱ�ж��Ƿ��ڴ�������
				if(origin.x < 27 || origin.x > 773 || origin.y < 50 || origin.y > 565)
				{
					//��ȡ��������
					Point p = getLocation();
				// ���ô��ڵ�λ��
				// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
				setLocation(p.x + b.getX() - origin.x, p.y + b.getY()- origin.y);
				}
			}
		});
		
	}
		
		
		//�߳�
		class Thread1 extends Thread
		{
			public void run()
			{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				myp.remove(ZCZButton);
				if(YouXi)
				{
					myp.add(ZMGButton);
					//ZMGButton.requestFocus(); // ʹ��ť��ȡ����
					repaint(25,45,200,415);
				}
				else
				{
					myp.add(ZJJButton);
					//ZJJButton.requestFocus(); // ʹ��ť��ȡ����
					repaint(25,45,200,415);
				}
			}
		}
		
		
		
			
		
		
	////////////////
	class myPanel extends JPanel{
		ImageIcon myimage;
		myPanel(){
		myimage = new ImageIcon(getClass().getResource("/image/�Թ�����.jpg"));
		}
		public void paintComponent(Graphics g){
		g.drawImage(myimage.getImage(),0,0,null);
		if(YouXi)
		{
		URL url = getClass().getResource("/image/ǽ.jpg"); // ָ��ͼƬ·��
		ImageIcon image = new ImageIcon(url); // ����ImageIcon����
		for(int i=0;i<53;i++)
	        for(int j=0;j<41;j++)
	        {
	          if (ArrayMaze[i][j] == false)
	          {
	        	g.drawImage(image.getImage(), 235+ i * 10 , 50 + j* 10,10, 10, this); // ��ͼƬ���Ƶ������
	          }
	        }
		//g.drawImage(image.getImage(), 50, 50, this); // ��ͼƬ���Ƶ������
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
			file1 = new FileInputStream(".\\src\\Music\\��.wav");
			buf1 = new BufferedInputStream(file1);
			audio1 = new AudioStream(buf1);
			AudioPlayer.player.start(audio1);
		} catch (Exception e) {
			System.out.println("��Ƶ�ļ���ȡʧ�ܣ�");
		}
	}
}