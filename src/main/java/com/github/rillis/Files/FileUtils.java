package com.github.rillis.Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
	public static File create(File file) throws IOException {
		if(file.exists()) {
			return file;
		}
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if(file.isDirectory()) {
			file.mkdir();
		}else {
			file.createNewFile();
		}
		
		return file;
	}
	
	public static void create(File[] file) throws IOException {
		for(File f : file) {
			create(f);
		}
	}
	
	public static void delete(File file) {
		if(file.isDirectory()) {
			File[] contents = file.listFiles();
		    if (contents != null) {
		        for (File f : contents) {
		            deleteDir(f);
		        }
		    }
		}
		file.delete();
	}
	
	public static void delete(File[] file) {
		for(File f : file) {
			delete(f);
		}
	}
	
	public static File rename(File file, String name) {
		file.renameTo(new File(file.getParent()+"\\"+name));
		return file;
	}
	
	public static void copy(File file, File destFile) throws IOException {
		Files.copy(file.toPath(), destFile.toPath());
	}
	
	public static File move(File file, File destFile) throws IOException {
		Files.move(file.toPath(), destFile.toPath());
		return destFile;
	}
	
	private static void deleteDir(File file) {
	    File[] contents = file.listFiles();
	    if (contents != null) {
	        for (File f : contents) {
	            if (! Files.isSymbolicLink(f.toPath())) {
	                deleteDir(f);
	            }
	        }
	    }
	    file.delete();
	}
	
	
	public static void write(File file, String str) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
	    writer.write(str);
	    writer.close();
	}
	
	public static void writeAppend(File file, String str, boolean newLine) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		if(newLine) {
			if(file.length()>0) {
				str="\n"+str;
			}
		}
	    writer.append(str);
	    writer.close();
	}
	
	public static String read(File file) throws FileNotFoundException, IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(file));

		    String everything = "";
		    String line = br.readLine();

		    while (line != null) {
		        if(!everything.equals("")) {
		        	everything+="\n";
		        }
		        everything+=line;
		        line = br.readLine();
		    }
		
		    br.close();

		
		return everything;		
	}
	
	public static String removeIllegalChars(String str) {
		return str.replaceAll("[^a-zA-Z0-9\\.\\-#$%@&]", "_");
	}
}
