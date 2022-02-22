package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.UnidadeConsumidora;
import modelDAO.UnidadeConsumidoraDAO;
import view.FrCadastroUnidCons;

public class UnidadeConsumidoraController {
    UnidadeConsumidoraDAO usrDAO;
    UnidadeConsumidora unidCons;
    
    public UnidadeConsumidoraController(){
        usrDAO = new UnidadeConsumidoraDAO();
    }
    
    public void abrirCadUnidCons(){
        try {
            FrCadastroUnidCons cadUnidCons = new FrCadastroUnidCons(this);
        } catch (ParseException ex) {
            Logger.getLogger(UnidadeConsumidoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object []> buscarUnidCons(Object [] usr){
        unidCons = null;
        if(usr != null){
            unidCons = new UnidadeConsumidora();
            unidCons.setId((int) usr[0]);
        }
        ArrayList<Object []> ArrayObjUnidConss = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(unidCons == null ? null : unidCons);
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjUC = new Object [5];
            arrayObjUC[0] = ((UnidadeConsumidora) arrayObj.get(i)).getId();
            arrayObjUC[1] = ((UnidadeConsumidora) arrayObj.get(i)).getTipo();
            arrayObjUC[2] = ((UnidadeConsumidora) arrayObj.get(i)).getEndereco();
            arrayObjUC[3] = ((UnidadeConsumidora) arrayObj.get(i)).getProprietario().getCpf();
            arrayObjUC[4] = ((UnidadeConsumidora) arrayObj.get(i)).getConsumo();
            ArrayObjUnidConss.add(arrayObjUC);
        }
        return ArrayObjUnidConss;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayUnidCons){
        Cliente c = new Cliente();
        c.setCpf(arrayUnidCons[1].toString());
        unidCons = new UnidadeConsumidora();
        unidCons.setId((int) arrayUnidCons[0]);
        unidCons.setProprietario((Cliente) c);
        unidCons.setTipo(arrayUnidCons[2].toString());
        unidCons.setConsumo((float) arrayUnidCons[3]);
        unidCons.setEndereco(arrayUnidCons[4].toString());
        usrDAO.alterar(unidCons);
    }
    
    public void excluir(Object [] usr){
        unidCons = new UnidadeConsumidora();
        unidCons.setId((int) usr[0]);
        usrDAO.excluir(unidCons);
    }
    
    public void inserir(Object [] arrayUnidCons){
        Cliente c = new Cliente();
        c.setCpf(arrayUnidCons[1].toString());
        unidCons = new UnidadeConsumidora();
        unidCons.setId((int) arrayUnidCons[0]);
        unidCons.setProprietario((Cliente) c);
        unidCons.setTipo(arrayUnidCons[2].toString());
        unidCons.setConsumo((float) arrayUnidCons[3]);
        unidCons.setEndereco(arrayUnidCons[4].toString());
        usrDAO.inserir(unidCons);
    }
}
