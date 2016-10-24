package org.rpereira.csv;

/** represent a data entry of a user */
public class Data {

	private int quota;
	private float quota_depasser;

	public Data(int quota, float quota_depasser) {
		this.quota = quota;
		this.quota_depasser = quota_depasser;
	}

	public int getQuota() {
		return (this.quota);
	}

	public float getQuotaDepasser() {
		return (this.quota_depasser);
	}

}
