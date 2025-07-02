# Jogo de Tabuleiro em Java

## Descrição do Projeto
Este projeto consiste em um jogo de tabuleiro desenvolvido em Java, onde os jogadores podem comprar e gerenciar imóveis, pagar aluguéis, e competir para acumular o maior patrimônio. O objetivo é criar uma experiência de jogo estratégica e divertida, utilizando conceitos de programação orientada a objetos e estruturas de dados.

## Estruturas de Dados Utilizadas
### Lista Ligada Circular
- **Uso**: Representa o tabuleiro do jogo, permitindo que os jogadores avancem pelas casas de forma contínua, simulando um movimento circular.
- **Implementação**: A classe `Tabuleiro` utiliza nós (`Node`) para criar a estrutura circular.

### ArrayList
- **Uso**: Gerencia a lista de jogadores e imóveis cadastrados, oferecendo flexibilidade e eficiência para manipulação de dados.
- **Implementação**: As classes `Jogador` e `Main` utilizam `ArrayList` para armazenar e acessar informações de forma dinâmica.

### Outros Recursos
- **Scanner**: Utilizado para capturar entradas do usuário durante o jogo.
- **Collections**: Empregado para ordenar os jogadores no ranking final com base no patrimônio acumulado.

## Como Executar o Projeto
### Pré-requisitos
- **Java JDK**: Certifique-se de ter o Java Development Kit instalado (versão 11 ou superior).
- **IDE**: Recomenda-se o uso de uma IDE como IntelliJ IDEA ou Eclipse, mas o projeto também pode ser executado diretamente pelo terminal.

### Passos para Execução
1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/PedroScheffer/ASED.git
   cd <PASTA_DO_PROJETO>

2. Compile o projeto:
   - **Usando IDE**: Importe o projeto na sua IDE (como IntelliJ IDEA) e compile a classe principal `Main`.
   - **Usando Terminal**:
     ```bash
     javac -d bin src/*.java
     ```

3. Execute o projeto:
   - **Usando IDE**: Execute a classe `Main` diretamente pela IDE.
   - **Usando Terminal**:
     ```bash
     java -cp bin Main
     ```

4. Siga as instruções exibidas no menu principal para jogar.

## Funcionalidades do Jogo

- **Gerenciamento de Jogadores**: Permite cadastrar, listar, atualizar e remover jogadores.
- **Gerenciamento de Imóveis**: Permite cadastrar, listar, atualizar e remover imóveis.
- **Simulação de Rodadas**: Jogadores lançam dados, avançam no tabuleiro e interagem com as casas.
- **Cobrança de Aluguel**: Jogadores pagam aluguel ao cair em propriedades de outros jogadores.
- **Cobrança de Impostos**: Jogadores pagam 10% do saldo ao cair em casas de imposto.
- **Salário por Volta**: Jogadores recebem um salário ao completar uma volta no tabuleiro.
- **Negociações**: Jogadores podem negociar propriedades entre si.
- **Ranking Final**: Exibe o ranking dos jogadores com base no patrimônio acumulado.
- **Fim de Jogo**: O jogo termina quando o número máximo de rodadas é atingido ou restar apenas um jogador ativo.