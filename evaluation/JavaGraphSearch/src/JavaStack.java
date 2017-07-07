import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class JavaStack {

	/**
	 * @param args
	 */
	private LinkedList list = new LinkedList();

	public void push(Object v) {
		list.addFirst(v);
	}
	public Object pop(){
		return list.removeFirst();
	}
	public Object top(){
		return list.getFirst();
	}
	public int size()
	{
		return list.size();
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JavaStack stack=new JavaStack();
//		for(int i=0;i<10;i++)
//		{
//			stack.push(i);
//		}
//		
//			System.out.println(stack.top());
//			stack.pop();
//			System.out.println(stack.top());
//		Map map=new HashMap();
//		A a=new A();
//		A b=new A();
//		A c=new A();
//		int i=0;
//		map.put(i, a);
//		map.put(i++, b);
//		map.put(i++, c);
//	}

}
