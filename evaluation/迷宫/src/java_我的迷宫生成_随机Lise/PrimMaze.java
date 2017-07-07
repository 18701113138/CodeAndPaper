package java_�ҵ��Թ�����_���Lise;

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
	/**ʱ�䣺2015������25��
	 * ���ߣ��������
	 * ���ܣ�����ķ��������Թ���
	 * 		1�����ɵ��Թ�û���Ե���·��ûѭ��·��
	 * 		2����������֮������ֻ��һ��ͨ·��
	 * ������Ҫ���������Թ���Ӧ�Ķ�λ����ArrayMaze[][]��
	 */
	long Rand_zhongzi = System.currentTimeMillis();//������ӣ��������������ͼ
	boolean ArrayMaze[][];//����Թ���ͼ
	int X , Y ;//�Թ���С
	final int ROAD = 10;//�Թ�ͨ·��ǽ�Ŀ��
	private List<Point> Lise = new ArrayList<Point>();;//�����б�������ſ���̽���������
	private int[] X_rand = { 1, 0, -1, 0 };//��������̽��X��ķ���
	private int[] Y_rand = { 0, -1, 0, 1 };//��������̽��Y��ķ���

	//���캯�������أ�Ĭ������51*51��С
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
	
	
	//�����Թ���С��m * n��
	private void reset(int m, int n)
	  {
		X = m;	Y = n;
		ArrayMaze = new boolean[m][n];
	    for (int i = 0; i < m; i++)
	      for (int j = 0; j < n; j++)
	    	  ArrayMaze[i][j] = false;//���Թ�ȫ������Ϊǽ-----falseΪǽ��trueΪͨ·
	    ArrayMaze[0][1] = true;//ѡ�����Ͻ�Ϊ���
	    ArrayMaze[1][1] = true;//���Ͻ�����ǽ����Ϊͨ· 
	    Lise.clear();//�б��ʼ��--���
	    Lise.add(new Point(1, 2));//��[1][1]��Χ�Ŀ�������Ϊͨ·������ǽ��������б�
	    Lise.add(new Point(2, 1));
	    
	    while (Lise.size() > 0)//Lise.size()�����б���Ԫ�صĸ�����ֻҪ������ǽ�����ѡȡһ��ǽȻ���ж��Ƿ������ó�ͨ·
	    {
	      choiceWall();// ���ѡ��һ��ǽ�ж�
	    }
	    ArrayMaze[m - 1][n - 2] = true;//�����ڴ�ͨ
	  }
	private void choiceWall()
	  {
	    Random rand = new Random(Rand_zhongzi);//ʱ����Ϊ���ӣ������������rand
	    Point point = Lise.remove(rand.nextInt(Lise.size()));//�����ѡ�е�ǽ���б���ɾ����Ȼ�󷵻ظ�point
	    int x = (int) point.getX();
	    int y = (int) point.getY();
	    if (test(x, y) == 1)//�жϸõ����ں���ǽ�ϻ�������ǽ��
	    {
	      if (isSafe(x - 1, y))//�ж�����ǽ�Ƿ����Թ������ں��Ƿ�Ϊǽ
	      {//���Ϊ��  ֤���õ�����Ϊǽ   �򽫸õ�͸õ���ߵĵ���Ϊͨ·
	    	ArrayMaze[x][y] = true;//���øõ�Ϊͨ·
	        ArrayMaze[x - 1][y] = true;//���øõ����һ����ҲΪͨ·
	        addWall(x - 1,y);//����x-1��y������ǽ�����б���
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
	    for (int i = 0; i < X_rand.length; i++)//�����õ�����ܵ�ǽ�����ܼ����б����������б�
	    {
	      if (isSafe(x + X_rand[i], y + Y_rand[i])&&!Lise.contains(new Point(x + X_rand[i], y + Y_rand[i])))//Lise.contains()�ж��б��Ƿ��Ѿ����ڸõ�
	      {
	    	  Lise.add(new Point(x + X_rand[i], y + Y_rand[i]));//���õ�����б�
	      }
	    }
	  }
	
	private int test(int x, int y)
	  {
	    if (x % 2 == 0)
	      return 1;// ����
	    else if (y % 2 == 0)
	      return 2;// ����
	    else
	      return 0;// ������
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
		URL url = getClass().getResource("/image/��.jpg"); // ָ��ͼƬ·��
		ImageIcon image = new ImageIcon(url); // ����ImageIcon����
		URL url2 = getClass().getResource("/image/·2.jpg"); // ָ��ͼƬ·��
		ImageIcon image2 = new ImageIcon(url2); // ����ImageIcon����
	//	ImageIcon image3 = new ImageIcon(getClass().getResource("/image/�Թ�����.png")); // ����ImageIcon����
	//	g.drawImage(image3.getImage(), 0, 0, this); // ��ͼƬ���Ƶ������
		for(int i=0;i<X;i++)
	        for(int j=0;j<Y;j++)
	        {
	          if (ArrayMaze[i][j] == true)
	          {
	            //g.setColor(Color.white);
	            //g.fillRect(50 + i * ROAD, 50 + j* ROAD, ROAD, ROAD);
	            g.drawImage(image2.getImage(), 50 + i * ROAD , 50 + j* ROAD ,ROAD, ROAD, this); // ��ͼƬ���Ƶ������
	          }
	          else
	          {
	            //g.setColor(Color.black);
	            //g.fillRect(50 + i * ROAD, 50 + j* ROAD, ROAD, ROAD);
	        	g.drawImage(image.getImage(), 50 + i * ROAD , 50 + j* ROAD ,ROAD, ROAD, this); // ��ͼƬ���Ƶ������
	          }
	        }
		//g.drawImage(image.getImage(), 50, 50, this); // ��ͼƬ���Ƶ������
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
		
		
		//��ӡ�Թ���������
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
