/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentorequisitos.model;

import java.time.LocalDateTime;

/**
 *
 * @author kevin
 */
public class HistoricoAlteracoes {
    private int idSistema;
    private int idRequisito;
    private int idUsuario;
    private LocalDateTime dataHora;
    private String descricaoMudanca;

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricaoMudanca() {
        return descricaoMudanca;
    }

    public void setDescricaoMudanca(String descricaoMudanca) {
        this.descricaoMudanca = descricaoMudanca;
    }
    
    
            
}
