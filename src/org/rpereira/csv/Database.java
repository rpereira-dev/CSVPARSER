package org.rpereira.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/** represent the database of every users and their data */
public class Database {

	private static final String FILEPATH = "C:/Users/Romain/workspace/CSVParser/";
	private static final String FILE_HEADER = "fileheader";

	private HashMap<String, User> users;

	public Database() {
		this.users = new HashMap<String, User>();
	}

	public User getUser(String name) {
		return (this.users.get(name.toLowerCase()));
	}

	public void addUser(User user) {
		this.users.put(user.getName().toLowerCase(), user);
	}

	public boolean isUserRegistered(String name) {
		return (this.getUser(name) != null);
	}

	public void loadCSV(Integer date) throws IOException {
		String filepath = FILEPATH + FILE_HEADER + date + ".csv";
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line;
		while ((line = reader.readLine()) != null) {
			String entry[] = line.split(";");
			User user = this.getUser(entry[2]);
			if (user == null) {
				user = new User(entry[2], entry[3]);
				this.addUser(user);
			}
			Data data = new Data(Integer.parseInt(entry[0]), Float.parseFloat(entry[1]));
			user.addData(date, data);
		}
		reader.close();
	}

	public void clear() {
		this.users.clear();
	}
}
