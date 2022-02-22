package modelDAO;

import controller.InterfaceDAO;
import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

public class ClienteDAO implements InterfaceDAO {
    Cliente usr;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int inserir(Object obj) {
         try {
            if(obj != null){
                Cliente usr = (Cliente)obj;
                String SQL = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ps = Persistencia.conectar().prepareStatement(SQL);
                ps.setString(1, usr.getNome());
                ps.setString(2, usr.getCpf());
                ps.setString(3, usr.getTelefone());
                ps.setString(4, usr.getEmail());
                ps.setString(5, usr.getSenha());
                ps.setString(6, usr.getSexo());
                java.sql.Date datasql = new java.sql.Date(usr.getDataNasc().getTime());
                ps.setDate(7, datasql);
                ps.setString(8, usr.getEndereco());
                ps.execute();
                return 1;
            } 
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void alterar(Object obj) {
        try {
            Cliente usr = (Cliente)obj;
            String sql = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, senha = ?, sexo = ?, data_nasc = ?, endereco = ? WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(sql);
            ps.setString(1, usr.getNome());
            ps.setString(2, usr.getTelefone());
            ps.setString(3, usr.getEmail());
            ps.setString(4, usr.getSenha());
            ps.setString(5, usr.getSexo());
            java.sql.Date datasql = new java.sql.Date(usr.getDataNasc().getTime());
            ps.setDate(6, datasql);
            ps.setString(7, usr.getEndereco());
            ps.setString(8, usr.getCpf());
            ps.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            Cliente usr = (Cliente)obj;
            String SQL = "DELETE FROM cliente WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);           
            if(obj != null){
                ps.setString(1, usr.getCpf());
            }
            ps.execute();    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList(); 
        Cliente usr = (Cliente)obj;
        if (obj == null){
            SQL = "SELECT * FROM cliente";
        }else{
            SQL = "SELECT * FROM cliente WHERE cpf = ?";
        }
        try {
            ps = Persistencia.conectar().prepareStatement(SQL);
                        
            if(obj != null){
                ps.setString(1, usr.getCpf().toString());
            }
            rs = ps.executeQuery();
            while(rs.next()){
                usr = new Cliente();
                usr.setNome(rs.getString("nome"));
                usr.setCpf(rs.getString("cpf"));
                usr.setTelefone(rs.getString("telefone"));
                usr.setEmail(rs.getString("email"));
                usr.setSenha(rs.getString("senha"));
                usr.setSexo(rs.getString("sexo"));
                usr.setDataNasc(rs.getDate("data_nasc"));
                usr.setEndereco(rs.getString("endereco"));
                arrayObj.add(usr);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;
    }

    @Override
    public Object buscar(String cod) {
        try {
            this.usr = null;
            SQL = "SELECT * FROM cliente WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                usr = new Cliente();
                usr.setNome(rs.getString("nome"));
                usr.setCpf(rs.getString("cpf"));
                usr.setTelefone(rs.getString("telefone"));
                usr.setEmail(rs.getString("email"));
                usr.setSenha(rs.getString("senha"));
                usr.setSexo(rs.getString("sexo"));
                usr.setDataNasc(rs.getDate("data_nasc"));
                usr.setEndereco(rs.getString("endereco"));
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usr == null){
            return null;
        }else{
            return this.usr;
        }
    }
    
}
