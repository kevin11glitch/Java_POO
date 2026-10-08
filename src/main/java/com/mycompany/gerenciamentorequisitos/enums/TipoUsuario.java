/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciamentorequisitos.enums;

/**
 *
 * @author kevin
 */
public enum TipoUsuario {
    COMUM, //vizualizar projeto, requisitos e histórico
    GERENTE_DE_PROJETO, //todas as funcionalidades
    ANALISTA, //todas as funcionalidades menos criar e editar projetos, e gerenciar usuários
    DESENVOLVEDOR, //todas as funcionalidades menos criar e editar projetos, e gerenciar usuários nem excluir requisitos
}
