package com.aj.james.backendproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="SUPPLIER")
@Component
public class Supplier {

	@Id
	private String supplier_id;
	private String supplier_name;
	private String supplier_description;
	private String supplier_address;
	private String supplier_contact_number;
	
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_description() {
		return supplier_description;
	}
	public void setSupplier_description(String supplier_description) {
		this.supplier_description = supplier_description;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public String getSupplier_contact_number() {
		return supplier_contact_number;
	}
	public void setSupplier_contact_number(String supplier_contact_number) {
		this.supplier_contact_number = supplier_contact_number;
	}
	
}
