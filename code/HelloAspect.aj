package com.aspectj.demo.aspect;

import java.util.*;

import javax.jws.soap.SOAPBinding.Use;
import javax.print.DocFlavor.STRING;
import javax.sound.sampled.Line;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.aspectj.lang.Signature; 
import utils.*;

public aspect HelloAspect{
	static final int number =50;
	String[] jieguo = new String[1000];
	int[][] function = new int[100][100];   // ��¼����׾����һ��
	int rowflag = 0;  
	int i=0;                     //��¼��ǰ���õĲ���
	Map<String, Character> testmap = new HashMap<String , Character>();  //��ֵ�� String��������   char������
	Stack<String> stack = new Stack<>(); //ջ��������洢��ϵ   Ҳ������һ��int���ͽ��б��
	
    //��ȡ���к���
	
	   pointcut function() : call(* *.*.*(..))&&!within(HelloAspect)&&!within(graph.*)&&!within(suanshu.myclass); //�г����еĺ���
	   pointcut mainPoint(): execution(* main(..));                                     //ֻ��������
      
      before() : mainPoint(){     //����������֮ǰ
    	  testmap.put("main", 'A');
	      System.out.println("Entering : " + thisJoinPoint.getSourceLocation());
	      System.out.println("ִ����������" + thisJoinPoint.getStaticPart().getSignature().toString());
	      
	      stack.add(thisJoinPoint.getStaticPart().getSignature().getName());
	      stack.add("f0");
  		  i++;
  		  String s=thisJoinPoint.getSignature().toString();
  		  
    	  try {
    		   File file = new File("function.txt");
    		   if(!file.exists()){
      			  file.createNewFile();
      		   }
    		   
    		   FileReader fr = new FileReader(file);
    		   BufferedReader br = new BufferedReader(fr);
    		   try {
    			   testmap.put("f0", 'B');
    			   String line = br.readLine();
    			   while(line != null)
    			   {
    				  
    				  testmap.put(line,(char)(testmap.size() + 'A'));
    				  
    				  System.out.println(line);
    				  line = br.readLine();
    			   }
    			   br.close();
        		   fr.close();
        		 
    		   }catch(IOException e)
    		   {
    			   e.printStackTrace();
    		   }
    		 
    		  } catch (Exception e) {
    		   e.printStackTrace();
    		  }
    	  
	    } 
      
      after() : mainPoint()  //�������������������
      {
    	  try {
    	        Thread.sleep(5000);//���������5000����5000���룬Ҳ����5�룬���Ըó�����Ҫ��ʱ��
    	} catch (InterruptedException e) {
    	        e.printStackTrace();
    	}
    	
    	 
    	  
    	  try {
   		   File file = new File("���.txt");
   		   FileReader fr = new FileReader(file);
   		   BufferedReader br = new BufferedReader(fr);
   		   try {
   			   String line = br.readLine();
   			   int JGnumber = 0;
   			   while(line != null)
   			   {
   				 
   				  int a = Integer.parseInt(line);
   			 System.out.print(a);
   	    	
   	    	   jieguo[JGnumber++] = line;
   	    	   line = br.readLine();
   				  
   			   }
   			   br.close();
       		   fr.close();
       		 
   		   }catch(IOException e)
   		   {
   			   e.printStackTrace();
   		   }
   		 
   		  } catch (Exception e) {
   		   e.printStackTrace();
   		  }
    	  //������׾���д���ļ�
    	 try {
     		   File file = new File("����׾���.txt");
     	
               if(file.exists())
               {
            	   file.delete();
               }
        	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
     		   BufferedWriter bw = new BufferedWriter(fw);
               file.createNewFile();
               
     		   for(int i=1 ;i< rowflag;i++)
     		   {
     			   for(int j=0 ; j<number ;j++)
     			   {
     				 
    				  
     			  bw.write(String.valueOf(function[i][j]));
     			  bw.write(" ");
     			   }
     			  System.out.println();
     			  System.out.print(jieguo[i-1]);
     			 bw.write(String.valueOf(jieguo[i-1]));
     			  /* if(jieguo[i-1] == "1")
     			   {
     				   bw.write("1");
     			   }
     			   else {
     				   
     				  bw.write("0");
				       }*/
     			  
     			
          		/*  Scanner input = new Scanner(System.in);
          		  int a =  input.nextInt();
          		  input.close();
          		  bw.write(String.valueOf(a));*/
     			  bw.write("\n");
     			  
     		   }
     	
     		   bw.close();
     		   
     		  } catch (IOException e) 
    	      {
     		   e.printStackTrace();
     		  }
    	// FalseLocationContext Tar = new FalseLocationContext(new FLARStrategy());
 		 //List<NodeValue> Ans = Tar.FalseLocation(function);
 		  
 		
    	 
      }

      before():function(){	
    	  String s=thisJoinPoint.getSignature().getName().toString();
      	Signature signature = thisJoinPoint.getSignature();  
      	String name = thisJoinPoint.getSignature().getName();
      	String canshu = thisJoinPoint.getArgs().toString();  
      	System.out.println();
      	
    	if(s.equals("start"))
      	{
      		rowflag++;
      		System.out.print(rowflag);
      		System.out.println("-----------------------------");
      		
      	}
    	
    	 else if(!s.equals("main")){
    	for (int j = 0; j < i; j++) {
			System.out.print("\t");
		}
    	
		
		i++;
		stack.add(s);
		if (!stack.empty() && !s.equals("end")) 
		{
			
			
			int use = (int)(testmap.get(stack.peek())- 'A')-2;
			
			if(use >= 0)
			function[rowflag][use]++;
			
		
		}
		
		//����ֵ���Ƿ����  �����ڼ���
		boolean flag=testmap.containsKey(s);
		if(flag != true && !s.equals("start"))
		{
			testmap.put(s,(char)(testmap.size() + 'A'));
		}
		
		
		String A = new String();
		A = testmap.get(s).toString();
		
		System.out.print("->" + s + "__"+testmap.get(s)+";");
		
    	  }
  	}
      
      after():function()
      {
    	String s=thisJoinPoint.getSignature().getName().toString();
    	if(s.equals("start"))
    	{
    		
    	}
    	else {
    		i--;
          	stack.pop();
		}
      	
      
      }
}
