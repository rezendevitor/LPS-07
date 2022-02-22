package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rede;
import modelDAO.RedeDAO;
import view.FrCadastroRede;

public class RedeController {
    RedeDAO usrDAO;
    Rede rede;
    
    public RedeController(){
        usrDAO = new RedeDAO();
    }
    
    public void abrirCadRede(){
        try {
            FrCadastroRede cadRede = new FrCadastroRede(this);
        } catch (ParseException ex) {
            Logger.getLogger(RedeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public ArrayList<Object []> buscarRede(Object [] usr){
        rede = null;
        if(usr != null){
            rede = new Rede();
            rede.setId((int) usr[0]);
        }
        ArrayList<Object []> ArrayObjRedes = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(rede == null ? null : rede);
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjR = new Object [5];
            arrayObjR[0] = ((Rede) arrayObj.get(i)).getId();
            arrayObjR[1] = ((Rede) arrayObj.get(i)).getTipo();
            arrayObjR[2] = ((Rede) arrayObj.get(i)).getBairro();
            arrayObjR[3] = ((Rede) arrayObj.get(i)).getAlcance();
            arrayObjR[4] = ((Rede) arrayObj.get(i)).getConsumo();
            ArrayObjRedes.add(arrayObjR);
        }
        return ArrayObjRedes;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayRede){
        rede = new Rede();
        rede.setId((int) arrayRede[0]);
        rede.setTipo(arrayRede[1].toString());
        rede.setBairro(arrayRede[2].toString());
        rede.setAlcance((int) arrayRede[3]);
        rede.setConsumo((float) arrayRede[4]);
        usrDAO.alterar(rede);
    }
    
    public void excluir(Object [] usr){
        rede = new Rede();
        rede.setId((int) usr[0]);
        usrDAO.excluir(rede);
    }
    
    public void inserir(Object [] arrayRede){
        rede = new Rede();
        rede.setId((int) arrayRede[0]);
        rede.setTipo(arrayRede[1].toString());
        rede.setBairro(arrayRede[2].toString());
        rede.setAlcance((int) arrayRede[3]);
        rede.setConsumo((float) arrayRede[4]);
        usrDAO.inserir(rede);
    }
}
