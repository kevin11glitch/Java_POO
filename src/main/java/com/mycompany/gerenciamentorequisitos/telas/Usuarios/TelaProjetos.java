/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gerenciamentorequisitos.telas.Usuarios;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.Pattern;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
/**
 *
 * @author kevin
 */
public class TelaProjetos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaProjetos.class.getName());

    /**
     * Creates new form TelaProjetos
     */
    
private void configurarFiltroProjetos() {

    DefaultTableModel modelo =
        (DefaultTableModel) jTableProjetos.getModel();

    TableRowSorter<DefaultTableModel> filtro =
        new TableRowSorter<>(modelo);

    jTableProjetos.setRowSorter(filtro);

    jTextFieldSearchBar.getDocument().addDocumentListener(
        new DocumentListener() {

            private void pesquisar() {
                String texto =
                    jTextFieldSearchBar.getText().trim();

                if (texto.isEmpty()) {
                    filtro.setRowFilter(null);
                } else {
                    filtro.setRowFilter(
                        RowFilter.regexFilter(
                            "(?iu)" + Pattern.quote(texto),
                            0
                        )
                    );
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }
        }
    );
}

    private void configurarBarraPesquisa(){
        jTextFieldSearchBar.setText("");
        //placeholder
        jTextFieldSearchBar.putClientProperty(
                "JTextField.placeholderText",
                "Pesquisar projetos..."
        );
        //botão limpar pesquisa
        jTextFieldSearchBar.putClientProperty(
                "JTextField.showClearButton", 
                true
        );
        //bordas arredondadas
        jTextFieldSearchBar.putClientProperty(
                "FlatLaf.style",
                "arc: 18"
        );
        //altura barra
        jTextFieldSearchBar.setPreferredSize(
                new java.awt.Dimension(250, 30)
        );
        //icone
        
        FlatSVGIcon iconeLupa = new FlatSVGIcon(
            "icons/lupa.svg",
            18,
            18
        );

        jTextFieldSearchBar.putClientProperty(
            "JTextField.leadingIcon",
            iconeLupa
        );

        
        
    };
    

    private void configurarColunaAcoes() {

        // Altura das linhas
        jTableProjetos.setRowHeight(36);

        // Configuração da coluna Ações
        TableColumn coluna =
            jTableProjetos.getColumnModel().getColumn(2);

        coluna.setPreferredWidth(150);

        coluna.setCellRenderer(new RenderizadorAcoes());
        coluna.setCellEditor(new EditorAcoes());
    }

    // Cria um botão reutilizável
    private JButton criarBotaoAcao(String texto) {

        JButton botao = new JButton();

        botao.setFocusable(false);
        botao.setToolTipText(texto);

        botao.setMargin(new Insets(3, 5, 3, 5));

        String caminhoIcone = switch (texto) {
            case "Ver" -> "icons/visualizar.svg";
            case "Editar" -> "icons/editar.svg";
            case "Excluir" -> "icons/excluir.svg";
            default -> null;
        };

        if (caminhoIcone != null) {
            botao.setIcon(
                new FlatSVGIcon(caminhoIcone, 18, 18)
            );
        }

        return botao;
    }


    // Organiza os três botões
    private JPanel criarPainelAcoes(
            JButton visualizar,
            JButton editar,
            JButton excluir) {

        JPanel painel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 4, 3)
        );

        painel.add(visualizar);
        painel.add(editar);
        painel.add(excluir);

        return painel;
    }

    //aparência dos botões            
    private class RenderizadorAcoes
            implements TableCellRenderer {

        private final JPanel painel = criarPainelAcoes(
            criarBotaoAcao("Ver"),
            criarBotaoAcao("Editar"),
            criarBotaoAcao("Excluir")
        );

        @Override
        public Component getTableCellRendererComponent(
                JTable tabela,
                Object valor,
                boolean selecionado,
                boolean foco,
                int linha,
                int coluna) {

            painel.setBackground(
                selecionado
                    ? tabela.getSelectionBackground()
                    : tabela.getBackground()
            );

            // Verifica se a linha está vazia
            if (tabela.getValueAt(linha, 0) == null) {

                JPanel vazio = new JPanel();

                vazio.setBackground(
                    painel.getBackground()
                );

                return vazio;
            }

            return painel;
        }
    }


    //cliques nos botões
    private class EditorAcoes extends AbstractCellEditor
            implements TableCellEditor {

        private Object valorOriginal;

        @Override
        public Component getTableCellEditorComponent(
                JTable tabela,
                Object valor,
                boolean selecionado,
                int linha,
                int coluna) {

            valorOriginal = valor;

            JButton visualizar = criarBotaoAcao("Ver");
            JButton editar = criarBotaoAcao("Editar");
            JButton excluir = criarBotaoAcao("Excluir");

            visualizar.addActionListener(e ->
                executarAcao(tabela, linha, "visualizar")
            );

            editar.addActionListener(e ->
                executarAcao(tabela, linha, "editar")
            );

            excluir.addActionListener(e ->
                executarAcao(tabela, linha, "excluir")
            );

            JPanel painel = criarPainelAcoes(
                visualizar, editar, excluir
            );

            painel.setBackground(tabela.getBackground());

            return painel;
        }

        private void executarAcao(
                JTable tabela, int linha, String acao) {

            // Converte a linha visual para a linha do modelo
            int indiceModelo =
                tabela.convertRowIndexToModel(linha);

            DefaultTableModel modelo =
                (DefaultTableModel) tabela.getModel();

            Object valorNome =
                modelo.getValueAt(indiceModelo, 0);

            fireEditingStopped();

            if (valorNome == null) {
                return;
            }

            String nomeProjeto = valorNome.toString();

            switch (acao) {

                case "visualizar":
                    JOptionPane.showMessageDialog(
                        TelaProjetos.this,
                        "Visualizar: " + nomeProjeto
                    );
                    break;

                case "editar":
                    JOptionPane.showMessageDialog(
                        TelaProjetos.this,
                        "Editar: " + nomeProjeto
                    );
                    break;

                case "excluir":
                    int resposta = JOptionPane.showConfirmDialog(
                        TelaProjetos.this,
                        "Deseja excluir o projeto " +
                        nomeProjeto + "?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (resposta == JOptionPane.YES_OPTION) {
                        modelo.removeRow(indiceModelo);
                    }
                    break;
            }
        }

        @Override
        public Object getCellEditorValue() {
            return valorOriginal;
        }
    }

    
    public TelaProjetos() {
        initComponents();
        configurarBarraPesquisa();
        configurarFiltroProjetos();
        configurarColunaAcoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonNovo = new javax.swing.JButton();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjetos = new javax.swing.JTable();
        jPanelMenu = new javax.swing.JPanel();
        jButtonRequisitos = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jButtonProjetos = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonHistorico = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(780, 480));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(780, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(780, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 480));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("GERENCIAMENTO DE REQUISITOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Projetos");

        jButtonNovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNovo.setText("+ Novo");
        jButtonNovo.addActionListener(this::jButtonNovoActionPerformed);

        jTextFieldSearchBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldSearchBar.setPreferredSize(new java.awt.Dimension(200, 22));

        jTableProjetos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"{Projeto X}", "{StatusProjeto}", null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Projeto", "Status", "Ações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableProjetos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTableProjetos);

        jPanelMenu.setMaximumSize(new java.awt.Dimension(2147483647, 480));
        jPanelMenu.setMinimumSize(new java.awt.Dimension(120, 480));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(120, 480));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRequisitos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRequisitos.setText("Requisitos");
        jButtonRequisitos.addActionListener(this::jButtonRequisitosActionPerformed);
        jPanelMenu.add(jButtonRequisitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, -1));

        jButtonInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonInicio.setText("Inicio");
        jButtonInicio.addActionListener(this::jButtonInicioActionPerformed);
        jPanelMenu.add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));

        jButtonProjetos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonProjetos.setText("Projetos");
        jButtonProjetos.addActionListener(this::jButtonProjetosActionPerformed);
        jPanelMenu.add(jButtonProjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, -1));

        jButtonUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonUsuarios.setText("Usuários");
        jPanelMenu.add(jButtonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, -1));

        jButtonHistorico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonHistorico.setText("Histórico");
        jPanelMenu.add(jButtonHistorico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, -1));

        jButtonSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(this::jButtonSairActionPerformed);
        jPanelMenu.add(jButtonSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 100, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovo)))
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonRequisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRequisitosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRequisitosActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProjetosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProjetosActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        com.formdev.flatlaf.FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {
            new TelaRequisitos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHistorico;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonProjetos;
    private javax.swing.JButton jButtonRequisitos;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProjetos;
    private javax.swing.JTextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
