public class JavaBFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 设定初始值并赋值，以邻接矩阵表示树
		int[][] graph = new int[7][7];
		// 赋值
		// graph[0][0]=0;
		for (int k = 0; k < graph.length; k++) {
			graph[k][k] = 0;
		}
		graph[0][1] = 1;
		graph[0][2] = 0;
		graph[0][3] = 0;
		graph[0][4] = 0;
		graph[0][5] = 1;
		graph[0][6] = 0;

		graph[1][0] = 1;
		graph[1][2] = 0;
		graph[1][3] = 0;
		graph[1][4] = 0;
		graph[1][5] = 1;
		graph[1][6] = 0;

		graph[2][0] = 0;
		graph[2][1] = 0;
		graph[2][3] = 1;
		graph[2][4] = 0;
		graph[2][5] = 0;
		graph[2][6] = 0;

		graph[3][0] = 0;
		graph[3][1] = 0;
		graph[3][2] = 1;
		graph[3][4] = 0;
		graph[3][5] = 1;
		graph[3][6] = 0;

		graph[4][0] = 0;
		graph[4][1] = 0;
		graph[4][2] = 0;
		graph[4][3] = 0;
		graph[4][5] = 1;
		graph[4][6] = 0;

		graph[5][0] = 1;
		graph[5][1] = 1;
		graph[5][2] = 0;
		graph[5][3] = 1;
		graph[5][4] = 1;
		graph[5][6] = 0;

		graph[6][0] = 0;
		graph[6][1] = 0;
		graph[6][2] = 0;
		graph[6][3] = 0;
		graph[6][4] = 0;
		graph[6][5] = 0;

		// 设置标志数祖
		int[] mark = new int[graph.length];
		for (int k = 0; k < mark.length; k++) {
			mark[k] = 0;
		}
		// 设置队列
		JavaQueue queue = new JavaQueue();
		// 开始遍历图的结点，从0开始
		for (int m = 0; m < graph.length; m++) {
			// 将元素依次压入队列,然后寻找连接的点，判断是否已经入队列
			if (mark[m] == 0)// 如果为了0表示还未入队列,依次检查连接点
			{
				mark[m] = 1;
				queue.push(m);
				while (!queue.isEmpty()) {
					// 取出队列值并输出
					int l = (Integer) queue.get();
					System.out.println(l);
					for (int n = 0; n < graph.length; n++) {
						// 如果为1，即表示有连接，且还未入队列，压入队列，设置当前值为-1，表示已经访问
						if (graph[l][n] == 1) {
							if (mark[n] != 1) {// 如果n节占尚未入栈，则入栈，否则不处理
								queue.push(n);
								mark[n] = 1;// 设置已经为入栈状态
								graph[l][n] = -1;// 并设置此条边已经访问过
								graph[n][l] = -1;
							}
						}
					}
				}
			}
			// System.out.println(queue.get());
		}
	}
}
