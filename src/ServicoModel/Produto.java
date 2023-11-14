package ServicoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Produto {
    static Scanner scanner = new Scanner(System.in);
    private String nomeProduto;
    private int idProduto;
    private String descricaoProduto;
    private List<Plano> planoPagamento = new ArrayList<>();
    private Plano sucessPlans;

    public Produto () {}

    public Produto(String nomeProduto, int idProduto, String descricaoProduto, List<Plano> planoPagamento) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
        this.planoPagamento = planoPagamento;
    }

    public Produto(String nomeProduto, int idProduto, String descricaoProduto, List<Plano> planoPagamento, Plano sucessPlans) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
        this.planoPagamento = planoPagamento;
        this.sucessPlans = sucessPlans;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public List<Plano> getPlanoPagamento() {
        return planoPagamento;
    }

    public void setPlanoPagamento(List<Plano> planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public Plano getSucessPlans() {
        return sucessPlans;
    }

    public void setSucessPlans(Plano sucessPlans) {
        this.sucessPlans = sucessPlans;
    }

    public void editarInformacoesPlanoPagamento(int editarIdPlano){

        System.out.println("Digite informação a ser editada:");
        var informacao = (scanner.nextLine()).replaceAll("[áàâãä]", "a").replaceAll("[í,ì]", "i").replaceAll("[é,è]", "e");

        if (informacao.equalsIgnoreCase("nome")) {
            System.out.println("Digite o nome atualizado:");
            var atualizacao = (scanner.nextLine());

            this.planoPagamento.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(plano -> plano.setNomePlano(atualizacao));

            System.out.println("\r\nO nome foi alterado com sucesso");


        } else if (informacao.equalsIgnoreCase("descrição")) {
            System.out.println("Digite a descrição atual:");
            var atualizacao = (scanner.nextLine());

            planoPagamento.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(plano -> plano.setDescricaoPlano(atualizacao));

            System.out.println("\r\nA descrição foi alterada com sucesso");

        } else if (informacao.equalsIgnoreCase("recursos")) {
            System.out.println("Digite os recursos atuais:");
            var atualizacao = (scanner.nextLine());

            planoPagamento.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(plano -> plano.setRecursosPlano(atualizacao));

            System.out.println("\r\nOs recursos foram alterados com sucesso");

        } else if (informacao.equalsIgnoreCase("id")) {
            System.out.println("Digite o ID atual:");
            var atualizacao = (scanner.nextInt());
            scanner.nextLine();

            planoPagamento.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(plano -> plano.setIdPlano(atualizacao));

            System.out.println("\r\nO ID foi alterado com sucesso");

        } else if (informacao.equalsIgnoreCase("preço")) {
            System.out.println("Digite o preço atual:");
            var atualizacao = (scanner.nextFloat());
            scanner.nextLine();

            planoPagamento.stream()
                    .filter(plano -> plano.getIdPlano() == (editarIdPlano)).toList()
                    .forEach(plano -> plano.setPrecoPlano(atualizacao));

            System.out.println("\r\nO preço foi alterado com sucesso");

        } else {
            System.out.println("Opção inválida");
        }



    }

    @Override
    public String toString() {
        return nomeProduto + "(" + idProduto + ")" +
                "\r\nDescrição do Produto: " + descricaoProduto +
                "\r\nPlanos de Pagamento: " + planoPagamento;
    }
}
