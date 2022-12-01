[![Java CI with Gradle](https://github.com/itmoura/nft-app/actions/workflows/maven.yml/badge.svg)](https://github.com/itmoura/nft-app/actions/workflows/maven.yml)

<h1 align="center"> Back-End OmNaNFT </h1>

## Descrição do Projeto

<p>O projeto consiste em um site desenvolvido em React voltado para o mundo de NFT, em que você pode criar, ver, comprar, vender, negociar, etc... suas NFTs</p>

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção desse projeto:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Gradle](https://gradle.org/)
- [Dockers](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- [Git](https://git-scm.com)
- [Docker](https://www.docker.com/)

### 🎲 Rodando o Back End (servidor)

- Lembrando, esse projeto foi feito com o intuito de ser usado em conjunto com o front-end e o nft-engine, que pode ser encontrado:
- [Nft-engine](https://github.com/itmoura/nft-engine)
- [Front](https://github.com/ItaloRez/OmNaNFT-Front/)

```bash
# Clone este repositório
$ git clone

# Acesse a pasta do projeto no terminal/cmd
$ cd nft-app

# Execute o comando para subir os containers
$ docker-compose up -d
```
Irá subir um container com o banco de dados e outro com o servidor:
- Banco de dados roda na porta 5432
- Servidor (NFT-APP) roda na porta 8080
- Servidor (NFT-ENGINE) roda na porta 8081

## 👥 Autores

<table  style="text-align:center; border: none" >
<tr>

<td align="center"> 
<a href="https://github.com/itmoura" style="text-align:center;">
<img style="border-radius: 20%;" src="https://github.com/itmoura.png" width="120px;" alt="autor"/><br> <strong> Ítalo Moura </strong>
</a>
</td>

<td align="center"> 
<a href="https://github.com/ItaloRez" styles="text-align:center;">
<img style="border-radius: 20%;" src="https://github.com/ItaloRez.png" width="120px;" alt="autor"/><br><strong> Ítalo de Rezende </strong>
</a>
</td>

</tr>
</table>

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).
