[![Java CI with Gradle](https://github.com/itmoura/nft-app/actions/workflows/maven.yml/badge.svg)](https://github.com/itmoura/nft-app/actions/workflows/maven.yml)

<h1 align="center"> Back-End OmNaNFT </h1>

## Descrição do Projeto

<p>O projeto consiste em um site desenvolvido em React voltado para o mundo de NFT, em que você pode criar, ver, comprar, vender, negociar, etc... suas NFTs</p>

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção desse projeto:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Gradle](https://gradle.org/)
- [PostgreSQL](https://www.postgresql.org/)

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- [Git](https://git-scm.com)
- [Java](https://www.java.com/pt-BR/)
- [Docker](https://www.docker.com/)
- [Gradle](https://gradle.org/)

Docker será usado afim de criar um container com o banco de dados PostgreSQL.
```bash
# Com docker instalado, execute o seguinte comando para criar o container
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=root -d postgres
```
E execute o mesmo.

### 🎲 Rodando o Back End (servidor)

- Lembrando, esse projeto foi feito com o intuito de ser usado em conjunto com o front-end e o nft-engine, que pode ser encontrado:
- [Nft-engine](https://github.com/itmoura/nft-engine)
- [Front](https://github.com/ItaloRez/OmNaNFT-Front/)

```bash
# Clone este repositório
$ git clone

# Acesse a pasta do projeto no terminal/cmd
$ cd nft-app

# Instale as dependências
$ gradle build

# Execute a aplicação em modo de desenvolvimento
$ gradle bootRun

# O servidor inciará na porta:8080 - acesse http://localhost:8080
```
ou pelo IntelliJ IDEA, basta abrir seu projeto e executar a classe NftAppApplication.java

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
