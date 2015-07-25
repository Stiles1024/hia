package cn.ssh.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

public class UploadUtil {
	private static final int BUFFER_SIZE = 16 * 1024;
	public static void upload(String loadFileFileName, String path,	File loadFile) {
		// TODO Auto-generated method stub
		File imageFile = new File(path+File.separator+loadFileFileName);
		copy(loadFile, imageFile);

	}

	private static void copy(File src, File dst) {
		
		// TODO Auto-generated method stub
		
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
