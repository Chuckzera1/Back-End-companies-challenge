# Back-End-companies-challenge
Banck-env Java

## Principais Tecnologias:
    Spring-boot, Maven, Postgres, 

## To run api: 
    You can run using itellij (Shift + F10) or you can use mvn
    Tou use mvn, run `mvn install` then `mvn spring-boot:run`

## Para rodar a api
    É possível rodar pelo intellij (Shift+F10) ou usar o mvn.
    Para usar mvn, rodar `mvn install` e depois `mvn spring-boot:run`
    É necessário possuir o Docker e que ele esteja rodando

## Sobre a api:
  A API tem todas as rotas de CRUD para empresas, porém ainda não é possível relacionar com Fornecedores.
  A parte de fornecedores é possível criar e listar os dados, mas não é possível deletar e nem atualizar no momento.
  Lembrando que ainda não é possível relacionar as entidades.
  A relação existe, mas não existe rota, nem usecase ou query que crie o vínculo de fato.

## Arquitetura:
  Foi aplicada a **Clean Architeture**, uma arquitetura que tenta dividir a api em camadas, pra deixar as partes mais independentes.<br>
  **As camadas que foram usadas nesse projeto são `Application`, `Infra`, `HTTP`.***
  - A camada `Application` é **responsável pelos casos de uso, regras de negócio e também mantém as interfaces dos repositórios**. 
  - A camada de `Infra` é **responsável pelos repositórios. Ela que vai ter a parte que faz requisições diretas ao banco.** <br>
    Aqui, **os reposítorios tendem a ser mais diretos e reterem o mínimo de lógica possível**, mas sempre **aproveitando o máximo que os bancos têm a oferecer**.<br>
  - Por último temos a camada `HTTP`. *Responsável por receber os requests via rotas http, ela possui Controllers necessários para validações de body, parâmetros, etc.*  
Na camada `HTTP`, **também podemos ter ErrorHandlers e alguns adapters**.<br>
  Decidi seguir com essa arquitetura, pois ela traz uma legibilidade maior ao código, uma independência melhor das camadas,
e também facilita refatorações e atualizações sem impactar muitos lugares no sistema.



