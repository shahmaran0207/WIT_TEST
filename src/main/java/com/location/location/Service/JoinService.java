package com.location.location.Service;

import com.location.location.DTO.joinDTO;
import com.location.location.Entity.UserEntity;
import com.location.location.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public JoinService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void JoinProcess(joinDTO joinDTO){
        String username=joinDTO.getUsername();
        String password=joinDTO.getPassword();

        Boolean isExist=userRepository.existsByUsername(username);

        if(isExist) return;

        UserEntity data=new UserEntity();
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
