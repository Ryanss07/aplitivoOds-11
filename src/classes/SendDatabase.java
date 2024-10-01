package classes;

/**
 *
 * @author ryans
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class SendDatabase {

    private static final String[][] NOMES = {
        {"Ana", "Silva"}, {"Bruno", "Souza"}, {"Carlos", "Oliveira"}, {"Daniela", "Pereira"},
        {"Eduardo", "Lima"}, {"Fernanda", "Costa"}, {"Gabriel", "Martins"}, {"Helena", "Rocha"},
        {"Igor", "Alves"}, {"Juliana", "Fernandes"}, {"Lucas", "Barros"}, {"Mariana", "Cardoso"},
        {"Nathalia", "Mendes"}, {"Otávio", "Pinto"}, {"Paula", "Ribeiro"}, {"Ricardo", "Teixeira"},
        {"Sofia", "Gomes"}, {"Thiago", "Nogueira"}, {"Vanessa", "Sales"}, {"William", "Figueiredo"}
    };

    private static final String[] EMAILS = {"@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com"};

    public static void main(String[] args) {
        try (Connection conn = conectar()) {
            //limparTabelaUsuarios(conn);
            cadastrarUsuarios(conn, 75, "comum");
            cadastrarUsuarios(conn, 15, "gerente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void limparTabelaUsuarios(Connection conn) throws SQLException {
        String sql = "DELETE FROM usuarios";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
    private static void cadastrarUsuarios(Connection conn, int quantidade, String tipo) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo, area_responsavel, endereco) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            Random random = new Random();

            for (int i = 0; i < quantidade; i++) {
                String[] nomeCompleto = NOMES[random.nextInt(NOMES.length)];
                String nome = nomeCompleto[0] + " " + nomeCompleto[1];
                String email = nomeCompleto[0].toLowerCase() + i + EMAILS[random.nextInt(EMAILS.length)];
                String senha = "senha123"; // Considere usar hashing
                String endereco = "Rua " + (random.nextInt(100) + 1) + ", São Paulo, SP";

                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setString(3, senha);
                stmt.setString(4, tipo);
                
                if (tipo.equals("gerente")) {
                    stmt.setString(5, "Área " + (random.nextInt(5) + 1)); // Área responsável para gerentes
                } else {
                    stmt.setString(5, null); // Sem área responsável para usuários comuns
                }

                stmt.setString(6, endereco);
                stmt.executeUpdate();
            }
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco"; // Altere "seu_banco"
    private static final String USUARIO = "root"; // Altere para seu usuário
    private static final String SENHA = "27224"; // Altere para sua senha

    private static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

