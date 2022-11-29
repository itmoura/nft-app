package com.omna.nftapp.service;

import com.omna.nftapp.integration.NFTs.v1.NFTsIntegration;
import com.omna.nftapp.integration.NFTs.v1.dto.CollectionsNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.CreateNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.NFTDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NFTService {

    private final NFTsIntegration integration;

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
        return null;
    }
}
