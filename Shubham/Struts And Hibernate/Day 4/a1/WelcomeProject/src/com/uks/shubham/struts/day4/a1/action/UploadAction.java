package com.uks.shubham.struts.day4.a1.action;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.common.util.CommonLogic;

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

	private File saveFilePath;
	CommonLogic objLogic =new CommonLogic();
	// Execution starts from here
	public String execute() {

    	//Start
		try {
			if (fileUploadFileName.length() > 0) {

				//change the path according to the use
				saveFilePath = new File("D:/Assignment/Struts 2 and Hibernate/Day 4/a2/WelcomeProject/WebContent/images/" + fileUploadFileName);


				File f = new File(saveFilePath.toString());
				System.out.println(saveFilePath.length());
				double fileSize = f.length() / 1024 ;

				if(fileSize < 20000){

				//Checking uploaded file is images type or not
		        String mimetype= new MimetypesFileTypeMap().getContentType(f);
		        String type = mimetype.split("/")[0];
		        if(type.equals("image")){
		            System.out.println("It's an image");
		            //passing file object and full path
					objLogic.uploadFile(fileUpload, saveFilePath );
					//FileUtils.copyFile(fileUpload, saveFilePath);
					clearActionErrors();
					addActionMessage("Upload successfully completed");
					return SUCCESS;
		        }
		        else{
		        	addActionError("Uploaded file is not image file, please upload only image files");
		        	return ERROR;
		        }
				}
				else{
					addActionError("Your image size extends the limit of 20mb");
					return ERROR;
				}
			} else {
				addActionError("Please select image file first then try to upload");
				return ERROR;
			}
		} catch (Exception ex) {
			addActionError("Please image select file first");
			addActionError("If you select file then something went to be wrong and file not uploaded");
			//System.out.println("Couldn't save file: " + ex.getMessage());
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

	public File getSaveFilePath() {
		return saveFilePath;
	}

	public void setSaveFilePath(File saveFilePath) {
		this.saveFilePath = saveFilePath;
	}


}
