package com.github.rillis.Windows;

import java.io.File;

public class WinVars {
	public static String APPDATA = System.getenv("APPDATA");
	public static String APPDATA_LOCAL = new File(System.getenv("APPDATA")).getParent()+"\\Local";
	public static String CMD = System.getenv("COMSPEC");
	public static String SYSTEM_DRIVE = System.getenv("SystemDrive");
	public static String PROGRAM_FILES = System.getenv("PROGRAMFILES");
	public static String PROGRAM_FILES_X86 = System.getenv("PROGRAMFILES(X86)");
	public static String WINDIR = System.getenv("WINDIR");
	public static String TEMP = System.getenv("TEMP");
}
