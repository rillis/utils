package com.github.rillis.Internet;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HTMLUtils {
	public static String getHTML(String url) {
		String content = null;
		URLConnection connection = null;
		try {
		  connection =  new URL(url).openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  content = scanner.next();
		  scanner.close();
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		return content;
	}
	
	public static String URLEncode(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
    }
	
	public static String URLDecode(String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, StandardCharsets.UTF_8.toString());
    }
}
