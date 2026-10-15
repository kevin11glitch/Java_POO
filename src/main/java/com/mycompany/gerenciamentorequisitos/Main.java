package com.mycompany.gerenciamentorequisitos;
import com.mycompany.gerenciamentorequisitos.telas.Usuarios.TelaRequisitos;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
/**
 * Classe principal do sistema de gerenciamento de requisitos.
 *
 * @author kevin
 */
public class Main {

    public static void main(String[] args) {
        // Aplica o FlatLaf à aplicação
    FlatLightLaf.setup();

    // Inicializa a interface
    java.awt.EventQueue.invokeLater(() -> {
        new TelaRequisitos().setVisible(true);
    });
    }
}