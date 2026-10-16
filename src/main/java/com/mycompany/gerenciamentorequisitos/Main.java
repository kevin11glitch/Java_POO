package com.mycompany.gerenciamentorequisitos;
import com.mycompany.gerenciamentorequisitos.telas.Usuarios.TelaProjetos;
import com.formdev.flatlaf.FlatLightLaf;
/**
 * Classe principal do sistema de gerenciamento de requisitos.
 *
 * @author kevin
 */
public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        TelaProjetos tela = new TelaProjetos();
        tela.setVisible(true);
    }
}