package com.example.excelProj.Service;


import com.example.excelProj.Commons.ApiResponse;
import com.example.excelProj.Dto.CandidateProfileDTO;
import com.example.excelProj.Model.CandidateProfile;
import com.example.excelProj.Model.User;
import com.example.excelProj.Repository.CandidateProfileRepository;
import com.example.excelProj.Repository.UserDaoRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateProfileService {

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    CandidateProfileRepository candidateProfileRepository;

    public ApiResponse postCandidateProfile(Long userId, CandidateProfileDTO candidateProfileDTO)
    {
        Optional<User> optionalUser =userDaoRepository.findById(userId);

        if(optionalUser.isPresent())
        {
            User user=optionalUser.get();

            if(!user.getProfileActive())
                user.setProfileActive(true);

            user.setEmail(candidateProfileDTO.getEmail());
            user.setName(candidateProfileDTO.getName());
            userDaoRepository.save(user);
           User newUser=userDaoRepository.findById(userId).isPresent()?userDaoRepository.findById(userId).get():null;


            CandidateProfile candidateProfile=candidateProfileRepository.findByUserId(userId)!=null?candidateProfileRepository.findByUserId(userId):new CandidateProfile();
            candidateProfile.setPresentationLetter(candidateProfileDTO.getPresentationLetter());
            candidateProfile.setField(candidateProfileDTO.getField());
            candidateProfile.setCv(candidateProfileDTO.getCv());
            candidateProfile.setDp(candidateProfileDTO.getDp());
            candidateProfile.setResumeContentType(candidateProfileDTO.getResumeContentType());
            candidateProfile.setImageContentType(candidateProfileDTO.getImageContentType());
            candidateProfile.setUser(newUser);
            candidateProfileRepository.save(candidateProfile);
          return new ApiResponse(200,"Candidate profile successfuly updated",userDaoRepository.findById(userId).get());
        }

        return  new ApiResponse(500,"Something went wrong",null);


    }


    public User saveUser(User user)
    {
        return userDaoRepository.save(user);
    }
}

