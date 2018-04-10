/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.ejb.BeanMensagem;
import br.edu.ifsul.modelo.Mensagem;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author devuser
 */
@Named(value = "controleMensagem")
@SessionScoped
public class ControleMensagem implements Serializable{
    
    @EJB
    private BeanMensagem beanMensagem;
    
    private Mensagem mensagem;
    private Usuario usuario;
    
    public ControleMensagem(){
        this.mensagem = new Mensagem();
        this.usuario = new Usuario();
    }
    
    public String verChat(){
        return "/chat/listar";
    }
    
    
    public void adicionaMensagem(){
        this.mensagem.setDataMensagem(Calendar.getInstance());
        this.mensagem.setUsuario(getUsuario());
        this.beanMensagem.adicionaMensagem(mensagem);        
        this.mensagem = new Mensagem();
    }
    
    public BeanMensagem getBeanMensagem() {
        return beanMensagem;
    }

    public void setBeanMensagem(BeanMensagem beanMensagem) {
        this.beanMensagem = beanMensagem;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void entrarChat(){
        this.beanMensagem.adicionaUsuario(usuario);
        this.beanMensagem.adicionaMensagem(
                new Mensagem(beanMensagem.nextUsuarioId(), 
                usuario.getNomeUsuario() + " entrou na sala", 
                Calendar.getInstance()));
    }
    
    public void sairChat(){
        this.beanMensagem.adicionaUsuario(usuario);
        this.beanMensagem.adicionaMensagem(
                new Mensagem(beanMensagem.nextUsuarioId(), 
                usuario.getNomeUsuario() + " saiu na sala", 
                Calendar.getInstance()));
        
        this.beanMensagem.removerUsuario(usuario);
        this.beanMensagem.removerUsuario(usuario);
        
        this.usuario = new Usuario();
    }
    
    private int number;
 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        System.out.println("chamou");
        number++;
    }
    
    
    
    
}
