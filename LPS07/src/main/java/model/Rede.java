package model;

public class Rede{
    private int id;
    private String tipo;
    private String bairro;
    private int alcance;
    private float consumo; 
    
    public Rede(){
        this.id = -1;
        this.tipo = "-";
        this.bairro = "-";
        this.alcance = -1;
        this.consumo = -1;

    }
    
    public Rede(int id, String tipo, String bairro, int alcance, float consumo){
        this.id = id;
        this.tipo = tipo;
        this.bairro = bairro;
        this.alcance = alcance;
        this.consumo = consumo;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
}
