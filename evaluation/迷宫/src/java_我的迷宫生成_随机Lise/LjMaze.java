package java_�ҵ��Թ�����_���Lise;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class LjMaze {
	boolean arry[][];
	int a[][] = new int[53][41];
	List<Point> Lise = new ArrayList<Point>();;//�����б�������ſ���̽���������
	Point P;
	public void myLjMaze()
	{
		P = new Point(52,39);
		for(int i = 0 ; i < 53 ; i++)
			for(int j = 0 ; j < 41 ; j++)
			{
				if(arry[i][j])
				{
					a[i][j] = 1;
				}
				else
				{
					a[i][j] = 0;
				}
			}
		Lise.clear();//�б��ʼ��--���
		Lise.add(new Point(0, 1));//
		Lise.add(new Point(1, 1));//
		a[0][1] = 2;
		a[1][1] = 2;
		while(Lise.get(Lise.size()-1).x < 52)
		{
			if(a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y - 1] == 1)//��
			{
				Lise.add(new Point(Lise.get(Lise.size()-1).x,Lise.get(Lise.size()-1).y - 1));
				a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y] = 2;
			}
			else 
			{
				if(a[Lise.get(Lise.size()-1).x + 1][Lise.get(Lise.size()-1).y] == 1)//��
				{
					Lise.add(new Point(Lise.get(Lise.size()-1).x + 1,Lise.get(Lise.size()-1).y ));
					a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y] = 2;
				}
				else 
				{
					if(a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y + 1] == 1)//��
					{
						Lise.add(new Point(Lise.get(Lise.size()-1).x,Lise.get(Lise.size()-1).y + 1));
						a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y] = 2;
					}
					else 
					{
						if(a[Lise.get(Lise.size()-1).x - 1][Lise.get(Lise.size()-1).y] == 1)//��
						{
							Lise.add(new Point(Lise.get(Lise.size()-1).x - 1,Lise.get(Lise.size()-1).y));
							a[Lise.get(Lise.size()-1).x][Lise.get(Lise.size()-1).y] = 2;
						}
						else
						{
							Lise.remove(Lise.size()-1);
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		LjMaze kk = new LjMaze();
	}

}
