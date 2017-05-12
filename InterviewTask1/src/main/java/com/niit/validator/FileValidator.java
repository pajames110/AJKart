package com.niit.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.niit.model.UploadedFile;

@Repository("fileValidator")
public class FileValidator implements Validator {
	
	
	
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object uploadedFile, Errors errors) {
		UploadedFile file = (UploadedFile) uploadedFile;  
		  
		  if (file.getFile().getSize() == 0) {  
		   errors.rejectValue("file", "uploadForm.selectFile",  
		     "Please select a file!");  
		  }  		
	}

}
