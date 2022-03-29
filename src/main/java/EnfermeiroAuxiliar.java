/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gonçalo Aguiar
 */
public class EnfermeiroAuxiliar extends Enfermeiros {
    
    public EnfermeiroAuxiliar(int anoNascimento, int id, String nome, int anoCarreira) {
        super(anoNascimento, id, nome, anoCarreira);
    }
    
    
     @Override
    public String toString(){
        String info;
        info =  "Enfermeiro Auxiliar ID: " + getID()+ "\n";
        info=info + "Ano nascimento: "+ getAnoNascimento()+"\n";
        info = info + "Nome: "+ getNome() + "\n";
        info = info + "Anos de Carreira: "+ getAnoCarreira() + "\n\n";
        
        return info;
    }
    
}
