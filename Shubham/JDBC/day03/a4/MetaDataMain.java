/**
 *
 */
package com.uks.shubham.day03.a4;

/**
 * @author		: 	Shubham Bujurge
 * Created Date :	13/06/2019 11:17 AM
 * Assignment	:  	Day 3
 * Task			:  	MetaData RowSet
 *
 */
public class MetaDataMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MetaData objMetaData=new MetaData();
		try {
			objMetaData.connect();
			objMetaData.dataMetadate();
			objMetaData.closeCon();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
