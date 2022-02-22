package model;

import java.util.Date;

public class Pessoa {
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private String sexo;
    private Date dataNasc;
    
    public Pessoa(){
        this.nome = "-";
        this.cpf = "-";
        this.telefone = "-";
        this.email = "-";
        this.senha = "-";
        this.sexo = "-";
        this.dataNasc = null;
    }
    
    public Pessoa(String nome, String cpf, String telefone, String email, String senha, String sexo, Date dataNasc){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
