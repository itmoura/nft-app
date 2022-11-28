package com.omna.nftapp.resource.v1;

import com.omna.nftapp.model.dto.UserAuthDTO;
import com.omna.nftapp.model.dto.UserDTO;
import com.omna.nftapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserAuthDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO createUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return userService.update(userId, userDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserAuthDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getMe() {
        return userService.getMe();
    }
}
