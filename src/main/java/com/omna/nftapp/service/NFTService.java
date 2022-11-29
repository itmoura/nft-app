package com.omna.nftapp.service;

import com.omna.nftapp.integration.NFTs.v1.NFTsIntegration;
import com.omna.nftapp.integration.NFTs.v1.dto.CollectionsNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.CreateNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.NFTDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NFTService {

    private final NFTsIntegration integration;

    private final UserService userService;

    public Page<NFTDTO> page(Pageable pageable) {
        return integration.page(pageable);
    }

    public NFTDTO findNftById(UUID id) {
        return integration.findNftById(id);
    }

    public Page<NFTDTO> findNftByCollection(UUID id, Pageable pageable) {
        return integration.findNftByCollection(id, pageable);
    }

    public NFTDTO updateNFT(UUID id, CreateNFTDTO nftdto) {
        return integration.updateNFT(id, nftdto);
    }

    public NFTDTO createNFT(CreateNFTDTO nftdto) {
        return integration.createNFT(nftdto);
    }

    // ------------------------------------ //

    public CollectionsNFTDTO createCollectionsNFT(CollectionsNFTDTO collectionsNFTDTO) {
        return integration.createCollectionsNFT(collectionsNFTDTO);
    }

    public CollectionsNFTDTO updateCollectionsNFT(UUID id, CollectionsNFTDTO collectionsNFTDTO) {
        return integration.updateCollectionsNFT(id, collectionsNFTDTO);
    }

    public Page<CollectionsNFTDTO> pageCollections(String name, Pageable pageable) {
        return integration.pageCollections(name, pageable);
    }

    public NFTDTO buyNFT(UUID id) {
        var nft = integration.findNftById(id);
        if (nft == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NFT not found");
        var userBuy = userService.buyNFT(nft.getPrice(), nft.getOwner_id());

        if (userBuy == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not have enough balance");

        return integration.buyNFT(id, userBuy);
    }

    public List<NFTDTO> NFTsByUser() {
        var userId = userService.getUserId();
        return integration.NFTsByUser(userId);
    }
}
