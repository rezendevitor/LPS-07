package model;

import java.util.Date;

public class Leiturista extends Pessoa{
    private float salario;
    
    public Leiturista(){
        super();
        this.salario = -1;
    }
    
    public Leiturista(String nome, String cpf, String telefone, String email, String senha, String sexo, Date dataNasc, float salario){
        super(nome, cpf, telefone, email, senha, sexo, dataNasc);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
