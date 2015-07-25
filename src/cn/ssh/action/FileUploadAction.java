package cn.ssh.action;


import java.io.File;

import org.apache.struts2.ServletActionContext;

import cn.ssh.util.UploadUtil;

import com.opensymphony.xwork2.ActionSupport;
public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private File loadFile;
	private String loadFileContentType;
	private String loadFileFileName;
	private String imageFileName;
	private String caption;


	
	@Override
	public String execute() {
		
		File dir=new File(ServletActionContext.getServletContext()
				.getRealPath("/UploadImages"));
		if(!dir.exists()) dir.mkdirs();
		
		String path=ServletActionContext.getServletContext()
				.getRealPath("/UploadImages");
		
		UploadUtil.upload(loadFileFileName,path,loadFile);
		System.out.println(loadFileFileName);
		System.out.println(imageFileName);
		return "success";
	}
	//=============================================
	public File getLoadFile() {
		return loadFile;
	}

	public void setLoadFile(File loadFile) {
		this.loadFile = loadFile;
	}

	public String getLoadFileContentType() {
		return loadFileContentType;
	}

	public void setLoadFileContentType(String loadFileContentType) {
		this.loadFileContentType = loadFileContentType;
	}

	public String getLoadFileFileName() {
		return loadFileFileName;
	}

	public void setLoadFileFileName(String loadFileFileName) {
		this.loadFileFileName = loadFileFileName;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}


}
