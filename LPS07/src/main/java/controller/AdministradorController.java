package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import modelDAO.AdministradorDAO;
import view.FrCadastroAdmin;

public class AdministradorController {
    Administrador admin;
    private AdministradorDAO usrDAO;
    
    public AdministradorController(){
        usrDAO = new AdministradorDAO();
    }
    
    public void abrirCadAdmin(){
        try {
            FrCadastroAdmin cadAdmin = new FrCadastroAdmin(this);
        } catch (ParseException ex) {
            Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object []> buscarAdmin(Object [] usr){
        admin = null;
        if(usr != null){
            admin = new Administrador();
            admin.setCpf(usr[1].toString());
        }
        ArrayList<Object []> ArrayObjAdmins = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(admin == null ? null : admin);        
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjA = new Object [8];
            arrayObjA[0] = ((Administrador) arrayObj.get(i)).getNome();
            arrayObjA[1] = ((Administrador) arrayObj.get(i)).getCpf();
            arrayObjA[2] = ((Administrador) arrayObj.get(i)).getTelefone();
            arrayObjA[3] = ((Administrador) arrayObj.get(i)).getEmail();
            arrayObjA[4] = ((Administrador) arrayObj.get(i)).getSenha();
            arrayObjA[5] = ((Administrador) arrayObj.get(i)).getSexo();
            arrayObjA[6] = ((Administrador) arrayObj.get(i)).getDataNasc();
            arrayObjA[7] = ((Administrador) arrayObj.get(i)).getSalario();
            ArrayObjAdmins.add(arrayObjA);
        }
        return ArrayObjAdmins;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayAdmin){
        admin = new Administrador();
        admin.setNome(arrayAdmin[0].toString());
        admin.setCpf(arrayAdmin[1].toString());
        admin.setTelefone(arrayAdmin[2].toString());
        admin.setEmail(arrayAdmin[3].toString());
        admin.setSenha(arrayAdmin[4].toString());
        admin.setSexo(arrayAdmin[5].toString());
        admin.setDataNasc((Date) arrayAdmin[6]);
        admin.setSalario((float) arrayAdmin[7]);
        usrDAO.alterar(admin);
    }

    public void excluir(Object [] usr){
        admin = new Administrador();
        admin.setCpf(usr[1].toString());
        usrDAO.excluir(admin);
    }
    
    public int inserir(Object [] arrayAdmin){
        admin = new Administrador();
        admin.setNome(arrayAdmin[0].toString());
        admin.setCpf(arrayAdmin[1].toString());
        admin.setTelefone(arrayAdmin[2].toString());
        admin.setEmail(arrayAdmin[3].toString());
        admin.setSenha(arrayAdmin[4].toString());
        admin.setSexo(arrayAdmin[5].toString());
        admin.setDataNasc((Date) arrayAdmin[6]);
        admin.setSalario((float) arrayAdmin[7]);
        return usrDAO.inserir(admin);
    }
    
}
