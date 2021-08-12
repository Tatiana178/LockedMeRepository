package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
	/**
	 * @param folderpath
	 * @return List<String
	 */
public static List<String> getAllFiles(String folderpath){

	//Creating file
	File fl= new File(folderpath);
	
	//Getting all files into FileArray
	File [] listOfFiles= fl.listFiles();
	
	//getting a list to store the name of files
	List<String> fileNames = new ArrayList<String>();

	for(File f: listOfFiles) {
		fileNames.add(f.getName());
	}
	return fileNames;
	
	
}
/**
 * This method will create or append content in a specific file
 * @param folderpath
 * @param fileName
 * @param content
 * @return
 */
	public static boolean createFiles(String folderpath, String fileName, List<String> content) {
		
		try {
			File fl = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(fl);
			
			for(String s: content)
			{
				fw.write(s);
			}
			fw.close();
			return true;
		}
		catch(Exception ex)
		{
		return false;	
		}
	}
		public static boolean deleteFile(String folderpath, String fileName) {
			File f =new File(folderpath+"//"+ fileName);
			
			try {
				if(f.delete()) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception ex)
			{
			return false;	
			}
		
	}
		public static boolean searchFile(String folderpath, String fileName) {
			File f =new File(folderpath+"//"+ fileName);
			
			try {
				if(f.exists()) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception ex)
			{
			return false;	
			}
		
	}
}
