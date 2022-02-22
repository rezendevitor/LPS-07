package model;

import java.util.Date;

public class Servico {
    private int id;
    private String tipo;
    private float valor;
    private Date data;
    private Cliente contratante;
    private UnidadeConsumidora local;
    
    
    public Servico(){
        this.id = -1;
        this.tipo = "-";
        this.valor = -1;
        this.data = null;
        this.contratante = null;
        this.local = null;
    }
    
    public Servico(int id, String tipo, float valor, Date data, Cliente contratante, UnidadeConsumidora local){
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.contratante = contratante;
        this.local = local;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getContratante() {
        return contratante;
    }

    public void setContratante(Cliente contratante) {
        this.contratante = contratante;
    }

    public UnidadeConsumidora getLocal() {
        return local;
    }

    public void setLocal(UnidadeConsumidora local) {
        this.local = local;
    }
}
