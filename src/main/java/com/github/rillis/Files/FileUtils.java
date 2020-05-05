package com.github.rillis.Files;

import java.io.File;
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
	
	
	public static String removeIllegalChars(String str) {
		return str.replaceAll("[^a-zA-Z0-9\\.\\-#$%@&]", "_");
	}
}
