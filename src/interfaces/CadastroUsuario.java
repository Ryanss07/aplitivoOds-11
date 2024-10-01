package interfaces;

import classes.BancoDeDados;
import classes.Idioma;
import classes.Tradutor;
import classes.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class CadastroUsuario extends javax.swing.JFrame {
    private BancoDeDados bancoDeDados;
    private Tradutor tradutor;

    public CadastroUsuario(String idiomaAtual) {
        tradutor = new Tradutor(idiomaAtual);
        initComponents(); // Inicializa os componentes
        setTitle(tradutor.traduzir("cadastroUsuario"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        traduzirComponentes();

                // Ação dos botões de idioma
        pt_btn.addActionListener(e -> {
            Idioma.setIdiomaAtual("pt");
                    traduzirComponentes();
        });

        en_btn.addActionListener(e -> {
            Idioma.setIdiomaAtual("en");
                    traduzirComponentes();
        });
         es_btn.addActionListener(e -> {
            Idioma.setIdiomaAtual("es");
                    traduzirComponentes();
        });

        pack(); // Ajusta o tamanho da janela para caber os componentes
        setVisible(true);
    }
   // public CadastroUsuario() {
    //    initComponents();
    //}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        t_label = new javax.swing.JLabel();
        nm_txt = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        em_txt = new javax.swing.JTextField();
        senhaLabel = new javax.swing.JLabel();
        psw_txt = new javax.swing.JPasswordField();
        psw_btn = new javax.swing.JRadioButton();
        cdt_btn = new javax.swing.JButton();
        pswVisivel_txt = new javax.swing.JTextField();
        end_txt = new javax.swing.JTextField();
        end_label = new javax.swing.JLabel();
        dsc_label = new javax.swing.JLabel();
        dsc2_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsmenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        pt_btn = new javax.swing.JMenuItem();
        en_btn = new javax.swing.JMenuItem();
        es_btn = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(935, 590));
        setResizable(false);
        setSize(new java.awt.Dimension(935, 590));
        getContentPane().setLayout(null);

        t_label.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        t_label.setText("Faça Seu Cadastro de Morador");
        getContentPane().add(t_label);
        t_label.setBounds(20, 10, 350, 40);

        nm_txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nm_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nm_txtActionPerformed(evt);
            }
        });
        getContentPane().add(nm_txt);
        nm_txt.setBounds(40, 200, 230, 60);

        nomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeLabel.setText("Nome :");
        getContentPane().add(nomeLabel);
        nomeLabel.setBounds(40, 180, 230, 20);

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailLabel.setText("Email:");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(40, 260, 230, 20);

        em_txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        em_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                em_txtActionPerformed(evt);
            }
        });
        getContentPane().add(em_txt);
        em_txt.setBounds(40, 280, 230, 60);

        senhaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        senhaLabel.setText("Senha:");
        getContentPane().add(senhaLabel);
        senhaLabel.setBounds(40, 440, 230, 20);

        psw_txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        psw_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psw_txtActionPerformed(evt);
            }
        });
        getContentPane().add(psw_txt);
        psw_txt.setBounds(40, 460, 230, 60);

        psw_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        psw_btn.setText("mostrar senha");
        psw_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psw_btnActionPerformed(evt);
            }
        });
        getContentPane().add(psw_btn);
        psw_btn.setBounds(310, 460, 160, 21);

        cdt_btn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cdt_btn.setText("cadastrar");
        cdt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdt_btnActionPerformed(evt);
            }
        });
        getContentPane().add(cdt_btn);
        cdt_btn.setBounds(310, 410, 160, 50);
        getContentPane().add(pswVisivel_txt);
        pswVisivel_txt.setBounds(40, 460, 230, 60);

        end_txt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(end_txt);
        end_txt.setBounds(40, 370, 230, 60);

        end_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        end_label.setText("Endereço:");
        getContentPane().add(end_label);
        end_label.setBounds(40, 346, 230, 20);

        dsc_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dsc_label.setText("Para realizar o seu cadastro,");
        dsc_label.setToolTipText("");
        dsc_label.setMaximumSize(new java.awt.Dimension(935, 554));
        dsc_label.setMinimumSize(new java.awt.Dimension(935, 554));
        dsc_label.setPreferredSize(new java.awt.Dimension(935, 554));
        getContentPane().add(dsc_label);
        dsc_label.setBounds(20, 60, 390, 30);

        dsc2_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dsc2_label.setText("prencha os campos abaixo");
        getContentPane().add(dsc2_label);
        dsc2_label.setBounds(20, 90, 400, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastro.png"))); // NOI18N
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 940, 530);

        optionsmenu.setText("opções");

        jMenu2.setText("Idioma");

        pt_btn.setText("Português (pt-br)");
        jMenu2.add(pt_btn);

        en_btn.setText("Inglês (en)");
        jMenu2.add(en_btn);

        es_btn.setText("espanhol (es)");
        jMenu2.add(es_btn);

        optionsmenu.add(jMenu2);

        jMenuItem1.setText("Tela Inicial");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        optionsmenu.add(jMenuItem1);

        jMenuBar1.add(optionsmenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void em_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_em_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_em_txtActionPerformed

    private void psw_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psw_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psw_txtActionPerformed
    private boolean verificarCampos() {
        if (nm_txt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome deve ser preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
            nm_txt.requestFocus();
            return false;
        }
        if (em_txt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Email deve ser preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
            em_txt.requestFocus();
            return false;
        }
        if (new String(psw_txt.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Senha deve ser preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
            psw_txt.requestFocus();
            return false;
        }
        return true;
    }
    private void cdt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdt_btnActionPerformed
        String nome = nm_txt.getText().trim();
        String email = em_txt.getText().trim();
        String senha = new String(psw_txt.getPassword()).trim();
        String endereco = end_txt.getText().trim();
        // verifica se não à campos vazios
       if(verificarCampos()){
        // Lógica para cadastrar o gerente no Banco de Dados
        BancoDeDados banco = new BancoDeDados();
        banco.cadastrarUsuarioComum(nome, email, senha, endereco);
                JOptionPane.showMessageDialog(this, tradutor.traduzir("usuarioCadastrado"));
        clearFields();
        psw_btn.setSelected(false);
       } else {
                JOptionPane.showMessageDialog(this, tradutor.traduzir("camposVazios"), "Erro", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_cdt_btnActionPerformed

    private void psw_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psw_btnActionPerformed
        // função para deixar a senha visivel   
        if(psw_btn.isSelected()){
              psw_txt.setVisible(false);
              pswVisivel_txt.setVisible(true);
              pswVisivel_txt.setText(psw_txt.getText());
          } else{
                psw_txt.setVisible(true);
                pswVisivel_txt.setVisible(false);    
          }
    }//GEN-LAST:event_psw_btnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaInicial tli = new TelaInicial();
        tli.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void nm_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nm_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nm_txtActionPerformed
    private void clearFields() {
        // função para limpar os campos de dados 
        nm_txt.setText("");
        em_txt.setText("");
        end_txt.setText("");
        psw_txt.setText("");
        pswVisivel_txt.setText("");
    }
       private void traduzirComponentes() {
        t_label.setText(tradutor.traduzir("tituloCadastroMorador"));
        dsc_label.setText(tradutor.traduzir("instrucoesCadastroParte1"));
        dsc2_label.setText(tradutor.traduzir("instrucoesCadastroParte2"));
        nomeLabel.setText(tradutor.traduzir("nome") + ":");
        emailLabel.setText(tradutor.traduzir("email") + ":");
        end_label.setText(tradutor.traduzir("endereco") + ":");
        senhaLabel.setText(tradutor.traduzir("senha") + ":");
        psw_btn.setText(tradutor.traduzir("mostrarSenha"));
        cdt_btn.setText(tradutor.traduzir("cadastrar"));
    }
     private void mudarIdioma(String novoIdioma) {
        tradutor = new Tradutor(Idioma.getIdiomaAtual());
        traduzirComponentes(); // Atualiza todos os textos na interface
        setTitle(tradutor.traduzir("cadastroUsuario")); // Atualiza o título da janela
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new CadastroUsuario("pt");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cdt_btn;
    private javax.swing.JLabel dsc2_label;
    private javax.swing.JLabel dsc_label;
    private javax.swing.JTextField em_txt;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JMenuItem en_btn;
    private javax.swing.JLabel end_label;
    private javax.swing.JTextField end_txt;
    private javax.swing.JMenuItem es_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField nm_txt;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JMenu optionsmenu;
    private javax.swing.JTextField pswVisivel_txt;
    private javax.swing.JRadioButton psw_btn;
    private javax.swing.JPasswordField psw_txt;
    private javax.swing.JMenuItem pt_btn;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JLabel t_label;
    // End of variables declaration//GEN-END:variables
}
