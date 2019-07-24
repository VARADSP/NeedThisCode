package com.uks.shubham.struts.day2.a1.bean;

public class UserDataBean {

	//Initilizing the variables
	String salutation=null;
	String FirstName =null;
	String MiddleName=null;
	String LastName =null;
	String Gender=null;
	String EmailId=null;
	String birth=null;
	String Address=null;
	String uname=null;
	String pass=null;
	String interest=null;
	String othintrest=null;
	String category=null;

	//list for interests
	String[] arrList;

	//Getter and Setter Methods
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getOthintrest() {
		return othintrest;
	}

	public void setOthintrest(String othintrest) {
		this.othintrest = othintrest;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String[] getArrList() {
		return arrList;
	}

	public void setArrList(String[] arrList) {
		this.arrList = arrList;
	}


}
