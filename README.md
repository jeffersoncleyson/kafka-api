# Informações do Projeto

#
## Introdução
#

Este projeto é uma prova de conceito da utilização do Kafka como serviço de mensageria. É possível realizar a troca de mensagens entre dois sistemas através do sistema de mensageria mencionado anteriormente, onde o Producer (Produtor de mensagem) envia conteúdos para o Consumer (Consumidor de mensage) atraves do protocolo TCP. <br>
A utilização de uma API Rest foi para facilitar a prova de conceito e demonstrar o uso de envio e recebimento de mensagens.


#
## Técnologias utilizadas neste projeto
#

#
### Spring Boot </br></br>

O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação. </br>
Ele consegue isso favorecendo a convenção sobre a configuração. Basta que você diga pra ele quais módulos deseja utilizar (WEB, Template, Persistência, Segurança, etc.) que ele vai reconhecer e configurar. </br></br>
Inicializador de projetos spring: *[Spring Initializr](https://start.spring.io/)*

#### **Material para consulta e entendimento:**
* [O que é Spring Boot?](https://blog.algaworks.com/spring-boot/)
* [Spring Boot: simplificando o Spring](https://www.devmedia.com.br/spring-boot-simplificando-o-spring/31979)
* [Criando uma API REST com o Spring Boot](https://www.treinaweb.com.br/blog/criando-uma-api-rest-com-o-spring-boot)

#
### Apache Kafka </br></br>

A arquitetura do Apache Kafka é organizada em torno de alguns termos chaves, são eles: messages, topics, producers, consumers groups e os brokers.

O Apache Kafka é uma plataforma de stream (fluxo de dados) de alto throughput que desacopla os produtores de dados dos consumidores de dados. Nele, as mensagens são organizadas em tópicos, os tópicos são divididos em partições, e as partições são replicadas entre os nós denominados brokers. </br></br>

* Menssages (mensagens): representam a unidade de dados, o registro do seu tópico. Toda mensagem é do tipo chave / valor, e elas são adicionadas sequencialmente ao final de um arquivo de log de uma partição e numeradas por offsets exclusivos.</br>

* Topics (tópicos): Um tópico é constituído de no mínimo uma partição e zero ou mais réplicas seguidoras, as partições permitem que vários consumidores leiam um tópico em paralelo, permitindo assim uma alta taxa de processamento.</br>

* Produtores (Produtores): Um produtor é qualquer aplicação que gera mensagens para serem persistidas no Apache Kafka. Um produtor é capaz de publicar mensagens em um ou mais tópicos de um cluster no Apache Kafka.</br>

* Consumers (Consumidores): Os consumidores são os assinantes (leitores) das mensagens de um determinado tópico.</br>

* Broker: um broker Apache Kafka recebe mensagens dos produtores e as armazena em disco, com uma chave exclusiva de offset. Um broker Apache Kafka permite que os consumidores busquem mensagens por tópico, consumer group, partição e offset. Brokers fazem parte de um cluster compartilhando informações entre si direta ou indiretamente, sendo que um dos brokers atua como controlador (controller).</br></br>

* **Link do Material com mais detalhes visuais [Uma introdução ao Apache Kafka, lições aprendidas em um ambiente de varejo](https://www.infoq.com/br/articles/apache-kafka-licoes/)**</br></br>

#### **Para utilizar o server do Apache kafka em conjunto com esta aplicação consultar o material disponível **[AQUI (Env-DEV)](https://github.com/jeffersoncleyson/env_dev)**** 

#
### Lombok </br></br>

O Lombok é um framework para Java que permite escrever código eliminando a verbosidade, o que permite ganhar tempo de desenvolvimento para o que realmente é importante. Seu uso permite gerar em tempo de compilação os métodos getters e setters, métodos construtores, padrão builder e muito mais.

#### **Material para consulta e entendimento:**
* [Lombok](https://projectlombok.org/)
* [Como usar o Lombok em projetos Java](https://digitalinnovation.one/artigos/como-usar-o-lombok-em-projetos-java)
* [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)

#
### OpenAPI </br></br>

A Especificação OpenAPI , originalmente conhecida como Especificação Swagger , é uma especificação para arquivos de interface legíveis por máquina para descrever, produzir, consumir e visualizar serviços da Web RESTful . Originalmente parte da estrutura Swagger , tornou-se um projeto separado em 2016, supervisionado pela OpenAPI Initiative, um projeto de colaboração de código aberto da Linux Foundation. Swagger e algumas outras ferramentas podem gerar código, documentação e casos de teste a partir de um arquivo de interface.

#### **Material para consulta e entendimento:**
* [Usando a OpenAPI para criar APIs inteligentes que ajudam os desenvolvedores](https://www.infoq.com/br/articles/apache-kafka-licoes/)
* [Open APO Initiative](https://www.openapis.org/)
* [Documenting a Spring REST API Using OpenAPI 3.0](https://www.baeldung.com/spring-rest-openapi-documentation)
* [springdoc-openapi v1.5.9](https://springdoc.org/)
* [OpenAPI 3 Documentation With Spring Boot](https://dzone.com/articles/openapi-3-documentation-with-spring-boot)
* [OpenAPI Specification - wikipedia](https://en.wikipedia.org/wiki/OpenAPI_Specification)

#
### Postman </br></br>

Os testes da API podem ser feitos utilizando a documentação especificada no tópico abaixo ou utilizando o software *Postman*. Junto ao projeto foi disponibilizado uma *collection* para ser importado no software e assim poder realizar os testes com os endpoints especificiados.

Para importar seguir os seguintes passos:

0) Fazer o [download](https://www.postman.com/downloads/) e instalar o Postman
1) Abrir o Postman
2) Clicar em *file*
3) Clicar em *import*
4) Arrastar e soltar o arquivo presenta na pasta *"Postman/Kafka-API.postman_collection.json"*

#
## Documentação da API
#

Para visualizar a documentação da API rodar o código e acessar no navegador o link abaixo:

```
http://localhost:9000/kafka/v1/swagger-ui.html
```

#
## Bibliotecas utilizadas
#

* Conectar a um broker do Kafka e usar dos recursos disponíveis.
```
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```
* Lombok cria os construtores , getteer e setters de forma automática.

```
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>provided</scope>
</dependency>
```
* Para montar a API Rest
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

* Para documentar a API Rest
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.2</version>
</dependency>
```


#
### Referências utilizadas para produzir este projeto
#

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-kafka)
* [How to Work with Apache Kafka in Your Spring Boot Application](https://www.confluent.io/blog/apache-kafka-spring-boot-application/)
* [Documenting Spring Boot REST API with SpringDoc + OpenAPI 3](https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/)
* [OpenAPI Specification](https://swagger.io/specification/)
* [OpenAPI 3 & Spring Boot](https://springdoc.org/)

