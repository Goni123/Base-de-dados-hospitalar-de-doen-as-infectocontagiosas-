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
import java.io.*;
import java.text.DecimalFormat; 


public class Hospital {
    private String nome;
    private ArrayList<Pacientes> listaPacientes;
    private ArrayList<Medicos> listaMedicos;
    private ArrayList <EnfermeiroEspecialista> listaEspecialistas;
    private ArrayList <EnfermeiroAuxiliar> listaAuxiliar;
    private ArrayList <Enfermeiros> listaChefes;
    private LinkedHashMap <Integer,Integer> listaRequerimentos;
    private ArrayList<Medicos> listaEXMedicos;
    private ArrayList <EnfermeiroAuxiliar> listaEXAuxiliar;
    private ArrayList <EnfermeiroEspecialista> listaEXEspecialistas;
    private ArrayList <Pacientes> listaHistorico;
    private ArrayList <Pacientes> listaObitos;
    static int id = 0;
    private int ultimoRequerimento;
    
    public Hospital(String nome){
        this.nome=nome;
        listaPacientes = new ArrayList<Pacientes>();
        listaMedicos = new ArrayList<Medicos>();
        listaEspecialistas = new ArrayList<EnfermeiroEspecialista>();
        listaAuxiliar = new ArrayList<EnfermeiroAuxiliar>();
        listaChefes = new ArrayList<Enfermeiros>();
        listaRequerimentos= new LinkedHashMap <Integer,Integer>();
        
        listaEXMedicos = new ArrayList<Medicos>();
        listaEXAuxiliar = new ArrayList<EnfermeiroAuxiliar>();
        listaEXEspecialistas = new ArrayList<EnfermeiroEspecialista>();
        listaHistorico = new ArrayList<Pacientes>();
        listaObitos = new ArrayList<Pacientes>();
    }
    
    Scanner scanner = new Scanner(System.in);
    
    public boolean existeMedico (int idMedico){
        boolean existe = false;
        for(int i = 0 ; i<listaMedicos.size();i++){
            if(listaMedicos.get(i).getID()== idMedico){
                existe = true;
                break;
            }
            else{  
                existe = false;
            }
        }
        return existe;
    }
    
    
    public boolean existeEspecialista (int idEspecialista){
        boolean existe = false;
         for(int i = 0 ; i<listaEspecialistas.size();i++){
              if(listaEspecialistas.get(i).getID()== idEspecialista){
                  existe = true;
                  break;
              }
              else  existe = false;
         }
         return existe;
    }
        
   // -------------------------------------- RELATÓRIOS ----------------------------------- 
    
    public void ObitosPorIdade(){
        int obitosMenos18=0;
        int obitos18Entre60=0;
        int obitosMaior60=0;
        
        System.out.println("Escolheu a opção Óbitos por faixa etária.");
        System.out.println("");
        
        for(int i =0 ; i< listaObitos.size(); i++){
            if(listaObitos.get(i).getAnoNascimento()<= 2021 && listaObitos.get(i).getAnoNascimento()>= 2004){
                obitosMenos18++;
            }
            else if(listaObitos.get(i).getAnoNascimento()<= 2003 && listaObitos.get(i).getAnoNascimento()>=1961 ){
                obitos18Entre60++;
            }
            else if(listaObitos.get(i).getAnoNascimento()<= 1962){
                obitosMaior60++;
            }
            
        }
        
        System.out.println(" O hospital do Funchal, apresenta "+ obitosMenos18 + " óbitoscom com idade inferior a 18 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ obitos18Entre60 + " óbitos com a idade compreendida entre 18 e 60 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ obitosMaior60 + " óbitos com idade superior a 60 anos.");
    }
    
    
    public void RecuperadosPorIdade(){
        int recuperadosMenos18=0;
        int recuperados18Entre60=0;
        int recuperadosMaior60=0;
        
        System.out.println("Escolheu a opção Recuperados por faixa etária.");
        System.out.println("");
        
        for(int i =0 ; i< listaHistorico.size(); i++){
            if(listaHistorico.get(i).getAnoNascimento()<= 2021 && listaHistorico.get(i).getAnoNascimento()>= 2004){
                recuperadosMenos18++;
            }
            else if(listaHistorico.get(i).getAnoNascimento()<= 2003 && listaHistorico.get(i).getAnoNascimento()>=1961 ){
                recuperados18Entre60++;
            }
            else if(listaHistorico.get(i).getAnoNascimento()<= 1962){
                recuperadosMaior60++;
            }
            
        }
        
        System.out.println(" O hospital do Funchal, apresenta "+ recuperadosMenos18 + " pessoas recuperadas com idade inferior a 18 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ recuperados18Entre60 + " pessoas recuperadas com a idade compreendida entre 18 e 60 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ recuperadosMaior60 + " pessoas recuperadas com idade superior a 60 anos.");
    }
    
    
    public void infetadosPorIdade(){
        int infetadosMenos18=0;
        int infetados18Entre60=0;
        int infetadosMaior60=0;
        System.out.println("Escollheu a opção Infetados por faixa etária.");
        System.out.println("");
        
        for(int i=0; i< listaMedicos.size(); i++){
            for(int j=0; j< listaMedicos.get(i).getPacientesMed().size(); j++){
                if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("HIV") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÉBOLA") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("COVID-19")){
                    if(listaMedicos.get(i).getPacientesMed().get(j).getAnoNascimento()<= 2021 && listaMedicos.get(i).getPacientesMed().get(j).getAnoNascimento()>= 2004){
                        infetadosMenos18++;
                    }
                    else if(listaMedicos.get(i).getPacientesMed().get(j).getAnoNascimento()<= 2003 && listaMedicos.get(i).getPacientesMed().get(j).getAnoNascimento()>=1961 ){
                        infetados18Entre60++;
                    }
                    else if(listaMedicos.get(i).getPacientesMed().get(j).getAnoNascimento()<= 1962){
                        infetadosMaior60++;
                    }
                }
            }
        }
        
        System.out.println(" O hospital do Funchal, apresenta "+ infetadosMenos18 + " pessoas infetadas com idade inferior a 18 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ infetados18Entre60 + " pessoas infetadas com a idade compreendida entre 18 e 60 anos.");
        System.out.println(" O hospital do Funchal, apresenta "+ infetadosMaior60 + " pessoas infetadas com idade superior a 60 anos.");
        
    }
    
    
    
    public void taxaMortalidadeERecuperados(){
        System.out.println("Escolheu a opção Número de óbitos e recuperados");
        System.out.println("");
        System.out.println("O hospital do Funchal contabiliza "+ listaObitos.size() + " mortes.");
        System.out.println("");
        System.out.println("O hospital do Funchal contabiliza "+ listaHistorico.size() + " pessoas recuperadas.");
    }
    
    
    
     public void relatorioTaxas(){
        int totalObitos =  getListaObitos().size();
        int totalRecuperados =  getListaHistorico().size();
        int total = totalObitos + totalRecuperados;
        DecimalFormat decFormat = new DecimalFormat("#%");
        
        
        double taxaSucesso = ((double)totalRecuperados/total);
        double taxaMortalidade = ((double)totalObitos/total);
        
        System.out.println("TAXA DE SUCESSO: " + decFormat.format(taxaSucesso) + "\n" );
        System.out.println("TAXA DE MORTALIDADE: " + decFormat.format(taxaMortalidade) + "\n" );
         
     }
    
    
    public void relatorioOutbreak(){
        
        System.out.println("------ LISTA DE MEDICOS INFETADOS (" + getListaEXMedicos().size() + "): ------ \n" );
        System.out.println(getListaEXMedicos() + "\n");
        System.out.println("------ LISTA DE ENFERMEIROS AUXILIARES INFETADOS (" + getListaEXAuxiliar().size() + "): ------ \n" );
        System.out.println(getListaEXAuxiliar() + "\n");
        System.out.println("------ LISTA DE ENFERMEIROS ESPECIALISTAS INFETADOS (" + getListaEXEspecialista().size() + "): ------ \n" );
        System.out.println(getListaEXEspecialista() + "\n"); 
               
    }
    
    
    
    
    public void relatorioTotalPorDoenca(){
        int numCovid = 0;
        int numEbola = 0;
        int numHIV = 0;
        
        for ( int i = 0 ; i<listaMedicos.size();i++){  // conta nos pacientes associados ao médico
            for ( int j = 0 ; j<listaMedicos.get(i).getPacientesMed().size();j++){
                if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("HIV")) {
                    numHIV++;
                }
                if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÉBOLA")) {
                    numEbola++;
                }
                if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("COVID-19")) {
                    numCovid++;
                }
            }
        }
        
        for ( int i = 0 ; i<listaMedicos.size();i++){  // conta nos pacientes associados ao especialista do médico
            for ( int j = 0 ; j<listaMedicos.get(i).getEspecialistasMed().size();j++){
                 for ( int k = 0 ; k<listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().size();k++){
                    if(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().get(k).getPatologia().contains("HIV")) {
                        numHIV++;
                    }
                    if(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().get(k).getPatologia().contains("ÉBOLA")) {
                        numEbola++;
                    }
                    if(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().get(k).getPatologia().contains("COVID-19")) {
                        numCovid++;
                    }
                 }    
            }
        }
        

            System.out.println("Número de pessoas infetadas por doença: \n");
            System.out.println("HIV: " + numHIV + "\n");
            System.out.println("ÉBOLA: " + numEbola + "\n");
            System.out.println("COVID-19: " + numCovid + "\n");
    }
    
    
    
    
    
    
    
    
    
   // -------------------------------------- FICHEIROS ----------------------------------- 

    

     public void criaPacientes() throws IOException{

       String linha;       
       Scanner fileScan, lineScan;
       fileScan = new Scanner (new File("Pacientes.txt"));
       
       while(fileScan.hasNext()){
           linha = fileScan.nextLine();
           lineScan = new Scanner (linha);
            
           
           Pacientes P = new Pacientes(Integer.parseInt(lineScan.next()),id,lineScan.next(),lineScan.next(),lineScan.next());
          addPacientes(P);
          id ++;  
       }
    }
     
     public void criaAuxiliares() throws IOException{

       String linha;       
       Scanner fileScan, lineScan;
       fileScan = new Scanner (new File("Auxiliares.txt"));
       
       while(fileScan.hasNext()){
           linha = fileScan.nextLine();
           lineScan = new Scanner (linha);
            
           EnfermeiroAuxiliar EA = new EnfermeiroAuxiliar(Integer.parseInt(lineScan.next()),id,lineScan.next(),Integer.parseInt(lineScan.next()));
           addAuxiliar(EA);
           id++;   
       } 
    }
     
      public void criaEspecialistas() throws IOException{

       String linha;       
       Scanner fileScan, lineScan;
       fileScan = new Scanner (new File("Especialistas.txt"));
       
       while(fileScan.hasNext()){
           linha = fileScan.nextLine();
           lineScan = new Scanner (linha);
           
           EnfermeiroEspecialista EE = new EnfermeiroEspecialista(Integer.parseInt(lineScan.next()),id,lineScan.next(),Integer.parseInt(lineScan.next()));
           addEspecialista(EE);
           id++;   
       } 
    }
      
       public void criaMedicos() throws IOException{

       String linha;       
       Scanner fileScan, lineScan;
       fileScan = new Scanner (new File("Medicos.txt"));
       
       while(fileScan.hasNext()){
            linha = fileScan.nextLine();
            lineScan = new Scanner (linha);
           
           
            Medicos medico = new Medicos (Integer.parseInt(lineScan.next()),id);     
            addMedico(medico); // Adiciona o médico acabado de ser instanciado na lista de médicos
            add3Pacientes(medico);  // Adiciona os 
            id++;   
       } 
    }
    
    
    // -------------------------------------- VIRUS OUTBREAK -----------------------------------
    
    public void outbreak(){ 
          int probabilidade;
        
         
        do{
        System.out.println("Introduza a probabilidade de um profissional de saúde ou algum ex-paciente ser infetado (0-100): ");
        probabilidade = scanner.nextInt();
        
        }
          
        while (probabilidade < 0 || probabilidade > 100);
        
        infetaMedicos(probabilidade);
        infetaAuxiliaresHospital(probabilidade);
        infetaAuxiliaresMedicos (probabilidade); 
        infetaEspecialistasHospital( probabilidade);
        infetaEspecialistasMedicos( probabilidade);
        infetaEXPacientes(probabilidade);
 
         
    }
    
    
    public void infetaEXPacientes(int probabilidade){ 
       
        for ( int i = 0 ; i<listaHistorico.size();i++){
            Random random = new Random();
            int randInfeta = random.nextInt(101);
            
            if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
               
                addPacientes(listaHistorico.get(i));
                System.out.println("O paciente " + listaHistorico.get(i).getID() + " da lista de histórico do hospital foi infetado.");
                listaHistorico.remove(listaHistorico.get(i));
                i--;  // para que a próxima iteração seja feita no indice certo, porque foi removida uma posição da lista
                
            }   
        }
       
    } 
    
    
    
    
    public void infetaMedicos(int probabilidade){ 
        for ( int i = 0 ; i<listaMedicos.size();i++){
            Random random = new Random();
            int randInfeta = random.nextInt(101);
            
            if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
                Pacientes P = new Pacientes(listaMedicos.get(i).getAnoNascimento(),listaMedicos.get(i).getID(),calculaTemperatura(),calculaSintomasGastro(),calculaNivelGB());
                addPacientes(P);
                System.out.println("O médico " + listaMedicos.get(i).getID() + " foi infetado.");
                
                
                for ( int j = 0 ; j<listaMedicos.get(i).getAuxiliaresMed().size();j++){
                    listaAuxiliar.add(listaMedicos.get(i).getAuxiliaresMed().get(j)); // coloca os auxiliares do médico na lista de auxiliares do hospital   
                }
                 
                
                for ( int j = 0 ; j<listaMedicos.get(i).getEspecialistasMed().size();j++){
                    listaEspecialistas.add(listaMedicos.get(i).getEspecialistasMed().get(j)); // coloca os especialistas do médico na lista de especialistas do hospital
                          for ( int k = 0 ; k < listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().size();k++){
                              listaPacientes.add(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().get(k));  // coloca os pacientes do especialista na lista de pacientes do hospital
                          }
                }
                
                
                for ( int j = 0 ; j<listaMedicos.get(i).getPacientesMed().size();j++){
                    listaPacientes.add(listaMedicos.get(i).getPacientesMed().get(j)); // coloca os pacientes do médico na lista de especialistas do hospital
                }
                
                
                listaMedicos.get(i).getAuxiliaresMed().clear();
                listaMedicos.get(i).getEspecialistasMed().clear();
                listaMedicos.get(i).getPacientesMed().clear();
                listaEXMedicos.add(listaMedicos.get(i));
                listaMedicos.remove(listaMedicos.get(i));
                i--;   // para que a próxima iteração seja feita no indice certo, porque foi removida uma posição da lista
                
            }
        }
       
    }
    
      public void infetaEspecialistasHospital(int probabilidade){ 
       
        for ( int i = 0 ; i<listaEspecialistas.size();i++){
            Random random = new Random();
            int randInfeta = random.nextInt(101);
            
            if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
                Pacientes P = new Pacientes(listaEspecialistas.get(i).getAnoNascimento(),listaEspecialistas.get(i).getID(),calculaTemperatura(),calculaSintomasGastro(),calculaNivelGB());
                addPacientes(P);
              
                System.out.println("O especialista " + listaEspecialistas.get(i).getID() + " da lista do hospital foi infetado.");

                listaEXEspecialistas.add(listaEspecialistas.get(i));
                listaEspecialistas.remove(listaEspecialistas.get(i));
                i--;  // para que a próxima iteração seja feita no indice certo, porque foi removida uma posição da lista
                
            }   
        }
       
    } 
      
      
      
        public void infetaEspecialistasMedicos(int probabilidade){
            
        for ( int i = 0 ; i<listaMedicos.size();i++){
            for ( int j = 0 ; j<listaMedicos.get(i).getEspecialistasMed().size();j++){
                
                Random random = new Random();
                int randInfeta = random.nextInt(101);
                
                if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
              
                    int idAux = listaMedicos.get(i).getEspecialistasMed().get(j).getID();
                    int anoNasc = listaMedicos.get(i).getEspecialistasMed().get(j).getAnoNascimento();
                    
                    Pacientes P = new Pacientes(anoNasc,idAux,calculaTemperatura(),calculaSintomasGastro(),calculaNivelGB());
                    addPacientes(P);
                    System.out.println("O especialista " + listaMedicos.get(i).getEspecialistasMed().get(j).getID() + " associado ao médico " +
                           listaMedicos.get(i).getID() + " foi infetado.");
                     
                    
                    for ( int k = 0 ; k < listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().size();k++){
                        listaPacientes.add(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp().get(k));  // coloca os pacientes do especialista na lista de pacientes do hospital
                    }
                    
                    listaEXEspecialistas.add(listaMedicos.get(i).getEspecialistasMed().get(j));
                    listaMedicos.get(i).getEspecialistasMed().remove(listaMedicos.get(i).getEspecialistasMed().get(j));
                    j--;
                    
                
                }
            }
            
        }
      
    }
      
      
      public void infetaAuxiliaresHospital(int probabilidade){ 
       
        for ( int i = 0 ; i<listaAuxiliar.size();i++){
            Random random = new Random();
            int randInfeta = random.nextInt(101);
            
            if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
                Pacientes P = new Pacientes(listaAuxiliar.get(i).getAnoNascimento(),listaAuxiliar.get(i).getID(),calculaTemperatura(),calculaSintomasGastro(),calculaNivelGB());
                addPacientes(P);
                System.out.println("O auxiliar " + listaAuxiliar.get(i).getID() + " da lista do hospital foi infetado.");

                
                listaEXAuxiliar.add(listaAuxiliar.get(i));
                listaAuxiliar.remove(listaAuxiliar.get(i));
                i--;   // para que a próxima iteração seja feita no indice certo, porque foi removida uma posição da lista
                
            }   
        }
       
    }    
    
     
     
    public void infetaAuxiliaresMedicos(int probabilidade){
            
        for ( int i = 0 ; i<listaMedicos.size();i++){
            for ( int j = 0 ; j<listaMedicos.get(i).getAuxiliaresMed().size();j++){
                
                Random random = new Random();
                int randInfeta = random.nextInt(101);
                
                if (randInfeta < probabilidade){   // tendo em conta a probabilidade, se o numero gerado for inferior: adiciona um novo paciente com o mesmo ID do médico
              
                    int idAux = listaMedicos.get(i).getAuxiliaresMed().get(j).getID();
                    int anoNasc = listaMedicos.get(i).getAuxiliaresMed().get(j).getAnoNascimento();
                    
                    Pacientes P = new Pacientes(anoNasc,idAux,calculaTemperatura(),calculaSintomasGastro(),calculaNivelGB());
                    addPacientes(P);
                    
                    System.out.println("O auxiliar " + listaMedicos.get(i).getAuxiliaresMed().get(j).getID() + " associado ao médico " +
                           listaMedicos.get(i).getID() + " foi infetado.");
                     
                    
                    listaEXAuxiliar.add(listaMedicos.get(i).getAuxiliaresMed().get(j));
                    listaMedicos.get(i).getAuxiliaresMed().remove(listaMedicos.get(i).getAuxiliaresMed().get(j));
                    j--;  // para que a próxima iteração seja feita no indice certo, porque foi removida uma posição da lista
                    
                
                }
            }
            
        }
      
    }
    
    
 // -------------------------------------- ENFERMEIROS -----------------------------------
    
    
    public void imprimeEnfermeiros(){
        int totalEnfermeiros = getListaAuxiliar().size() + getListaEspecialista().size();
        System.out.println("------ LISTA DE ENFERMEIROS DISPONÍVEIS NO HOSPITAL (" + totalEnfermeiros + "): ------ \n" );
        System.out.println("--> LISTA DE ENFERMEIROS AUXILIARES DISPONÍVEIS (" + getListaAuxiliar().size() + ") \n \n " + getListaAuxiliar());
        System.out.println(" \n --> LISTA DE ENFERMEIROS ESPECIALISTAS DISPONÍVEIS(" + getListaEspecialista().size() + ") \n \n " + getListaEspecialista());
        
         System.out.println(" \n --> LISTA DE ENFERMEIROS-CHEFES \n \n " + getListaChefes());
        
        System.out.println("------ LISTA DE ENFERMEIROS AUXILIARES ATRIBUÍDOS A MÉDICOS: ------ \n" );
        for(int i = 0 ; i<listaMedicos.size();i++){
             System.out.println("--> Médico ID " + listaMedicos.get(i).getID() + " (" + listaMedicos.get(i).getAuxiliaresMed().size() + ") \n" );
             System.out.println(listaMedicos.get(i).getAuxiliaresMed() + " \n" );
             
        }
        
        System.out.println("------ LISTA DE ENFERMEIROS ESPECIALISTAS ATRIBUÍDOS A MÉDICOS: ------ \n" );
        for(int i = 0 ; i<listaMedicos.size();i++){
             System.out.println("--> Médico ID " + listaMedicos.get(i).getID() + " (" + listaMedicos.get(i).getEspecialistasMed().size() + ") \n" );
             System.out.println(listaMedicos.get(i).getEspecialistasMed() + " \n" );
             
        }
    }
    
    public void imprimeEnfermeirosDeMedico() {
          if (listaMedicos.isEmpty()) {
             System.out.println("Não existe nenhum médico no hospital.");
            }
          
          else {
            System.out.println(getListaMedicos());
            System.out.println("\n Introduza o ID do médico para listar os seus enfermeiros associados: ");
              
            int idMedico = scanner.nextInt();
            
            for ( int i = 0 ; i<listaMedicos.size();i++){ // percorre a lista de médicos
                   if  (listaMedicos.get(i).getID()== idMedico){   // até encontrar o médico com id = idMedico
                        System.out.println(listaMedicos.get(i) );
                        System.out.println("--> Lista de enfermeiros auxiliares do médico ID " + listaMedicos.get(i).getID()+ ": \n");
                        System.out.println(listaMedicos.get(i).getAuxiliaresMed());
                        System.out.println("--> Lista de enfermeiros especialistas do médico ID " + listaMedicos.get(i).getID()+ ": \n");
                        System.out.println(listaMedicos.get(i).getEspecialistasMed());
                   }
                   
                   else if (!existeMedico(idMedico)) {
                       System.out.println("O médico que escolheu não existe.");
                   }
                    
              }
          }
          
      }
    
    public void imprimePacientesAguardarCurativo() {
          if (listaMedicos.isEmpty()) {
             System.out.println("Não existe nenhum médico no hospital.");
            }
          
          else {
            System.out.println(getListaMedicos());
            System.out.println("\n Introduza o ID do médico para listar os seus enfermeiros associados: ");
              
            int idMedico = scanner.nextInt();
            int idEnfermeiroEspecialista;
            
            for ( int i = 0 ; i<listaMedicos.size();i++){ // percorre a lista de médicos
                   if  (listaMedicos.get(i).getID()== idMedico){   // até encontrar o médico com id = idMedico
                        System.out.println(listaMedicos.get(i) );
                        System.out.println("--> Lista de enfermeiros especialistas do médico ID " + listaMedicos.get(i).getID()+ ": \n");
                        System.out.println(listaMedicos.get(i).getEspecialistasMed());
                        System.out.println("");
                        System.out.println("Escolha o ID do Enfermeiro Especialista.");
                        idEnfermeiroEspecialista=scanner.nextInt();
                        for(int j=0;j<listaMedicos.get(j).getEspecialistasMed().size();j++){
                            if(listaMedicos.get(i).getEspecialistasMed().get(j).getID()==idEnfermeiroEspecialista){
                                System.out.println(listaMedicos.get(i).getEspecialistasMed().get(j));
                                System.out.println("--> Lista de paciente do enfermeiros especialistas ID " + listaMedicos.get(i).getEspecialistasMed().get(j).getID()+ ": \n");
                                System.out.println(listaMedicos.get(i).getEspecialistasMed().get(j).getListaPacientesEsp());
                                System.out.println("");
                            }
                            else if(!existeEspecialista(idEnfermeiroEspecialista)){
                                System.out.println("O enfermeiro que escolheu não existe.");
                            }
                       }
                            
                       
                   }
                   
                   else if (!existeMedico(idMedico)) {
                       System.out.println("O médico que escolheu não existe.");
                   }
                    
              }
          }
          
      }
    
    // -------------------------------------- REQUERIMENTO/CRIAÇÃO/ATRIBUIÇÃO/REMOÇÃO DE AUXILIARES -----------------------------------
    
    
    public void addAuxMed (Medicos medico,int quantAux){
        Random random = new Random();
        
        for(int i = 0 ; i <quantAux;i++){
            int indice = random.nextInt(listaAuxiliar.size());
            medico.addAuxiliaresMed(listaAuxiliar.get(indice));
            listaAuxiliar.remove(indice);
        }
    }
    
    public void inserirRequerimentoAux(int id , int numAuxNecessarios){  // menu médico
        Medicos m = new Medicos(0,0);
       
        if (listaChefes.isEmpty()) {
             System.out.println("Não existe nenhum enfermeiro-chefe disponível para atender o pedido.");
        }
        
        else {
            
            if (existeMedico(id) == true){
                if(listaAuxiliar.size()< numAuxNecessarios){  // Se não existem auxiliares suficientes, é feito o requerimento para a administração
                    listaRequerimentos.put(id,numAuxNecessarios);
                    ultimoRequerimento = id;
                    System.out.println("Não existem auxiliares suficientes para satisfazer o pedido. \n "
                            + "Foi realizado um requerimento de auxiliares à administração.");
                }
  
                else{
                    //atribuição normal
                    for(int i = 0 ; i<listaMedicos.size();i++){
                        if(listaMedicos.get(i).getID()==id){
                            m=listaMedicos.get(i);
                        }
                    }

                    addAuxMed(m,numAuxNecessarios);
                    
                    System.out.println("Foram atribuidos " + numAuxNecessarios +" enfermeiros auxiliares ao médico ID " + id);
                }

            }
            else{
                System.out.println("O médico que introduziu nao existe.");
            }
        }    
    }
    
    public void atenderRequerimento () {
        Random random = new Random();
        int numAuxiliares = random.nextInt(2)+2;  // a administração irá atender ao pedido com 2 ou 3 auxiliares
         
        
        if (listaRequerimentos.isEmpty()) {
            System.out.println("Não existem pedidos para requerimento de auxiliares.");
        }
        
        else {
        
            Medicos medico = new Medicos(0,0);
           

            for(int i=0 ; i <listaMedicos.size();i++){
                if(listaMedicos.get(i).getID() == ultimoRequerimento){
                    medico=listaMedicos.get(i);
                }
            }
            
            System.out.println("Ultimo requerimento feito pelo médico: " + ultimoRequerimento);
           
            System.out.println("Serão criados " + numAuxiliares + " auxiliares para atender ao pedido. Introduza os dados dos enfermeiros:");
            criaAuxiliares (numAuxiliares);
            addAuxMed(medico,numAuxiliares); 
            listaRequerimentos.remove(ultimoRequerimento);
             System.out.println("O pedido foi concluído e foram atribuídos " + numAuxiliares + 
                     " auxiliares ao médico ID " + ultimoRequerimento);
            
        }
    }
    
    public void criaAuxiliares (int quantidade){ 
        for(int i=1 ; i <=quantidade; i++){
 
            System.out.println("Ano de nascimento do enfermeiro auxiliar " + i +": ");
            int anoNascimentoAux = scanner.nextInt();
            
            if(anoNascimentoAux >2021 || anoNascimentoAux < 1900 ){
                System.out.println("Introduza um ano de nascimento válido. (Inferior a 2021 e superior a 1900)");
                }
            else{
                System.out.println("Nome do enfermeiro auxiliar " + i +": ");
                String nomeAux = scanner.next();
                System.out.println("Anos de Carreira do enfermeiro auxiliar " + i +": ");
                int anoCarreiraAux = scanner.nextInt();
                addAuxiliar(new EnfermeiroAuxiliar(anoNascimentoAux,Hospital.id,nomeAux,anoCarreiraAux));
                Hospital.id++;
                System.out.println("\n");
            }    
        }
    }
    
    
    public void pedidosAuxTrituradora(){
        Random random =  new Random();
        ArrayList <Integer> idMed;
        idMed = new ArrayList <Integer>();
        int aux;
        int indice;
        int num;
        
        for(int i=0;i<listaMedicos.size();i++){
            if(listaRequerimentos.containsKey(listaMedicos.get(i).getID())){
                idMed.add(listaMedicos.get(i).getID());
            }
        }
       
        do{
           num = random.nextInt(listaRequerimentos.size()+1);  // número de pedidos que vão ser removidos
        }while(num==0);
        
        System.out.println("Serão removidos "+num+" pedidos da lista.");

        for(int i = 0; i<num;i++){

            indice = random.nextInt(idMed.size());//indice do pedido que vai ser removido
            aux = idMed.get(indice);


            listaRequerimentos.remove(aux);
            idMed.remove(indice);
        }

        System.out.println("Os pedidos de Auxiliares foram removidos.");
        
    }
    
      // -------------------------------------- ATRIBUIÇÃO DE ESPECIALISTAS -----------------------------------
      
    public void addEspMed (Medicos medico,int quantEsp){
        Random random = new Random();
        if(quantEsp>listaEspecialistas.size()){
            System.out.println("Não existem mais Enfermeiros Especialistas no Hospital.");
            System.out.println("É necessário criar mais.");
        }
        else{
            for(int i = 0 ; i <quantEsp;i++){
                int indice = random.nextInt(listaEspecialistas.size());
                medico.addEspecialistasMed(listaEspecialistas.get(indice));
                listaEspecialistas.remove(indice);
            }
            System.out.println("Foram atribuidos " + quantEsp +" enfermeiros especialistas ao médico ID " + medico.getID());
        }
    }
    
    public void atribuirEspMed(int id , int numEspNecessarios){
        Medicos m = new Medicos(0,0);
       
        if (listaChefes.isEmpty()) {
             System.out.println("Não existe nenhum enfermeiro-chefe disponível para atender o pedido.");
        }
        
        else {
            
            if (existeMedico(id) == true){                
                    //atribuição normal
                    for(int i = 0 ; i<listaMedicos.size();i++){
                        if(listaMedicos.get(i).getID()==id){
                            m=listaMedicos.get(i);
                        }
                    }
       
                    addEspMed(m,numEspNecessarios);
     
            }
            else{
                System.out.println("O médico que introduziu nao existe.");
            }
        }    
    }
    
   
      
   // -------------------------------------- ESPECIALISTAS E CHEFES -----------------------------------  
   
    public void listadecandidatosaChefe(){  // mostra os enfermeiros com 25 anos de carreira
       
        for(int i = 0 ; i<listaEspecialistas.size();i++){
            if(listaEspecialistas.get(i).getAnoCarreira() >= 25 ){
                System.out.println(listaEspecialistas.get(i));
            }
        }
    }
    
    public void promover(int id){

        String nomeEspecialista = new String();

        for(int i = 0 ; i<listaEspecialistas.size();i++){
            if(listaEspecialistas.get(i).getID() == id){
                if(listaEspecialistas.get(i).getAnoCarreira() >= 25){
                    nomeEspecialista = listaEspecialistas.get(i).getNome();
                    listaChefes.add(listaEspecialistas.get(i));
                    listaEspecialistas.remove(listaEspecialistas.get(i));
                    System.out.println("O Enfermeiro Especialista " + nomeEspecialista + " foi promovido a Enfermeiro Chefe.");
                    break;
                }
            }
            else if(i==listaEspecialistas.size()-1){
                System.out.println("O enfermeiro que escolheu, não possui a experiência necessária para o cargo.");
            }
        }
    }  
                
    public void incrementaAnosCarreira(int anos){
        for (int i =0 ; i<listaEspecialistas.size();i++){
            EnfermeiroEspecialista a = listaEspecialistas.get(i);
            int aux = a.getAnoCarreira();
            int aux2 = aux + anos;
            a.setAnoCarreira(aux2);    
        }
        
        for (int i =0 ; i<listaAuxiliar.size();i++){
            EnfermeiroAuxiliar a = listaAuxiliar.get(i);
            int aux = a.getAnoCarreira();
            int aux2 = aux + anos;
            a.setAnoCarreira(aux2);
        } 
        
        for (int i =0 ; i<listaMedicos.size();i++){ //percorre a lista de médicos
            for (int j =0 ; j<listaMedicos.get(i).getAuxiliaresMed().size();j++){  // percorre a lista de auxiliares do médico
            
                int anoAtual = listaMedicos.get(i).getAuxiliaresMed().get(j).getAnoCarreira();
                listaMedicos.get(i).getAuxiliaresMed().get(j).setAnoCarreira(anoAtual+anos);
            }    
        }
        
        for (int i =0 ; i<listaMedicos.size();i++){ //percorre a lista de médicos
             for (int j =0 ; j<listaMedicos.get(i).getEspecialistasMed().size();j++){  // percorre a lista de especialistas do médico
                 
                int anoAtual = listaMedicos.get(i).getEspecialistasMed().get(j).getAnoCarreira();
                listaMedicos.get(i).getEspecialistasMed().get(j).setAnoCarreira(anoAtual+anos);
             }
        }
        
        System.out.println("Foram aumentados "+ anos+" anos de carreia a todos os enfermeiros do hospital. \n"); 
        
    }
    
     // -------------------------------------- MÉDICOS E PACIENTES -----------------------------------
  
    public void atenderPaciente(){ 
        int idMedico;
        Medicos medico = new Medicos(0,0);
       
        if(listaMedicos.isEmpty()){
            System.out.println("Não existem Médicos no Hospital disponíveis.");
            System.out.println("");  
        }
        
        else {
            System.out.println(listaMedicos); 
            System.out.println("Escolha o Médico que pretende utilizar.");
            idMedico=scanner.nextInt();
            
            for(int i=0 ; i <listaMedicos.size();i++){  // percorre a lista para encontrar o medico com ID escolhido
                if(listaMedicos.get(i).getID() == idMedico){
                    medico=listaMedicos.get(i);
                } 
            }
       
            if(medico.getPacientesMed().size() >= 3){
                System.out.println("O médico escolhido já tem 3 pacientes na sua lista.");
            }
            
            else{
                try 
                {
                    medico.addPacientesMed(listaPacientes.get(0));   // adiciona à lista de pacientes do médico ( médico este que será passado no parametro) o paciente na posição i da lista de pacientes
                    listaPacientes.remove(0);  // remove o paciente da lista de pacientes  
                    System.out.println("Foi adicionado um paciente à lista do médico.");
                } 

                catch (IndexOutOfBoundsException  e) {
                    System.out.println("Não existem pacientes na fila de espera.");
                }
            }    
        }
    }    
   
    
    
    
    
    
   public void darAlta(){
       try {
            int aux=0;
            int idMedico;
            int idPaciente;
            System.out.println("Escolha o Médico que pretende utilizar.");
            System.out.println(listaMedicos);
            idMedico=scanner.nextInt();
            if(listaMedicos.isEmpty()){
                System.out.println("Não existem Médicos no Hospital disponíveis.");
                System.out.println("");
            }
            else{
                for(int i =0 ; i<listaMedicos.size();i++){
                    if(listaMedicos.get(i).getID() == idMedico){
                        System.out.println(" ");
                        System.out.println("Escolheu o Médico com o ID "+ idMedico);
                        System.out.println("");
                        System.out.println("Escolha o Paciente que pretende dar alta.");
                        System.out.println(listaMedicos.get(i).getPacientesMed());
                        System.out.println("");
                        idPaciente = scanner.nextInt();
                        
                        for(int j=0 ; j< listaMedicos.get(i).getPacientesMed().size(); j++){
                            if(listaMedicos.get(i).getPacientesMed().isEmpty()){
                                
                                System.out.println("O médico que escolheu não tem Pacientes associados.");
                                break;
  
                            }
                            else{
                                
                                if(listaMedicos.get(i).getPacientesMed().get(j).getID()== idPaciente){
                                    if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("SAUDAVEL")){
                                        
                                        System.out.println("");
                                        System.out.println("O paciente com o ID "+ idPaciente+ " teve alta.");
                                        listaHistorico.add(listaMedicos.get(i).getPacientesMed().get(j));
                                        listaMedicos.get(i).getPacientesMed().remove(listaMedicos.get(i).getPacientesMed().get(j));
                                        break;
                                    }
                                    else if (listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÓBITO")){
                                        System.out.println("");
                                        System.out.println("O paciente com o ID "+ idPaciente+ " foi dado como óbito.");
                                        System.out.println("Os nossos pesâmes");
                                        System.out.println("");
                                        listaObitos.add(listaMedicos.get(i).getPacientesMed().get(j));
                                        listaMedicos.get(i).getPacientesMed().remove(listaMedicos.get(i).getPacientesMed().get(j));
                                        break;
                                    }
                                    else if (listaMedicos.get(i).getPacientesMed().get(j).getPatologia().isEmpty()){
                                        System.out.println("O paciente com o ID "+idPaciente+ " não tem o diagonóstico realizado ainda.");
                                        break;
                                    }
                                    else if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("HIV") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÉBOLA") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("COVID-19")){
                                        System.out.println("O paciente com o ID "+idPaciente + " ainda encontra-se doente. Faça um novo diagonóstico.");
                                        break;
                                    }
                                }
                                else if(j==listaMedicos.get(i).getPacientesMed().size()-1){
                                    System.out.println("O Paciente que escolheu não existe.");
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    else if (i==listaMedicos.size()-1){
                        
                        System.out.println("O Médico que introduziu não existe.");
                        break;
                       
                    }
                }   
            }
        }
        catch(InputMismatchException ime){
            System.out.println("Não introduziu um inteiro.");
        }
    } 
    
    
    
   public void pacientesAguardarAlta(){
        
        try{
            int aux=0;
            int idMedico;
            System.out.println("Escolha o Médico que pretende visualizar a lista de de pacientes a aguardar alta.");
            System.out.println(listaMedicos);
            idMedico=scanner.nextInt();
            if(listaMedicos.isEmpty()){
                System.out.println("Não existem Médicos no Hospital disponíveis.");
                System.out.println("");
            }
            else{
                for(int i =0 ; i<listaMedicos.size();i++){
                    if(listaMedicos.get(i).getID() == idMedico){
                        System.out.println(" ");
                        System.out.println("Escolheu o Médico com o ID "+ idMedico);
                        System.out.println("");
                       
                        for(int j=0 ; j< listaMedicos.get(i).getPacientesMed().size(); j++){
                            if(listaMedicos.get(i).getPacientesMed().isEmpty()){
                                
                                System.out.println("O médico que escolheu não tem Pacientes associados.");
                                break;
  
                            }
                            else{
                                
                                if(!(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().isEmpty())){
                                    if(aux==0){
                                    System.out.println("A lista de pacientes a aguardar alta é a seguinte:");
                                    aux=1;
                                    }
                                    System.out.println("");
                                    System.out.println(listaMedicos.get(i).getPacientesMed().get(j));
                                    
                                    
                                }
                                else if (j==listaMedicos.get(i).getPacientesMed().size()-1){
                                    System.out.println("O Médico que escolheu não tem Pacientes a aguardar alta.");
                                    break;
                                    
                                }
                            }
                        }
                        break;
                    }
                    else if (i==listaMedicos.size()-1){
                        
                        System.out.println("O Médico que introduziu não existe.");
                        break;
                       
                    }
                }
          
                
            }
        }
        catch(InputMismatchException ime){
            System.out.println("Não introduziu um inteiro.");
        }
    } 
    
    
    
   public void diagonostico(){
        Scanner scanner = new Scanner(System.in);
        int idPaciente;
        int idEspecialista;
        int aux=0;

        if(listaMedicos.isEmpty()){
            System.out.println("A lista de Médicos encontra-se vazia. Crie um novo médico primeiro.");
        }
        
        else{
            
              for ( int i = 0 ; i<listaMedicos.size();i++){ // mostra os médicos e os seus pacientes
                   System.out.println(listaMedicos.get(i) );
                    System.out.println("--> Lista de pacientes do médico ID " + listaMedicos.get(i).getID()+ ":");
                   System.out.println(listaMedicos.get(i).getPacientesMed());
              }
            System.out.println("Escolha o Médico que pretende usar, pelo ID.");
            int idMed = scanner.nextInt();
            System.out.println("");
            
            
            for ( int i = 0 ; i<listaMedicos.size();i++){
                if(listaMedicos.get(i).getID()==idMed){  // se encontrar o médico com ID = idMed
                    
                    if(listaMedicos.get(i).getEspecialistasMed().isEmpty()) {
                            System.out.println("O médico escolhido não tem nenhum enfermeiro especialista associado.");
                            aux = 4;
                        }
                        else {    
                    
                        aux=1;
                        System.out.println("Escolheu o Médico com o ID "+ idMed );
                        System.out.println("Escolha o Paciente que pretende fazer o diagnóstico, pelo ID.");
                        listaMedicos.get(i).getPacientesMed();
                        idPaciente = scanner.nextInt();

                        for(int j =0; j<listaMedicos.get(i).getPacientesMed().size();j++){
                       
                            
                        
                            if(listaMedicos.get(i).getPacientesMed().get(j).getID()==idPaciente){  // se encontrar o paciente (j) na lista do médico (i)
                                aux=2;
                                if((listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÓBITO"))){
                                    System.out.println("Diagnóstico inválido.");
                                    aux=10;
                                }
                                if((listaMedicos.get(i).getPacientesMed().get(j).getNivelGB().equals("baixo"))  & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("HIV")) & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÓBITO"))){
                                    listaMedicos.get(i).getPacientesMed().get(j).addPatologia("HIV");
                                    System.out.println("Foi diagnósticado ao seu paciente HIV");
                                } 
                                if((listaMedicos.get(i).getPacientesMed().get(j).getSintomasGastro().equals("elevado"))  & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÉBOLA")) & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÓBITO")) ){
                                    listaMedicos.get(i).getPacientesMed().get(j).addPatologia("ÉBOLA");
                                    System.out.println("Foi diagnósticado ao seu paciente ÉBOLA");
                                }
                                if((listaMedicos.get(i).getPacientesMed().get(j).getTemperatura().equals("elevado"))  & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("COVID-19")) & (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÓBITO"))){
                                    listaMedicos.get(i).getPacientesMed().get(j).addPatologia("COVID-19");
                                    System.out.println("Foi diagnósticado ao seu paciente COVID-19");
                                }
                                if((listaMedicos.get(i).getPacientesMed().get(j).getNivelGB().equals("elevado")) && (listaMedicos.get(i).getPacientesMed().get(j).getSintomasGastro().equals("baixo")) && (listaMedicos.get(i).getPacientesMed().get(j).getTemperatura().equals("baixo")) && (!listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("SAUDAVEL")) ){
                                    listaMedicos.get(i).getPacientesMed().get(j).addPatologia("SAUDAVEL");
                                    System.out.println("O paciente encontra-se saudável.");
                                    aux=7;
                                }
                               
                                if(listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("HIV") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("ÉBOLA") || listaMedicos.get(i).getPacientesMed().get(j).getPatologia().contains("COVID-19")){
                                    System.out.println("\n" + listaMedicos.get(i).getEspecialistasMed());
                                    System.out.println("");
                                    System.out.println("Escolha o ID do Enfermeiro Especialista que pretende enviar os Pacientes.");
                                    idEspecialista = scanner.nextInt();

                                    for(int k =0; k<listaMedicos.get(i).getEspecialistasMed().size();k++){
                                        if(listaMedicos.get(i).getEspecialistasMed().get(k).getID() == idEspecialista){
                                            aux=3;

                                            listaMedicos.get(i).getEspecialistasMed().get(k).addPacientesEsp(listaMedicos.get(i).getPacientesMed().get(j));
                                            listaMedicos.get(i).getPacientesMed().remove(listaMedicos.get(i).getPacientesMed().get(j));
                                            System.out.println("O paciente foi enviado para o enfermeiro especialista ID "+ idEspecialista );

                                        }

                                    }

                                }
                            }
                        }
                    }
                   
                } 
            }
            if(aux==0){
                System.out.println("O médico que escolheu não existe.");
            }
            if(aux==1){
                System.out.println("O paciente que introduziu não se encontra associado ao médico.");
            }
            if(aux==2){
                System.out.println("O Enfermeiro Especialista que introduziu não se encontra associado ao médico.");
            }
           
        }
    }
    
    
    public void aplicarCurativo(){
       
        Random random = new Random();
        Random random2 = new Random();
        int idEsp;
        int idPaciente;
        int changeCurativo;
        int aux=0;
        int vacina;
        Medicos med = new Medicos(0,0);
        
        try{    
                vacina=random2.nextInt(101);
               
                System.out.println("");
                for(int q=0 ; q< listaMedicos.size();q++){
                    for(int w=0 ; w < listaMedicos.get(q).getEspecialistasMed().size();w++){
                        System.out.println(listaMedicos.get(q).getEspecialistasMed().get(w));
                    }
                }
                System.out.println("Escolha o Enfermeiro Especialista que pretende utilizar:");
                idEsp=scanner.nextInt();
                
        
                for(int m =0; m <listaMedicos.size(); m++){
                    for(int n=0;n<listaMedicos.get(m).getEspecialistasMed().size();n++){
                        if(listaMedicos.get(m).getEspecialistasMed().get(n).getID() == idEsp){
                            med = listaMedicos.get(m);
                        }
                    }
                }
            
                for(int i = 0; i <med.getEspecialistasMed().size();i++){
                    if(idEsp==med.getEspecialistasMed().get(i).getID()){
                        aux=2;
                        System.out.println("Escolheu o Enfermeiro Especialista com o ID: "+ idEsp);

                        if(med.getEspecialistasMed().get(i).getListaPacientesEsp().isEmpty()){
                            System.out.println("O enfermeiro especialista escolhido não tem nenhum paciente na sua agenda para administrar o curativo.");
                            aux=4;
                        }
                        else{
                            
                            System.out.println("Escolha o paciente da lista que pretende administrar o curativo.");
                            med.getEspecialistasMed().get(i).getListaPacientesEsp();
                            idPaciente = scanner.nextInt();
                            for(int j=0; j<med.getEspecialistasMed().get(i).getListaPacientesEsp().size();j++){
                                if(idPaciente == med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getID()){
                                    aux=3;
                                    System.out.println("Escolheu o Paciente com o ID: " + idPaciente);
                                        if(vacina>10){
                                            if(med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().contains("HIV")){
                                                changeCurativo = random.nextInt(101);
                                                if(changeCurativo >55){

                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().remove("HIV");
                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).setNivelGB("elevado");
                                                    System.out.println("Foi administrado um curativo para HIV.");

                                                }
                                            }
                                            else if(med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().contains("COVID-19")){
                                                changeCurativo = random.nextInt(101);
                                                if(changeCurativo > 60){

                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().remove("COVID-19");
                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).setTemperatura("baixo");
                                                    System.out.println("Foi administrado um curativo para a COVID-19.");
                                                }
                                            }
                                            else if(med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().contains("ÉBOLA")){
                                                changeCurativo = random.nextInt(101);
                                                if(changeCurativo > 40){

                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().remove("ÉBOLA");
                                                    med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).setSintomasGastro("baixo");
                                                    System.out.println("Foi administrado um curativo para o ÉBOLA.");
                                                }
                                            }
                                        }
                                        else{
                                            med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().clear(); //remove todos as doenças
                                            med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j).getPatologia().add("ÓBITO"); // adiciona óbito
                                            
                                          
                                        }

                                        med.addPacientesMed(med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j));
                                        med.getEspecialistasMed().get(i).getListaPacientesEsp().remove(med.getEspecialistasMed().get(i).getListaPacientesEsp().get(j));
                                        System.out.println("O paciente foi devolvido ao médico para fazer o respetivo diagonóstico.");
                                }
                            }
                        }
                    }
                }
                                          
                
                if(aux==1){
                    System.out.println("O enfermeiro especialistas que escolheu não existe");
                }
                if(aux==2){
                    System.out.println("O paciente que escolheu não se encontra associado ao enfermeiro especialista.");
                }
            
        }
        catch(InputMismatchException ime){
            System.out.println("Não introduziu um inteiro.");
        }
    }
    
    
    
    
    
    
    
    
    

    public void add3Pacientes(Medicos medico){
        try 
        {
            for(int i =0 ; i<3;i++){

                    medico.addPacientesMed(listaPacientes.get(0));   // adiciona à lista de pacientes do médico ( médico este que será passado no parametro) o paciente na posição i da lista de pacientes
                    listaPacientes.remove(0);  // remove o paciente da lista de pacientes
            }     
        } 
        
        catch (IndexOutOfBoundsException  e) {
                    System.out.println("O médico não ficou com a lista de pacientes completa.");
                }
    }
    
    public String calculaTemperatura(){
        String info;
        Random random = new Random();
        
        int num = random.nextInt(100);
        
        if(num<50){
            info = "elevado";
        }
        else{
            info= "baixo";
        }
        
        return info;
        
    }
    
    public String calculaSintomasGastro(){
        String info;
        Random random = new Random();
        
        int num = random.nextInt(100);
        
        if(num<50){
            info = "baixo";
        }
        else{
            info= "elevado";
        }
        
        return info;
    }
    
    public String calculaNivelGB(){
        String info;
        Random random = new Random();
        
        int num = random.nextInt(100);
        
        if(num<50){
            info = "elevado";
        }
        else{
            info= "baixo";
        }
        
        return info;
    }
    
     
    // -------------------------------------- GET'S -----------------------------------
     
    public HashMap <Integer,Integer> getListaRequerimentos(){
        return listaRequerimentos;
    }
    
    public ArrayList<Pacientes> getListaPacientes(){
        return listaPacientes;
    }
     
    public ArrayList<Medicos> getListaMedicos(){
        return listaMedicos;
    } 
    
     public ArrayList<Medicos> getListaEXMedicos(){
        return listaEXMedicos;
    } 
       
    public ArrayList <EnfermeiroEspecialista> getListaEspecialista(){
        return listaEspecialistas;
    }
    
    public ArrayList <EnfermeiroEspecialista> getListaEXEspecialista(){
        return listaEXEspecialistas;
    }
        
    public ArrayList <EnfermeiroAuxiliar> getListaAuxiliar(){
        return listaAuxiliar;
    }
    
      public ArrayList <EnfermeiroAuxiliar> getListaEXAuxiliar(){
        return listaEXAuxiliar;
    }
     
    public ArrayList <Enfermeiros> getListaChefes(){
        return listaChefes;
    }
    
    public ArrayList <Pacientes> getListaHistorico(){
        return listaHistorico;
    }
    
     public ArrayList <Pacientes> getListaObitos(){
        return listaObitos;
    }
    
    
    // -------------------------------------- SET'S -----------------------------------
    
    
    public void addPacientes(Pacientes paciente){
        listaPacientes.add(paciente);
    }
    
    public void addMedico(Medicos medico){
        listaMedicos.add(medico);
    }

    public void addEspecialista(EnfermeiroEspecialista especialista){
        listaEspecialistas.add(especialista);
    }
     
    public void addAuxiliar(EnfermeiroAuxiliar auxiliar){
        listaAuxiliar.add(auxiliar);
    }
    
    public void addHistorico(Pacientes paciente){
        listaHistorico.add(paciente);
    }
    
    public void addObitos(Pacientes paciente){
        listaObitos.add(paciente);
    }
    
  
        @Override
    public String toString(){
        String texto;
        texto = "O hospital " + nome + " tem os seguintes médicos: \n";
        texto += listaMedicos;
        texto = texto + "Lista de Pacientes: " + listaPacientes + "\n";
        texto = texto + "Lista de Enfermeiros Especialistas: " + listaEspecialistas + "\n";
        texto = texto + "Lista de Enfermeiros Auxiliar: " + listaAuxiliar + "\n";
        
        return texto;
    }   
      
}

