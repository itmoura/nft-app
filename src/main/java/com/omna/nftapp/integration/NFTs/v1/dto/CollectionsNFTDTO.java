package com.omna.nftapp.integration.NFTs.v1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name="CollectionNftDTO", description = "Get collection NFT")
public class CollectionsNFTDTO {

    @Schema(name="collectionId",
            description = "Id da coleção",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private UUID collectionId;

    @Schema(name="name",
            description = "Nome do NFT",
            example = "NFT 1")
    private String name;

    @Schema(name="description",
            description = "Descrição do NFT",
            example = "NFT 1")
    private String description;

    @Schema(name="created_by",
            description = "Criado por",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private UUID created_by;

    @Schema(name="created_at",
            description = "Criado em",
            example = "2021-08-01 00:00:00")
    private LocalDateTime created_at;

    @Schema(name="updated_at",
            description = "Atualizado em",
            example = "2021-08-01 00:00:00")
    private LocalDateTime updated_at;
}
