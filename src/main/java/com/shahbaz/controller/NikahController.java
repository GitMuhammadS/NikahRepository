package com.shahbaz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.shahbaz.entity.MarriageSeekerInfo;
import com.shahbaz.model.MarriageSeeker;
import com.shahbaz.service.IMatrimonyService;

@Controller
public class NikahController {
	@Autowired
	private IMatrimonyService service;
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showProfileFormPage(@ModelAttribute("profile") MarriageSeeker seeker) {
		return "marriage_seeker_register";
	}
	
	@PostMapping("/register")
	public String performFileUpload(@ModelAttribute("profile") MarriageSeeker seeker,Map<String,Object> map) throws Exception{
		//get folder location to store uploaded file
		String location=env.getProperty("upload.store");
		System.out.println(location);
		File locationStore=new File(location);
		
		//create location folder if it is not already available
		if(!locationStore.exists())
			locationStore.mkdir();
		
		//get the orignal name of the uploading file
		MultipartFile resumeFile=seeker.getResume();
		MultipartFile photoFile=seeker.getPhoto();
		String resumeFileName=resumeFile.getOriginalFilename();
		String photoFileName=photoFile.getOriginalFilename();
		System.out.println("ResumeFileName: "+resumeFileName+" photoFileName: "+photoFileName);
		
		//create the input stream representing the upload file
		InputStream resumeIStream=resumeFile.getInputStream();
		InputStream photoIStream=photoFile.getInputStream();
		
		//creating output stream pointing to destination file on the server machine file system
		OutputStream resumeOStream=new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photoOStream=new FileOutputStream(location+"/"+photoFileName);
		
		//close stream
		resumeIStream.close();
		photoIStream.close();
		resumeOStream.close();
		photoOStream.close();
		
		//create Entity class obejct
		MarriageSeekerInfo info=new MarriageSeekerInfo();
		info.setProfileName(seeker.getProfileName());
		info.setGender(seeker.getGender());
		info.setResumePath(location+"/"+resumeFileName);
		info.setPhotoPath(location+"/"+photoFileName);
		
		//use service
		String msg=service.registerProfile(info);
		//create model attributes
		map.put("resumeFile", resumeFileName);
		map.put("photoFile", photoFileName);
		map.put("resultMsg", msg);
		
		return "marriage_seeker_register";
		
	}
	
	public static void t1() {
		System.out.println("Dead POOl");
	}
}
