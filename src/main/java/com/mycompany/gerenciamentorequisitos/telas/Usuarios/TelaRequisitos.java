/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gerenciamentorequisitos.telas.Usuarios;

import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author kevin
 */
public class TelaRequisitos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaRequisitos.class.getName());

    /**
     * Creates new form TelaRequisitos
     */
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
    
    
    private void configurarTabelaRequisitos() {

        javax.swing.table.DefaultTableModel modelo =
            new javax.swing.table.DefaultTableModel(
                new Object[]{
                    "ID", "Título", "Tipo", "Status"
                },
                0
            ) {
                @Override
                public boolean isCellEditable(
                    int linha, int coluna) {
                    return false;
                }
            };

        jTableRequisitos.setModel(modelo);

        // Altura das linhas
        jTableRequisitos.setRowHeight(32);

        // Permite selecionar apenas uma linha
        jTableRequisitos.setSelectionMode(
            javax.swing.ListSelectionModel.SINGLE_SELECTION
        );

        // Preenche a largura disponível
        jTableRequisitos.setAutoResizeMode(
            javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS
        );

        // Largura inicial das colunas
        jTableRequisitos.getColumnModel()
            .getColumn(0).setPreferredWidth(65);

        jTableRequisitos.getColumnModel()
            .getColumn(1).setPreferredWidth(180);

        jTableRequisitos.getColumnModel()
            .getColumn(2).setPreferredWidth(120);

        jTableRequisitos.getColumnModel()
            .getColumn(3).setPreferredWidth(120);
    }

    
    private void configurarPesquisaRequisitos() {

        javax.swing.table.TableRowSorter<
            javax.swing.table.DefaultTableModel
        > filtro = new javax.swing.table.TableRowSorter<>(
            (javax.swing.table.DefaultTableModel)
                jTableRequisitos.getModel()
        );

        jTableRequisitos.setRowSorter(filtro);

        jTextFieldSearchBar.getDocument()
            .addDocumentListener(
                new javax.swing.event.DocumentListener() {

                    private void pesquisar() {

                        String texto =
                            jTextFieldSearchBar
                                .getText().trim();

                        if (texto.isEmpty()) {
                            filtro.setRowFilter(null);
                        } else {
                            filtro.setRowFilter(
                                javax.swing.RowFilter.regexFilter(
                                    "(?iu)" +
                                    java.util.regex.Pattern.quote(texto),
                                    0, 1, 2, 3
                                )
                            );
                        }
                    }

                    @Override
                    public void insertUpdate(
                            javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }

                    @Override
                    public void removeUpdate(
                            javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }

                    @Override
                    public void changedUpdate(
                            javax.swing.event.DocumentEvent e) {
                        pesquisar();
                    }
                }
            );
    }

    
    public TelaRequisitos() {
        initComponents();
        configurarBarraPesquisa();
        configurarTabelaRequisitos();
        configurarPesquisaRequisitos();
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
        jPanelMenu = new javax.swing.JPanel();
        jButtonRequisitos = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jButtonProjetos = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonHistorico = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRequisitos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(780, 480));
        setMinimumSize(new java.awt.Dimension(780, 480));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(780, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(780, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 480));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("GERENCIAMENTO DE REQUISITOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Requisitos");

        jTextFieldSearchBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldSearchBar.setPreferredSize(new java.awt.Dimension(200, 22));
        jTextFieldSearchBar.addActionListener(this::jTextFieldSearchBarActionPerformed);

        jButtonNovo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNovo.setText("+ Novo");
        jButtonNovo.addActionListener(this::jButtonNovoActionPerformed);

        jTableRequisitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Tipo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRequisitos);
        if (jTableRequisitos.getColumnModel().getColumnCount() > 0) {
            jTableRequisitos.getColumnModel().getColumn(2).setResizable(false);
            jTableRequisitos.getColumnModel().getColumn(3).setResizable(false);
        }

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNovo)))
                        .addGap(94, 94, 94))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchBarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaRequisitos().setVisible(true));
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
    private javax.swing.JTable jTableRequisitos;
    private javax.swing.JTextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
