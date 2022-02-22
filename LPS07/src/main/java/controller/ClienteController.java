package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import modelDAO.ClienteDAO;
import view.FrCadastroCliente;

public class ClienteController {
    private Cliente cliente;
    private ClienteDAO usrDAO;
    
    public ClienteController(){
        usrDAO = new ClienteDAO();
    }
    
    public void abrirCadCliente(){
        try {
            FrCadastroCliente cadCliente = new FrCadastroCliente(this);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object []> buscarCliente(Object [] usr){
        cliente = null;
        if(usr != null){
            cliente = new Cliente();
            cliente.setCpf(usr[1].toString());
        }
        ArrayList<Object []> ArrayObjClientes = new ArrayList<>();
        ArrayList<Object> arrayObj = usrDAO.consultar(cliente == null ? null : cliente);
        for (int i = 0; i < arrayObj.size(); i++) {
            Object [] arrayObjC = new Object [8];
            arrayObjC[0] = ((Cliente) arrayObj.get(i)).getNome();
            arrayObjC[1] = ((Cliente) arrayObj.get(i)).getCpf();
            arrayObjC[2] = ((Cliente) arrayObj.get(i)).getTelefone();
            arrayObjC[3] = ((Cliente) arrayObj.get(i)).getEmail();
            arrayObjC[4] = ((Cliente) arrayObj.get(i)).getSenha();
            arrayObjC[5] = ((Cliente) arrayObj.get(i)).getSexo();
            arrayObjC[6] = ((Cliente) arrayObj.get(i)).getDataNasc();
            arrayObjC[7] = ((Cliente) arrayObj.get(i)).getEndereco();
            ArrayObjClientes.add(arrayObjC);
        }
        return ArrayObjClientes;
    }
    
    public boolean existe(String cod){
        if(usrDAO.buscar(cod) == null){
            return false;
        }else{
            return true;
        }
    }
    
    public void alterar(Object [] arrayCliente){
        cliente = new Cliente();
        cliente.setNome(arrayCliente[0].toString());
        cliente.setCpf(arrayCliente[1].toString());
        cliente.setTelefone(arrayCliente[2].toString());
        cliente.setEmail(arrayCliente[3].toString());
        cliente.setSenha(arrayCliente[4].toString());
        cliente.setSexo(arrayCliente[5].toString());
        cliente.setDataNasc((Date) arrayCliente[6]);
        cliente.setEndereco(arrayCliente[7].toString());
        usrDAO.alterar(cliente);
    }
    
    public void excluir(Object [] usr){
        cliente = new Cliente();
        cliente.setCpf(usr[1].toString());
        usrDAO.excluir(cliente);
    }
    
    public void inserir(Object [] arrayCliente){
        cliente = new Cliente();
        cliente.setNome(arrayCliente[0].toString());
        cliente.setCpf(arrayCliente[1].toString());
        cliente.setTelefone(arrayCliente[2].toString());
        cliente.setEmail(arrayCliente[3].toString());
        cliente.setSenha(arrayCliente[4].toString());
        cliente.setSexo(arrayCliente[5].toString());
        cliente.setDataNasc((Date) arrayCliente[6]);
        cliente.setEndereco(arrayCliente[7].toString());
        usrDAO.inserir(cliente);
    }
}
