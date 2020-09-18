package com.example.excelProj.Dto;

import com.example.excelProj.Model.User;

import java.io.Serializable;

public class ViewTenderDTO implements Serializable {
    TenderDTO tenderDTO;
    User userDto;
    Boolean isAccept;

    public ViewTenderDTO() {
    }

    public Boolean getAccept() {
        return isAccept;
    }

    public void setAccept(Boolean accept) {
        isAccept = accept;
    }

    public TenderDTO getTenderDTO() {
        return tenderDTO;
    }

    public void setTenderDTO(TenderDTO tenderDTO) {
        this.tenderDTO = tenderDTO;
    }

    public User getUserDto() {
        return userDto;
    }

    public void setUserDto(User userDto) {
        this.userDto = userDto;
    }

    public ViewTenderDTO(TenderDTO tenderDTO, User userDto) {
        this.tenderDTO = tenderDTO;
        this.userDto = userDto;
    }
}
