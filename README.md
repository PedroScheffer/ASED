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