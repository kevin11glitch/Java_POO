package com.mycompany.gerenciamentorequisitos;
import com.mycompany.gerenciamentorequisitos.telas.Usuarios.TelaProjetos;
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

    // Verifica o tema utilizado
    System.out.println(
        "Tema atual: " +
        UIManager.getLookAndFeel().getName()
    );

    // Inicializa a interface
    java.awt.EventQueue.invokeLater(() -> {
        new TelaProjetos().setVisible(true);
    });
    }
}