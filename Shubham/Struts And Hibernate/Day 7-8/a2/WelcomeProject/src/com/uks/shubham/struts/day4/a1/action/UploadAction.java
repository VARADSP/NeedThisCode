package com.uks.shubham.struts.day4.a1.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day4.a1.logic.CommonLogic;

public class UploadAction extends ActionSupport{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	public boolean status = false;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;


	CommonLogic objLogic =new CommonLogic();
	// Execution starts from here
	public String execute() {
		File saveFilePath = new File(Constants.filePath + fileUploadFileName);
		try {
			if (fileUploadFileName.length() > 0) {
				objLogic.uploadFile(fileUpload, saveFilePath );
				//FileUtils.copyFile(fileUpload, saveFilePath);
				addActionMessage("Upload successfully completed");
				clearActionErrors();
				return SUCCESS;
			} else {
				addActionError("file not uploaded something went wrong");
				return ERROR;
			}
		} catch (Exception ex) {
			addActionError("Please image select file first");
			addActionError("If you select file then something went to be wrong and file not uploaded");
			System.out.println("Couldn't save file: " + ex.getMessage());
			return ERROR;
		}
	}

	//Getter and Setter methods
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}



}
