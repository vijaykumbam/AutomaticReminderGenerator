package com.capgemini.ticket.reminder.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderFromExcelFile {

	private static String fileName = "C:\\Users\\vkumbam\\Downloads\\Tickets_to_be_resolved.xlsx";
	//private static String fileLocation = "https:\\capgemini.sharepoint.com\:x:\r\sites\APACAIAVitality\_layouts\15\Doc.aspx?sourcedoc=%7B439944AF-8AAC-4EF2-9269-A46C0AC8AA6E%7D&file=Incident%20Tracker_2022.xlsx&action=default&mobileredirect=true";
	//https://capgemini.sharepoint.com/:x:/r/sites/APACAIAVitality/_layouts/15/Doc.aspx?sourcedoc=%7B439944AF-8AAC-4EF2-9269-A46C0AC8AA6E%7D&file=Incident%20Tracker_2022.xlsx&action=default&mobileredirect=true
	private static String sheet_to_be__read = "Sheet1";
	private static String current_system_Date = "03-oct-2022";

	static DataWriterFromExcelToCSVFile dataWriterFromExcelToCSVFile = new DataWriterFromExcelToCSVFile();

	public void xlsx_fileAutomation(String fileName, String sheet_to_be__read) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(fileName));
			XSSFSheet sheet = workbook.getSheet(sheet_to_be__read);
			int rowcount = 1;

			while (sheet.getRow(rowcount) != null) {
				XSSFRow row = sheet.getRow(rowcount);
				String incidentNumber = row.getCell(0).toString();
				String first_Reminder_Date = row.getCell(1).toString();
				Date firstReminderDate = dateFormatter(first_Reminder_Date);
				

				String second_Reminder_Date = row.getCell(2).toString();
				Date secondReminderDate = dateFormatter(second_Reminder_Date);
				

				String ticket_To_Be_Resolve_Date = row.getCell(3).toString();
				Date ticketToBeResolveDate = dateFormatter(ticket_To_Be_Resolve_Date);
			

				String resource_Name = row.getCell(6).toString();

				// Returns the day of the week represented by this date.
				// Returned value (0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4
				// =Thursday, 5 = Friday, 6 = Saturday)
				Date current_system_DateDay = dateFormatter(current_system_Date);
				int currentSystemDay = current_system_DateDay.getDay();
				if ((currentSystemDay != 6) && (currentSystemDay != 0)) {
					// Reminder ignore sunday and saturday
					if (firstReminderDate.equals(dateFormatter(current_system_Date))) {
						//System.out.println("First reminder Condition" + incidentNumber);
						String strMsg = " First Reminder should be sent on " + firstReminderDate;
						dataWriterFromExcelToCSVFile.addIntoList(incidentNumber, resource_Name, strMsg,firstReminderDate,null ,null);
					}
					else if(secondReminderDate.equals(dateFormatter(current_system_Date))) {
							//System.out.println("Second reminder Condition" + incidentNumber);
							String strMsg = " Second Reminder should be sent on " + secondReminderDate;
							dataWriterFromExcelToCSVFile.addIntoList(incidentNumber, resource_Name, strMsg,null,secondReminderDate,null);

						}
					else if (ticketToBeResolveDate.equals(dateFormatter(current_system_Date))) {
						//System.out.println("Ticket to be resolve Condition" + incidentNumber);
						String strMsg = " Ticket to be resolve on " + ticketToBeResolveDate;
						dataWriterFromExcelToCSVFile.addIntoList(incidentNumber, resource_Name, strMsg,null,null,ticketToBeResolveDate);
					}
					else {
						//System.out.println("No Work Happy day! :)");
					}
				}
				else {
					System.out.println("We cannot sent reminders on Sunday and Saturday !");
				}
				rowcount++;
			}

		} catch (FileNotFoundException e) {
			System.out.println(
					"System unable to find the file location in given path, Please check the path and name of the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Issue occured while reading the data from file ");
			e.printStackTrace();
		}
	}

	public static Date dateFormatter(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String dateInString = strDate;
		Date date;
		try {
			date = formatter.parse(dateInString);
			//System.out.println(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		DataReaderFromExcelFile dataReaderFromExcelFile = new DataReaderFromExcelFile();
		dataReaderFromExcelFile.xlsx_fileAutomation(fileName, sheet_to_be__read);
		dataWriterFromExcelToCSVFile.writeIntoList();
	}

}
