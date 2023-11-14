package View;

import ServicoModel.Plano;
import ServicoModel.Produto;
import UsuarioModel.Administrador;
import UsuarioModel.Cliente;

import java.util.*;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> usuariosCadastrados;
    static ArrayList<Administrador> administradores;
    static ArrayList<Produto> produtosCadastrados;
    static ArrayList<Plano> sucessPlans;



    public static void main(String[] args) {
        usuariosCadastrados = new ArrayList<>();

        administradores = new ArrayList<>(List.of(
                new Administrador(554166, "554166", "fiap1", "Ana Janeth", "rm554166@fiap.com.br"),
                new Administrador(553635, "553635", "fiap2", "Gabriel Torres", "rm553635@fiap.com.br"),
                new Administrador(553427, "553427", "fiap3", "Julia Gonzalez", "rm553427@fiap.com.br")
        ));

        produtosCadastrados = new ArrayList<>(List.of(
                new Produto("Sales Cloud", 123121, "Venda mais rápido e com mais inteligência com qualquer uma das nossas edições de CRM totalmente personalizáveis.", new ArrayList<>(List.of(
                        new Plano("Starter", "Ferramentas de vendas e atendimento ao cliente em um app", 41, 25),
                        new Plano("Sales Professional", "Solução de vendas completa para equipes de qualquer tamanho", 42, 80),
                        new Plano("Enterprise", "CRM de vendas altamente personalizável para o seu negócio", 43, 165),
                        new Plano("Unlimited", "A plataforma definitiva para seu crescimento", 44, 330)
                ))),
                new Produto("Service Cloud", 123122, "Deixe seus clientes mais satisfeitos usando todas as funções da melhor plataforma de Atendimento.",  new ArrayList<>(List.of(
                        new Plano("Starter", "O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas", 51, 25),
                        new Plano("Professional", "Solução completa de atendimento ao cliente para equipes de qualquer tamanho", 52, 80),
                        new Plano("Enterprise", "CRM personalizável para atendimento abrangente", 53, 150),
                        new Plano("Unlimited", "Recursos ilimitados de CRM", 54, 300)
                ))),
                new Produto("MuleSoft Automation", 123123, "Combine o poder do MuleSoft RPA, MuleSoft Composer e Anypoint Platform para ajudar as equipes a automatizar.", new ArrayList<>(List.of(
                        new Plano("MuleSoft Automation", "Capacite suas equipes para fazer mais, com menos.", 61, 4750)
                ))),
                new Produto("MuleSoft Composer", 123124, "Conecte facilmente aplicativos e dados ao Salesforce com cliques, não com código. Selecione um nível de assinatura que atenda às suas necessidades e dimensione suas integrações adicionando tarefas adicionais conforme necessário.",  new ArrayList<>(List.of(
                        new Plano("Starter", "Desbloqueie seus aplicativos e conecte o Salesforce a três sistemas compatíveis.", 71, 2250),
                        new Plano("Plus", "Conecte o Salesforce a um número ilimitado de sistemas suportados.", 72, 4750)
                )))
        ));

        sucessPlans = new ArrayList<>(List.of(
                new Plano("Standard", "Explore recursos autoguiados, como aprendizado online, demonstrações e conselhos da comunidade. Incluído em todas as licenças", "Trailhead, Portal de Ajuda, Comunidade de Trailblazers, Success Center, Suporte Técnico", 1),
                new Plano("Premier", "Obtenha ajuda especializada adicional, orientação de adoção, treinamento e suporte ao vivo. 30% das taxas de licença aplicáveis", "Trailhead, Portal de Ajuda, Comunidade de Trailblazers, Success Center, Suporte Técnico", 2),
                new Plano("Signature", "Adicione gerenciamento proativo de conta e de incidentes, prontidão para eventos e muito mais.", "Trailhead, Portal de Ajuda, Comunidade de Trailblazers, Success Center, Suporte Técnico, Serviços Proativos, Gerenciamento Técnico de Conta, Gerenciamento de Eventos-Chave", 3)
        ));


        while (true) {
            System.out.println("""
                    \r
                    Bem vindo ao sistema da SalesForce, digite a opção desejada:\r
                    1) Usuário \r
                    2) Adminitrador \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> abrirMenuCliente();
                case 2 -> verificarAdministrador();
                case 0 -> {
                    System.out.println("Encerrando sistema;");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");

            }
        }

    }

    public static Optional<Cliente> verificarUsuario(){
        System.out.println("Digite seu nome de usuário");
        var nomeUsuario = scanner.nextLine();

        System.out.println("Digite sua senha");
        var senha = scanner.nextLine();

        return usuariosCadastrados.stream()
                .filter(pessoa-> pessoa.getNomeUsuario().equals(nomeUsuario) & pessoa.getSenha().equals(senha)).findAny();
    }

    public static void abrirMenuCliente() {

        while (true) {
            System.out.println("""
                    \r
                    Bem vindo ao sistema da SalesForce, digite a opção desejada:\r
                    1) Criar conta \r
                        11) Editar informações de cadastro \r
                    2) Consultar produto \r
                        21) Filtrar planos de pagamento por preço mais caro \r
                        22) Filtrar planos de pagamento por preço mais barato \r
                    3) Enviar perguntas ou comentários \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarConta();
                case 11 -> editarInformacoesCadastro();
                case 2 -> consultarProduto();
                case 21 -> filtrarPlanosPagamentoPrecoDecrescente();
                case 22 -> filtrarPlanosPagamentoPrecoCrescente();
                case 3 -> enviarPerguntasComentarios();
                case 0 -> {
                    System.out.println("Encerrando sistema;");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public static void verificarAdministrador() {

        System.out.println("Digite seu nome de usuário: ");
        var nomeUsuarioAdm = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        var senhaAdm = scanner.nextLine();

        Optional<Administrador> optional = administradores.stream()
                .filter(pessoa -> pessoa.getNomeUsuario().equals(nomeUsuarioAdm) & pessoa.getSenha().equals(senhaAdm)).findAny();
        optional.ifPresent(System.out::println);

        if (optional.isPresent()) {
            System.out.println("Abrindo menu...");
            abrirMenuAdministrador();
        } else {
            System.out.println("Usuário ou senha inválidos");
        }
    }
    public static void abrirMenuAdministrador() {

        while (true) {
            System.out.println("""
                    \r
                    Bem vindo ao sistema da SalesForce, digite a opção desejada:\r
                    1) Cadastrar usuário \r
                        11) Editar informações de cadastro \r
                        12) Listar usuários cadastrados \r
                        13) Filtrar usuários por país \r
                    2) Cadastrar produto\r
                        21) Editar informações do produto \r
                    3) Cadastrar plano de pagamento\r
                        31) Editar informações dos planos de pagamento \r
                    4) Cadastrar sucessplan \r
                        41) Editar informações dos sucessplans  \r
                    5) Consultar produto \r
                        51) Filtrar planos de pagamento por preço mais caro \r
                        52) Filtrar planos de pagamento por preço mais barato \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> criarConta();
                case 11 -> editarInformacoesCadastro();
                case 12 -> listarUsuarios();
                case 13 -> filtrarUsuariosPais();
                case 2 -> cadastrarProduto();
                case 21 -> editarInformacoesProduto();
                case 3 -> cadastrarPlanoPagamento();
                case 31 -> editarInformacoesPlanoPagamento();
                case 4 -> cadastrarSucessPlan();
                case 41 -> editarInformacoesSucessPlan();
                case 5 -> consultarProduto();
                case 51 -> filtrarPlanosPagamentoPrecoDecrescente();
                case 52 -> filtrarPlanosPagamentoPrecoCrescente();
                case 0 -> {
                    System.out.println("Você esta sendo deslogado. \r\nEncerrando sistema...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }


    public static void editarInformacoesCadastro(){
        System.out.println("Digite seu nome de usuário");
        var nomeUsuario = scanner.nextLine();

        System.out.println("Digite sua senha");
        var senha = scanner.nextLine();

        Optional<Cliente> optional = usuariosCadastrados.stream()
                .filter(pessoa-> pessoa.getNomeUsuario().equals(nomeUsuario) & pessoa.getSenha().equals(senha)).findAny();
        optional.ifPresent(System.out::println);

        if (optional.isPresent()) {

            System.out.println("Digite informação a ser editada:");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]","a").replaceAll("[í,ì]","i").replaceAll("[é,è]","e");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite seu nome atualizado:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setNomeCompleto(atualizacao));

                System.out.println("\r\nSeu nome foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("telefone")) {
                System.out.println("Digite o telefone atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setTelefone(atualizacao));

                System.out.println("\r\nSeu telefone foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("empresa")) {
                System.out.println("Digite a empresa atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setEmpresa(atualizacao));

                System.out.println("\r\nSua empresa foi alterada com sucesso");

            }

            else if (informacao.equalsIgnoreCase("cargo")) {
                System.out.println("Digite o cargo atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setCargo(atualizacao));

                System.out.println("\r\nSeu cargo foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("segmento")) {
                System.out.println("Digite o segmento atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setSegmento(atualizacao));

                System.out.println("\r\nSeu segmento foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("tamanho da empresa")) {
                System.out.println("Digite o tamano atual da empresa:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setTamanhoEmpresa(atualizacao));

                System.out.println("\r\nO tamanho da empresa foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("pais")) {
                System.out.println("Digite o país atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setPais(atualizacao));

                System.out.println("\r\nSeu país foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("email corporativo")) {
                System.out.println("Digite o email atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setEmailCorporativo(atualizacao));

                System.out.println("\r\nSeu email foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("nome de usuario")) {
                System.out.println("Digite o nome de usuário atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setNomeUsuario(atualizacao));

                System.out.println("\r\nSeu nome de usuário foi alterado com sucesso");

            }

            else if (informacao.equalsIgnoreCase("senha")) {
                System.out.println("Digite a senha atual:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setSenha(atualizacao));

                System.out.println("\r\nSua senha foi alterada com sucesso");

            }

            else {
                System.out.println("Opção inválida");
            }

        }

        else {
            System.out.println("Nome de usuário ou senha inválida");
        }

    }
    public static void editarInformacoesProduto(){
        System.out.println("Digite o id do produto");
        var editarIdProduto = scanner.nextInt();
        scanner.nextLine();

        Optional<Produto> optional = produtosCadastrados.stream()
                .filter(item -> item.getIdProduto() == (editarIdProduto)).findAny();
        System.out.println(optional);
        //Verificar System.out.println(optional);


        if (optional.isPresent()) {

            System.out.println("Digite informação a ser editada: ");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e").replaceAll("ç", "c");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite o nome atualizado:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getIdProduto() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setNomeProduto(atualizacao));

                System.out.println("\r\nO nome foi alterado com sucesso");


            } else if (informacao.equalsIgnoreCase("descricao")) {
                System.out.println("Digite a descrição atual:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getIdProduto() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setDescricaoProduto(atualizacao));

                System.out.println("\r\nA descrição foi alterada com sucesso");

            } else if (informacao.equalsIgnoreCase("id")) {
                System.out.println("Digite o ID atual:");
                var atualizacao = (scanner.nextInt());
                scanner.nextLine();

                produtosCadastrados.stream()
                        .filter(produto -> produto.getIdProduto() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setIdProduto(atualizacao));

                System.out.println("\r\nO ID foi alterado com sucesso");

            } else {
                System.out.println("Opção inválida");
            }

        } else {
            System.out.println("ID inválido");
        }
    }
    public static void editarInformacoesPlanoPagamento(){
        System.out.println("Digite o id do plano: ");
        var buscaIdPlano = scanner.nextInt();
        scanner.nextLine();

        Optional<Plano> optional = produtosCadastrados.stream()
                .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano)).findAny();
        System.out.println(optional);

        if (optional.isPresent()) {
            System.out.println("Digite informação a ser editada: ");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e").replaceAll("ç", "c");

            if (informacao.equalsIgnoreCase("nome")) {

                System.out.println("Digite o nome atualizado:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano))
                        .forEach(plano -> plano.setNomePlano(atualizacao));
            }
            else if (informacao.equalsIgnoreCase("id")) {
                System.out.println("Digite o id atual do plano: ");
                var atualizacao = scanner.nextInt();
                scanner.nextLine();

                produtosCadastrados.stream()
                        .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano))
                        .forEach(plano -> plano.setIdPlano(atualizacao));
            }
            else if (informacao.equalsIgnoreCase("descricao")) {
                System.out.println("Digite a descrição atual:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano))
                        .forEach(plano -> plano.setDescricaoPlano(atualizacao));
            }
            else if (informacao.equalsIgnoreCase("recursos")) {
                System.out.println("Digite os recursos atuais:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano))
                        .forEach(plano -> plano.setRecursosPlano(atualizacao));
            }
            else if (informacao.equalsIgnoreCase("preco")) {
                System.out.println("Digite o preço atual:");
                var atualizacao = (scanner.nextFloat());
                scanner.nextLine();

                produtosCadastrados.stream()
                        .flatMap(produto -> produto.getPlanoPagamento().stream().filter(plano -> plano.getIdPlano() == buscaIdPlano))
                        .forEach(plano -> plano.setPrecoPlano(atualizacao));
            }
            else {
                System.out.println("Opção inválida");
            }
        }
        else {
            System.out.println("ID inválido");
        }

    }
    public static void editarInformacoesSucessPlan(){
        System.out.println("Digite o id do plano");
        var editarIdPlano = scanner.nextInt();
        scanner.nextLine();

        Optional<Plano> optional = sucessPlans.stream()
                .filter(item -> item.getIdPlano() == (editarIdPlano)).findAny();


        if (optional.isPresent()) {
            sucessPlans.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(System.out::println);

            System.out.println("Digite informação a ser editada:");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite o nome atualizado:");
                var atualizacao = (scanner.nextLine());

                sucessPlans.stream()
                        .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setNomePlano(atualizacao));

                System.out.println("\r\nO nome foi alterado com sucesso");


            } else if (informacao.equalsIgnoreCase("descrição")) {
                System.out.println("Digite a descrição atual:");
                var atualizacao = (scanner.nextLine());

                sucessPlans.stream()
                        .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setDescricaoPlano(atualizacao));

                System.out.println("\r\nA descrição foi alterada com sucesso");

            } else if (informacao.equalsIgnoreCase("recursos")) {
                System.out.println("Digite os recursos atuais:");
                var atualizacao = (scanner.nextLine());

                sucessPlans.stream()
                        .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setRecursosPlano(atualizacao));

                System.out.println("\r\nOs recursos foram alterados com sucesso");

            } else if (informacao.equalsIgnoreCase("id")) {
                System.out.println("Digite o ID atual:");
                var atualizacao = (scanner.nextInt());
                scanner.nextLine();

                sucessPlans.stream()
                        .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setIdPlano(atualizacao));

                System.out.println("\r\nO ID foi alterado com sucesso");

            } else if (informacao.equalsIgnoreCase("preço")) {
                System.out.println("Digite o preço atual:");
                var atualizacao = (scanner.nextFloat());
                scanner.nextLine();

                sucessPlans.stream()
                        .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setPrecoPlano(atualizacao));

                System.out.println("\r\nO preço foi alterado com sucesso");

            } else {
                System.out.println("Opção inválida");
            }

        } else {
            System.out.println("ID inválido");
        }

    }

    public static void criarConta() {
        var novoUsuario = new Cliente();

        System.out.println("\r\nIniciando o cadastro de usuário");

        System.out.println("Nome completo: ");
        novoUsuario.setNomeCompleto(scanner.nextLine());

        System.out.println("Telefone: ");
        novoUsuario.setTelefone(scanner.nextLine());

        System.out.println("Empresa: ");
        novoUsuario.setEmpresa(scanner.nextLine());

        System.out.println("Cargo: ");
        novoUsuario.setCargo(scanner.nextLine());

        System.out.println("Segmento: ");
        novoUsuario.setSegmento(scanner.nextLine());

        System.out.println("Tamanho da empresa: ");
        novoUsuario.setTamanhoEmpresa(scanner.nextLine());

        System.out.println("País: ");
        novoUsuario.setPais(scanner.nextLine());

        System.out.println("Email corporativo: ");
        novoUsuario.setEmailCorporativo(scanner.nextLine());

        System.out.println("Nome de usuário: ");
        novoUsuario.setNomeUsuario(scanner.nextLine());

        System.out.println("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());

        usuariosCadastrados.add(novoUsuario);

        System.out.println("\r\nUsuário registrado com sucesso");


    }
    public static void criarContaComPergunta() {
        var novoUsuario = new Cliente();

        System.out.println("\r\nIniciando o cadastro de usuário");

        System.out.println("Nome completo: ");
        novoUsuario.setNomeCompleto(scanner.nextLine());

        System.out.println("Telefone: ");
        novoUsuario.setTelefone(scanner.nextLine());

        System.out.println("Empresa: ");
        novoUsuario.setEmpresa(scanner.nextLine());

        System.out.println("Cargo: ");
        novoUsuario.setCargo(scanner.nextLine());

        System.out.println("Segmento: ");
        novoUsuario.setSegmento(scanner.nextLine());

        System.out.println("Tamanho da empresa: ");
        novoUsuario.setTamanhoEmpresa(scanner.nextLine());

        System.out.println("País: ");
        novoUsuario.setPais(scanner.nextLine());

        System.out.println("Email corporativo: ");
        novoUsuario.setEmailCorporativo(scanner.nextLine());

        System.out.println("Nome de usuário: ");
        novoUsuario.setNomeUsuario(scanner.nextLine());

        System.out.println("Senha: ");
        novoUsuario.setSenha(scanner.nextLine());

        System.out.println("Pergunta: ");
        novoUsuario.setPerguntasOuComentarios(scanner.nextLine());

        usuariosCadastrados.add(novoUsuario);

        System.out.println("\r\nUsuário registrado com sucesso");


    }
    public static void cadastrarProduto(){
        var novoProduto = new Produto();

        System.out.println("\r\nIniciando o cadastro de produto");

        System.out.println("Nome: ");
        novoProduto.setNomeProduto(scanner.nextLine());

        System.out.println("Descrição: ");
        novoProduto.setDescricaoProduto(scanner.nextLine());

        System.out.println("ID: ");
        novoProduto.setIdProduto(scanner.nextInt());
        scanner.nextLine();

        novoProduto.setPlanoPagamento(cadastrarPlanoPagamento());

        produtosCadastrados.add(novoProduto);

        System.out.println("\r\nProduto cadastrado com sucesso");
    }
    public static List<Plano> cadastrarPlanoPagamento(){
        var novoPlano = new Plano();

        System.out.println("Nome do Plano de Pagamento: ");
        novoPlano.setNomePlano(scanner.nextLine());

        System.out.println("Descrição do Plano de Pagamento: ");
        novoPlano.setDescricaoPlano(scanner.nextLine());

        System.out.println("Recursos do Plano de Pagamento: ");
        novoPlano.setRecursosPlano(scanner.nextLine());

        System.out.println("ID do Plano de Pagamento: ");
        novoPlano.setIdPlano(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Preço do Plano de Pagamento: ");
        novoPlano.setPrecoPlano(scanner.nextFloat());
        scanner.nextLine();

        return new ArrayList<>(List.of(novoPlano));
    }
    public static void cadastrarSucessPlan(){
        var novoPlano = new Plano();

        System.out.println("\r\nIniciando o cadastro de plano");

        System.out.println("Nome: ");
        novoPlano.setNomePlano(scanner.nextLine());

        System.out.println("Descrição: ");
        novoPlano.setDescricaoPlano(scanner.nextLine());

        System.out.println("Recursos: ");
        novoPlano.setRecursosPlano(scanner.nextLine());

        System.out.println("ID: ");
        novoPlano.setIdPlano(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Preço: ");
        novoPlano.setPrecoPlano(scanner.nextFloat());
        scanner.nextLine();

        sucessPlans.add(novoPlano);

        System.out.println("\r\nPlano cadastrado com sucesso");

    }

    public static void consultarProduto(){


        System.out.println("Digite o nome ou ID do produto:");
        String buscaproduto = scanner.nextLine();

        if (produtosCadastrados.stream().anyMatch(produto -> produto.getNomeProduto().equalsIgnoreCase(buscaproduto) || Integer.toString(produto.getIdProduto()).equals(buscaproduto))) {
            produtosCadastrados.stream()
                    .filter(produto -> produto.getNomeProduto().equalsIgnoreCase(buscaproduto) || Integer.toString(produto.getIdProduto()).equals(buscaproduto))
                    .forEach(System.out::println);
        }

        else {
            System.out.println("Nome ou ID inválidos");
        }


    }
    public static void listarUsuarios(){
        usuariosCadastrados.stream().toList().forEach(System.out::println);
        System.out.println("Numero de usuários cadastrados é de: " + usuariosCadastrados.stream().toList().size());
    }
    public static void filtrarPlanosPagamentoPrecoCrescente(){
        produtosCadastrados.stream()
                .flatMap(produto -> produto.getPlanoPagamento().stream())
                .sorted(Comparator.comparingDouble(Plano::getPrecoPlano))
                .forEach(System.out::println);
    }
    public static void filtrarPlanosPagamentoPrecoDecrescente(){

        produtosCadastrados.stream()
                .flatMap(produto -> produto.getPlanoPagamento().stream())
                .sorted(Comparator.comparingDouble(Plano::getPrecoPlano).reversed())
                .forEach(System.out::println);
    }
    public static void filtrarUsuariosPais(){

        System.out.println("\r\nFiltrar usuários pelo País: ");
        var buscaPais = (scanner.nextLine());

        System.out.println("Numero de usuário do(a) " + buscaPais + " é de: " + usuariosCadastrados.stream()
                .filter(pessoa -> pessoa.getPais().equalsIgnoreCase(buscaPais)).count());

        usuariosCadastrados.stream()
                .filter(pessoa -> pessoa.getPais().equalsIgnoreCase(buscaPais)).toList()
                .forEach(System.out::println);
    }

    public void adicionarAoCarrinho(Produto produto, List<Produto> carrinho) {
        if (verificarUsuario().isPresent()) {
            carrinho.add(produto);
            System.out.println("Produto adicionado ao carrinho");

        }else {System.out.println("Para adicionar itens ao carrinho é necessário criar uma conta");
            criarConta();
        }
    }
    //editar metodo verificarUsuario()

    public static void enviarPerguntasComentarios(){

        System.out.println("Para enviar sua pergunta ou comentário é necessario fazer o cadastro. \r\nSe você já possui um cadastro digite sim, caso contrario digite não");
        var simnao = (scanner.nextLine()).replaceAll("[áàâãä]", "a");

        if (simnao.equalsIgnoreCase("sim")) {
            var verificarUsuario = verificarUsuario();

            if (verificarUsuario.isPresent()) {
                System.out.println("Digite sua pergunta");
                var pergunta = (scanner.nextLine());
                verificarUsuario.ifPresent(c ->c.setPerguntasOuComentarios(pergunta));

                System.out.println("\r\nSua pergunta foi registrada com sucesso, sua resposta será enviada por e-mail dentro de 24h");
            }
            else {
                System.out.println("Usuário ou senha inválidos");
            }

        }
        else if (simnao.equalsIgnoreCase("nao")) {
            criarContaComPergunta();
            System.out.println("\r\nSua pergunta foi registrada com sucesso, sua resposta será enviada por e-mail dentro de 24h");
        }
        else {
            System.out.println("Resposta inválida");
        }
    }

}



