package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Servico;
import model.UnidadeConsumidora;
import modelDAO.ServicoDAO;
import view.FrCadastroServico;

public class ServicoController {
    ServicoDAO usrDAO;
    Servico servico;
    public ServicoController(){
        usrDAO = new ServicoDAO();
    }
    
    public void abrirCadServico(){
        try {
            FrCadastroServico cadServico = new FrCadastroServico(this);
        } catch (ParseException ex) {
            Logger.getLogger(ServicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object []> buscarServico(Object [] usr){
        servico = null;
        if(usr != null){
            servico = new Servico();
            servico.setId((int) usr[0]);
        }
        ArrayList<Object []> ArrayObjServicos = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(servico == null ? null : servico);
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjS = new Object [6];
            arrayObjS[0] = ((Servico) arrayObj.get(i)).getId();
            arrayObjS[1] = ((Servico) arrayObj.get(i)).getTipo();
            arrayObjS[2] = ((Servico) arrayObj.get(i)).getValor();
            arrayObjS[3] = ((Servico) arrayObj.get(i)).getData();
            arrayObjS[4] = ((Servico) arrayObj.get(i)).getContratante().getCpf();
            arrayObjS[5] = ((Servico) arrayObj.get(i)).getLocal().getId();
            ArrayObjServicos.add(arrayObjS);
        }
        return ArrayObjServicos;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayServico){
        Cliente c = new Cliente();
        c.setCpf(arrayServico[4].toString());
        UnidadeConsumidora uc = new UnidadeConsumidora();
        uc.setId(Integer.parseInt(arrayServico[2].toString()));
        servico = new Servico();
        servico.setId((int) arrayServico[0]);
        servico.setTipo(arrayServico[1].toString());
        servico.setLocal((UnidadeConsumidora) uc);
        servico.setData((Date) arrayServico[3]);
        servico.setContratante((Cliente) c);
        servico.setValor((float) arrayServico[5]);
        usrDAO.alterar(servico);
    }
    
    public void excluir(Object [] usr){
        servico = new Servico();
        servico.setId((int) usr[0]);
        usrDAO.excluir(servico);
    }
    
    public void inserir(Object [] arrayServico){
        Cliente c = new Cliente();
        c.setCpf(arrayServico[4].toString());
        UnidadeConsumidora uc = new UnidadeConsumidora();
        uc.setId(Integer.parseInt(arrayServico[2].toString()));
        servico = new Servico();
        servico.setId((int) arrayServico[0]);
        servico.setTipo(arrayServico[1].toString());
        servico.setLocal((UnidadeConsumidora) uc);
        servico.setData((Date) arrayServico[3]);
        servico.setContratante((Cliente) c);
        servico.setValor((float) arrayServico[5]);
        usrDAO.inserir(servico);
    }
}
