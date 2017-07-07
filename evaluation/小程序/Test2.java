package test2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.stream.events.EndDocument;

public class Test2 {
    private int f1() {
    	
		return 1;
	}
private int f2() {
    	
		return 2;
	}
private int f3() {
	
	return 3;
}
private int f4() {
	
	return 4;
}
private int f5() {
	
	return 5;
}

private int f6()
{
	return 2*f3();
}

private int f7()
{
	return f1()+2*f3();
}
private int f8()
{
	return f3()+f5()+1;
}

private int f9()
{
	return f2()+f7();
}
private int f10()
{
	return 2*f5();
}

private int f11()
{
	return f3()+f8();
}

private int f12()
{
	return f2()+2*f5();
}

private int f13()
{
	return f1()+f3()+f9();
}

private int f14()
{
	return 2*f7()+1;
}

private int f15()
{
	return f1()+f6()+f3()+f5();
}

private int f16() //特例
{
	return 2*f8();
}

private int f17()
{
	return f7()+f9()+f1();
}

private int f18()
{
	return 2*f9();
}

private int f19()
{
	return f11()+f7()+f1();
}

private int f20()
{
	return f17()+f3();
}

private int f21()
{
	return f18()+f3();
}

private int f22()
{
	return 2*f11();
}

private int f23()
{
	return f13()+f10();
}

private int f24()
{
	return f15()+f9()+1;
}

private int f25()
{
	return f23()+f2();
}

private int f26()
{
	return 2*f13();
}

private int f27()
{
	return f21()+f6();
}

private int f28()
{
	return f9()+f11()+f8();
}

private int f29()
{
	return f9()+f20();
}

private int f30()
{
	return 2*f15();
}

private int f31()
{
	return f19()+f12();
}

private int f32()
{
	return f18()+f14();
}

private int f33()
{
	return f32()+f1();
}

private int f34()
{
	return 2*f17();
}

private int f35()
{
	return f9()+f13()+f13();
}

private int f36()
{
	return f15()+f19()+f2();
}

private int f37()
{
	return f33()+f4();
}

private int f38()
{
	return 2*f19();
}

private int f39()
{
	return f15()+f24()+1;
}

private int f40()
{
	return f15()+f21()+f4();
}

private int f41()
{
	return f35()+f6();
}

private int f42()
{
	return 2*f21();
}

private int f43()
{
	return f33()+f10();
}

private int f44()
{
	return f38()+f6();
}

private int f45()
{
	return f23()+f22();
}

private int f46()
{
	return 2*f23();
}

private int f47()
{
	return f1()+f46();
}

private int f48()
{
	return f28()+f20();
}

private int f49()
{
	return f44()+f5();
}

private int f50()
{
	return 2*f25();
}

private static void start()
{
	
}
private static void end()
{
	
}   
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		 try {
   		   File file = new File("结果.txt");
             if(file.exists())
             {
            	 if (!file.delete()) {
                     System.out.println("请关闭使用该文件的所有进程或者流！！");
                 } else {
                     System.out.println(file.getName()+" 成功被删除！");
                 }
             }
             file.createNewFile();

   		  } catch (IOException e) 
  	      {
   		   e.printStackTrace();
   		  }
		 
		 
		for(int i=1;i<=51;i++)
		{
	   	start();
		 /* Scanner input = new Scanner(System.in);
  		  int a =  input.nextInt();
  		  input.close();*/
	      int a = i;
  		  int b;
  		  Test2 test = new Test2();
  		
  		  if(a==1)
  		  {
  			  b=test.f1();
  			  System.out.println(b);
  		  }
  		  else  if(a==2)
  		  {
  			b=test.f2();
  			System.out.println(b);
  		  }
  		  
  		  else  if(a==3)
  		  {
  			b=test.f3();
  			System.out.println(b);
  		  }
  		  else  if(a==4)
  		  {
  			b=test.f4();
  			System.out.println(b);
  		  }
  		  else  if(a==5)
  		  {
  			b=test.f5();
  			System.out.println(b);
  		  }
  		  else  if(a==6)
  		  {
  			b=test.f6();
  			System.out.println(b);
  		  }
  		  else  if(a==7)
  		  {
  			b=test.f7();
  			System.out.println(b);
  		  }
  		  else  if(a==8)
  		  {
  			b=test.f8();
  			System.out.println(b);
  		  }
  		  else  if(a==9)
  		  {
  			b=test.f9();
  			System.out.println(b);
  		  }
  		  else  if(a==10)
  		  {
  			b=test.f10();
  			System.out.println(b);
  		  }
  		  else  if(a==11)
  		  {
  			b=test.f11();
  			System.out.println(b);
  		  }
  		  else  if(a==12)
  		  {
  			b=test.f12();
  			System.out.println(b);
  		  }
  		  else  if(a==13)
  		  {
  			b=test.f13();
  			System.out.println(b);
  		  }
  		  else  if(a==14)
  		  {
  			b=test.f14();
  			System.out.println(b);
  		  }
  		  else  if(a==15)
  		  {
  			b=test.f15();
  			System.out.println(b);
  		  }
  		  else  if(a==16)
  		  {
  			b=test.f16();
  			System.out.println(b);
  		  }
  		  else  if(a==17)
  		  {
  			b=test.f17();
  			System.out.println(b);
  		  }
  		  else  if(a==18)
  		  {
  			b=test.f18();
  			System.out.println(b);
  		  }
  		  else  if(a==19)
  		  {
  			b=test.f19();
  			System.out.println(b);
  		  }
  		  else  if(a==20)
  		  {
  			b=test.f20();
  			System.out.println(b);
  		  }
  		  else  if(a==21)
  		  {
  			b=test.f21();
  			System.out.println(b);
  		  }
  		  else  if(a==22)
  		  {
  			b=test.f22();
  			System.out.println(b);
  		  }
  		  else  if(a==23)
  		  {
  			b=test.f23();
  			System.out.println(b);
  		  }
  		  else  if(a==24)
  		  {
  			b=test.f24();
  			System.out.println(b);
  		  }
  		  else  if(a==25)
  		  {
  			b=test.f25();
  			System.out.println(b);
  		  }
  		  else  if(a==26)
  		  {
  			b=test.f26();
  			System.out.println(b);
  		  }
  		  else  if(a==27)
  		  {
  			b=test.f27();
  			System.out.println(b);
  		  }
  		  else  if(a==28)
  		  {
  			b=test.f28();
  			System.out.println(b);
  		  }
  		  else  if(a==29)
  		  {
  			b=test.f29();
  			System.out.println(b);
  		  }
  		  else  if(a==30)
  		  {
  			b=test.f30();
  			System.out.println(b);
  		  }
  		  else  if(a==31)
  		  {
  			b=test.f31();
  			System.out.println(b);
  		  }
  		  else  if(a==32)
  		  {
  			b=test.f32();
  			System.out.println(b);
  		  }
  		  else  if(a==33)
  		  {
  			b=test.f33();
  			System.out.println(b);
  		  }
  		  else  if(a==34)
  		  {
  			b=test.f34();
  			System.out.println(b);
  		  }
  		  else  if(a==35)
  		  {
  			b=test.f35();
  			System.out.println(b);
  		  }
  		  else  if(a==36)
  		  {
  			b=test.f36();
  			System.out.println(b);
  		  }
  		  else  if(a==37)
  		  {
  			b=test.f37();
  			System.out.println(b);
  		  }
  		  else  if(a==38)
  		  {
  			b=test.f38();
  			System.out.println(b);
  		  }
  		  else  if(a==39)
  		  {
  			b=test.f39();
  			System.out.println(b);
  		  }
  		  else  if(a==40)
  		  {
  			b=test.f40();
  			System.out.println(b);
  		  }
  		  else  if(a==41)
  		  {
  			b=test.f41();
  			System.out.println(b);
  		  }
  		  else  if(a==42)
  		  {
  			b=test.f42();
  			System.out.println(b);
  		  }
  		  else  if(a==43)
  		  {
  			b=test.f43();
  			System.out.println(b);
  		  }
  		  else  if(a==44)
  		  {
  			b=test.f44();
  			System.out.println(b);
  		  }
  		  else  if(a==45)
  		  {
  			b=test.f45();
  			System.out.println(b);
  		  }
  		  else  if(a==46)
  		  {
  			b=test.f46();
  			System.out.println(b);
  		  }
  		  else  if(a==47)
  		  {
  			b=test.f47();
  			System.out.println(b);
  		  }
  		  else  if(a==48)
  		  {
  			b=test.f48();
  			System.out.println(b);
  		  }
  		  else  if(a==49)
  		  {
  			b=test.f49();
  			System.out.println(b);
  		  }
  		  else
  		  {
  			b=test.f50();
  			System.out.println(b);
  		  }
  		  
  		
  		 try {
   		   File file = new File("结果.txt");
   		
   		   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
   		   BufferedWriter bw = new BufferedWriter(fw);
   		  if(a == b)
   		  {
   			bw.write( String.valueOf(1));
   			
   		  }
   		  else{
   			bw.write( String.valueOf(0));
   		  }

   			  bw.write("\n");

   		   bw.close();
   		   
   		  } catch (IOException e) 
  	      {
   		   e.printStackTrace();
   		  }
		 
		System.out.println("-----------------------------------函数结束-----------------------------");
		}  
	    end();
	    
	}
	
}
