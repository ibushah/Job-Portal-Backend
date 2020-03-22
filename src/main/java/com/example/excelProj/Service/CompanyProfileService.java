package com.example.excelProj.Service;

import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CompanyProfileDTO;
import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.CompanyProfile;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.CompanyProfileRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyProfileService {


    @Autowired
    CompanyProfileRepository companyProfileRepository;

    @Autowired
    UserDaoRepository userDaoRepository;
    public ApiResponse<String> postCompanyProfile(Long userId,CompanyProfileDTO companyProfileDTO)
    {
        Optional<User> optionalUser =userDaoRepository.findById(userId);

        if(optionalUser.isPresent())
        {
            User user=optionalUser.get();

            if(!user.getProfileActive()) {
                user.setProfileActive(true);
                userDaoRepository.save(user);
            }
            CompanyProfile companyProfile=companyProfileRepository.findByUserId(userId)!=null?companyProfileRepository.findByUserId(userId):new CompanyProfile();


                companyProfile.setBillingAddress(companyProfileDTO.getBillingAddress());
                companyProfile.setContactName(companyProfileDTO.getContactName());
                companyProfile.setContactTitle(companyProfileDTO.getContactTitle());
                companyProfile.setCorporateAddress(companyProfileDTO.getCorporateAddress());
                companyProfile.setLogo(companyProfileDTO.getLogo());
                companyProfile.setName(companyProfileDTO.getName());
                companyProfile.setLogoContentType(companyProfileDTO.getLogoContentType());
                companyProfile.setUser(user);

                companyProfileRepository.save(companyProfile);
                return new ApiResponse(200, "Company profile successfuly updated",companyProfileRepository.findByUserId(userId));

        }

        return  new ApiResponse(500,"Something went wrong",null);

    }

}
