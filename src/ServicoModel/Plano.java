package ServicoModel;

public class Plano {

    private String nomePlano;
    private String descricaoPlano;
    private String recursosPlano;
    private int idPlano;
    private float precoPlano;


    public Plano() {}

    public Plano(String nomePlano, String descricaoPlano, int idPlano) {
        this.nomePlano = nomePlano;
        this.descricaoPlano = descricaoPlano;
        this.idPlano = idPlano;
    }
    public Plano(String nomePlano, String descricaoPlano, String recursosPlano, int idPlano) {
        this.nomePlano = nomePlano;
        this.descricaoPlano = descricaoPlano;
        this.recursosPlano = recursosPlano;
        this.idPlano = idPlano;
    }
    public Plano(String nomePlano, String descricaoPlano, int idPlano, float precoPlano) {
        this.nomePlano = nomePlano;
        this.descricaoPlano = descricaoPlano;
        this.idPlano = idPlano;
        this.precoPlano = precoPlano;
    }
    public Plano(String nomePlano, String descricaoPlano, String recursosPlano, int idPlano, float precoPlano) {
        this.nomePlano = nomePlano;
        this.descricaoPlano = descricaoPlano;
        this.recursosPlano = recursosPlano;
        this.idPlano = idPlano;
        this.precoPlano = precoPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    public void setDescricaoPlano(String descricaoPlano) {
        this.descricaoPlano = descricaoPlano;
    }

    public String getRecursosPlano() {
        return recursosPlano;
    }

    public void setRecursosPlano(String recursosPlano) {
        this.recursosPlano = recursosPlano;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public float getPrecoPlano() {
        return precoPlano;
    }

    public void setPrecoPlano(float precoPlano) {
        this.precoPlano = precoPlano;
    }

    @Override
    public String toString() {
        return  nomePlano + "(" + idPlano +")" +
                ", preco:" + precoPlano +
                ", descricao: " + descricaoPlano +
                ", recursos:" + recursosPlano +
                "\r\n";
    }
}
