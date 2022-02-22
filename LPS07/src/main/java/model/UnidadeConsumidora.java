package model;

public class UnidadeConsumidora {
    private int id;
    private String tipo;
    private String endereco;
    private Cliente proprietario;
    private float consumo;
    
    public UnidadeConsumidora(){
        this.id = -1;
        this.tipo = "-";
        this.endereco = "-";
        this.proprietario = null;
        this.consumo = -1;
    }
    
    public UnidadeConsumidora(int id, String tipo, String endereco, Cliente proprietario, float consumo){
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.proprietario = proprietario;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
}
