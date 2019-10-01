package com.mellisphera.entities.bm;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmSensor implements Serializable{

	@JsonProperty("device")
	private BmDevice device;
	@JsonProperty("hivePositionId")
	private String hivePositionId;
	@JsonProperty("start")
	private int start;

	public BmSensor(BmDevice device, String hivePositionId, int start) {
		this.device = device;
		this.hivePositionId = hivePositionId;
		this.start = start;
	}

	public BmSensor(){}
	public BmDevice getDevice() {
		return device;
	}

	public void setDevice(BmDevice device) {
		this.device = device;
	}

	public String getHivePositionId() {
		return hivePositionId;
	}

	public void setHivePositionId(String hivePositionId) {
		this.hivePositionId = hivePositionId;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}



	public class BmDevice implements Serializable {
		@JsonProperty("deviceId")
		private String deviceId;
		@JsonProperty("createDate")
		private int createDate;
		@JsonProperty("dataLastReceived")
		private int dataLastReceived;
		@JsonProperty("name")
		private String name;
		@JsonProperty("deviceAddress")
		private String deviceAddress;
		@JsonProperty("model")
		private String model;

		public BmDevice() {}
		public String getDeviceId() {
			return deviceId;
		}

		public String getDeviceAddress() {
			return deviceAddress;
		}

		public void setDeviceAddress(String deviceAddress) {
			this.deviceAddress = deviceAddress;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		public int getCreateDate() {
			return createDate;
		}

		public void setCreateDate(int createDate) {
			this.createDate = createDate;
		}

		public int getDataLastReceived() {
			return dataLastReceived;
		}

		public void setDataLastReceived(int dataLastReceived) {
			this.dataLastReceived = dataLastReceived;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}
	}


}
