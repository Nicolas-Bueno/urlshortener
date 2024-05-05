# URL Shortener Challenge

Este é um projeto desenvolvido como parte do desafio do Backend Brasil. O objetivo principal é criar um serviço de encurtamento de URLs.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Mysql
- Apache Commons Lang

## Funcionalidades

- Encurtamento de URLs: Os usuários podem enviar uma URL longa e receber uma versão encurtada.
- Redirecionamento: Os usuários podem acessar a URL encurtada e serão redirecionados para a URL original.
- Expiração de URLs: As URLs encurtadas têm um prazo de validade configurado e são removidas do banco de dados após esse período.

## Como Executar

1. Certifique-se de ter o Java e o Maven instalados.
2. Clone este repositório: `git clone https://github.com/seu-usuario/url-shortener.git`
3. Navegue até o diretório do projeto: `cd url-shortener`
4. Compile o projeto: `mvn clean install`
5. Execute o projeto: `mvn spring-boot:run`

O serviço estará disponível em `http://localhost:8080`.

## Exemplo

Seu serviço recebe uma chamada para encurtar uma URL.

**[POST]** `{{host}}/shorten-url`

{
"url": "[https://backendbrasil.com.br](https://backendbrasil.com.br/)"
}

E retorna um JSON com a URL encurtada:

HTTP/1.1 200 OK

{
"url": "https://xxx.com/DXB6V"
}

