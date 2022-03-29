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
public class EnfermeiroEspecialista extends Enfermeiros {
    
    private ArrayList <Pacientes> listaPacientesEsp;
    
    public EnfermeiroEspecialista(int anoNascimento, int id, String nome, int anoCarreira) {
        super(anoNascimento, id, nome, anoCarreira);
        listaPacientesEsp = new ArrayList<Pacientes>(3);
    }
    
    public ArrayList<Pacientes> getListaPacientesEsp(){
        return listaPacientesEsp;
    }
    
    public void addPacientesEsp(Pacientes p){
       listaPacientesEsp.add(p);
    }
    
    @Override
    public String toString(){
        String info;
        info =  "Enfermeiro Especialista ID: " + getID()+ "\n";
        info=info + "Ano nascimento: "+ getAnoNascimento()+"\n";
        info = info + "Nome: "+ getNome() + "\n";
        info = info + "Anos de Carreira: "+ getAnoCarreira() + "\n";
        info=info + "Lista de Pacientes à espera do curativo: " + getListaPacientesEsp()+"\n\n";
        
        return info;
    }
    
}
