package modelDAO;

import controller.InterfaceDAO;
import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;

public class AdministradorDAO implements InterfaceDAO{
    Administrador usr;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int inserir(Object obj) {
        try {
            if(obj != null){
                Administrador usr = (Administrador)obj;
                String SQL = "INSERT INTO administrador VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ps = Persistencia.conectar().prepareStatement(SQL);
                ps.setString(1, usr.getNome());
                ps.setString(2, usr.getCpf());
                ps.setString(3, usr.getTelefone());
                ps.setString(4, usr.getEmail());
                ps.setString(5, usr.getSenha());
                ps.setString(6, usr.getSexo());
                java.sql.Date datasql = new java.sql.Date(usr.getDataNasc().getTime());
                ps.setDate(7, datasql);
                ps.setFloat(8, usr.getSalario());
                ps.execute(); 
                return 1;
            }
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void alterar(Object obj) {
        try {
            Administrador usr = (Administrador)obj;
            String sql = "UPDATE administrador SET nome = ?, telefone = ?, email = ?, senha = ?, sexo = ?, data_nasc = ?, salario = ? WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(sql);
            ps.setString(1, usr.getNome());
            ps.setString(2, usr.getTelefone());
            ps.setString(3, usr.getEmail());
            ps.setString(4, usr.getSenha());
            ps.setString(5, usr.getSexo());
            java.sql.Date datasql = new java.sql.Date(usr.getDataNasc().getTime());
            ps.setDate(6, datasql);
            ps.setFloat(7, usr.getSalario());
            ps.setString(8, usr.getCpf());
            ps.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void excluir(Object obj) {
        try {
            Administrador usr = (Administrador)obj;
            String SQL = "DELETE FROM administrador WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);           
            if(obj != null){
                ps.setString(1, usr.getCpf());
            }
            ps.execute();    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList(); 
        Administrador usr = (Administrador)obj;
        if (obj == null){
            SQL = "SELECT * FROM administrador";
        }else{
            SQL = "SELECT * FROM administrador WHERE cpf = ?";
        }
        try {
            ps = Persistencia.conectar().prepareStatement(SQL);
                        
            if(obj != null){
                ps.setString(1, usr.getCpf());
            }
            rs = ps.executeQuery();
            while(rs.next()){
                usr = new Administrador();
                usr.setNome(rs.getString("nome"));
                usr.setCpf(rs.getString("cpf"));
                usr.setTelefone(rs.getString("telefone"));
                usr.setEmail(rs.getString("email"));
                usr.setSenha(rs.getString("senha"));
                usr.setSexo(rs.getString("sexo"));
                usr.setDataNasc(rs.getDate("data_nasc"));
                usr.setSalario(rs.getFloat("salario"));
                arrayObj.add(usr);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;    
    }

    @Override
    public Object buscar(String cod) {
        try {
            this.usr = null;
            SQL = "SELECT * FROM administrador WHERE cpf = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                this.usr = new Administrador();
                this.usr.setNome(rs.getString("nome"));
                this.usr.setCpf(rs.getString("cpf"));
                this.usr.setTelefone(rs.getString("telefone"));
                this.usr.setEmail(rs.getString("email"));
                this.usr.setSenha(rs.getString("senha"));
                this.usr.setSexo(rs.getString("sexo"));
                this.usr.setDataNasc(rs.getDate("data_nasc"));
                this.usr.setSalario(rs.getFloat("salario")); 
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usr == null){
            return null;
        }else{
            return this.usr;
        }
    }
    
    
}
