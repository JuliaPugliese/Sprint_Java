package View;

import ServicoModel.Plano;
import ServicoModel.Produto;
import ServicoModel.Servico;
import UsuarioModel.Administrador;
import UsuarioModel.Cliente;

import java.util.*;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> usuariosCadastrados;
    static ArrayList<Produto> produtosCadastrados;
    static ArrayList<Plano> planosCadastrados;
    static ArrayList<Administrador> administradores;


    public static void main(String[] args) {
        usuariosCadastrados = new ArrayList<Cliente>();
        produtosCadastrados = new ArrayList<Produto>(List.of(
                new Produto("MuleSoft Automation", "Combine o poder do MuleSoft RPA, MuleSoft Composer e Anypoint Platform para ajudar as equipes a automatizar.", "Integração com Salesforce. Conectores incluídos. Créditos adicionais de automação", 122263, 57000, "Automação do processo"),
                new Produto("MuleSoft Composer", "starter", "Desbloqueie seus aplicativos e conecte o Salesforce a três sistemas compatíveis.", "Integração com Salesforce. Implantação em Cloud. Tarefas de Integração", 122212, 27000, "Crie integrações dentro da UI do Salesforce — sem necessidade de código.")
        ));
        planosCadastrados = new ArrayList<Plano>(List.of(
                new Plano("Service Cloud", "Starter", "O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas", 122698, 25),
                new Plano("Service Cloud", "Professional", "Solução completa de atendimento ao cliente para equipes de qualquer tamanho", 125568, 80),
                new Plano("Service Cloud", "Enterprise", "CRM personalizável para atendimento abrangente", 124898, 150),
                new Plano("Service Cloud", "Unlimited", "Recursos ilimitados de CRM", 145998, 300)
        ));

        administradores = new ArrayList<Administrador>(List.of(
                new Administrador(554166, "554166", "fiap1", "Ana Janeth", "rm554166@fiap.com.br"),
                new Administrador(553635, "553635", "fiap2", "Gabriel Torres", "rm553635@fiap.com.br"),
                new Administrador(553427, "553427", "fiap3", "Julia Gonzalez", "rm553427@fiap.com.br")
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

            if (opcao == 0) {
                System.out.println("Encerrando sistema;");
                break;
            } else if (opcao == 1) {
                abrirMenuCliente();
            } else if (opcao == 2) {
                verificarAdministrador();
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
                    2) Consultar produto ou plano \r
                        21) Filtrar produtos e planos por preço mais caro \r
                        22) Filtrar produtos e planos por preço mais barato \r
                    3) Enviar perguntas ou comentários \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando sistema;");
                break;
            }
            else if (opcao == 1) {
                criarConta();
            }
            else if (opcao == 11) {
                editarInformacoesCadastro();
            }
            else if (opcao == 2) {
                consultarProdutoPlano();
            }
            else if (opcao == 21) {
                filtrarProdutosPlanosPrecoDecrescente();
            }
            else if (opcao == 22) {
                filtrarProdutosPlanosPrecoCrescente();
            }
            else if (opcao == 3) {
                enviarPerguntasComentarios();
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

        if (optional.isPresent()) {
            administradores.stream()
                    .filter(pessoa -> pessoa.getNomeUsuario().equals(nomeUsuarioAdm) & pessoa.getSenha().equals(senhaAdm)).toList()
                    .forEach(System.out::println);
            System.out.println("Abrindo menu");
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
                        12) Filtrar usuários por país \r
                    2) Cadastrar produto\r
                        21) Editar informações do produto \r
                    3) Cadastrar plano \r
                        31) Editar informações do plano \r
                    4) Consultar produto ou plano \r
                        41) Filtrar produtos e planos por preço mais caro \r
                        42) Filtrar produtos e planos por preço mais barato \r
                    0) Sair""");

            var opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 0) {
                System.out.println("Encerrando sistema;");
                break;
            }
            else if (opcao == 1) {
                criarConta();
            }
            else if (opcao == 11) {
                editarInformacoesCadastro();
            }
            else if (opcao == 12) {

                System.out.println("\r\n");
                System.out.println("Filtrar usuários pelo País: ");
                var buscaPais = (scanner.nextLine());

                System.out.println("Numero de usuário do(a) " + buscaPais + " é de: " + usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getPais().equalsIgnoreCase(buscaPais)).count());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getPais().equalsIgnoreCase(buscaPais)).toList()
                        .forEach(System.out::println);

            }
            else if (opcao == 2) {
                cadastrarProduto();
            }
            else if (opcao == 21) {
                editarInformacoesProduto();
            }
            else if (opcao == 3) {
                cadastrarPlano();
            }
            else if (opcao == 31) {
                editarInformacoesPlano();
            }
            else if (opcao == 4) {
                consultarProdutoPlano();
            }
            else if (opcao == 41) {
                filtrarProdutosPlanosPrecoCrescente();
            }
            else if (opcao == 42) {
                filtrarProdutosPlanosPrecoDecrescente();
            }
        }


    }

    public static void editarInformacoesProduto(){
        System.out.println("Digite o id do produto");
        var editarIdProduto = scanner.nextInt();
        scanner.nextLine();

        Optional<Produto> optional = produtosCadastrados.stream()
                .filter(item -> item.getId() == (editarIdProduto)).findAny();


        if (optional.isPresent()) {

            produtosCadastrados.stream()
                    .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                    .forEach(System.out::println);

            System.out.println("Digite informação a ser editada: ");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite o nome atualizado:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setNome(atualizacao));

                System.out.println("\r\nO nome foi alterado com sucesso");

                //TESTE ALTERAÇÃO DO NOME

                produtosCadastrados.stream()
                        .filter(produto -> produto.getNome().equals(atualizacao)).toList()
                        .forEach(System.out::println);
            } else if (informacao.equalsIgnoreCase("descrição")) {
                System.out.println("Digite a descrição atual:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setDescricao(atualizacao));

                System.out.println("\r\nA descrição foi alterada com sucesso");

            } else if (informacao.equalsIgnoreCase("recursos")) {
                System.out.println("Digite os recursos atuais:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setRecursos(atualizacao));

                System.out.println("\r\nOs recursos foram alterados com sucesso");

            } else if (informacao.equalsIgnoreCase("id")) {
                System.out.println("Digite o ID atual:");
                var atualizacao = (scanner.nextInt());
                scanner.nextLine();

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setId(atualizacao));

                System.out.println("\r\nO ID foi alterado com sucesso");

            } else if (informacao.equalsIgnoreCase("preço")) {
                System.out.println("Digite o preço atual:");
                var atualizacao = (scanner.nextFloat());
                scanner.nextLine();

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setPreco(atualizacao));

                System.out.println("\r\nO preço foi alterado com sucesso");

            } else if (informacao.equalsIgnoreCase("funcionalidades")) {
                System.out.println("Digite as funcionalidades atuais:");
                var atualizacao = (scanner.nextLine());

                produtosCadastrados.stream()
                        .filter(produto -> produto.getId() == (editarIdProduto)).toList()
                        .forEach(produto -> produto.setFuncionalidades(atualizacao));

                System.out.println("\r\nAs funcionalidades foram alteradas com sucesso");

            } else {
                System.out.println("Opção inválida");
            }

        } else {
            System.out.println("ID inválido");
        }
    }
    public static void editarInformacoesPlano(){
        System.out.println("Digite o id do plano");
        var editarIdPlano = scanner.nextInt();
        scanner.nextLine();

        Optional<Plano> optional = planosCadastrados.stream()
                .filter(item -> item.getId() == (editarIdPlano)).findAny();


        if (optional.isPresent()) {

            planosCadastrados.stream()
                    .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                    .forEach(System.out::println);

            System.out.println("Digite informação a ser editada:");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite o nome atualizado:");
                var atualizacao = (scanner.nextLine());

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setNome(atualizacao));

                System.out.println("\r\nO nome foi alterado com sucesso");

                //TESTE ALTERAÇÃO DO NOME

                planosCadastrados.stream()
                        .filter(plano -> plano.getNome().equals(atualizacao)).toList()
                        .forEach(System.out::println);
            } else if (informacao.equalsIgnoreCase("descrição")) {
                System.out.println("Digite a descrição atual:");
                var atualizacao = (scanner.nextLine());

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setDescricao(atualizacao));

                System.out.println("\r\nA descrição foi alterada com sucesso");

            } else if (informacao.equalsIgnoreCase("recursos")) {
                System.out.println("Digite os recursos atuais:");
                var atualizacao = (scanner.nextLine());

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setRecursos(atualizacao));

                System.out.println("\r\nOs recursos foram alterados com sucesso");

            } else if (informacao.equalsIgnoreCase("id")) {
                System.out.println("Digite o ID atual:");
                var atualizacao = (scanner.nextInt());
                scanner.nextLine();

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setId(atualizacao));

                System.out.println("\r\nO ID foi alterado com sucesso");

            } else if (informacao.equalsIgnoreCase("preço")) {
                System.out.println("Digite o preço atual:");
                var atualizacao = (scanner.nextFloat());
                scanner.nextLine();

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setPreco(atualizacao));

                System.out.println("\r\nO preço foi alterado com sucesso");

            } else if (informacao.equalsIgnoreCase("edição")) {
                System.out.println("Digite o nome da edição atual:");
                var atualizacao = (scanner.nextLine());

                planosCadastrados.stream()
                        .filter(plano -> plano.getId() == (editarIdPlano)).toList()
                        .forEach(plano -> plano.setEdicao(atualizacao));

                System.out.println("\r\nAs funcionalidades foram alteradas com sucesso");

            } else {
                System.out.println("Opção inválida");
            }

        }
        else {
            System.out.println("ID inválido");
        }

    }
    public static void editarInformacoesCadastro(){
        System.out.println("Digite seu nome de usuário");
        var nomeUsuario = scanner.nextLine();

        System.out.println("Digite sua senha");
        var senha = scanner.nextLine();

        Optional<Cliente> optional = usuariosCadastrados.stream()
                .filter(pessoa-> pessoa.getNomeUsuario().equals(nomeUsuario) & pessoa.getSenha().equals(senha)).findAny();


        if (optional.isPresent()) {

            usuariosCadastrados.stream()
                    .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                    .forEach(System.out::println);

            System.out.println("Digite informação a ser editada:");
            var informacao = (scanner.nextLine()).replaceAll("[áàâãä]","a").replaceAll("[í,ì]","i").replaceAll("[é,è]","e");

            if (informacao.equalsIgnoreCase("nome")) {
                System.out.println("Digite seu nome atualizado:");
                var atualizacao = (scanner.nextLine());

                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeUsuario().equalsIgnoreCase(nomeUsuario)).toList()
                        .forEach(pessoa -> pessoa.setNomeCompleto(atualizacao));

                System.out.println("\r\nSeu nome foi alterado com sucesso");

                //TESTE ALTERAÇÃO DO NOME
                usuariosCadastrados.stream()
                        .filter(pessoa -> pessoa.getNomeCompleto().equalsIgnoreCase(atualizacao)).toList()
                        .forEach(System.out::println);
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

    public void adicionarAoCarrinho(Servico servico, List<Servico> carrinho) {
        if (verificarUsuario().isPresent()) {
            carrinho.add(servico);
            System.out.println("Produto adicionado ao carrinho");

        }else {System.out.println("Para adicionar itens ao carrinho é necessário criar uma conta");
            criarConta();
        }
    }
    //editar metodo verificarUsuario()

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
        novoProduto.setNome(scanner.nextLine());

        System.out.println("Descrição: ");
        novoProduto.setDescricao(scanner.nextLine());

        System.out.println("Recursos: ");
        novoProduto.setRecursos(scanner.nextLine());

        System.out.println("ID: ");
        novoProduto.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Preço: ");
        novoProduto.setPreco(scanner.nextFloat());
        scanner.nextLine();

        System.out.println("Edição: ");
        novoProduto.setEdicao(scanner.nextLine());

        System.out.println("Funcionalidades: ");
        novoProduto.setFuncionalidades(scanner.nextLine());

        produtosCadastrados.add(novoProduto);

        System.out.println("\r\nProduto cadastrado com sucesso");
    }
    public static void cadastrarPlano(){
        var novoPlano = new Plano();

        System.out.println("\r\nIniciando o cadastro de produto");

        System.out.println("Nome: ");
        novoPlano.setNome(scanner.nextLine());

        System.out.println("Descrição: ");
        novoPlano.setDescricao(scanner.nextLine());

        System.out.println("Recursos: ");
        novoPlano.setRecursos(scanner.nextLine());

        System.out.println("Edição: ");
        novoPlano.setEdicao(scanner.nextLine());

        System.out.println("ID: ");
        novoPlano.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Preço: ");
        novoPlano.setPreco(scanner.nextFloat());
        scanner.nextLine();

        planosCadastrados.add(novoPlano);

        System.out.println("\r\nProduto cadastrado com sucesso");

    }

    public static void consultarProdutoPlano(){

        System.out.println("Digite o nome do produto ou plano desejado");
        var buscaproduto = scanner.nextLine();

        produtosCadastrados.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(buscaproduto)).toList()
                .forEach(System.out::println);
        planosCadastrados.stream()
                .filter(plano -> plano.getNome().equalsIgnoreCase(buscaproduto)).toList()
                .forEach(System.out::println);
    }
    public static void filtrarProdutosPlanosPrecoCrescente(){

        planosCadastrados.sort(Comparator.comparingDouble(Plano::getPreco));
        System.out.println(planosCadastrados);
        produtosCadastrados.sort(Comparator.comparingDouble(Produto::getPreco));
        System.out.println(produtosCadastrados);

    }
    public static void filtrarProdutosPlanosPrecoDecrescente(){

        planosCadastrados.sort(Comparator.comparingDouble(Plano::getPreco).reversed());
        System.out.println(planosCadastrados);
        produtosCadastrados.sort(Comparator.comparingDouble(Produto::getPreco).reversed());
        System.out.println(produtosCadastrados);
    }

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



