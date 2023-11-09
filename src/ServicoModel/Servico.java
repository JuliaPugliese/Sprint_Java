package ServicoModel;

public class Servico {

    private String nome;
    private String edicao;

    private String descricao;
    private String recursos;
    private int id;
    private float preco;



    public Servico () {}

    public Servico(String nome, String descricao, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public Servico(String nome, String descricao, String recursos, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.recursos = recursos;
        this.id = id;
    }

    public Servico(String nome,  String edicao, String descricao, String recursos, int id, float preco) {
        this.nome = nome;
        this.edicao = edicao;
        this.descricao = descricao;
        this.recursos = recursos;
        this.id = id;
        this.preco = preco;
    }

    public Servico(String nome, String edicao, String descricao, int id, float preco) {
        this.nome = nome;
        this.edicao = edicao;
        this.descricao = descricao;
        this.id = id;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return  nome + "(" + id +")" +
                ", preco:" + preco +
                ", descricao: " + descricao +
                ", recursos:" + recursos +
                "\r\n";
    }
}
