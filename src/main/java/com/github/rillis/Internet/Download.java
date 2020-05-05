package com.github.rillis.Internet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {
	public static File download(String url, File destFile) throws MalformedURLException, IOException {
		if(destFile.isDirectory()) {
			throw new IllegalArgumentException();
		}
		URL urlR = new URL(url);

        InputStream is = urlR.openStream();
        FileOutputStream fos = new FileOutputStream(destFile);

        int bytes = 0;

        while ((bytes = is.read()) != -1) {
            fos.write(bytes);
        }

        is.close();

        fos.close();	
        
        
		return destFile;
	}
}
