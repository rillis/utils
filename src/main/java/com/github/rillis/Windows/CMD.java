package com.github.rillis.Windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CMD {
	public static Process dispachCommand(String cmd, boolean waitFor) throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec("cmd /c " + cmd);
		if(waitFor) {
			p.waitFor();
		}
		return p;
	}
	
	public static String getResponse(Process process) throws IOException {
		InputStream is = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		String response = "";
		String line = null;
		while ((line = reader.readLine()) != null) {
			if(response.equals("")) {
				response+=line;
			}else {
				response+="\n"+line;
			}
		}
		
		return response;
	}
}
