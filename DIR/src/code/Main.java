package code;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Dir object=new Dir();
		while(!object.CMDline()){		//输入功能，如果输入非法，就循环执行
		}
		object.ShowFileList();				//显示制定路径的文件目录
		System.out.println("执行完毕");				
	}
}
class Dir{
	String path = null;		//存储文件路径的变量

	boolean CMDline(){
		Scanner in=new Scanner(System.in);
		System.out.print("输入路径：");
		if(!in.next().equals("dir")){		//判断用户输入的第一个字段是不是dir
			System.out.println("命令不合法");
			return false;
		}
		path=in.nextLine();
		in.close();
		Scanner word=new Scanner(path);
		if(word.hasNext()){
			path=word.next();			//获取dir 命令后面的路径名
		}
		word.close();
		return true;
	}
	boolean ShowFileList(){
		File files=new File(path);
		/////实现循环输出文件目录的第一种方法
		String[] filelist=files.list();				//获取路径文件目录存入一个String 数组
		for(int i=0;i<filelist.length;i++){
			System.out.println(filelist[i]);			//循环打印这个数组里的内容
		}
		/*
		/////第二种
		for(String file:files.list()){
			System.out.println(file);
		}
		*/
		return true;
	}
}




