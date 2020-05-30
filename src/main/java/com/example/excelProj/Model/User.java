package com.example.excelProj.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
	private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private Boolean active;

    @Column
	private Boolean profileActive;
    
    @Column
    private String userType;

	@JsonBackReference
	@OneToOne(mappedBy = "user")
	private CandidateProfile candidateProfile;

	@OneToOne(mappedBy = "user")
	private CompanyProfile companyProfile;

	@OneToOne(mappedBy = "user")
	private RecruiterProfile recruiterProfile;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<RecruiterJobs> recruiterJobs;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<AppliedForRecruiterJob> appliedForRecruiterJobs;


	@JsonIgnore
	@OneToMany(mappedBy="user")
	List<Job> jobList;


	public User() {
	}

	public User(String email, String name, String password, Boolean active, Boolean profileActive, String userType, CandidateProfile candidateProfile, CompanyProfile companyProfile, RecruiterProfile recruiterProfile, List<RecruiterJobs> recruiterJobs, Set<AppliedForRecruiterJob> appliedForRecruiterJobs, List<Job> jobList) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
		this.profileActive = profileActive;
		this.userType = userType;
		this.candidateProfile = candidateProfile;
		this.companyProfile = companyProfile;
		this.recruiterProfile = recruiterProfile;
		this.recruiterJobs = recruiterJobs;
		this.appliedForRecruiterJobs = appliedForRecruiterJobs;
		this.jobList = jobList;
	}

	public List<RecruiterJobs> getRecruiterJobs() {
		return recruiterJobs;
	}

	public void setRecruiterJobs(List<RecruiterJobs> recruiterJobs) {
		this.recruiterJobs = recruiterJobs;
	}

	public Set<AppliedForRecruiterJob> getAppliedForRecruiterJobs() {
		return appliedForRecruiterJobs;
	}

	public void setAppliedForRecruiterJobs(Set<AppliedForRecruiterJob> appliedForRecruiterJobs) {
		this.appliedForRecruiterJobs = appliedForRecruiterJobs;
	}

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getProfileActive() {
		return profileActive;
	}

	public void setProfileActive(Boolean profileActive) {
		this.profileActive = profileActive;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public CandidateProfile getCandidateProfile() {
		return candidateProfile;
	}

	public void setCandidateProfile(CandidateProfile candidateProfile) {
		this.candidateProfile = candidateProfile;
	}

	public CompanyProfile getCompanyProfile() {
		return companyProfile;
	}

	public void setCompanyProfile(CompanyProfile companyProfile) {
		this.companyProfile = companyProfile;
	}

	public RecruiterProfile getRecruiterProfile() {
		return recruiterProfile;
	}

	public void setRecruiterProfile(RecruiterProfile recruiterProfile) {
		this.recruiterProfile = recruiterProfile;
	}
}
