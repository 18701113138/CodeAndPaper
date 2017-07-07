package java_我的迷宫生成_随机Lise;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrimMaze {
	/**时间：2015年六月25号
	 * 作者：鼠标猎人
	 * 功能：随机的方法生成迷宫；
	 * 		1）生成的迷宫没明显的主路，没循环路；
	 * 		2）任意两点之间有且只有一条通路；
	 * 本类主要用于生成迷宫对应的二位数组ArrayMaze[][]；
	 */
	long Rand_zhongzi = System.currentTimeMillis();//随机种子，用来保存随机地图
	boolean ArrayMaze[][];//存放迷宫地图
	int X , Y ;//迷宫大小
	final int ROAD = 10;//迷宫通路和墙的宽度
	private List<Point> Lise = new ArrayList<Point>();;//创建列表，用来存放可以探索的坐标点
	private int[] X_rand = { 1, 0, -1, 0 };//用来设置探索X轴的方向
	private int[] Y_rand = { 0, -1, 0, 1 };//用来设置探索Y轴的方向

	//构造函数的重载，默认生成51*51大小
	PrimMaze()
	{
		reset(53,41);
	}
	PrimMaze(int M)
	{
		M = M - M%2 + 1;
		reset(M,M);
	}
	PrimMaze(int M , int N)
	{
		M = M - M%2 + 1;
		N = N - N%2 + 1;
		reset(M,N);
	}
	
	
	//创建迷宫大小（m * n）
	private void reset(int m, int n)
	  {
		X = m;	Y = n;
		ArrayMaze = new boolean[m][n];
	    for (int i = 0; i < m; i++)
	      for (int j = 0; j < n; j++)
	    	  ArrayMaze[i][j] = false;//将迷宫全部设置为墙-----false为墙，true为通路
	    ArrayMaze[0][1] = true;//选择左上角为入口
	    ArrayMaze[1][1] = true;//左上角两个墙设置为通路 
	    Lise.clear();//列表初始化--清空
	    Lise.add(new Point(1, 2));//将[1][1]周围的可能设置为通路的两个墙坐标放入列表
	    Lise.add(new Point(2, 1));
	    
	    while (Lise.size() > 0)//Lise.size()返回列表中元素的个数，只要里面有墙就随机选取一个墙然后判断是否能设置成通路
	    {
	      choiceWall();// 随机选择一个墙判断
	    }
	    ArrayMaze[m - 1][n - 2] = true;//将出口打通
	  }
	private void choiceWall()
	  {
	    Random rand = new Random(Rand_zhongzi);//时间作为种子，创建随机对象rand
	    Point point = Lise.remove(rand.nextInt(Lise.size()));//将随机选中的墙从列表中删除，然后返回给point
	    int x = (int) point.getX();
	    int y = (int) point.getY();
	    if (test(x, y) == 1)//判断该点是在横线墙上还是竖线墙上
	    {
	      if (isSafe(x - 1, y))//判断左临墙是否在迷宫数组内和是否为墙
	      {//如过为真  证明该点的左边为墙   则将该点和该点左边的点设为通路
	    	ArrayMaze[x][y] = true;//设置该点为通路
	        ArrayMaze[x - 1][y] = true;//设置该点的下一个点也为通路
	        addWall(x - 1,y);//将（x-1，y）的临墙加入列表中
	        return ;
	      }
	      else if (isSafe(x + 1, y))
	      {
	    	ArrayMaze[x][y] = true;
	    	ArrayMaze[x + 1][y] = true;
	    	addWall(x + 1,y);
	        return ;
	      }
	    }
	    else if (test(x, y) == 2)
	    {
	      if (isSafe(x, y - 1))
	      {
	    	ArrayMaze[x][y] = true;
	        ArrayMaze[x][y - 1] = true;
	        addWall(x,y - 1);
	        return;
	      }
	      else if (isSafe(x, y + 1))
	      {
	    	ArrayMaze[x][y] = true;
	        ArrayMaze[x][y + 1] = true;
	        addWall(x,y + 1);
	        return;
	      }
	    }
	    return;
	  }
	
	private void addWall(int x, int y)
	  {
	    for (int i = 0; i < X_rand.length; i++)//遍历该点的四周的墙，将能加入列表的坐标加入列表
	    {
	      if (isSafe(x + X_rand[i], y + Y_rand[i])&&!Lise.contains(new Point(x + X_rand[i], y + Y_rand[i])))//Lise.contains()判断列表是否已经存在该点
	      {
	    	  Lise.add(new Point(x + X_rand[i], y + Y_rand[i]));//将该点加入列表
	      }
	    }
	  }
	
	private int test(int x, int y)
	  {
	    if (x % 2 == 0)
	      return 1;// 竖线
	    else if (y % 2 == 0)
	      return 2;// 横线
	    else
	      return 0;// 出错了
	  }
	
	private boolean isSafe(int x, int y)
	  {

	    if (x <= 0 || x >= X|| y <= 0 || y >= Y || ArrayMaze[x][y] == true)
	    {
	      return false;
	    }
	    return true;
	  }
	/*
	public void paint(Graphics g)
	{
		URL url = getClass().getResource("/image/地.jpg"); // 指定图片路径
		ImageIcon image = new ImageIcon(url); // 创建ImageIcon对象
		URL url2 = getClass().getResource("/image/路2.jpg"); // 指定图片路径
		ImageIcon image2 = new ImageIcon(url2); // 创建ImageIcon对象
	//	ImageIcon image3 = new ImageIcon(getClass().getResource("/image/迷宫界面.png")); // 创建ImageIcon对象
	//	g.drawImage(image3.getImage(), 0, 0, this); // 将图片绘制到面板上
		for(int i=0;i<X;i++)
	        for(int j=0;j<Y;j++)
	        {
	          if (ArrayMaze[i][j] == true)
	          {
	            //g.setColor(Color.white);
	            //g.fillRect(50 + i * ROAD, 50 + j* ROAD, ROAD, ROAD);
	            g.drawImage(image2.getImage(), 50 + i * ROAD , 50 + j* ROAD ,ROAD, ROAD, this); // 将图片绘制到面板上
	          }
	          else
	          {
	            //g.setColor(Color.black);
	            //g.fillRect(50 + i * ROAD, 50 + j* ROAD, ROAD, ROAD);
	        	g.drawImage(image.getImage(), 50 + i * ROAD , 50 + j* ROAD ,ROAD, ROAD, this); // 将图片绘制到面板上
	          }
	        }
		//g.drawImage(image.getImage(), 50, 50, this); // 将图片绘制到面板上
	}
	
	
	public static void main(String []args)
	{
		JLabel label = new JLabel();
		PrimMaze PM = new PrimMaze();
		PM.setUndecorated(true);
		PM.setSize(1180, 986);
		PM.setVisible(true);
		label.setOpaque(false);
		PM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//打印迷宫数组的情况
		for(int i = 0 ; i < 21 ; i++)
		{
			for(int j = 0 ; j < 21 ; j++)
			{
				if(PM.ArrayMaze[j][i])
					System.out.print("2 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
	*/
}
