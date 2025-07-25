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
    *   `Singleton.java`
    *   `DecisionTable.java`
    *   `BidirectionalConversion.java`
    *   `StatusPhase.java`
    *   `AbstractMethod.java`
    *   `PropertyMapping.java`
    *   `DomainSpecificLogic.java`

## Exemplos de Padrões de Enum

Cada arquivo Java no pacote `br.com.fabiohaider.enumpattern` demonstra um padrão específico ou uma técnica de uso de `enums`:

### `Command.java`

Este exemplo ilustra o **Padrão Command** utilizando `enums`. Cada instância do `enum` representa um comando específico (START, STOP, RESTART) e encapsula a lógica de execução associada a esse comando. Isso permite que você trate as operações como objetos, facilitando a extensão e a manutenção do código.

### `ConfigurableValidators.java`

Demonstra como usar `enums` para criar **Configurable Validators**. Cada membro do `enum` é associado a uma `Predicate<String>`, permitindo a definição de regras de validação reutilizáveis e expressivas (ex: `IS_NUMERIC`, `IS_EMAIL`, `IS_NOT_EMPTY`).

### `Factory.java`

Implementa o **Padrão Factory Method** com `enums`. Cada membro do `enum` atua como uma fábrica para criar instâncias de diferentes tipos de objetos (ex: `Circle`, `Square`, `Triangle`). Isso centraliza a lógica de criação de objetos e promove o baixo acoplamento.

### `StateMachine.java`

Este exemplo demonstra a implementação de uma **State Machine** simples usando `enums` e a nova `switch expression` do Java 21. Cada membro do `enum` representa um estado (RED, GREEN, YELLOW) e define as transições para o próximo estado (`next()`) e as ações associadas a cada estado (`action()`). Isso oferece uma maneira concisa e segura de tipo para modelar fluxos de estado.

### `Strategy.java`

Este exemplo implementa o **Padrão Strategy** utilizando `enums` e interfaces funcionais (`IntBinaryOperator`). Cada membro do `enum` representa uma estratégia de operação matemática (ADD, SUBTRACT, MULTIPLY, DIVIDE) e encapsula a lógica de execução. Isso permite que o algoritmo seja selecionado em tempo de execução, promovendo a flexibilidade e a extensibilidade. O exemplo também demonstra o uso de `var` para inferência de tipo e `Stream API` para processamento conciso.

### `Singleton.java`

O **Padrão Singleton** garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela. Embora existam várias maneiras de implementar o Singleton em Java, o uso de um `enum` é amplamente considerado a abordagem mais simples, segura e robusta.

### `DecisionTable.java`

Este padrão utiliza `enums` para representar regras ou condições que levam a uma decisão ou ação específica. É uma forma elegante de substituir longas cadeias de `if-else` ou `switch` aninhados, tornando a lógica de decisão mais declarativa e fácil de gerenciar.

### `BidirectionalConversion.java`

O **Padrão Bidirectional Conversion** é fundamental quando os `enums` precisam ser mapeados para e de outras representações de dados, como códigos de banco de dados, strings de API, valores numéricos ou IDs externos. Garante uma conversão segura e consistente entre o `enum` e seu valor correspondente.

### `StatusPhase.java`

O **Padrão Status Phase** é usado para definir os diferentes estados ou fases pelos quais uma entidade pode passar em um processo de negócio. Diferente de uma state machine completa (como `StateMachine.java`), o foco aqui é mais nas propriedades e comportamentos associados a cada estado, e menos nas transições explícitas entre eles.

### `AbstractMethod.java`

**Abstract Method** é um padrão clássico e muito poderoso que permite que cada membro do `enum` tenha uma implementação única para um método abstrato definido no próprio `enum`. Isso é uma forma elegante de alcançar polimorfismo de comportamento de forma concisa e segura de tipo.


### `PropertyMapping.java`

O **Property Mapping** é útil quando você precisa associar múltiplos valores ou propriedades a cada membro do `enum`, além do seu nome e ordinal. É comum para representar configurações, códigos de erro com mensagens, ou tipos de dados com metadados.


### `DomainSpecificLogic.java`

Expandindo o conceito de `Strategy` e `Command`, o **Domain Specific Logic** foca em encapsular lógica de negócio mais complexa e específica do domínio dentro dos membros do `enum`. Isso pode incluir cálculos, validações encadeadas ou transformações de dados que são inerentemente ligadas ao tipo de `enum`.


## Como Construir e Executar

Para construir o projeto, navegue até o diretório raiz do projeto (`java-enumpattern`) e execute o seguinte comando Maven:

```bash
mvn clean install
```

Para acompanhar a cobertura de testes, execute:

```bash
mvn clean verify
```

E verifique o arquivo criado em `java-enum-patterns/target/site/index.html`

Para executar os exemplos individuais, você pode compilar e rodar as classes `main` presentes em cada arquivo de exemplo (ex: `Command.java`, `ConfigurableValidators.java`, `Factory.java`... ).

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para sugerir melhorias, adicionar novos exemplos de padrões de `enum` ou corrigir bugs.

## Licença

Este projeto está licenciado sob a licença [MIT License](LICENSE).