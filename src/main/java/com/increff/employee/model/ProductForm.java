package com.increff.employee.model;

public class ProductForm {

	private String barcode;
	private String brand_category;
	private String name;
	private double mrp;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBrand_category() {
		return brand_category;
	}

	public void setBrand_category(String brand_category) {
		this.brand_category = brand_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
}
