# Java Enum Patterns (Java 21)

Este repositório é uma coleção de exemplos práticos que demonstram o uso de padrões de design e técnicas de programação funcional com `enums` no Java 21. O objetivo é explorar como os `enums` podem ser utilizados de forma mais poderosa e flexível, aproveitando os recursos modernos da linguagem para criar código mais limpo, conciso e expressivo.

## Tecnologias Utilizadas

*   **Java 21**: Versão da linguagem utilizada para aproveitar recursos como `switch expressions`, `records` e outras melhorias.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.

## Estrutura do Projeto

O projeto está organizado em pacotes que contêm diferentes exemplos de padrões de `enum`:

*   `br.com.fabiohaider.enumpattern`
    *   `Command.java`
    *   `ConfigurableValidators.java`
    *   `Factory.java`
    *   `StateMachine.java`
    *   `Strategy.java`

## Exemplos de Padrões de Enum

Cada arquivo Java no pacote `br.com.fabiohaider.enumpattern` demonstra um padrão específico ou uma técnica de uso de `enums`:

### `Command.java`

Este exemplo ilustra o **Padrão Command** utilizando `enums`. Cada instância do `enum` representa um comando específico (START, STOP, RESTART) e encapsula a lógica de execução associada a esse comando. Isso permite que você trate as operações como objetos, facilitando a extensão e a manutenção do código.

### `ConfigurableValidators.java`

Demonstra como usar `enums` para criar **validadores configuráveis**. Cada membro do `enum` é associado a uma `Predicate<String>`, permitindo a definição de regras de validação reutilizáveis e expressivas (ex: `IS_NUMERIC`, `IS_EMAIL`, `IS_NOT_EMPTY`).

### `Factory.java`

Implementa o **Padrão Factory Method** com `enums`. Cada membro do `enum` atua como uma fábrica para criar instâncias de diferentes tipos de objetos (ex: `Circle`, `Square`, `Triangle`). Isso centraliza a lógica de criação de objetos e promove o baixo acoplamento.

### `StateMachine.java`

Este exemplo demonstra a implementação de uma **Máquina de Estados** simples usando `enums` e a nova `switch expression` do Java 21. Cada membro do `enum` representa um estado (RED, GREEN, YELLOW) e define as transições para o próximo estado (`next()`) e as ações associadas a cada estado (`action()`). Isso oferece uma maneira concisa e segura de tipo para modelar fluxos de estado.

### `Strategy.java`

Este exemplo implementa o **Padrão Strategy** utilizando `enums` e interfaces funcionais (`IntBinaryOperator`). Cada membro do `enum` representa uma estratégia de operação matemática (ADD, SUBTRACT, MULTIPLY, DIVIDE) e encapsula a lógica de execução. Isso permite que o algoritmo seja selecionado em tempo de execução, promovendo a flexibilidade e a extensibilidade. O exemplo também demonstra o uso de `var` para inferência de tipo e `Stream API` para processamento conciso.


## Como Construir e Executar

Para construir o projeto, navegue até o diretório raiz do projeto (`java-enumpattern`) e execute o seguinte comando Maven:

```bash
mvn clean install
```

Para executar os exemplos individuais, você pode compilar e rodar as classes `main` presentes em cada arquivo de exemplo (ex: `Command.java`, `ConfigurableValidators.java`, `Factory.java`).

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para sugerir melhorias, adicionar novos exemplos de padrões de `enum` ou corrigir bugs.

## Licença

Este projeto está licenciado sob a licença [MIT License](LICENSE).