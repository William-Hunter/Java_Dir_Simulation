package code;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Dir object=new Dir();
		while(!object.CMDline()){
		}
		object.ShowFileList();
		System.out.println("over");
	}
}
class Dir{
	String path = null;

	boolean CMDline(){
		Scanner in=new Scanner(System.in);
		System.out.print("输入你的路径：");
		if(!in.next().equals("dir")){
			System.out.println("命令不合法");
			return false;
		}
		path=in.nextLine();
		in.close();
		Scanner word=new Scanner(path);
		if(word.hasNext()){
			path=word.next();
		}
		word.close();
		return true;
	}
	boolean ShowFileList(){
		File files=new File(path);
		/////实现循环输出文件目录的第一种方法
		String[] filelist=files.list();
		for(int i=0;i<filelist.length;i++){
			System.out.println(filelist[i]);
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




