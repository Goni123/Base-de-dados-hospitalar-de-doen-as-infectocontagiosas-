/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gonçalo Aguiar
 */
public class Enfermeiros {
    
    private int anoNascimento;
    private int id;
    private String nome;
    private int anoCarreira;
    
    public Enfermeiros(int anoNascimento, int id , String nome, int anoCarreira){
        this.anoNascimento = anoNascimento;
        this.id = id;
        this.nome = nome;
        this.anoCarreira = anoCarreira;
    }
    
   
   
    
    
    
    
    @Override
    public String toString(){
        String info;
        info =  "Enfermeiro ID: " + getID()+ "\n";
        info=info + "Ano nascimento: "+ getAnoNascimento()+"\n";
        info = info + "Nome: "+ getNome() + "\n";
        info = info + "Anos de Carreira: "+ getAnoCarreira() + "\n\n";
        
        return info;
    }
    
    
    
   // Get's
    
     public int getAnoNascimento(){
        return anoNascimento;
    }
    
    public int getID(){
        return id;
    }
     public String getNome(){
        return nome;
    }
    
      public int getAnoCarreira(){
        return anoCarreira;
    }
    
      
      
      
    // Set's 
    
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento=anoNascimento;
    }
  
    
    public void setID(int id){
        this.id=id;
    }
    
 
    public void setNome(String nome){
        this.nome=nome;
    }
      
     public void setAnoCarreira(int anoCarreira){
        this.anoCarreira = anoCarreira;
    }
    
}
