/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.heroku.java.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Admin
 */
@Document
public class Base {
    @Id
    private String id;
    private String usuarioCriou;
    private LocalDate criadoEm;
    private String usuarioAtualizou;
    private LocalDate atualizadoEm;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioCriou() {
        return usuarioCriou;
    }

    public void setUsuarioCriou(String usuarioCriou) {
        this.usuarioCriou = usuarioCriou;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getUsuarioAtualizou() {
        return usuarioAtualizou;
    }

    public void setUsuarioAtualizou(String usuarioAtualizou) {
        this.usuarioAtualizou = usuarioAtualizou;
    }

    public LocalDate getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDate atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    private Map<String, String> userSettings = new HashMap<>();

    public Base(String id, String usuarioCriou, LocalDate criadoEm, String usuarioAtualizou, LocalDate atualizadoEm) {
        this.id = id;
        this.usuarioCriou = usuarioCriou;
        this.criadoEm = criadoEm;
        this.usuarioAtualizou = usuarioAtualizou;
        this.atualizadoEm = atualizadoEm;
    }

    public Base() {
    }

    public Base(String id) {
        this.id = id;
    }


	public Map<String, String> getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(Map<String, String> userSettings) {
		this.userSettings = userSettings;
	}

   

}