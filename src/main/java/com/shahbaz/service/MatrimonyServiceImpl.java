package com.shahbaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahbaz.entity.MarriageSeekerInfo;
import com.shahbaz.repository.IMarriageSeekerInfoRepository;

@Service
public class MatrimonyServiceImpl implements IMatrimonyService{
	@Autowired
	private IMarriageSeekerInfoRepository repo;
	
	@Override
	public String registerProfile(MarriageSeekerInfo entity) {
		
		return "profile is registered with: "+repo.save(entity).getProfileId();
	}

	@Override
	public String saveProfile() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public String task456() {
		return "done completely";
	}
	
	public String task123() {
		return "complete task"; //incomplete

	}

}
