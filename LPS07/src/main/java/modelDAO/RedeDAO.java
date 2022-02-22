package modelDAO;

import controller.InterfaceDAO;
import controller.Persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rede;

public class RedeDAO implements InterfaceDAO {
    Rede usr;
    String SQL;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int inserir(Object obj) {
         try {
            if(obj != null){
                Rede usr = (Rede)obj;
                String SQL = "INSERT INTO rede VALUES (?, ?, ?, ?, ?)";
                ps = Persistencia.conectar().prepareStatement(SQL);
                ps.setInt(1, usr.getId());
                ps.setString(2, usr.getTipo());
                ps.setString(3, usr.getBairro());
                ps.setInt(4, usr.getAlcance());
                ps.setFloat(5, usr.getConsumo());
                ps.execute(); 
                return 1;
            } 
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void alterar(Object obj) {
        try {
            Rede usr = (Rede)obj;
            String sql = "UPDATE rede SET tipo = ?, bairro = ?, alcance = ?, consumo = ? WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(sql);
            ps.setString(1, usr.getTipo());
            ps.setString(2, usr.getBairro());
            ps.setInt(3, usr.getAlcance());
            ps.setFloat(4, usr.getConsumo());
            ps.setInt(5, usr.getId());
            ps.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Object obj) {
        try {
            Rede usr = (Rede)obj;
            String SQL = "DELETE FROM rede WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);           
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            ps.execute();    
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Object> consultar(Object obj) {
        ArrayList<Object> arrayObj = new ArrayList(); 
        Rede usr = (Rede)obj;
        if (obj == null){
            SQL = "SELECT * FROM rede";
        }else{
            SQL = "SELECT * FROM rede WHERE id = ?";
        }
        try {
            ps = Persistencia.conectar().prepareStatement(SQL);
                        
            if(obj != null){
                ps.setInt(1, usr.getId());
            }
            rs = ps.executeQuery();
            while(rs.next()){
                usr = new Rede();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setBairro(rs.getString("bairro"));
                usr.setAlcance(rs.getInt("alcance"));
                usr.setConsumo(rs.getFloat("consumo"));
                arrayObj.add(usr);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;
    }

    @Override
    public Object buscar(String cod) {
        try {
            this.usr = null;
            SQL = "SELECT * FROM rede WHERE id = ?";
            ps = Persistencia.conectar().prepareStatement(SQL);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                usr = new Rede();
                usr.setId(rs.getInt("id"));
                usr.setTipo(rs.getString("tipo"));
                usr.setBairro(rs.getString("bairro"));
                usr.setAlcance(rs.getInt("alcance"));
                usr.setConsumo(rs.getFloat("consumo"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usr == null){
            return null;
        }else{
            return this.usr;
        }
    }
    
}
