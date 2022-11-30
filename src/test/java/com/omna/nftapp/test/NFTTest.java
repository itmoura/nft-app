package com.omna.nftapp.test;

import com.omna.nftapp.integration.NFTs.v1.dto.CollectionsNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.CreateNFTDTO;
import com.omna.nftapp.integration.NFTs.v1.dto.NFTDTO;
import com.omna.nftapp.resource.v1.NFTResource;
import com.omna.nftapp.service.NFTService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes de NFT")
public class NFTTest {

    @InjectMocks
    private NFTResource resource;

    @Mock
    private NFTService service;

    @Test
    @DisplayName("Teste para listar NFTs")
    void testListNFTs() {
        var pageable = PageRequest.of(0, 20);
        var dto = NFTDTO.builder()
                .nftId(UUID.randomUUID())
                .name("NFT 1")
                .description("NFT 1")
                .build();

        var page = new PageImpl<>(Collections.singletonList(dto));
        when(service.page(pageable)).thenReturn(page);

        var pageReturn = resource.page(pageable);

        verify(service, only()).page(pageable);
        assertThat(pageReturn).isNotNull().isEqualTo(page);
    }

    @Test
    @DisplayName("Teste para criar NFT")
    void testCreateNFT() {
        var create = CreateNFTDTO.builder()
                .name("NFT 1")
                .description("NFT 1")
                .build();

        var dto = NFTDTO.builder()
                .nftId(UUID.randomUUID())
                .name("NFT 1")
                .description("NFT 1")
                .build();

        when(service.createNFT(create)).thenReturn(dto);

        var dtoReturn = resource.createNFT(create);

        verify(service, only()).createNFT(create);
        assertThat(dtoReturn).isNotNull().isEqualTo(dto);
    }

    @Test
    @DisplayName("Teste para atualizar NFT")
    void testUpdateNFT() {
        var create = CreateNFTDTO.builder()
                .name("NFT 1")
                .description("NFT 1")
                .build();

        var dto = NFTDTO.builder()
                .nftId(UUID.randomUUID())
                .name("NFT 1")
                .description("NFT 1")
                .build();

        when(service.updateNFT(dto.getNftId(), create)).thenReturn(dto);

        var dtoReturn = resource.updateNFT(dto.getNftId(), create);

        verify(service, only()).updateNFT(dto.getNftId(), create);
        assertThat(dtoReturn).isNotNull().isEqualTo(dto);
    }

    @Test
    @DisplayName("Teste para pegar um NFT pelo ID")
    void testGetNFTById() {
        var dto = NFTDTO.builder()
                .nftId(UUID.randomUUID())
                .name("NFT 1")
                .description("NFT 1")
                .build();

        when(service.findNftById(dto.getNftId())).thenReturn(dto);

        var dtoReturn = resource.findNftById(dto.getNftId());

        verify(service, only()).findNftById(dto.getNftId());
        assertThat(dtoReturn).isNotNull().isEqualTo(dto);
    }

    @Test
    @DisplayName("Teste para cadastrar uma nova coleção")
    void testCreateCollection() {
        var create = CollectionsNFTDTO.builder()
                .name("NFT 1")
                .description("NFT 1")
                .build();

        when(service.createCollectionsNFT(create)).thenReturn(create);

        var dtoReturn = resource.createCollectionsNFT(create);

        verify(service, only()).createCollectionsNFT(create);
        assertThat(dtoReturn).isNotNull().isEqualTo(create);
    }

    @Test
    @DisplayName("Teste para atualizar uma coleção")
    void testUpdateCollection() {
        var collectionId = UUID.randomUUID();
        var create = CollectionsNFTDTO.builder()
                .name("NFT 1")
                .description("NFT 1")
                .build();

        when(service.updateCollectionsNFT(collectionId, create)).thenReturn(create);

        var dtoReturn = resource.updateCollectionsNFT(collectionId, create);

        verify(service, only()).updateCollectionsNFT(collectionId, create);
        assertThat(dtoReturn).isNotNull().isEqualTo(create);
    }

    @Test
    @DisplayName("Teste para listar coleções")
    void testListCollections() {
        var pageable = PageRequest.of(0, 20);
        var dto = CollectionsNFTDTO.builder()
                .collectionId(UUID.randomUUID())
                .name("NFT 1")
                .description("NFT 1")
                .build();

        var page = new PageImpl<>(Collections.singletonList(dto));
        when(service.pageCollections(dto.getName(), pageable)).thenReturn(page);

        var pageReturn = resource.pageCollections(dto.getName(), pageable);

        verify(service, only()).pageCollections(dto.getName(), pageable);
        assertThat(pageReturn).isNotNull().isEqualTo(page);
    }
}
