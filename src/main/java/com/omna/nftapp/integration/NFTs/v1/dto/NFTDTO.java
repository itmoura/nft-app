package com.omna.nftapp.integration.NFTs.v1.dto;

import com.omna.nftapp.integration.NFTs.v1.enumeration.TypeCoin;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name="NftDTO", description = "Informações sobre NFT")
public class NFTDTO {

    @Schema(name="nftId",
            description = "Id do NFT",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private UUID nftId;

    @Schema(name="name",
            description = "Nome do NFT",
            example = "NFT 1")
    private String name;

    @Schema(name="description",
            description = "Descrição do NFT",
            example = "NFT 1")
    private String description;

    @Schema(name="imageSrc",
            description = "URL para imagem",
            example = "/nft1.png")
    private String link_image;

    @Schema(name="price",
            description = "Preço do NFT",
            example = "100")
    private String price;

    @Schema(name="typeCoin",
            description = "Tipo de moeda",
            example = "ETH")
    private TypeCoin typeCoin;

    @Schema(name="collectionId",
            description = "Identificador da coleção",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private CollectionsNFTDTO collectionId;

    @Schema(name="owner_id",
            description = "Id do dono do NFT",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private UUID owner_id;

    @Schema(name="status",
            description = "Status do NFT",
            example = "SOLD")
    private String status;

    @Schema(name="category",
            description = "Categoria do NFT",
            example = "art")
    private String category;

    @Schema(name="tags",
            description = "Tags do NFT",
            example = "tag1, tag2")
    private String tags;

    @Schema(name="created_by",
            description = "Criado por",
            example = "2516154a-0a34-40a7-9c91-5f9ac2ffa516")
    private UUID created_by;

    @Schema(name="created_at",
            description = "Criado em",
            example = "2021-08-01 00:00:00")
    private String created_at;

    @Schema(name="updated_at",
            description = "Atualizado em",
            example = "2021-08-01 00:00:00")
    private String updated_at;
}
