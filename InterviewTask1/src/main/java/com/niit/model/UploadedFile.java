package com.niit.model;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class UploadedFile {
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
