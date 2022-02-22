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
import model.Servico;
import model.UnidadeConsumidora;

public class ServicoDAO implements InterfaceDAO {
    Servico usr;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int inserir(Object obj) {
         try {
            if(obj != null){
                Servico usr = (Servico)obj;
                String SQL = "INSERT INTO servico VALUES (?, ?, ?, ?, ?, ?)";
                ps = Persistencia.conectar().prepareStatement(SQL);
                ps.setInt(1, usr.getId());
                ps.setString(2, usr.getTipo());
                ps.setFloat(3, usr.getValor());
                java.sql.Date datasql = new java.sql.Date(usr.getData().getTime());
                ps.setDate(4, datasql);
                ps.setString(5, usr.getContratante().getCpf());
                ps.setInt(6, usr.getLocal().getId());
                ps.execute(); 
                return 1;
            } 
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void alterar(Object obj) {
        try {
            Servico usr = (Servico)obj;
            String sql = "UPDATE servico SET tipo = ?, valor = ?, data = ?, contratante = ?, local = ? WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(sql);
            ps.setString(1, usr.getTipo());
            ps.setFloat(2, usr.getValor());
            java.sql.Date datasql = new java.sql.Date(usr.getData().getTime());
            ps.setDate(3, datasql);
            ps.setString(4, usr.getContratante().getCpf());
            ps.setInt(5, usr.getLocal().getId());
            ps.setInt(6, usr.getId());
            ps.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            Servico usr = (Servico)obj;
            String SQL = "DELETE FROM servico WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);           
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            ps.execute();    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList(); 
        Servico usr = (Servico)obj;
        if (obj == null){
            SQL = "SELECT * FROM servico";
        }else{
            SQL = "SELECT * FROM servico WHERE id = ?";
        }
        try {
            ps = Persistencia.conectar().prepareStatement(SQL);
                        
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString("contratante"));
                UnidadeConsumidora uc = new UnidadeConsumidora();
                uc.setId(rs.getInt("local"));
                
                usr = new Servico();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setValor(rs.getFloat("valor"));
                usr.setData(rs.getDate("data"));
                usr.setContratante(c);
                usr.setLocal(uc);
                arrayObj.add(usr);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;
    }

    @Override
    public Object buscar(String cod) {
        try {
            this.usr = null;
            SQL = "SELECT * FROM servico WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString("contratante"));
                UnidadeConsumidora uc = new UnidadeConsumidora();
                uc.setId(rs.getInt("local"));
                
                usr = new Servico();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setValor(rs.getFloat("valor"));
                usr.setData(rs.getDate("data"));
                usr.setContratante(c);
                usr.setLocal(uc);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usr == null){
            return null;
        }else{
            return this.usr;
        }
    }
    
}
