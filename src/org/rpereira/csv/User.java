package org.rpereira.csv;

import java.util.HashMap;

/** represent a user entry into the database */
public class User {

	private HashMap<Integer, Data> datas;
	private String name;
	private String domaine;

	public User(String name, String domaine) {
		this.datas = new HashMap<Integer, Data>();
		this.name = name;
		this.domaine = domaine;
	}

	public void addData(Integer date, Data data) {
		this.datas.put(date, data);
	}

	public Data getData(Integer date) {
		return (this.datas.get(date));
	}

	public String getName() {
		return (this.name);
	}

	public String getDomaine() {
		return (this.domaine);
	}

	public float getQuotaDepasserMoyenne() {
		float total = 0.0f;
		for (Data data : this.datas.values()) {
			total += data.getQuotaDepasser();
		}
		return (total / this.datas.size());
	}
}
