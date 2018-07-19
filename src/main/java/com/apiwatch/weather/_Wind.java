package com.apiwatch.weather;

public class _Wind {

	public float speed;
	public float deg;
	
	
	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", deg=" + deg + "]";
	}
	public float getSpeed() {
		return speed;
	}
	public _Wind() {
		super();
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDeg() {
		return deg;
	}
	public void setDeg(float deg) {
		this.deg = deg;
	}
	
	
}
