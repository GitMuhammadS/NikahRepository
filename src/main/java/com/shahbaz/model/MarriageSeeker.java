package com.shahbaz.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MarriageSeeker {
	private String profileName;
	private String gender;
	private MultipartFile resume;
	private MultipartFile photo;
}
