import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final int MAX_JOGADORES = 6;
    private static ArrayList<Jogador> jogadores = new ArrayList<>();
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static double saldoInicial = 25000.0;
    private static double salarioPorVolta = 2000.0;
    private static int maxRodadas = 20;
    private static int rodadaAtual = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Gerenciar Jogadores");
            System.out.println("2. Gerenciar Imóveis");
            System.out.println("3. Configurações");
            System.out.println("4. Iniciar Jogo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> gerenciarJogadores(scanner);
                case 2 -> gerenciarImoveis(scanner);
                case 3 -> definirConfiguracoes(scanner);
                case 4 -> {
                    if (validarInicioJogo()) {
                        iniciarJogo(scanner);
                    }
                }
                case 0 -> {
                    System.out.println("Encerrando o programa. Até a próxima!");
                    sair = true;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarJogadores(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("--- Menu de Jogadores ---");
            System.out.println("(Atualmente: " + jogadores.size() + "/6 jogadores cadastrados)");
            System.out.println("1. Cadastrar Novo Jogador");
            System.out.println("2. Listar Jogadores Cadastrados");
            System.out.println("3. Atualizar Dados de um Jogador");
            System.out.println("4. Remover um Jogador");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (jogadores.size() < 6) {
                        System.out.print("Digite o nome do jogador: ");
                        String nome = scanner.nextLine();
                        jogadores.add(new Jogador(nome, saldoInicial));
                        System.out.println("Jogador cadastrado com sucesso!");
                    } else {
                        System.out.println("Máximo de 6 jogadores já cadastrados.");
                    }
                }
                case 2 -> {
                    System.out.println("--- Jogadores Cadastrados ---");
                    for (int i = 0; i < jogadores.size(); i++) {
                        Jogador jogador = jogadores.get(i);
                        System.out.printf("%d. %s - Saldo: R$ %.2f%n", (i + 1), jogador.getNome(), jogador.getSaldo());
                    }
                }
                case 3 -> {
                    System.out.println("--- Atualizar Jogador ---");
                    for (int i = 0; i < jogadores.size(); i++) {
                        System.out.printf("%d. %s%n", (i + 1), jogadores.get(i).getNome());
                    }
                    System.out.print("Escolha o número do jogador para atualizar: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indice >= 0 && indice < jogadores.size()) {
                        Jogador jogador = jogadores.get(indice);
                        System.out.print("Digite o novo nome do jogador (ou pressione Enter para manter): ");
                        String novoNome = scanner.nextLine();
                        if (!novoNome.isEmpty()) jogador.setNome(novoNome);
                        System.out.print("Digite o novo saldo do jogador (ou -1 para manter): ");
                        double novoSaldo = scanner.nextDouble();
                        if (novoSaldo >= 0) jogador.setSaldo(novoSaldo);
                        System.out.println("Jogador atualizado com sucesso!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                case 4 -> {
                    System.out.println("--- Remover Jogador ---");
                    for (int i = 0; i < jogadores.size(); i++) {
                        System.out.printf("%d. %s%n", (i + 1), jogadores.get(i).getNome());
                    }
                    System.out.print("Escolha o número do jogador para remover: ");
                    int indice = scanner.nextInt() - 1;
                    if (indice >= 0 && indice < jogadores.size()) {
                        System.out.println("Jogador '" + jogadores.get(indice).getNome() + "' removido.");
                        jogadores.remove(indice);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                case 5 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarImoveis(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("--- Menu de Imóveis ---");
            System.out.println("(Atualmente: " + imoveis.size() + "/40 imóveis cadastrados)");
            System.out.println("1. Cadastrar Novo Imóvel");
            System.out.println("2. Listar Imóveis Cadastrados");
            System.out.println("3. Atualizar Dados de um Imóvel");
            System.out.println("4. Remover um Imóvel");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    if (imoveis.size() < 40) {
                        System.out.print("Digite o nome do imóvel: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o preço do imóvel: ");
                        double preco = scanner.nextDouble();
                        System.out.print("Digite o valor do aluguel: ");
                        double aluguel = scanner.nextDouble();
                        imoveis.add(new Imovel(nome, preco, aluguel));
                        System.out.println("Imóvel cadastrado com sucesso!");
                    } else {
                        System.out.println("Máximo de 40 imóveis já cadastrados.");
                    }
                }
                case 2 -> {
                    System.out.println("--- Imóveis Cadastrados ---");
                    for (int i = 0; i < imoveis.size(); i++) {
                        Imovel imovel = imoveis.get(i);
                        System.out.printf("%d. %s - Preço: R$ %.2f - Aluguel: R$ %.2f%n",
                                (i + 1), imovel.getNome(), imovel.getPreco(), imovel.getAluguel());
                    }
                }
                case 3 -> {
                    System.out.println("--- Atualizar Imóvel ---");
                    for (int i = 0; i < imoveis.size(); i++) {
                        System.out.printf("%d. %s%n", (i + 1), imoveis.get(i).getNome());
                    }
                    System.out.print("Escolha o número do imóvel para atualizar: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (indice >= 0 && indice < imoveis.size()) {
                        Imovel imovel = imoveis.get(indice);
                        System.out.print("Digite o novo nome do imóvel (ou pressione Enter para manter): ");
                        String novoNome = scanner.nextLine();
                        if (!novoNome.isEmpty()) imovel.setNome(novoNome);
                        System.out.print("Digite o novo preço do imóvel (ou -1 para manter): ");
                        double novoPreco = scanner.nextDouble();
                        if (novoPreco >= 0) imovel.setPreco(novoPreco);
                        System.out.print("Digite o novo valor do aluguel (ou -1 para manter): ");
                        double novoAluguel = scanner.nextDouble();
                        if (novoAluguel >= 0) imovel.setAluguel(novoAluguel);
                        System.out.println("Imóvel atualizado com sucesso!");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                case 4 -> {
                    System.out.println("--- Remover Imóvel ---");
                    for (int i = 0; i < imoveis.size(); i++) {
                        System.out.printf("%d. %s%n", (i + 1), imoveis.get(i).getNome());
                    }
                    System.out.print("Escolha o número do imóvel para remover: ");
                    int indice = scanner.nextInt() - 1;
                    if (indice >= 0 && indice < imoveis.size()) {
                        System.out.println("Imóvel '" + imoveis.get(indice).getNome() + "' removido.");
                        imoveis.remove(indice);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                case 5 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void definirConfiguracoes(Scanner scanner) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("--- Configurações da Partida ---");
            System.out.printf("1. Definir Saldo Inicial (Atual: R$ %.2f)%n", saldoInicial);
            System.out.printf("2. Definir Salário por volta (Atual: R$ %.2f)%n", salarioPorVolta);
            System.out.printf("3. Definir Nº Máximo de Rodadas (Atual: %d)%n", maxRodadas);
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o novo saldo inicial: ");
                    saldoInicial = scanner.nextDouble();
                    System.out.printf("Saldo inicial definido para R$ %.2f.%n", saldoInicial);

                    // Atualizar saldo dos jogadores já cadastrados
                    for (Jogador jogador : jogadores) {
                        jogador.setSaldo(saldoInicial);
                    }
                }
                case 2 -> {
                    System.out.print("Digite o novo salário por volta: ");
                    salarioPorVolta = scanner.nextDouble();
                    System.out.printf("Salário por volta definido para R$ %.2f.%n", salarioPorVolta);
                }
                case 3 -> {
                    System.out.print("Digite o número máximo de rodadas: ");
                    maxRodadas = scanner.nextInt();
                    System.out.printf("Número máximo de rodadas definido para %d.%n", maxRodadas);
                }
                case 4 -> voltar = true;
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static boolean validarInicioJogo() {
        if (jogadores.size() < 2) {
            System.out.println("Erro: O jogo precisa de pelo menos 2 jogadores.");
            return false;
        }
        if (imoveis.size() < 10) {
            System.out.println("Erro: O jogo precisa de pelo menos 10 imóveis cadastrados.");
            return false;
        }
        return true;
    }

    private static void iniciarJogo(Scanner scanner) {
        System.out.println("Iniciando o jogo...");
        Tabuleiro tabuleiro = criarTabuleiro();
        inicializarPosicoes(tabuleiro);

        while (rodadaAtual <= maxRodadas) {
            System.out.printf("=== Rodada %d ===%n", rodadaAtual);

            for (Jogador jogador : jogadores) {
                if (jogador.getSaldo() <= 0) {
                    System.out.printf("Jogador %s está falido e não pode jogar.%n", jogador.getNome());
                    continue;
                }
                menuTurnoJogador(jogador, scanner, tabuleiro);
            }

            rodadaAtual++;

            if (verificarFimDeJogo()) {
                exibirFimDeJogo("Fim do jogo: Condições de término atingidas.");
                break;
            }
        }

        if (rodadaAtual > maxRodadas) {
            exibirFimDeJogo("Fim do jogo: Número máximo de rodadas atingido.");
        }
    }

    private static Tabuleiro criarTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro();
        for (Imovel imovel : imoveis) {
            tabuleiro.adicionarCasa(new Node("Imóvel", imovel));
        }
        tabuleiro.adicionarCasa(new Node("Imposto", null));
        tabuleiro.adicionarCasa(new Node("Restituição", null));
        return tabuleiro;
    }

    private static void inicializarPosicoes(Tabuleiro tabuleiro) {
        Node inicio = tabuleiro.getInicio();
        for (Jogador jogador : jogadores) {
            jogador.setPosicaoAtual(inicio);
        }
    }

    private static void menuTurnoJogador(Jogador jogador, Scanner scanner, Tabuleiro tabuleiro) {
        boolean turnoFinalizado = false;

        while (!turnoFinalizado) {
            System.out.println("=========================================");
            System.out.printf("=== RODADA %d / %d - VEZ DE: %s ===%n", rodadaAtual, maxRodadas, jogador.getNome());
            System.out.println("=========================================");
            System.out.printf("Posição Atual: %s%n", jogador.getPosicaoAtual().getImovel() != null ? jogador.getPosicaoAtual().getImovel().getNome() : "Casa Especial");
            System.out.printf("Saldo: R$ %.2f%n", jogador.getSaldo());
            System.out.println("--- O que você deseja fazer? ---");
            System.out.println("1. Lançar Dados e Mover");
            System.out.println("2. Ver Meu Status Completo (Saldo e Propriedades)");
            System.out.println("3. Propor Negociação com Outro Jogador");
            System.out.println("4. Ver Ranking de Jogadores");
            System.out.println("0. Desistir do Jogo");
            System.out.print(">> Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    lancarDadosEMover(jogador, scanner, tabuleiro);
                    turnoFinalizado = true;
                }
                case 2 -> verStatusCompleto(jogador);
                case 3 -> proporNegociacao(jogador, scanner);
                case 4 -> verRankingJogadores();
                case 0 -> {
                    System.out.printf("%s desistiu do jogo.%n", jogador.getNome());
                    jogador.setSaldo(0);
                    turnoFinalizado = true;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void lancarDadosEMover(Jogador jogador, Scanner scanner, Tabuleiro tabuleiro) {
        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int total = dado1 + dado2;

        System.out.printf("Você tirou %d e %d. Total: %d.%n", dado1, dado2, total);
        System.out.printf("Avançando %d casas...%n", total);

        moverJogador(jogador, total, tabuleiro);

        Node casaAtual = jogador.getPosicaoAtual();
        System.out.printf("Você parou em: '%s'.%n", casaAtual.getImovel() != null ? casaAtual.getImovel().getNome() : casaAtual.getTipo());

        if ("Imposto".equals(casaAtual.getTipo())) {
            double imposto = jogador.getSaldo() * 0.10;
            jogador.setSaldo(jogador.getSaldo() - imposto);
            System.out.printf("Você parou na casa de Imposto e pagou R$ %.2f.%n", imposto);
        } else if ("Restituição".equals(casaAtual.getTipo())) {
            double restituição = jogador.getSaldo() * 0.10;
            jogador.setSaldo(jogador.getSaldo() + restituição);
            System.out.printf("Você parou na casa de Restituição e recebeu R$ %.2f.%n", restituição);
        } else if (casaAtual.getImovel() != null) {
            Imovel imovel = casaAtual.getImovel();
            if (imovel.getProprietario() == null) {
                System.out.printf("O imóvel '%s' está disponível para compra por R$ %.2f.%n", imovel.getNome(), imovel.getPreco());
                System.out.print("Deseja comprá-lo? (s/n): ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("s") && jogador.getSaldo() >= imovel.getPreco()) {
                    jogador.setSaldo(jogador.getSaldo() - imovel.getPreco());
                    jogador.adicionarPropriedade(imovel);
                    imovel.setProprietario(jogador);
                    System.out.printf("Você comprou o imóvel '%s'.%n", imovel.getNome());
                } else if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("Saldo insuficiente para comprar este imóvel.");
                }
            } else if (!imovel.getProprietario().equals(jogador)) {
                double aluguel = imovel.getAluguel();
                if (jogador.getSaldo() >= aluguel) {
                    jogador.setSaldo(jogador.getSaldo() - aluguel);
                    imovel.getProprietario().setSaldo(imovel.getProprietario().getSaldo() + aluguel);
                    System.out.printf("Você pagou R$ %.2f de aluguel para %s.%n", aluguel, imovel.getProprietario().getNome());
                } else {
                    System.out.printf("Você não tem saldo suficiente para pagar o aluguel de R$ %.2f.%n", aluguel);
                    jogador.setSaldo(0);
                }
            }
        } else {
            System.out.println("Nada a fazer nesta casa.");
        }

        System.out.println("Pressione Enter para finalizar o turno...");
        scanner.nextLine();
    }

    private static void moverJogador(Jogador jogador, int dado, Tabuleiro tabuleiro) {
        Node posicaoAtual = jogador.getPosicaoAtual();
        Node inicio = tabuleiro.getInicio();

        for (int i = 0; i < dado; i++) {
            posicaoAtual = posicaoAtual.getProximo();
            if (posicaoAtual == inicio) {
                jogador.setSaldo(jogador.getSaldo() + salarioPorVolta);
                System.out.printf("%s completou uma volta e recebeu R$ %.2f de salário.%n", jogador.getNome(), salarioPorVolta);
            }
        }

        jogador.setPosicaoAtual(posicaoAtual);
        System.out.printf("%s agora está na casa: %s.%n", jogador.getNome(),
                posicaoAtual.getImovel() != null ? posicaoAtual.getImovel().getNome() : posicaoAtual.getTipo());
    }

    private static void verStatusCompleto(Jogador jogador) {
        System.out.printf("Jogador: %s%n", jogador.getNome());
        System.out.printf("Saldo: R$ %.2f%n", jogador.getSaldo());
        System.out.println("Propriedades:");
        for (Imovel imovel : jogador.getPropriedades()) {
            System.out.printf("- %s (Preço: R$ %.2f, Aluguel: R$ %.2f)%n", imovel.getNome(), imovel.getPreco(), imovel.getAluguel());
        }
    }

    private static void proporNegociacao(Jogador jogador, Scanner scanner) {
        System.out.println("--- Negociação ---");
        System.out.println("Jogadores disponíveis para negociação:");
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador outroJogador = jogadores.get(i);
            if (!outroJogador.equals(jogador) && outroJogador.getSaldo() > 0) {
                System.out.printf("%d. %s%n", i + 1, outroJogador.getNome());
            }
        }

        System.out.print("Escolha o número do jogador para negociar: ");
        int indiceJogador = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceJogador >= 0 && indiceJogador < jogadores.size() && !jogadores.get(indiceJogador).equals(jogador)) {
            Jogador outroJogador = jogadores.get(indiceJogador);

            System.out.println("--- Propriedades Disponíveis para Negociação ---");
            for (int i = 0; i < jogador.getPropriedades().size(); i++) {
                Imovel imovel = jogador.getPropriedades().get(i);
                System.out.printf("%d. %s (Preço: R$ %.2f)%n", i + 1, imovel.getNome(), imovel.getPreco());
            }

            System.out.print("Escolha o número da propriedade para negociar: ");
            int indicePropriedade = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indicePropriedade >= 0 && indicePropriedade < jogador.getPropriedades().size()) {
                Imovel imovel = jogador.getPropriedades().get(indicePropriedade);
                System.out.printf("Propriedade '%s' selecionada. Proponha um valor: R$ ", imovel.getNome());
                double valor = scanner.nextDouble();
                scanner.nextLine();

                System.out.printf("%s, você aceita pagar R$ %.2f por '%s'? (s/n): ", outroJogador.getNome(), valor, imovel.getNome());
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("s") && outroJogador.getSaldo() >= valor) {
                    outroJogador.setSaldo(outroJogador.getSaldo() - valor);
                    jogador.setSaldo(jogador.getSaldo() + valor);
                    outroJogador.adicionarPropriedade(imovel);
                    jogador.getPropriedades().remove(imovel);
                    System.out.printf("Negociação concluída! '%s' agora pertence a %s.%n", imovel.getNome(), outroJogador.getNome());
                } else {
                    System.out.println("Negociação recusada ou saldo insuficiente.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Jogador inválido.");
        }
    }

    private static void verRankingJogadores() {
        Collections.sort(jogadores, (j1, j2) -> Double.compare(calcularPatrimonio(j2), calcularPatrimonio(j1)));

        System.out.println("--- Ranking de Jogadores ---");
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);
            System.out.printf("%d. %s - Patrimônio: R$ %.2f%n", i + 1, jogador.getNome(), calcularPatrimonio(jogador));
        }
    }

    private static double calcularPatrimonio(Jogador jogador) {
        double patrimonio = jogador.getSaldo();
        for (Imovel imovel : jogador.getPropriedades()) {
            patrimonio += imovel.getPreco();
        }
        return patrimonio;
    }

    private static boolean verificarFimDeJogo() {
        int jogadoresAtivos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador != null && jogador.getSaldo() > 0) {
                jogadoresAtivos++;
            }
        }
        return jogadoresAtivos <= 1;
    }

    private static void reiniciarEstadoDoJogo() {
        rodadaAtual = 1;
        jogadores.clear();
        imoveis.clear();
    }

    private static void exibirFimDeJogo(String motivo) {
        System.out.println("=========================================");
        System.out.println("======          FIM DE JOGO!         ======");
        System.out.println("=========================================");
        System.out.printf("Motivo do término: %s%n", motivo);
        System.out.println("--- Ranking Final ---");
        verRankingJogadores();
        System.out.println("--- O que deseja fazer? ---");
        System.out.println("1. Jogar Novamente (com as mesmas configurações)");
        System.out.println("2. Voltar ao Menu Principal (para novas configurações)");
        System.out.println("0. Encerrar Programa");

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao < 0 || opcao > 2) {
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Digite um número entre 0 e 2.");
                scanner.nextLine();
            }
        }

        switch (opcao) {
            case 1 -> {
                reiniciarEstadoDoJogo();
                iniciarJogo(scanner);
            }
            case 2 -> {
                reiniciarEstadoDoJogo();
                Main.main(null);
            }
            case 0 -> System.out.println("Encerrando o programa. Até a próxima!");
        }
    }
}