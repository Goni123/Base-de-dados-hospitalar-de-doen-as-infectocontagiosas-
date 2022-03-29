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
public class Medicos {
    
    private int anoNascimento;
    private int id;
    private ArrayList <Pacientes> listaPacientesMed;
    private ArrayList <EnfermeiroAuxiliar> listaEnfermeirosAuxMed;
    private ArrayList <EnfermeiroEspecialista> listaEnfermeirosEspMed;
   
    
    public Medicos(int anoNascimento , int id){
        this.anoNascimento = anoNascimento;
        this.id = id;
        listaPacientesMed = new ArrayList <Pacientes>(3);
        listaEnfermeirosAuxMed = new ArrayList <EnfermeiroAuxiliar>();
        
        listaEnfermeirosEspMed = new ArrayList <EnfermeiroEspecialista>();
    }
    
    public void addPacientesMed(Pacientes p){
        listaPacientesMed.add(p); 
    }
    
    public void addAuxiliaresMed(EnfermeiroAuxiliar enfAux){
        listaEnfermeirosAuxMed.add(enfAux); 
    }
    
   public void addEspecialistasMed(EnfermeiroEspecialista enfEsp){
       listaEnfermeirosEspMed.add(enfEsp);
   }
    
    @Override
    public String toString(){
        String texto;
        texto = "\n--- Médico ID: " + id + " Ano de nascimento: " + anoNascimento+" ---\n";
       // texto = texto + "Pacientes do medico: " + getPacientesMed();
        return texto;
                
    }

    // Get's
    
    
    public int getID(){
       return id;
   }
    
    public int getAnoNascimento(){
       return anoNascimento;
    }
       
    public ArrayList<Pacientes> getPacientesMed(){
        return listaPacientesMed;
    }
    
    public ArrayList <EnfermeiroAuxiliar> getAuxiliaresMed(){
        return listaEnfermeirosAuxMed;
    }
    
    public ArrayList <EnfermeiroEspecialista> getEspecialistasMed(){
        return listaEnfermeirosEspMed;
    }

 
    // Set's
    
    public void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    } 
     
    public void setID(int id){
        this.id = id;
    } 
    
}
