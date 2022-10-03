package com.capgemini.ticket.reminder.automation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.ticket.reminder.automation.model.DataOutputModel;

public class DataWriterFromExcelToCSVFile {

	private static String csv_file = "C:\\Users\\vkumbam\\Downloads\\ReminderFile.csv";
	List<DataOutputModel> list = new ArrayList<>();

	public void addIntoList(String incidentNumber, String resource_Name, String comments, Date firstReminderDate,
			Date secondReminderDate, Date ticketToBeResolveDate) {
		DataOutputModel obj = new DataOutputModel();
		obj.setResource_Name(resource_Name);
		obj.setIncident_Number(incidentNumber);
		obj.setFirst_Reminder_Date(firstReminderDate);
		obj.setSecond_Reminder_Date(secondReminderDate);
		obj.setTicket_To_Be_Resolve_Date(ticketToBeResolveDate);
		obj.setComments(comments);
		list.add(obj);
	}

	public void writeIntoList() {
		try {
			FileWriter fileWriter = new FileWriter(csv_file);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			for(DataOutputModel obj :list) {
				bufferWriter.write( obj.getIncident_Number() +", "+obj.getResource_Name()+" , "+obj.getFirst_Reminder_Date()+" , "+
									obj.getSecond_Reminder_Date()+" , "+ obj.getTicket_To_Be_Resolve_Date()+" , "+obj.getComments());
				bufferWriter.flush();
				bufferWriter.newLine();
			}
			bufferWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
