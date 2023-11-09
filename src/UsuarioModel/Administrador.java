package UsuarioModel;

import ServicoModel.Plano;
import ServicoModel.Produto;

import java.util.*;

public class Administrador extends Usuario {
    private String nomeAdm;
    private String email;


    public Administrador() {
    }

    public Administrador(int id, String nomeUsuario, String senha, String nomeAdm, String email) {
        super(id, nomeUsuario, senha);
        this.nomeAdm = nomeAdm;
        this.email = email;
    }

    public String getNomeAdm() {
        return nomeAdm;
    }

    public void setNomeAdm(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

