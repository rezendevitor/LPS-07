package controller;

import java.util.ArrayList;

public interface InterfaceDAO {
    public int inserir(Object obj);
    public void alterar(Object obj);
    public void excluir(Object obj);
    public ArrayList<Object> consultar(Object obj);
    public Object buscar(String cod);
}
