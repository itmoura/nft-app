package com.omna.nftapp.integration.NFTs.v1;

import com.omna.nftapp.integration.NFTs.v1.dto.CollectionsNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.CreateNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.NFTDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "nft-engine", url = "${api.nft.host}${api.nft.v1.basePath}")
public interface NFTsIntegration {

    @GetMapping("/nfts")
    Page<NFTDTO> page(@PageableDefault Pageable pageable);

    @GetMapping("/nfts/{id}")
    NFTDTO findNftById(@PathVariable UUID id);

    @GetMapping("/nfts/collection/{id}")
    Page<NFTDTO> findNftByCollection(@PathVariable UUID id, @PageableDefault Pageable pageable);

    @PatchMapping("/nfts/{id}")
    NFTDTO updateNFT(@PathVariable UUID id, @RequestBody CreateNFTDTO nftdto);

    @PostMapping("/nfts")
    NFTDTO createNFT(@RequestBody CreateNFTDTO nftdto);

    @PostMapping("/nfts/{id}/buy")
    NFTDTO buyNFT(@PathVariable UUID id, @RequestParam UUID newOwner);

    // ------------------------------------ //

    @PostMapping("/collections")
    CollectionsNFTDTO createCollectionsNFT(@RequestBody CollectionsNFTDTO collectionsNFTDTO);

    @PutMapping("/collections/{id}")
    CollectionsNFTDTO updateCollectionsNFT(@PathVariable UUID id, @RequestBody CollectionsNFTDTO collectionsNFTDTO);

    @GetMapping("/collections")
    Page<CollectionsNFTDTO> pageCollections(@RequestParam(required = false) String name, @PageableDefault Pageable pageable);

    @GetMapping("/nfts/me/{ownerId}")
    List<NFTDTO> NFTsByUser(@PathVariable UUID ownerId);
}
