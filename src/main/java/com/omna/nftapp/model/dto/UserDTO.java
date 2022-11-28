package com.omna.nftapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omna.nftapp.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2042784939527707612L;

    private UUID userId;

    @NotNull(message = "error.validation.name.notNull")
    private String name;

    @NotNull(message = "error.validation.email.notNull")
    private String email;

    @NotNull(message = "error.validation.password.notNull")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String description;

    private String avatar;

    private String phone;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
