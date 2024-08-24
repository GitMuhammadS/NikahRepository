package com.shahbaz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="BOOT_MARRIAGE_SEEKER_INFO")
public class MarriageSeekerInfo {
		
		@Id
		@GeneratedValue
		private Integer profileId;
		@Column(length=20)
		private String profileName;
		@Column(length=20)
		private String gender;
		@Column(length=150)
		private String resumePath;
		@Column(length=150)
		private String photoPath;
		
		@Column
		private String golgappe;
}
