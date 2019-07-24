/**
 *
 */
package com.uks.shubham.struts.common.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Shubham
 *
 */
public class CommonLogic {
	public void uploadFile(File fileUpload,File saveFilePath) throws IOException{

		FileUtils.copyFile(fileUpload, saveFilePath);
	}
}
