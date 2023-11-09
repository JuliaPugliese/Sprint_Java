package ServicoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto extends Servico {

    private String funcionalidades;

    public Produto () {}

    public Produto(String funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public Produto(String nome, String descricao, int id, String funcionalidades) {
        super(nome, descricao, id);
        this.funcionalidades = funcionalidades;
    }

    public Produto(String nome, String descricao, String recursos, int id, String funcionalidades) {
        super(nome, descricao, recursos, id);
        this.funcionalidades = funcionalidades;
    }

    public Produto(String nome, String edicao, String descricao, String recursos, int id, float preco, String funcionalidades) {
        super(nome, edicao, descricao, recursos, id, preco);
        this.funcionalidades = funcionalidades;
    }

    public Produto(String nome, String edicao, String descricao, int id, float preco, String funcionalidades) {
        super(nome, edicao, descricao, id, preco);
        this.funcionalidades = funcionalidades;
    }

    public String getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(String funcionalidades) {
        this.funcionalidades = funcionalidades;
    }


}
