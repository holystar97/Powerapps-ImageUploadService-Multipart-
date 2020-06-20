package com.net.main;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageUploadService {
	
	
	public boolean upload(MultipartFile file) {
		
		System.out.println(file.getOriginalFilename());
		String originalfileName = file.getOriginalFilename();
		String path = "C:/Users/mkrice/Desktop/testimg/" + originalfileName;
		
		File dest = new File(path);
		try {
			file.transferTo(dest);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
