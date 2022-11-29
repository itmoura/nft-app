package com.omna.nftapp.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omna.nftapp.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "user_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID userId;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean enabled;

    private String description;

    private String avatar;

    private String phone;

    private BigDecimal cash;

    public static User convert(UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
