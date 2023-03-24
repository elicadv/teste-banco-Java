import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {

    public static void main(String[] args){

       Connection conn = null;
       PreparedStatement stmt = null;

       try{

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?user=root&password=fe279719");

        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";
        
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "João da Silva");
        stmt.setString(2, "joao.silva@teste.com");

        stmt.executeUpdate();
        System.out.println("Dados Inseridos com sucesso");

       }catch(SQLException ex){
        System.out.println("Erro ao inserir Dados:" + ex.getMessage());
       } finally{
        try {
            
            if(stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch(SQLException ex){
            System.out.println("Erro ao fechar conexão: " + ex.getMessage());
           }
       }
    }
}

