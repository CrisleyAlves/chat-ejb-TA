/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author devuser
 */
public class Mensagem implements Serializable{

    private int id;
    private String mensagem;
    private Calendar dataMensagem;
    private Usuario usuario;
    
    public Mensagem(){
        
    }

    public Mensagem(int id, String mensagem, Calendar dataMensagem) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataMensagem = dataMensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Calendar getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Calendar dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getMensagemDiferente(){
                if(usuario != null)
                return usuario.getNomeUsuario() + ": disse: "+mensagem;
            else
                return mensagem;
    }
    
    public String calendarToString(Calendar calendar){
            String formatada;
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            return formatada = sdf.format(calendar.getTime());
    }
    
    
    
}
