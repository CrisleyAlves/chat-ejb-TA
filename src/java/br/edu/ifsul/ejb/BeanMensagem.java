/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Singleton;
import java.util.List;

/**
 *
 * @author devuser
 */
@Singleton
public class BeanMensagem implements Serializable{
    
    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private String mensagem;
    
    public BeanMensagem(){}

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void adicionaUsuario(Usuario usuario){
        usuario.setId(this.usuarios.size() + 1);
        this.usuarios.add(usuario);
    }
    
    public void adicionaMensagem(Mensagem mensagem){
        this.mensagens.add(mensagem);
    }
    
    public void removerUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public int nextUsuarioId(){
        return this.usuarios.size()+1;
    }
    
}
