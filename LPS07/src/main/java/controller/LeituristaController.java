package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Leiturista;
import modelDAO.LeituristaDAO;
import view.FrCadastroLeiturista;

public class LeituristaController {
    private LeituristaDAO usrDAO;
    private Leiturista leiturista;
    
    public LeituristaController(){
        usrDAO = new LeituristaDAO();
    }
    
    public void abrirCadLeiturista(){
        try {
            FrCadastroLeiturista cadLeiturista = new FrCadastroLeiturista(this);
        } catch (ParseException ex) {
            Logger.getLogger(LeituristaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object []> buscarLeiturista(Object [] usr){
        leiturista = null;
        if(usr != null){
            leiturista = new Leiturista();
            leiturista.setCpf(usr[1].toString());
        }
        ArrayList<Object []> ArrayObjLeituristas = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(leiturista == null ? null : leiturista);
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjL = new Object [8];
            arrayObjL[0] = ((Leiturista) arrayObj.get(i)).getNome();
            arrayObjL[1] = ((Leiturista) arrayObj.get(i)).getCpf();
            arrayObjL[2] = ((Leiturista) arrayObj.get(i)).getTelefone();
            arrayObjL[3] = ((Leiturista) arrayObj.get(i)).getEmail();
            arrayObjL[4] = ((Leiturista) arrayObj.get(i)).getSenha();
            arrayObjL[5] = ((Leiturista) arrayObj.get(i)).getSexo();
            arrayObjL[6] = ((Leiturista) arrayObj.get(i)).getDataNasc();
            arrayObjL[7] = ((Leiturista) arrayObj.get(i)).getSalario();
            ArrayObjLeituristas.add(arrayObjL);
        }
        return ArrayObjLeituristas;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayLeiturista){
        leiturista = new Leiturista();
        leiturista.setNome(arrayLeiturista[0].toString());
        leiturista.setCpf(arrayLeiturista[1].toString());
        leiturista.setTelefone(arrayLeiturista[2].toString());
        leiturista.setEmail(arrayLeiturista[3].toString());
        leiturista.setSenha(arrayLeiturista[4].toString());
        leiturista.setSexo(arrayLeiturista[5].toString());
        leiturista.setDataNasc((Date) arrayLeiturista[6]);
        leiturista.setSalario((float) arrayLeiturista[7]);
        usrDAO.alterar(leiturista);
    }
    
    public void excluir(Object [] usr){
        leiturista = new Leiturista();
        leiturista.setCpf(usr[1].toString());
        usrDAO.excluir(leiturista);
    }
    
    public void inserir(Object [] arrayLeiturista){
        leiturista = new Leiturista();
        leiturista.setNome(arrayLeiturista[0].toString());
        leiturista.setCpf(arrayLeiturista[1].toString());
        leiturista.setTelefone(arrayLeiturista[2].toString());
        leiturista.setEmail(arrayLeiturista[3].toString());
        leiturista.setSenha(arrayLeiturista[4].toString());
        leiturista.setSexo(arrayLeiturista[5].toString());
        leiturista.setDataNasc((Date) arrayLeiturista[6]);
        leiturista.setSalario((float) arrayLeiturista[7]);
        usrDAO.inserir(leiturista);
    }
}
