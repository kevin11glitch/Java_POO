/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentorequisitos.model;

import com.mycompany.gerenciamentorequisitos.enums.StatusRequisito;

/**
 *
 * @author kevin
 */
public class Requisito {
    private int idSistema;
    private String idRequisito;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String tipoRequisito;
    private StatusRequisito status;
    private String historico;
    

    public int getIdSistema() {
        return idSistema;
    }

//    public void setIdSistema(int idSistema) {
//        this.idSistema = idSistema;
//    }

    public String getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(String idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(String tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public StatusRequisito getStatus() {
        return status;
    }

    public void setStatus(StatusRequisito status) {
        this.status = status;
    }

    public String getHistorico() {
        return historico;
    }

//    public void setHistorico(String historico) {
//        this.historico = historico;
//    }

}
