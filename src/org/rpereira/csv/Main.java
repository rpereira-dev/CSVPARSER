package org.rpereira.csv;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Database database = new Database();
		
		database.loadCSV(20160930);
		database.loadCSV(20161030);
		database.loadCSV(20161130);
		database.clear();
		
		User user = database.getUser("Anthony PEREIRA");
		System.out.println(user.getName() + " " + user.getQuotaDepasserMoyenne());
	}
}
