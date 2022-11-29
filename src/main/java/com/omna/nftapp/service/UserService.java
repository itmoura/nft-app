package com.omna.nftapp.service;

import com.omna.nftapp.model.dto.UserAuthDTO;
import com.omna.nftapp.model.dto.UserDTO;
import com.omna.nftapp.model.entity.User;
import com.omna.nftapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.omna.nftapp.model.entity.User.convert;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    public UserAuthDTO save(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
        var user = convert(userDTO);
        user.setEnabled(true);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        return UserAuthDTO.convert(userRepository.save(user));
    }

    public UserDTO update(UUID userId, UserDTO userDTO) {
        var userIdS = getUserId();
        if (!userIdS.equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authorized to update");
        }
        var user = userRepository.findByUserId(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setUserId(user.getUserId());
        user.setEmail(user.getEmail());
        user.setEnabled(true);
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(encoder.encode(userDTO.getPassword()));
        }
        if (userDTO.getDescription() != null) {
            user.setDescription(userDTO.getDescription());
        }
        if (userDTO.getAvatar() != null) {
            user.setAvatar(userDTO.getAvatar());
        }
        if (userDTO.getPhone() != null) {
            user.setPhone(userDTO.getPhone());
        }
        return UserDTO.convert(userRepository.save(user));
    }

    public List<UserAuthDTO> getUsers() {
        return userRepository.findAll().stream().map(UserAuthDTO::convert).collect(toList());
    }

    public UserDTO getMe() {
        var userId = getUserId();
        return userRepository.findByUserId(userId).map(UserDTO::convert).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public UUID getUserId() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userRepository.findByEmail(email).map(user -> user.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User getUser() {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void addCash(BigDecimal cash) {
        var email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        var user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        if (user.getCash() == null) {
            user.setCash(cash);
        } else {
            user.setCash(user.getCash().add(cash));
        }
    }
}
