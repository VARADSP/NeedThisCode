/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.util.List;
import java.util.Scanner;


/**
 * @author: 	Shubham Bujurge
 * Created Date:20/05/2019 02: 12 PM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class DisplayInfo extends Thread {

	//This display the records after user authentication is done, according to the user role
	public void dispRecord(String userId) {
		List<MergeInfo> mergeArray;
		Scanner objScanner;
		boolean parsable = true;
		int i;
		LogInAuthentication objLoginAuthentication = null;
		String userChoice;
		try {
			objLoginAuthentication = new LogInAuthentication();
			objScanner = new Scanner(System.in);
			//mergeArray = new ArrayList<MergeInfo>();
			/**
			 * get records to display/search from mergedArray collection of
			 * Loader class
			 */
			mergeArray = MergeInfo.mergedArray;

			if (mergeArray.size() != 0) {
				for (i = 0; i < mergeArray.size(); i++) {
					try {
						Long.parseLong(userId);
					} catch (NumberFormatException e) {
						System.out
								.println("Please enter valid data,string can't be converted to number");
						parsable = false;
						break;
					}
					if (parsable) {
						if ((mergeArray.get(i).getUserId()) == Long.parseLong(userId)) {
							// if Logged in user is employee than he can access
							// following steps
							if (mergeArray.get(i).getUserRole().toLowerCase()
									.equals("employee")) {
								dispPersonalData(mergeArray, i);
								System.out.println("Enter 'O' to Log Off, 'X' to Exit.");
								// userChoice = objScanner.nextLine();
								userChoice = objScanner.nextLine();
								switch (userChoice.toUpperCase()) {
								case "O":
									objLoginAuthentication = new LogInAuthentication();
									System.out
											.println("-------------successfully logged off--------------"
													+ "\n\n");
									objLoginAuthentication.userAuthentication();
									break;
								case "X":
									System.out
											.println("-------------successfully exited from the program--------------"
													+ "\n\n");
									break;
								}
							}/**
							 * if logged in user is manager than he can
							 * view/search details of employee
							 */
							else if (mergeArray.get(i).getUserRole()
									.toLowerCase().equals("manager")) {
								dispPersonalData(mergeArray, i);
								viewOrSearchDetails(mergeArray.get(i)
										.getUserRole(), mergeArray);

							}/**
							 * if logged in user is admin than he can
							 * view/search details of admin,manager or employee
							 */
							else if (mergeArray.get(i).getUserRole()
									.toLowerCase().equals("admin")) {
								dispPersonalData(mergeArray, i);
								viewOrSearchDetails(mergeArray.get(i)
										.getUserRole(), mergeArray);
							} else {
								System.out
										.println("Unknown employee role found.");
							}
							break;
						}
					}
				}
			} else {
				System.out.println("Data lost, try again.");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	//search the records according to the user i/p and other and merge the records
	private void viewOrSearchDetails(String userRole, List<MergeInfo> mergedArray) {
		String userChoice;
		Scanner objScanner;
		String continueProcess = "y";
		LogInAuthentication objLoginAuthentication = null;
		try {
			objScanner = new Scanner(System.in);
			do {
				System.out.println("Enter 'L' to Display List of Employees,"
						+ "\n     " + " 'S' to search Employee," + "\n     "
						+ " 'O' to Log Off," + "\n     " + " 'X' to Exit.");
				userChoice = objScanner.nextLine();

				// switch case to show main menu of process

				switch (userChoice.toUpperCase()) {
				case "L":
					if (userRole.toLowerCase().equals("manager")) {
						System.out.println("Enter 'B'- Back to Main Menu,"
								+ "\n     " + " 'E'- For Employee.");
						userChoice = objScanner.nextLine();
						// switch case to show sub menu of process
						switch (userChoice.toUpperCase()) {
						case "B":
							viewOrSearchDetails(userRole, mergedArray);
							break;
						case "E":
							listEmployee(userRole, mergedArray, 0);
							break;
						default:
							System.out.println("Invalid choice,try again.");
							break;
						}
					} else if (userRole.toLowerCase().equals("admin")) {
						System.out.println("Enter 'B'- Back to Main Menu,"
								+ "\n     " + " 'E'- For Employee," + "\n     "
								+ " 'M' - For Manager," + "\n     "
								+ " 'A' FOR Admin," + "\n     "
								+ " 'ALL' For All Employee");
						userChoice = objScanner.nextLine();
						// switch case to show sub menu of process
						switch (userChoice.toUpperCase()) {
						case "B":
							viewOrSearchDetails(userRole, mergedArray);
							break;
						case "E":
							listEmployee(userRole, mergedArray, 0);
							break;
						case "M":
							listEmployee(userRole, mergedArray, 1);
							break;
						case "A":
							listEmployee(userRole, mergedArray, 2);
							break;
						case "ALL":
							listEmployee(userRole, mergedArray, 3);
							break;
						default:
							System.out.println("Invalid choice,try again.");
							break;
						}
					}
					break;
				case "S":
					if (userRole.toLowerCase().equals("manager")) {
						System.out.println("Enter 'B'- Back to Main Menu,"
								+ "\n     " + " 'E'-Search Employee.");
						userChoice = objScanner.nextLine();
						// switch case to show sub menu of process
						switch (userChoice.toUpperCase()) {
						case "B":
							viewOrSearchDetails(userRole, mergedArray);
							break;
						case "E":
							searchRecord(userRole, mergedArray, 0);
							break;
						default:
							System.out.println("Invalid choice,try again.");
							break;
						}
					} else if (userRole.toLowerCase().equals("admin")) {
						System.out.println("Enter 'B'- Back to Main Menu,"
								+ "\n     " + " 'E'- For Employee," + "\n     "
								+ " 'M' - For Manager," + "\n     "
								+ " 'A' FOR Admin," + "\n     "
								+ " 'ALL' For All Employee");
						userChoice = objScanner.nextLine();
						// switch case to show sub menu of process
						switch (userChoice.toUpperCase()) {
						case "B":
							viewOrSearchDetails(userRole, mergedArray);
							break;
						case "E":
							searchRecord(userRole, mergedArray, 0);
							break;
						case "M":
							searchRecord(userRole, mergedArray, 1);
							break;
						case "A":
							searchRecord(userRole, mergedArray, 2);
							break;
						case "ALL":
							searchRecord(userRole, mergedArray, 3);
							break;
						default:
							System.out.println("Invalid choice,try again.");
							break;
						}
					}
					break;
				case "O":
					objLoginAuthentication = new LogInAuthentication();
					System.out
							.println("-------------successfully logged off--------------"
									+ "\n");
					objLoginAuthentication.userAuthentication();
					break;
				case "X":
					break;
				default:
					System.out.println("Invalid choice,try again.");
					break;
				}
				/**
				 * if user want to continue the process than he/she has to press
				 * y/Y, and user who has selected 'x' for main menu can not able
				 * to access this choice process
				 */
				if (!(userChoice.toUpperCase().equals("X"))
						&& !(userChoice.toUpperCase().equals("O"))) {
					System.out
							.println("Enter 'y/Y' to continue or else to exit from the program.");
					continueProcess = objScanner.nextLine();
				} else {
					continueProcess = "N";
				}
			} while (continueProcess.length() == 1
					&& continueProcess.toLowerCase().equals("y"));
			if (!(continueProcess.toLowerCase().equals("y"))
					&& !(userChoice.toUpperCase().equals("O"))) {
				System.out
						.println("-------------successfully exited from the program--------------"
								+ "\n");
			}
		} catch (Exception ex) {

		} finally {
			System.out.println();
		}
	}

	//Search the records according to the i/p and display the result in the form of tabale type not table
	@SuppressWarnings("resource")
	private void searchRecord(String userRole, List<MergeInfo> mergedArray,
			int empTypeChoice) {
		int i = 0, j = 0;
		String empTypeSearch = "", keyName = "", searchBy = "";
		Scanner objScanner;
		boolean isValid = false;
		try {
			// this will identify which type of data user want to search
			if (empTypeChoice == 0) {
				empTypeSearch = "employee";
			} else if (empTypeChoice == 1) {
				empTypeSearch = "manager";
			} else if (empTypeChoice == 2) {
				empTypeSearch = "admin";
			}
			do {
				objScanner = new Scanner(System.in);
				System.out.println("Enter 'name' to search by first name, "
						+ "\n  " + "and 'uid' to search by user id : ");
				searchBy = objScanner.nextLine();
				if (searchBy.toLowerCase().equals("name")
						|| searchBy.toLowerCase().equals("uid")) {
					isValid = true;
				} else {
					System.out.println("Enter valid search category");
					isValid = false;
				}
			} while (!isValid);

			System.out.println("Enter keyword to search records.");
			keyName = objScanner.nextLine();

			// search process for manager
			if (userRole.toLowerCase().equals("manager") && isValid) {
				if (mergedArray.size() != 0) {
//					printHeader();
					if (searchBy.toLowerCase().equals("name")) {
						for (i = 0; i < mergedArray.size(); i++) {
							if (mergedArray.get(i).getUName().toLowerCase()
									.contains(keyName.toLowerCase())
									&& mergedArray.get(i).getUserRole()
											.equals(empTypeSearch)) {
								if(j==0)
									printHeader();
								System.out
										.format("%15s%10s%23s%15s%15s%8s",
												mergedArray.get(i).getUName()
														+ "|", mergedArray
														.get(i).getUserRole()
														+ "|", mergedArray
														.get(i).getAddress()
														+ "|",
												mergedArray.get(i).getCity()
														+ "|", mergedArray
														.get(i).getTelNumber()
														+ "|", mergedArray
														.get(i).getSalary());
								System.out.println();
								j++;
							}
						}
					} else if (searchBy.toLowerCase().equals("uid")) {
						for (i = 0; i < mergedArray.size(); i++) {

							if ((Integer.toString(mergedArray.get(i)
									.getUserId())).toLowerCase().contains(
									keyName.toLowerCase())
									&& mergedArray.get(i).getUserRole()
											.equals(empTypeSearch)) {
								if(j==0)
									printHeader();
								System.out
										.format("%15s%10s%23s%15s%15s%8s",
												mergedArray.get(i).getUName()
														+ "|", mergedArray
														.get(i).getUserRole()
														+ "|", mergedArray
														.get(i).getAddress()
														+ "|",
												mergedArray.get(i).getCity()
														+ "|", mergedArray
														.get(i).getTelNumber()
														+ "|", mergedArray
														.get(i).getSalary());
								System.out.println();
								j++;
							}
						}
					}
				}
				if (j != 0)
					System.out
							.println("---------------------------------------------------------------------------------------");
				System.out.println(j + ": Records Found.");
				System.out.println("-------------------");
			}// search process from admin
			else if (userRole.toLowerCase().equals("admin") && isValid) {
				if (mergedArray.size() != 0) {
					//printHeader();
					/**
					 * if admin want to search data for all types user than this
					 * code will execute
					 */
					if (searchBy.toLowerCase().equals("name")) {
						if (empTypeChoice == 3) {
							for (i = 0; i < mergedArray.size(); i++) {
								if (mergedArray.get(i).getUName()
										.toLowerCase()
										.contains(keyName.toLowerCase())) {
									if(j==0)
										printHeader();
									System.out.format(
											"%15s%10s%23s%15s%15s%8s",
											mergedArray.get(i).getUName()
													+ "|", mergedArray.get(i)
													.getUserRole() + "|",
											mergedArray.get(i).getAddress()
													+ "|", mergedArray.get(i)
													.getCity() + "|",
											mergedArray.get(i).getTelNumber()
													+ "|", mergedArray.get(i)
													.getSalary());
									System.out.println();
									j++;
								}
							}
						}/**
						 * if admin want to search data for specific types of
						 * employee than
						 */
						else {
							for (i = 0; i < mergedArray.size(); i++) {
								if (mergedArray.get(i).getUName()
										.toLowerCase()
										.contains(keyName.toLowerCase())
										&& mergedArray.get(i).getUserRole()
												.equals(empTypeSearch)) {
									if(j==0)
										printHeader();
									System.out.format(
											"%15s%10s%23s%15s%15s%8s",
											mergedArray.get(i).getUName()
													+ "|", mergedArray.get(i)
													.getUserRole() + "|",
											mergedArray.get(i).getAddress()
													+ "|", mergedArray.get(i)
													.getCity() + "|",
											mergedArray.get(i).getTelNumber()
													+ "|", mergedArray.get(i)
													.getSalary());
									System.out.println();
									j++;
								}
							}
						}
					} else {
						if (empTypeChoice == 3) {
							for (i = 0; i < mergedArray.size(); i++) {
								if ((Integer.toString(mergedArray.get(i)
										.getUserId())).toLowerCase().contains(
										keyName.toLowerCase())) {
									if(j==0)
										printHeader();
									System.out.format(
											"%15s%10s%23s%15s%15s%8s",
											mergedArray.get(i).getUName()
													+ "|", mergedArray.get(i)
													.getUserRole() + "|",
											mergedArray.get(i).getAddress()
													+ "|", mergedArray.get(i)
													.getCity() + "|",
											mergedArray.get(i).getTelNumber()
													+ "|", mergedArray.get(i)
													.getSalary());
									System.out.println();
									j++;
								}
							}
						}/**
						 * if admin want to search data for specific types of
						 * employee than
						 */
						else {
							for (i = 0; i < mergedArray.size(); i++) {
								if ((Integer.toString(mergedArray.get(i)
										.getUserId())).toLowerCase().contains(
										keyName.toLowerCase())
										&& mergedArray.get(i).getUserRole()
												.equals(empTypeSearch)) {
									if(j==0)
										printHeader();
									System.out.format(
											"%15s%10s%23s%15s%15s%8s",
											mergedArray.get(i).getUName()
													+ "|", mergedArray.get(i)
													.getUserRole() + "|",
											mergedArray.get(i).getAddress()
													+ "|", mergedArray.get(i)
													.getCity() + "|",
											mergedArray.get(i).getTelNumber()
													+ "|", mergedArray.get(i)
													.getSalary());
									System.out.println();
									j++;
								}
							}
						}
					}
				}
				if (j != 0)
					System.out
							.println("---------------------------------------------------------------------------------------");
				System.out.println(j + ": Records Found.");
				System.out.println("-------------------");
			}
		} finally {
			System.out.println();
		}
	}

	//It will print the list employee according to the search and user role
	private void listEmployee(String userRole, List<MergeInfo> mergedArray,
			int empTypeChoice) {
		int i = 0, j = 0;
		String empTypeSearch = "";
		try {
			if (empTypeChoice == 0) {
				empTypeSearch = "employee";
			} else if (empTypeChoice == 1) {
				empTypeSearch = "manager";
			} else if (empTypeChoice == 2) {
				empTypeSearch = "admin";
			}
			if (userRole.toLowerCase().equals("manager")) {
				if (mergedArray.size() != 0) {
				//	printHeader();
					for (i = 0; i < mergedArray.size(); i++) {
						if (mergedArray.get(i).getUserRole()
								.equals(empTypeSearch)) {
							if(j==0)
								printHeader();
							System.out.format("%15s%10s%23s%15s%15s%8s",
									mergedArray.get(i).getUName() + "|",
									mergedArray.get(i).getUserRole() + "|",
									mergedArray.get(i).getAddress() + "|",
									mergedArray.get(i).getCity() + "|",
									mergedArray.get(i).getTelNumber() + "|",
									mergedArray.get(i).getSalary());
							System.out.println();
							j++;
						}
					}

				}
				System.out
						.println("---------------------------------------------------------------------------------------");
				System.out.println(j + ": Records Found.");
				System.out.println("-------------------");
			} else if (userRole.toLowerCase().equals("admin")) {
				if (mergedArray.size() != 0) {
					if (empTypeChoice == 3) {
//						printHeader();
						for (i = 0; i < mergedArray.size(); i++) {
							if(j==0)
								printHeader();
							System.out.format("%15s%10s%23s%15s%15s%8s",
									mergedArray.get(i).getUName() + "|",
									mergedArray.get(i).getUserRole() + "|",
									mergedArray.get(i).getAddress() + "|",
									mergedArray.get(i).getCity() + "|",
									mergedArray.get(i).getTelNumber() + "|",
									mergedArray.get(i).getSalary());
							System.out.println();
							j++;
						}
					} else {
//						printHeader();
						for (i = 0; i < mergedArray.size(); i++) {
							if (mergedArray.get(i).getUserRole()
									.equals(empTypeSearch)) {
								if(j==0)
									printHeader();
								System.out
										.format("%15s%10s%23s%15s%15s%8s",
												mergedArray.get(i).getUName()
														+ "|", mergedArray
														.get(i).getUserRole()
														+ "|", mergedArray
														.get(i).getAddress()
														+ "|",
												mergedArray.get(i).getCity()
														+ "|", mergedArray
														.get(i).getTelNumber()
														+ "|", mergedArray
														.get(i).getSalary());
								System.out.println();
								j++;
							}
						}
					}
				}
				System.out
						.println("---------------------------------------------------------------------------------------");
				System.out.println(j + ": Records Found.");
				System.out.println("-------------------");
			}
		} finally {
			System.out.println();
		}
	}


	//print the header of the table type
	private void printHeader() {
		System.out
				.println("---------------------------------------------------------------------------------------");
		System.out.format("%14s%10s%23s%15s%15s%8s", "EMP NAME", "USER ROLE",
				"ADDRESS", "CITY", "TEL. NO.", "SALARY");
		System.out.println("");
		System.out.println("---------------------------------------------------------------------------------------");
	}

	//display the employee data
	private void dispPersonalData(List<MergeInfo> mergedArray, int i) {
		System.out.println("---------------------------");
		System.out.println("Name : " + mergedArray.get(i).getUName());
		System.out.println("Role : " + mergedArray.get(i).getUserRole());
		System.out.println("Address : " + mergedArray.get(i).getAddress());
		System.out.println("City : " + mergedArray.get(i).getCity());
		System.out.println("Telephone : " + mergedArray.get(i).getTelNumber());
		System.out.println("Salary : " + mergedArray.get(i).getSalary());
		System.out.println("---------------------------");
	}
}
