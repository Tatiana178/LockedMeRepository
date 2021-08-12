package com.lockedMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe {

	static final String folderpath = "C:\\Users\\tatia\\Desktop\\SimpleLearning\\MyPhase1Project\\LockedMe Files";

	public static void main(String[] args) {

		int proceed = 1;
		do {
			Scanner obj = new Scanner(System.in);

			int ch;
			displayMenu();

			System.out.println("Enter your choice:");
			ch = Integer.parseInt(obj.nextLine());

			switch (ch) {
			case 1:
				getAllFiles();
				break;

			case 2:
				createFiles();
				break;

			case 3:
				deleteFile();
				break;

			case 4:
				searchFile();
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option");
				break;
			}
		} while (proceed > 0);
	}

	public static void displayMenu() {

		System.out.println("*********************************************************");
		System.out.println("\t\tLockedMe.com");

		System.out.println("*********************************************************");
		System.out.println("1.Display all files");
		System.out.println("2.Add new file");
		System.out.println("3.Delete a file");
		System.out.println("4.Search a file");
		System.out.println("5.Exit");
		System.out.println("*********************************************************");

	}

	/**
	 * This method is used to get the names of all the files that are in directory.
	 */

	public static void getAllFiles() {
		List<String> fileNames = FileManager.getAllFiles(folderpath);
		if (fileNames.size() == 0) {
			System.out.println("No files in directory");
		} else {
			System.out.println("FILE LIST IS BELOW:");
			for (String f : fileNames) {
				System.out.println(f);
			}
		}
	}

	/**
	 * This method is used to create a file in directory
	 */
	public static void createFiles() {
		Scanner obj = new Scanner(System.in);
		String fileName;
		int lineCounts;
		List<String> content = new ArrayList<String>();

		System.out.println("Enter file name:");
		fileName = obj.nextLine();

		System.out.println("Enter how many lines in the file:");
		lineCounts = Integer.parseInt(obj.nextLine());

		for (int i = 1; i <= lineCounts; i++) {

			System.out.println("Enter line" + i + ":");
			content.add(obj.nextLine());
		}

		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		if (isSaved) {
			System.out.println("File and data saved sucessfully");

		} else {
			System.out.println("Some error accured. Please contact tatianamuja@outlook.com");

		}

	}

	/**
	 * This method is used to delete a file from directory
	 */
	public static void deleteFile() {

		String fileName;
		Scanner obj = new Scanner(System.in);

		System.out.println("Enter file name to be deleted");
		fileName = obj.nextLine();

		boolean isDeleted = FileManager.deleteFile(folderpath, fileName);

		if (isDeleted) {
			System.out.println("File deleted succesfully");

		} else {

			System.out.println("Either file not there or some access issues");
		}
	}

	/**
	 * This method is used to search if a file exist
	 */
	public static void searchFile() {

		String fileName;

		Scanner obj = new Scanner(System.in);

		System.out.println("Enter the file that you are searching");

		fileName = obj.nextLine();

		boolean isFound = FileManager.searchFile(folderpath, fileName);

		if (isFound) {
			System.out.println("File is present in the folder");
		} else

		{
			System.out.println("File is not present in the folder");
		}
	}
}
