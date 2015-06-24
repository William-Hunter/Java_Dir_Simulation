/**
 * @author william Lone
 * 	2015/6/24		zhengzhou.china
 * 
 * Dir类的属性及方法：
 * 			path  用以储存用户输入的文件路径
 * 			GetPath()			返回文件路径
 * 			CMDline()        检查用户输入的路径名，并且将其存入path变量
 * 			ShowFileList()	显示当前路径的所有文件夹和文件	
 * */
package code;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Dir object=new Dir();
		while( !object.CMDline()) {		//输入功能，如果输入非法，就循环执行
		}
		object.ShowFileList(object.GetPath(),0);				//显示指定路径的文件目录
		System.out.println("执行完毕");				
	}
}
class Dir{
	String path = null;						//存储文件路径的变量
	String GetPath(){    					//返回当前路径的方法
		return this.path;
	}
	boolean CMDline(){				//确保路径可用的方法
		Scanner in=new Scanner(System.in);
		System.out.print("输入路径：");
		if(!in.next().equals("dir")){		//判断用户输入的第一个字段是不是dir
			System.out.println("命令不合法");
			return false;
		}
		this.path=in.nextLine();
		in.close();
		Scanner word=new Scanner(this.path);
		if(word.hasNext()){
			this.path=word.next();			//获取dir 命令后面的路径名
		}
		word.close();
		return true;
	}
	void ShowFileList(String path,int tab){			
		File files=new File(path);
		if(files.isDirectory()){
			String[] List=files.list();
			for(int i=0;i<List.length;i++){
				for(int j=0;j<tab;j++){
					System.out.print("\t");
				}
				System.out.println(List[i]);
				ShowFileList((path+"\\"+List[i]),tab+1);		//将这个路径名与下级文件夹名一起组合传入递归调用的参数
			}
		}else{
			return ;
		}
	}
}




