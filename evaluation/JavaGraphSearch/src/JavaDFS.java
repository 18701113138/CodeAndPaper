public class JavaDFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 设定初始值并赋值，以邻接矩阵表示树
		int[][] graph = new int[7][7];
		// 赋值
		// graph[0][0]=0;
		graph = init(graph);
		// 设置标志数祖
		int[] mark = new int[graph.length];
		for (int k = 0; k < mark.length; k++) {
			mark[k] = 0;
		}
		// 设置堆栈
		JavaStack stack = new JavaStack();
		// 开始遍历图的结点，从0开始，并递归实现
		for (int m = 0; m < graph.length; m++) {
			stackloop(m, graph, mark, stack);
		}
	}

	// 递归处理
	public static void stackloop(int m, int[][] graph, int[] mark,
			JavaStack stack) {
		// 遍历每一个结点元素，判断是否已经入栈，没有则入栈
		// 入栈并设置已访问过
		if (mark[m] == -1) {
		} else {
			if (mark[m] == 0) {
				mark[m] = 1;
				stack.push(m);
				System.out.println(stack.top());
			}
			int n = 0;
			// 循环寻找是不是存在连接点,继续判断连续点的状态，有则连续点继续入栈，无则出栈
			for (n = 0; n < graph.length; n++) {
				// 此时说明n还未入栈,把n压入堆栈，并设置这条边已经访问过
				if (graph[m][n] == 1) {
					graph[m][n] = 0;
					graph[n][m] = 0;
					stackloop(n, graph, mark, stack);
				}
			}
			if (stack.size() != 0) {
				int j = (Integer) stack.top();
				mark[j] = -1;
				// 弹出后设置为-1，即已经访问过，且不在堆栈中，不能再访问
				stack.pop();
				// 继续抛出上一个入栈值
			}
		}
	}

	// 邻接矩阵赋初值
	public static int[][] init(int[][] graph) {
		for (int k = 0; k < graph.length; k++) {
			graph[k][k] = 0;
		}
		graph[0][1] = 0;
		graph[0][2] = 0;
		graph[0][3] = 1;
		graph[0][4] = 0;
		graph[0][5] = 1;
		graph[0][6] = 0;

		graph[1][0] = 0;
		graph[1][2] = 1;
		graph[1][3] = 0;
		graph[1][4] = 0;
		graph[1][5] = 0;
		graph[1][6] = 0;

		graph[2][0] = 0;
		graph[2][1] = 1;
		graph[2][3] = 1;
		graph[2][4] = 0;
		graph[2][5] = 0;
		graph[2][6] = 0;

		graph[3][0] = 1;
		graph[3][1] = 0;
		graph[3][2] = 1;
		graph[3][4] = 1;
		graph[3][5] = 0;
		graph[3][6] = 0;

		graph[4][0] = 0;
		graph[4][1] = 0;
		graph[4][2] = 0;
		graph[4][3] = 1;
		graph[4][5] = 0;
		graph[4][6] = 0;

		graph[5][0] = 1;
		graph[5][1] = 0;
		graph[5][2] = 0;
		graph[5][3] = 0;
		graph[5][4] = 0;
		graph[5][6] = 1;

		graph[6][0] = 0;
		graph[6][1] = 0;
		graph[6][2] = 0;
		graph[6][3] = 0;
		graph[6][4] = 0;
		graph[6][5] = 1;
		return graph;
	}
}
