# :bulb: Projeto cobrança
#### A aplicação tras a ideia de anotar suas cobranças, tanto pendentes quanto as recebidas ou concluídas.
# Tópicos
  1. [Status do projeto](#status-do-projeto)
  2. [Funcionalidades da aplicação](#funcionalidades-da-aplicação)
  3. [Versões](#versões)
  5. [Tecnologias utilizadas](#tecnologias-utilizadas)
  6. [Autor](#autor)
  7. [Meus contatos](#meus-contatos)
# Status do projeto
#### Concluido. Mas, aplicando modificações com a finalidade de estudar os conceitos aprendidos dentro e fora do curso que proporcionou a construção da ideia do projeto, curso da AlgaWorks.
# Funcionalidades da aplicação
- [x] Cadastro, edição e exclusão de títulos.
- [x] Mudança de estado do titulo, via Ajax.
- [x] Mascara de valores da cobrança e da data.
- [x] Pesquisa de titulos a partir de elementos que contenham.

# Versões
  
## Implementações Versão - 2.0

- [x]  Mensagem de titulos não encontrados.
- [x]  Mostrando quantidade de titulos no banco de dados, bem como a quantidade de titulos pendentes e recebidos.
- [x]  Adicionar de qual cartão é a conta, ex: comprei um tênis no **cartão do nubank** adicionar o cartão como uma tag como está com pendente com concluído.
- [x]  Adicionar o total do valor
  ### Para exibir o preço total dos títulos foi usado o método utilitário, disponivel pelo thymeleaf, abaixo:

```Java
  formatDecimal(Number target, Integer minIntegerDigits, String thousandsPointType, Integer decimalDigits, String decimalPoinType);
```
  - O primeiro parâmetro **requer o elemento** ao qual será feita a formatação;
- O segundo parâmetro o **minimo de digitos inteiros;**
- O terceiro parâmetro o **separador de milhar (’POINT’);**
- O quarto parâmetro requer a **quantidade de digitos decimais** a qual será exibido ao usuário, no caso da aplicação, dois digítos;
- O terceiro parâmetro o **separador decimal (’COMMA’);**

**OBS:** Para metodos do tipo decimal e integer, há alguns separadores disponiveis 'POINT', 'COMMA', 'WHITESPACE', 'NONE' ou 'DEFAULT' (por local).

[Referência](https://frontbackend.com/thymeleaf/thymeleaf-utility-methods-for-numbers)

#### Todas as implementações podem ser conferidas na aplicação através do link que está na aba *About.*

# Tecnologias utilizadas
* Spring MVC
* Spring IoC
* Spring Data
* Spring Boot
* Thymeleaf
* Bootstrap
* Design Responsivo
* Maven
* MySQL
* Tomcat
* JPA e Hibernate
* Bean Validation
* JQuery
* AJAX
* Spring Tool Suite
* Spring Boot DevTools


# Autor
  <img src="https://user-images.githubusercontent.com/58925056/157934762-1b63b01a-92c4-4a5a-8cf3-1787c894c565.png" width=175px>

### 📲Meus contatos

  <a href="https://instagram.com/tiago_lopes_14" target="_blank"><img src="https://img.shields.io/badge/-Instagram-%23E4405F?style=for-the-badge&logo=instagram&logoColor=white" target="_blank"></a> 
  <a href="mailto:saxtiago@gmailcom"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="https://www.linkedin.com/in/tiagolopesdeveloper/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href="https://t.me/tiagoLopesDev" target="_blank"><img src="https://img.shields.io/badge/Telegram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white" target="_blank"></a>
