package classes;
//@author Ryan S. Santos
import java.util.HashMap;
import java.util.Map;

public class Tradutor {
    private Map<String, String[]> dicionario; // Mapa que armazena as traduções
    private String idiomaAtual; // Idioma atualmente selecionado

    // Construtor que inicializa o tradutor com o idioma especificado
    public Tradutor(String idioma) {
        this.idiomaAtual = idioma;
        inicializarDicionario(); // Chama o método para inicializar o dicionário
    }

    // Método privado para inicializar o dicionário de traduções
    private void inicializarDicionario() {
        dicionario = new HashMap<>(); // Cria um novo HashMap para o dicionário

    // Dicionário com traduções em [Português, Inglês, Espanhol]
    // Traduções para Cadastro
    dicionario.put("cadastroUsuario", new String[]{"Cadastro de Usuário", "User Registration", "Registro de Usuario"});
    dicionario.put("tituloCadastroMorador", new String[]{"Faça Seu Cadastro de Morador", "Register Your Resident", "Haga Su Registro de Habitante"});
    dicionario.put("tituloCadastroGestor", new String[]{"Faça Seu Cadastro de Gestor", "Register Your Manager", "Haga Su Registro de Gestor"});
    dicionario.put("instrucoesCadastroParte1", new String[]{"Para realizar o seu cadastro,", "To complete your registration,", "Para realizar su registro,"});
    dicionario.put("instrucoesCadastroParte2", new String[]{"preencha os campos abaixo", "fill in the fields below", "complete los campos abajo"});
    dicionario.put("camposVazios", new String[]{"Todos os campos devem ser preenchidos!", "All fields must be filled!", "¡Todos los campos deben ser llenados!"});
    dicionario.put("usuarioCadastrado", new String[]{"Usuário cadastrado com sucesso!", "User registered successfully!", "¡Usuario registrado con éxito!"});

    // Traduções para Login
    dicionario.put("login", new String[]{"Login", "Login", "Iniciar sesión"});
    dicionario.put("senha", new String[]{"Senha", "Password", "Contraseña"});
    dicionario.put("email", new String[]{"Email", "Email", "Correo Electrónico"});
    dicionario.put("esqueciSenha", new String[]{"Esqueci minha senha", "Forgot my password", "Olvidé mi contraseña."});
    dicionario.put("loginSucesso", new String[]{"Login efetuado com sucesso!", "Login successful!", "¡Inicio de sesión exitoso!"});
    dicionario.put("senhaIncorreta", new String[]{"Senha incorreta.", "Incorrect password.", "Contraseña incorrecta."});
    dicionario.put("erroAutenticacao", new String[]{"Erro de autenticação.", "Authentication error.", "Error de autenticación."});

    // Traduções para Gerenciamento
    dicionario.put("Gerenciaruser", new String[]{"Gerenciamento de Moradores", "Resident Management", "Gestión de residentes"});
    dicionario.put("cadastroGestores", new String[]{"Cadastro de Gestores", "Manager Registration", "Registro de Gerente"});
    dicionario.put("modperm", new String[]{"Modificar permissão", "Modify permission", "Modificar permiso"});

    // Traduções para Edição de Usuário
    dicionario.put("edituser", new String[]{"Editar usuario", "Edit user", "Editar usuario"});
    dicionario.put("sucessoEditarUsuario", new String[]{"Edição realizada com sucesso!", "Edit successfully completed!", "Edición realizada con éxito!"});
    dicionario.put("nenhumCampoPreenchido", new String[]{"Nenhum campo preenchido para edição.", "No fields filled for editing.", "Ningún campo lleno para editar."});
    dicionario.put("nenhumCampoAlterado", new String[]{"Nenhum campo foi alterado.", "No fields were changed.", "Ningún campo fue cambiado."});
    dicionario.put("nenhumUsuarioEncontrado", new String[]{"Nenhum usuário encontrado com o e-mail fornecido.", "No user found with the provided email.", "No se encontró ningún usuario con el correo electrónico proporcionado."});
    dicionario.put("erroEditarUsuario", new String[]{"Erro ao editar usuário: ", "Error editing user: ", "Error al editar el usuario: "});

    // Traduções para Mudança de Tipo de Usuário
    dicionario.put("sucessoTrocaTipoUsuario", new String[]{"Tipo de usuário alterado com sucesso!", "User type changed successfully!", "Tipo de usuario cambiado con éxito!"});
    dicionario.put("nenhumUsuarioEncontradoTipo", new String[]{"Nenhum usuário encontrado com o e-mail fornecido para alteração de tipo.", "No user found with the provided email for type change.", "No se encontró ningún usuario con el correo electrónico proporcionado para cambiar de tipo."});
    dicionario.put("erroTrocaTipoUsuario", new String[]{"Erro ao alterar tipo de usuário: ", "Error changing user type: ", "Error al cambiar el tipo de usuario: "});

    // Traduções para Sugestões
    dicionario.put("minhasSugestoes", new String[]{"Minhas Sugestões", "My Suggestions", "Mis Sugerencias"});
    dicionario.put("areaSugestao", new String[]{"Área de Sugestões", "Suggestions Area", "Área de sugerencias"});
    dicionario.put("sugestao", new String[]{"Sugestão", "Suggestion", "Sugerencia"});
    dicionario.put("adicionarSugestao", new String[]{"Adicionar Sugestão", "Add Suggestion", "Agregar Sugerencia"});
    dicionario.put("mostrarSugestoes", new String[]{"Mostrar Sugestões", "Show Suggestions", "Mostrar Sugerencias"});
    dicionario.put("removerSugestao", new String[]{"Remover Sugestão", "Remove Suggestion", "Eliminar Sugerencia"});
    dicionario.put("editarSugestao", new String[]{"Editar Sugestão", "Edit Suggestion", "Editar Sugerencia"});

    // Traduções para Mensagens Gerais
    dicionario.put("bemVindo", new String[]{"Bem-vindo", "Welcome", "Bienvenido"});
    dicionario.put("erro", new String[]{"Erro", "Error", "Error"});
    dicionario.put("sucesso", new String[]{"Sucesso", "Success", "Éxito"});
    dicionario.put("carregando", new String[]{"Carregando...", "Loading...", "Cargando..."});
    dicionario.put("aguarde", new String[]{"Aguarde...", "Please wait...", "Por favor, espere..."});
    dicionario.put("tenteNovamente", new String[]{"Tente novamente.", "Please try again.", "Por favor, inténtelo de nuevo."});
    dicionario.put("sucessoOperacao", new String[]{"Operação realizada com sucesso!", "Operation completed successfully!", "¡Operación completada con éxito!"});
    dicionario.put("usuarioInexistente", new String[]{"Usuário inexistente.", "User does not exist.", "Usuario inexistente."});
    dicionario.put("erroBanco", new String[]{"Erro ao acessar o banco de dados.", "Error accessing the database.", "Error al acceder a la base de datos."});
    dicionario.put("erroDesconhecido", new String[]{"Erro desconhecido.", "Unknown error.", "Error desconocido."});

    // Traduções para Configurações e Ajuda
    dicionario.put("configuracoes", new String[]{"Configurações", "Settings", "Configuraciones"});
    dicionario.put("perfil", new String[]{"Perfil", "Profile", "Perfil"});
    dicionario.put("ajuda", new String[]{"Ajuda", "Help", "Ayuda"});
    dicionario.put("sobre", new String[]{"Sobre", "About", "Acerca de"});
    dicionario.put("termos", new String[]{"Termos e Condições", "Terms and Conditions", "Términos y Condiciones"});
    dicionario.put("privacidade", new String[]{"Política de Privacidade", "Privacy Policy", "Política de Privacidad"});

    }

    // Método para traduzir uma chave para o idioma atual
    public String traduzir(String chave) {
        String[] traducoes = dicionario.get(chave); // Busca as traduções pela chave
        if (traducoes != null) {
            // Retorna a tradução correspondente ao idioma atual
            switch (idiomaAtual) {
                case "pt":
                    return traducoes[0]; // Português
                case "en":
                    return traducoes[1]; // Inglês
                case "es":
                    return traducoes[2]; // Espanhol
                default:
                    return chave; // Retorna a chave se o idioma não for reconhecido
            }
        }
        return chave; // Retorna a chave se não encontrar tradução
    }

    // Método para alterar o idioma atual
    public void setIdiomaAtual(String idioma) {
        this.idiomaAtual = idioma; // Atualiza o idioma atual
    }
}
