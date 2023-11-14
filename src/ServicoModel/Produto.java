package ServicoModel;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public String toString() {
        return nomeProduto + "(" + idProduto + ")" +
                "\r\nDescrição do Produto: " + descricaoProduto +
                "\r\nPlanos de Pagamento: " + planoPagamento;
    }
}
