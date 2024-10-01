package classes;
//@author Ryan S. Santos
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco"; // Altere "seu_banco" para o nome do seu banco
    private static final String USUARIO = "root"; // Altere para seu usuário
    private static final String SENHA = "27224"; // Altere para sua senha

    // Método para estabelecer uma conexão com o banco de dados
    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro de conexão
            return null; // Retorna null em caso de falha
        }
    }
    // =================== Funções de Usuários ===================
    // Método para adicionar usuários comuns
    public void cadastrarUsuarioComum(String nome, String email, String senha, String endereco) {
        String sql = "INSERT INTO usuarios (nome, email, senha, endereco, tipo) VALUES (?, ?, ?, ?, 'comum')";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Configura os parâmetros da consulta
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha); 
            stmt.setString(4, endereco);
            stmt.executeUpdate(); // Executa a atualização no banco
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao cadastrar
        }
    }

    // Método para adicionar usuários com permissão de administrador
    public void cadastrarGerente(String nome, String email, String senha, String endereco,String tipo) {
        String sql = "INSERT INTO usuarios (nome, email, senha, endereco, tipo) VALUES (?, ?, ?, ?, 'gerente')";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Configura os parâmetros da consulta
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha); 
            stmt.setString(4, endereco);
            stmt.executeUpdate(); // Executa a atualização no banco
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao cadastrar
        }
    }

    // Método para listar usuários
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>(); // Lista para armazenar usuários
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(); // Cria um novo objeto Usuario
                // Preenche os dados do usuário a partir do ResultSet
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEndereco(rs.getString("endereco")); 
                usuario.setTipo(rs.getString("tipo"));
                usuarios.add(usuario); // Adiciona o usuário à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar
        }
        return usuarios; // Retorna a lista de usuários
    }

    // Método para remover usuários
    public boolean removerUsuario(String email) {
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email); // Configura o parâmetro da consulta
            int affectedRows = stmt.executeUpdate(); // Executa a remoção
            return affectedRows > 0; // Retorna true se uma linha foi afetada
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao remover
            return false; // Retorna false em caso de erro
        }
    }
    
    public String editarUsuario(String emailAtual, String novoEmail, String novoNome, String novoEndereco) {
        // Verifica se todos os campos estão vazios
        if (novoEmail == null && novoNome == null && novoEndereco == null) {
            return "nenhumCampoPreenchido"; // Mensagem se nenhum campo foi preenchido
        }

        StringBuilder sql = new StringBuilder("UPDATE usuarios SET ");
        boolean hasUpdates = false;

        if (novoEmail != null) {
            sql.append("email = ?, ");
            hasUpdates = true;
        }
        if (novoNome != null) {
            sql.append("nome = ?, ");
            hasUpdates = true;
        }
        if (novoEndereco != null) {
            sql.append("endereco = ?, ");
            hasUpdates = true;
        }

        if (hasUpdates) {
            sql.setLength(sql.length() - 2); // Remove a última vírgula e espaço
            sql.append(" WHERE email = ?");

            try (Connection conn = conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
                int index = 1;
                if (novoEmail != null) {
                    stmt.setString(index++, novoEmail);
                }
                if (novoNome != null) {
                    stmt.setString(index++, novoNome);
                }
                if (novoEndereco != null) {
                    stmt.setString(index++, novoEndereco);
                }
                stmt.setString(index, emailAtual); // E-mail atual para a cláusula WHERE
                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    return "sucessoEditarUsuario"; // Mensagem de sucesso
                } else {
                    return "nenhumUsuarioEncontrado"; // Mensagem para nenhum usuário encontrado
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "erroEditarUsuario: " + e.getMessage(); // Mensagem de erro
            }
        } else {
            return "nenhumCampoAlterado"; // Mensagem se nenhum campo foi alterado
        }
    }

   
     public boolean trocarTipoUsuario(String email) {
        String sql = "UPDATE usuarios SET tipo = CASE " +
                     "WHEN tipo = 'comum' THEN 'gerente' " +
                     "WHEN tipo = 'gerente' THEN 'comum' " +
                     "END WHERE email = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email); // Define o e-mail no PreparedStatement
            int affectedRows = stmt.executeUpdate(); // Executa a atualização
            return affectedRows > 0; // Retorna true se pelo menos uma linha foi atualizada
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime a stack trace em caso de erro
            return false; // Retorna false em caso de exceção
        }
    }

    // Método para validação do login
    public String validarUsuario(String email, String senha) {
        // Verifica se os campos estão vazios
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return "camposVazios"; // Mensagem para campos vazios
        }

        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email); // Configura o parâmetro da consulta
            ResultSet rs = stmt.executeQuery();
            
            if (!rs.next()) {
                return "usuarioInexistente"; // Mensagem para usuário inexistente
            }

            // Verifica a senha
            String senhaArmazenada = rs.getString("senha");
            if (!senhaArmazenada.equals(senha)) { // Considere usar hashing aqui
                return "senhaIncorreta"; // Mensagem para senha incorreta
            }

            return "sucesso"; // Usuário validado com sucesso

        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao validar
            return "erroBanco"; // Mensagem para erro de banco de dados
        }
    }

    // Método para obter usuário por email
    public Usuario obterUsuarioPorEmail(String email) {
        Usuario usuario = null; // Inicializa o usuário como null
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try(Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email); // Configura o parâmetro da consulta
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Criação do objeto Usuario com os dados do banco
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
            }
        }catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao obter usuário
        }

        return usuario; // Retorna o usuário encontrado
    }
   // =================== Funções de Ônibus ===================
    // Método para adicionar uma linha de ônibus ao banco de dados
    public void adicionarLinhaOnibus(String linha, String partida, String destino) {
        String sql = "INSERT INTO linhas_onibus (linha, partida, destino) VALUES (?, ?, ?)";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, linha);
            stmt.setString(2, partida);
            stmt.setString(3, destino);
            stmt.executeUpdate(); // Executa a inserção
            System.out.println("Linha de ônibus adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar linha de ônibus: " + e.getMessage());
        }
    }
    // Método para remover uma linha de ônibus do banco de dados
    public void removerLinhaOnibus(String linha) {
        String sql = "DELETE FROM linhas_onibus WHERE linha = ?";
        
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, linha);
            int rowsAffected = stmt.executeUpdate(); // Executa a remoção
            if (rowsAffected > 0) {
                System.out.println("Linha de ônibus removida com sucesso!");
            } else {
                System.out.println("Nenhuma linha de ônibus encontrada com o nome: " + linha);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover linha de ônibus: " + e.getMessage());
        }
    }
    // Método para buscar linhas de ônibus
    public List<LinhaOnibus> buscarLinhasOnibus(String partida, String destino) {
    List<LinhaOnibus> linhas = new ArrayList<>();
    
    // Consulta no banco de dados (Exemplo SQL)
    String sql = "SELECT linha, partida, destino FROM linhas_onibus WHERE LOWER(destino) LIKE LOWER(?) AND partida = ?";
    
    try (Connection conn = conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, "%" + destino + "%"); // Usando LIKE para pesquisar
        stmt.setString(2, partida);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String linha = rs.getString("linha");
            String partidaDB = rs.getString("partida");
            String destinoDB = rs.getString("destino");
            linhas.add(new LinhaOnibus(linha, partidaDB, destinoDB));
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return linhas;
}

    // =================== Funções de Sugestões ===================
    // Métodos de gerenciamento de sugestões
    public void adicionarSugestao(String descricao, String usuario) {
        String sql = "INSERT INTO sugestoes (descricao, usuario) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descricao); // Configura a descrição
            stmt.setString(2, usuario); // Configura o usuário
            stmt.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao adicionar sugestão
        }
    }

    public boolean removerSugestao(String descricao) {
        String sql = "DELETE FROM sugestoes WHERE descricao = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descricao); // Configura a descrição da sugestão a ser removida
            int affectedRows = stmt.executeUpdate(); // Executa a remoção
            return affectedRows > 0; // Retorna true se uma linha foi afetada
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao remover sugestão
            return false; // Retorna false em caso de erro
        }
    }

    public List<Sugestao> listarSugestoes() {
        List<Sugestao> sugestoes = new ArrayList<>(); // Lista para armazenar sugestões
        String sql = "SELECT * FROM sugestoes";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Cria um novo objeto Sugestao a partir dos dados do ResultSet
                Sugestao sugestao = new Sugestao(rs.getString("descricao"), rs.getString("usuario"));
                sugestoes.add(sugestao); // Adiciona a sugestão à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar sugestões
        }
        return sugestoes; // Retorna a lista de sugestões
    }

    public List<Sugestao> listarSugestoesPorUsuario(String usuarioEmail) {
        List<Sugestao> sugestoes = new ArrayList<>(); // Lista para armazenar sugestões do usuário
        String sql = "SELECT * FROM sugestoes WHERE usuario = ?";  
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, usuarioEmail); // Configura o parâmetro para o email do usuário
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                // Cria um novo objeto Sugestao a partir dos dados do ResultSet
                Sugestao sugestao = new Sugestao(rs.getString("descricao"), rs.getString("usuario"));
                sugestoes.add(sugestao); // Adiciona a sugestão à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar sugestões
        }
        return sugestoes; // Retorna a lista de sugestões do usuário
    }
    // =================== Funções de Áreas de Risco ===================
    // Métodos de gerenciamento de áreas de risco
    public void adicionarAreaDeRisco(String descricao, String localizacao) {
        String sql = "INSERT INTO areas_risco (descricao, localizacao) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descricao); // Configura a descrição da área de risco
            stmt.setString(2, localizacao); // Configura a localização da área de risco
            stmt.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao adicionar área de risco
        }
    }

    public List<AreaRisco> listarAreasDeRisco() {
        List<AreaRisco> areasRisco = new ArrayList<>(); // Lista para armazenar áreas de risco
        String sql = "SELECT * FROM areas_risco";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Cria um novo objeto AreaRisco a partir dos dados do ResultSet
                AreaRisco area = new AreaRisco(rs.getString("descricao"), rs.getString("localizacao"));
                areasRisco.add(area); // Adiciona a área de risco à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar áreas de risco
        }
        return areasRisco; // Retorna a lista de áreas de risco
    }

   // =================== Funções de EspacoPublico ===================
    // Métodos de gerenciamento de espaços públicos
    public void adicionarEspacoPublico(String nome, String descricao) {
        String sql = "INSERT INTO espacos_publicos (nome, descricao) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome); // Configura o nome do espaço público
            stmt.setString(2, descricao); // Configura a descrição do espaço público
            stmt.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao adicionar espaço público
        }
    }

    public List<EspacoPublico> listarEspacosPublicos() {
        List<EspacoPublico> espacosPublicos = new ArrayList<>(); // Lista para armazenar espaços públicos
        String sql = "SELECT * FROM espacos_publicos";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Cria um novo objeto EspacoPublico a partir dos dados do ResultSet
                EspacoPublico espaco = new EspacoPublico(rs.getString("nome"), rs.getString("descricao"));
                espacosPublicos.add(espaco); // Adiciona o espaço público à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar espaços públicos
        }
        return espacosPublicos; // Retorna a lista de espaços públicos
    }
    // =================== Funções de Planejamento Urbano ===================
    // Métodos de gerenciamento de planejamento urbano
    public void adicionarPlanejamentoUrbano(String nome, String descricao) {
        String sql = "INSERT INTO planejamento_urbano (nome, descricao) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome); // Configura o nome do planejamento urbano
            stmt.setString(2, descricao); // Configura a descrição do planejamento urbano
            stmt.executeUpdate(); // Executa a inserção
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao adicionar planejamento urbano
        }
    }

    public List<PlanejamentoUrbano> listarPlanejamentoUrbano() {
        List<PlanejamentoUrbano> planejamentoUrbano = new ArrayList<>(); // Lista para armazenar planejamentos urbanos
        String sql = "SELECT * FROM planejamento_urbano";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Cria um novo objeto PlanejamentoUrbano a partir dos dados do ResultSet
                PlanejamentoUrbano planejamento = new PlanejamentoUrbano(rs.getString("nome"), rs.getString("descricao"));
                planejamentoUrbano.add(planejamento); // Adiciona o planejamento urbano à lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe erro ao listar planejamentos urbanos
        }
        return planejamentoUrbano; // Retorna a lista de planejamentos urbanos
    }
}
