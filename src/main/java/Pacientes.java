/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gonçalo Aguiar
 */

import java.util.*;
public class Pacientes{
    
    private int anoNascimento;
    private int id;
    private String temperatura;
    private String sintomasGastrointestinais;
    private String nivelGB;
    private ArrayList <String> patologia;
    
    public Pacientes(int anoNascimento, int id, String temperatura, String sintomasGastrointestinais, String nivelGB){
        this.anoNascimento = anoNascimento;
        this.id = id; // vai ter de ser passado, aquando da instaciação de um objeto
        this.temperatura = temperatura;
        this.sintomasGastrointestinais = sintomasGastrointestinais;
        this.nivelGB= nivelGB;
        patologia = new ArrayList <String>();
    }
    
    
 
    
    
    @Override
    public String toString(){
       String info;
       info= "Paciente ID: " + getID();
       info= info + " Ano Nascimento: " + getAnoNascimento()+"\n";
       
       info= info + "Temperatura: " + getTemperatura()+"\n";
       info= info + "Sintomas Gastrointestinais: " + getSintomasGastro()+"\n";
       info=info + "nivelGB: " + getNivelGB()+"\n";
       info= info + "Patologia: " + getPatologia() + "\n\n";
       return info;
    }
    
    
    // Get's
    
    public int getAnoNascimento(){
        return anoNascimento;
    }
    
    
    public int getID(){
        return id;
    }
    
    
  
    
    
     public String getTemperatura(){
        return temperatura;
    }
    

    public String getSintomasGastro(){
        return sintomasGastrointestinais;
    }
    
   
    public String getNivelGB(){
        return nivelGB;
    }
    
    public ArrayList <String> getPatologia(){
        return patologia;
    }
    
    
    // Set's
    
    public void setID(int id){
        this.id=id;
    }
    
     public void setAnoNascimento(int anoNascimento){
        this.anoNascimento=anoNascimento;
    }
   
     
     public void setTemperatura(String temperatura){
        this.temperatura=temperatura;
    }
    
     
     public void setSintomasGastro(String sintomasGastrointestinais){
        this.sintomasGastrointestinais=sintomasGastrointestinais;
    }
     
     
    public void setNivelGB(String nivelGB){
        this.nivelGB=nivelGB;
    }
    
    
    public void addPatologia(String doenca){
        patologia.add(doenca);
    }
   
}
