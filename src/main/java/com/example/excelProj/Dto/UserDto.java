package com.example.excelProj.Dto;

public class UserDto {

    private String name;
    private String email;
    private String password;
    private Boolean active ;
    private String userType;
    private String field;
    private String presentationLetter;
    private String legalCompanyName;


//    private Long clientId;


	public UserDto() {
	}


	public UserDto(String name, String email, String password, Boolean active, String userType) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.userType = userType;

	}

	public String getLegalCompanyName() {
		return legalCompanyName;
	}

	public void setLegalCompanyName(String legalCompanyName) {
		this.legalCompanyName = legalCompanyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	//extraFileds for candidate


	public UserDto(String name, String email, String password, Boolean active, String userType, String field, String presentationLetter, String legalCompanyName) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.userType = userType;
		this.field = field;
		this.presentationLetter = presentationLetter;
		this.legalCompanyName = legalCompanyName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getPresentationLetter() {
		return presentationLetter;
	}

	public void setPresentationLetter(String presentationLetter) {
		this.presentationLetter = presentationLetter;
	}
}
