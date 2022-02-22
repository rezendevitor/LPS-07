package model;

import java.util.Date;

public class Cliente extends Pessoa{
    private String endereco;
    
    public Cliente(){
        super();
        this.endereco = "-";
    }
    
    public Cliente(String nome, String cpf, String telefone, String email, String senha, String sexo, Date dataNasc, String endereco){
        super(nome, cpf, telefone, email, senha, sexo, dataNasc);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
