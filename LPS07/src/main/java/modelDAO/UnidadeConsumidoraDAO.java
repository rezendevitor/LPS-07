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
import model.UnidadeConsumidora;

public class UnidadeConsumidoraDAO implements InterfaceDAO {
    UnidadeConsumidora usr;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int inserir(Object obj) {
         try {
            if(obj != null){
                UnidadeConsumidora usr = (UnidadeConsumidora)obj;
                String SQL = "INSERT INTO unidade_consumidora VALUES (?, ?, ?, ?, ?)";
                ps = Persistencia.conectar().prepareStatement(SQL);
                ps.setInt(1, usr.getId());
                ps.setString(2, usr.getTipo());
                ps.setString(3, usr.getEndereco());
                ps.setString(4, usr.getProprietario().getCpf());
                ps.setFloat(5, usr.getConsumo());
                ps.execute(); 
                return 1;
            } 
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void alterar(Object obj) {
        try {
            UnidadeConsumidora usr = (UnidadeConsumidora)obj;
            String sql = "UPDATE unidade_consumidora SET tipo = ?, endereco = ?, proprietario = ?, consumo = ? WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(sql);
            ps.setString(1, usr.getTipo());
            ps.setString(2, usr.getEndereco());
            ps.setString(3, usr.getProprietario().getCpf());
            ps.setFloat(4, usr.getConsumo());
            ps.setInt(5, usr.getId());
            ps.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            UnidadeConsumidora usr = (UnidadeConsumidora)obj;
            String SQL = "DELETE FROM unidade_consumidora WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);           
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            ps.execute();    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList(); 
        UnidadeConsumidora usr = (UnidadeConsumidora)obj;
        if (obj == null){
            SQL = "SELECT * FROM unidade_consumidora";
        }else{
            SQL = "SELECT * FROM unidade_consumidora WHERE id = ?";
        }
        try {
            ps = Persistencia.conectar().prepareStatement(SQL);
                        
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString("proprietario"));
                
                usr = new UnidadeConsumidora();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setEndereco(rs.getString("endereco"));
                usr.setProprietario(c);
                usr.setConsumo(rs.getFloat("consumo"));
                arrayObj.add(usr);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;
    }

    @Override
    public Object buscar(String cod) {
        try {
            this.usr = null;
            SQL = "SELECT * FROM unidade_consumidora WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setCpf(rs.getString("proprietario"));
                
                usr = new UnidadeConsumidora();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setEndereco(rs.getString("endereco"));
                usr.setProprietario(c);
                usr.setConsumo(rs.getFloat("consumo"));
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UnidadeConsumidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usr == null){
            return null;
        }else{
            return this.usr;
        }
    }
    
}
