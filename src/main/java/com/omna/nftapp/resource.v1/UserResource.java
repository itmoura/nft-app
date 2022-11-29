package com.omna.nftapp.resource.v1;

import com.omna.nftapp.model.dto.UserAuthDTO;
import com.omna.nftapp.model.dto.UserDTO;
import com.omna.nftapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(CREATED)
    @Operation(summary = "Criar usuário",
            description = "Endpoint responsável por criar um usuário")
    @ApiResponse(responseCode = "201", description = "Retorna o usuário criado")
    public UserAuthDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping("/{userId}")
    @ResponseStatus(OK)
    @Operation(summary = "Atualizar usuário",
            description = "Endpoint responsável por atualizar um usuário")
    @ApiResponse(responseCode = "200", description = "Retorna o usuário atualizado")
    public UserDTO createUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return userService.update(userId, userDTO);
    }

    @GetMapping
    @ResponseStatus(OK)
    @Operation(summary = "Listar usuários",
            description = "Endpoint responsável por listar os usuários")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de usuários")
    public List<UserAuthDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/me")
    @ResponseStatus(OK)
    @Operation(summary = "Buscar usuário logado",
            description = "Endpoint responsável por buscar o usuário logado")
    @ApiResponse(responseCode = "200", description = "Retorna o usuário logado")
    public UserDTO getMe() {
        return userService.getMe();
    }

    @PostMapping("/add-cash")
    @ResponseStatus(OK)
    @Operation(summary = "Adicionar dinheiro",
            description = "Endpoint responsável por adicionar dinheiro na carteira do usuário")
    @ApiResponse(responseCode = "200", description = "Retorna o usuário atualizado")
    public void addCash(@RequestParam BigDecimal cash) {
        userService.addCash(cash);
    }
}
