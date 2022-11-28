package com.omna.nftapp.model.dto;

import com.omna.nftapp.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDTO {

    private String name;

    private String email;

    public static UserAuthDTO convert(User user) {
        UserAuthDTO userAuthorizationDTO = new UserAuthDTO();
        BeanUtils.copyProperties(user, userAuthorizationDTO);
        return userAuthorizationDTO;
    }

}
