package com.omna.nftapp.resource.v1;

import com.omna.nftapp.integration.NFTs.v1.dto.CollectionsNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.CreateNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.NFTDTO;
import com.omna.nftapp.integration.NFTs.v1.enumeration.Status;
import com.omna.nftapp.service.NFTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

@RestController("API para gerenciar NFTs")
@RequestMapping("/api/v1/nfts")
@RequiredArgsConstructor
public class NFTResource {

    private final NFTService service;

    @GetMapping
    @ResponseStatus(OK)
    @Operation(summary = "Listagem de NFTs",
            description = "Endpoint responsável por NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de coleções de NFTs")
    public Page<NFTDTO> page(Pageable pageable) {
        return service.page(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @Operation(summary = "Busca NFTs por id",
            description = "Endpoint responsável por buscar NFTs por id")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public NFTDTO findNftById(@RequestParam UUID id) {
        return service.findNftById(id);
    }

    @GetMapping("/collections/{id}")
    @ResponseStatus(OK)
    @Operation(summary = "Busca NFTs por coleção",
            description = "Endpoint responsável por buscar NFTs por coleção")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public Page<NFTDTO> findNftByCollection(@PathVariable UUID id, Pageable pageable) {
        return service.findNftByCollection(id, pageable);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @Operation(summary = "Atualização de NFTs",
            description = "Endpoint responsável por atualizar NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public NFTDTO updateNFT(@PathVariable UUID id, @RequestBody CreateNFTDTO NFTDTO) {
        return service.updateNFT(id, NFTDTO);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(OK)
    @Operation(summary = "Muda o status de NFTs",
            description = "Endpoint responsável por mudar o status de NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public NFTDTO changeStatusNFT(@PathVariable UUID id, @RequestParam Status status) {
        return service.changeStatusNFT(id, status);
    }

    @PutMapping("/{id}/price")
    @ResponseStatus(OK)
    @Operation(summary = "Muda o preço de NFTs",
            description = "Endpoint responsável por mudar o preço de NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public NFTDTO changePriceNFT(@PathVariable UUID id, @RequestParam BigDecimal price) {
        return service.changePriceNFT(id, price);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Criação de NFTs",
            description = "Endpoint responsável por criar NFTs")
    @ApiResponse(responseCode = "201", description = "Retorna o NFTs")
    public NFTDTO createNFT(@RequestBody CreateNFTDTO NFTDTO) {
        return service.createNFT(NFTDTO);
    }

    // --------------------------------- //

    @PostMapping("/collections")
    @ResponseStatus(CREATED)
    @Operation(summary = "Criação de uma coleção de NFTs",
            description = "Endpoint responsável por criar uma coleção de NFTs")
    @ApiResponse(responseCode = "201", description = "Retorna a coleção de NFTs")
    public CollectionsNFTDTO createCollectionsNFT(@RequestBody CollectionsNFTDTO collectionsNFTDTO) {
        return service.createCollectionsNFT(collectionsNFTDTO);
    }

    @PutMapping("/collections/{id}")
    @ResponseStatus(OK)
    @Operation(summary = "Atualização de uma coleção de NFTs",
            description = "Endpoint responsável por atualizar uma coleção de NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna a coleção de NFTs")
    public CollectionsNFTDTO updateCollectionsNFT(@PathVariable UUID id, @RequestBody CollectionsNFTDTO collectionsNFTDTO) {
        return service.updateCollectionsNFT(id, collectionsNFTDTO);
    }

    @GetMapping("/collections")
    @ResponseStatus(OK)
    @Operation(summary = "Listagem de coleções de NFTs",
            description = "Endpoint responsável por listar coleções de NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de coleções de NFTs")
    public Page<CollectionsNFTDTO> pageCollections(@RequestParam(required = false) String name, Pageable pageable) {
        return service.pageCollections(name, pageable);
    }

    // --------------------------------- //

    @PostMapping("/buy/{id}")
    @ResponseStatus(OK)
    @Operation(summary = "Compra de NFTs",
            description = "Endpoint responsável por comprar NFTs")
    @ApiResponse(responseCode = "200", description = "Retorna o NFTs")
    public NFTDTO buyNFT(@PathVariable UUID id) {
        return service.buyNFT(id);
    }

    @GetMapping("/me")
    @ResponseStatus(OK)
    @Operation(summary = "Listagem de NFTs do usuário",
            description = "Endpoint responsável por listar NFTs do usuário")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de NFTs do usuário")
    public List<NFTDTO> NFTsByUser() {
        return service.NFTsByUser();
    }

}
