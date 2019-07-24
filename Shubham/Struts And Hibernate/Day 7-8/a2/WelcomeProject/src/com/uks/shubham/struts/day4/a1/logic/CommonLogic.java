package com.uks.shubham.struts.day4.a1.logic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CommonLogic {

	public void uploadFile(File fileUpload,File saveFilePath) throws IOException{

		FileUtils.copyFile(fileUpload, saveFilePath);
	}
}
