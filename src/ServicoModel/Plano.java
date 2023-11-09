package ServicoModel;

import java.util.*;

public class Plano extends Servico {

    public Plano () {}

    public Plano(String nome, String descricao, int id) {
        super(nome, descricao, id);
    }

    public Plano(String nome, String descricao, String recursos, int id) {
        super(nome, descricao, recursos, id);
    }

    public Plano(String nome, String edicao, String descricao, String recursos, int id, float preco) {
        super(nome, edicao, descricao, recursos, id, preco);
    }
    public Plano(String nome, String edicao, String descricao, int id, float preco) {
        super(nome, edicao, descricao, id, preco);
    }

}
