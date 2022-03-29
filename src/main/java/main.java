/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gonçalo Aguiar
 */
import java.io.IOException;
import java.util.Scanner;
public class main {

    /**
     * @param args the command line arguments
     */
     
    public static void menuPrincipal(){
            int opcaoMedico;
            System.out.println("\n");
            System.out.println("------------ Bem-vindo ao Hospital! ------------");
            System.out.println("Escolha uma opção");
            System.out.println(" ");
            System.out.println("1. Menu Médico");
            System.out.println("2. Menu Enfermeiro");
            System.out.println("3. Menu Administração");
            System.out.println("0. Sair");
            System.out.println(" ");
            System.out.println("Insira a sua opção:");
            
            
            
    } 
    
     public static void menuMedico(){
        System.out.println("\n");
        System.out.println("------------ MENU MÉDICO ------------");
        System.out.println("1. Listar pacientes em espera no hospital");
        System.out.println("2. Listar pacientes a aguardar alta");
        System.out.println("3. Diagonóstico ao paciente");
        System.out.println("4. Dar alta hospitalar");
        System.out.println("5. Requerimento de auxiliares");
        System.out.println("6. Colocar paciente na lista do médico");
        System.out.println("0. Voltar atrás");
        System.out.println(" ");
        System.out.println("Insira a sua opção:");
        
        
        
     }
    
      public static void menuEnfermeiro(){
          System.out.println("\n");
          System.out.println("------------ MENU ENFERMEIRO ------------");
          System.out.println("1. Lista de especialistas e auxiliares atribuídos a um dado médico");
          System.out.println("2. Lista de pacientes a aguardar curativo para um dado enfermeiro");
          System.out.println("3. Atribuir enfermeiro-especialista a médico");
          System.out.println("4. Aplicar curativo a paciente");
          System.out.println("0. Voltar atrás");
          System.out.println(" ");
          System.out.println("Insira a sua opção:");
     }
    
       public static void menuAdministracao(){
            System.out.println("\n");
            System.out.println("------------ MENU ADMINISTRAÇÃO ------------");
            System.out.println("1. Criar Médico");
            System.out.println("2. Criar Especialista");
            System.out.println("3. Criar Auxiliar");
            System.out.println("4. Criar novo paciente");
            System.out.println("5. Promover enfermeiro a chefe");
            System.out.println("6. Aumentar anos de carreira");
            System.out.println("7. Listar enfermeiros");
            System.out.println("8. Listar médicos");
            System.out.println("9. Listar pedidos para enfermeiros auxiliares");
            System.out.println("10. Listar pacientes em espera no hospital");
            System.out.println("11. Atirar pedidos de auxiliares para a trituradora");
            System.out.println("12. Atender ao pedido de auxiliares");
            System.out.println("13. Virus Outbreak");
            System.out.println("14. Gerar relatórios hospitalares");
            System.out.println("15. Sair da aplicação");
            System.out.println("0. Voltar atrás");
            System.out.println(" ");
            System.out.println("Insira a sua opção:");
     }
       
      public static void menuRelatorios(){
          System.out.println("\n");
          System.out.println("------------ MENU RELATORIOS ------------");
          System.out.println("1. Número de infetados por doença");
          System.out.println("2. Infetados causados pelo outbreak");
          System.out.println("3. Taxa de mortalidade e sucesso");
          System.out.println("4. Infetados por faixa etária");
          System.out.println("5. Recuperados por faixa etária");
          System.out.println("6. Óbitos por faixa etária");
          System.out.println("7. Número de óbitos e recuperados");
          
          System.out.println("0. Voltar atrás");
          System.out.println(" ");
          System.out.println("Insira a sua opção:");
     }  
       
    public static void main(String[] args)  throws IOException{
         Hospital hospitalUMa = new Hospital("Hospital do Funchal");
         
      
            hospitalUMa.criaPacientes();
            hospitalUMa.criaAuxiliares();
            hospitalUMa.criaEspecialistas();
            hospitalUMa.criaMedicos();
               
            hospitalUMa.promover(65);
                           
           hospitalUMa.atribuirEspMed(93, 3);
//           hospitalUMa.inserirRequerimentoAux(62,5);
//      
            for (int i =0 ; i<20;i++){
               Pacientes P = new Pacientes(1990+i,Hospital.id,hospitalUMa.calculaTemperatura(),hospitalUMa.calculaSintomasGastro(),hospitalUMa.calculaNivelGB());
               hospitalUMa.addHistorico(P);
               hospitalUMa.id++;
            }
            
            for (int i =0 ; i<200;i++){
               Pacientes P = new Pacientes(1990+i,Hospital.id,hospitalUMa.calculaTemperatura(),hospitalUMa.calculaSintomasGastro(),hospitalUMa.calculaNivelGB());
               hospitalUMa.addObitos(P);
               hospitalUMa.id++;
            }


        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;
        int opcaoMedico;
        int opcaoEnfermeiro;
        int opcaoAdmin;
        
        
        
       
            do {
            menuPrincipal();
            opcaoPrincipal = scanner.nextInt();
          
            switch(opcaoPrincipal){
                
                case 1:
                    do{
                        menuMedico();
                        opcaoMedico = scanner.nextInt();

                        switch(opcaoMedico){
                            case 1:
                                System.out.println("------ LISTA DE PACIENTES NO HOSPITAL (" + hospitalUMa.getListaPacientes().size() + "): ------" );
                                System.out.println(hospitalUMa.getListaPacientes());

                                break;

                            case 2:
                                hospitalUMa.pacientesAguardarAlta();
                                break;

                            case 3:
                                hospitalUMa.diagonostico();
                                break;

                            case 4:
                                hospitalUMa.darAlta();
                                break;

                            case 5:
                              
                                 System.out.println(hospitalUMa.getListaMedicos());
                                System.out.println("Escolha o ID do Médico com o qual pretende realizar o requerimento: ");
                                int idMedico = scanner.nextInt();
                                 System.out.println("\n Existem " + hospitalUMa.getListaAuxiliar().size() + " auxiliares disponíveis no hospital.");
                                System.out.println("Insira o número de auxiliares necessários: ");
                                int num = scanner.nextInt();
                                hospitalUMa.inserirRequerimentoAux(idMedico, num );
                                break;
                            
                            case 6:    
                                hospitalUMa.atenderPaciente();
                                break;
                                
                            case 0:
                                
                                break; 
                        }
                        
                    }while(opcaoMedico != 0);
                  
                    break;    
                case 2:
                    
                    do{
                        menuEnfermeiro();
                        opcaoEnfermeiro = scanner.nextInt();


                        switch(opcaoEnfermeiro){
                            case 1:
                                hospitalUMa.imprimeEnfermeirosDeMedico();
                                break;

                            case 2:
                                hospitalUMa.imprimePacientesAguardarCurativo();
                                break;

                            case 3:
                              
                                int numEsp;
                                System.out.println(hospitalUMa.getListaMedicos());
                                System.out.println("Escolha o ID do médico que pretende adicionar os enfermeiros especialistas.");
                                int idMedico = scanner.nextInt();
                                do{
                                System.out.println("\n Existem " + hospitalUMa.getListaEspecialista().size() + " enfermeiros especialistas disponíveis no hospital."); 
                                System.out.println("Introduza quantos enfermeiros especialistas precisa.(Pelo menos um)");
                                numEsp = scanner.nextInt();
                                }while(numEsp==0);
                                hospitalUMa.atribuirEspMed(idMedico, numEsp);
                                break;

                            case 4:
                                hospitalUMa.aplicarCurativo();
                                break;

                            case 0:
                                
                                break;        
                        } 
                        
                    }while(opcaoEnfermeiro != 0);
                    
                break;    
                
                
                case 3:
                   do{
                   menuAdministracao();
                   opcaoAdmin = scanner.nextInt();
                   
                    
                        switch(opcaoAdmin){
                            case 1:
                                System.out.println("--- CRIAR MÉDICO --- \n Ano de nascimento do médico: ");
                                int ano = scanner.nextInt();
                                if(ano >2021 || ano < 1900 ){
                                    System.out.println("Introduza um ano de nascimento válido. (Inferir a 2021 e superior a 1900)");
                                }
                                else{
                                    
                                    Medicos medico = new Medicos (ano, Hospital.id);     
                                    hospitalUMa.addMedico(medico); // Adiciona o médico acabado de ser instanciado na lista de médicos
                                    hospitalUMa.add3Pacientes(medico);  // Adiciona os 3 pacientes ao médico acabado de ser instanciado
                                    System.out.println("Adicionou um novo médico. \n");
                                    Hospital.id++;
                                }
                                

                                break;

                            case 2:
                                System.out.println("--- CRIAR ENFERMEIRO ESPECIALISTA --- \n Ano de nascimento do enfermeiro especialista: ");
                                int anoNascimentoEsp = scanner.nextInt();
                                if(anoNascimentoEsp >2021 || anoNascimentoEsp < 1900 ){
                                    System.out.println("Introduza um ano de nascimento válido. (Inferir a 2021 e superior a 1900)");
                                }
                                else{
                                    System.out.println("Nome do enfermeiro especialista: ");
                                    String nomeEsp = scanner.next();
                                    System.out.println("Anos de Carreira do enfermeiro especialista: ");
                                    int anoCarreiraEsp = scanner.nextInt();
                                    hospitalUMa.addEspecialista(new EnfermeiroEspecialista(anoNascimentoEsp,Hospital.id,nomeEsp,anoCarreiraEsp));
                                    Hospital.id++;
                                    System.out.println("Adicionou um novo enfermeiro especialista. \n");
                                }
                                break;

                            case 3:
                                System.out.println("--- CRIAR ENFERMEIRO AUXILIAR --- \n Escolha quantos auxiliares deseja criar: ");
                                hospitalUMa.criaAuxiliares(scanner.nextInt());   
                                break;

                            case 4:
                                System.out.println("--- CRIAR PACIENTE --- \n Ano de nascimento do paciente: ");
                                int anoNascPaciente = scanner.nextInt();
                                if(anoNascPaciente >2021 || anoNascPaciente < 1900 ){
                                    System.out.println("Introduza um ano de nascimento válido. (Inferir a 2021 e superior a 1900)");
                                }
                                
                                else{
                                    hospitalUMa.addPacientes(new Pacientes (anoNascPaciente,Hospital.id,hospitalUMa.calculaTemperatura(),hospitalUMa.calculaSintomasGastro(),hospitalUMa.calculaNivelGB()));
                                    System.out.println("Adicionou um novo paciente. \n");
                                    Hospital.id++;
                                }
                                
                                break;

                            case 5:
                                hospitalUMa.listadecandidatosaChefe();
                                System.out.println("Escolha o enfermeiro que deseja promover pelo ID: ");
                                int id = scanner.nextInt();     
                                hospitalUMa.promover(id);
                                break;

                            case 6:
                                System.out.println("Anos de Carreira a adicionar: ");
                                hospitalUMa.incrementaAnosCarreira(scanner.nextInt());
                                break;

                            case 7:
                                hospitalUMa.imprimeEnfermeiros();
                                break;

                            case 8:
                                System.out.println("------ LISTA DE MÉDICOS NO HOSPITAL (" + hospitalUMa.getListaMedicos().size() + "): ------" );
                                System.out.println(hospitalUMa.getListaMedicos());
                                break;

                            case 9:
                                System.out.println("------ PEDIDOS PARA ENFERMEIROS AUXILIARES (" + hospitalUMa.getListaRequerimentos().size() + "): ------" );
                                System.out.println("ID do Médio ....... NºAuxiliares Necessários");
                                System.out.println(hospitalUMa.getListaRequerimentos());
                                
                                break;

                            case 10:
                                System.out.println("------ LISTA DE PACIENTES NO HOSPITAL (" + hospitalUMa.getListaPacientes().size() + "): ------" );
                                System.out.println(hospitalUMa.getListaPacientes());
                                break;

                            case 11:
                                hospitalUMa.pedidosAuxTrituradora();
                                System.out.println(hospitalUMa.getListaRequerimentos());
                                break;

                            case 12:
                                hospitalUMa.atenderRequerimento();
                                break;

                            case 13:
                              
                                hospitalUMa.outbreak();
                                break;

                                
                                
                            case 14:
                                int opcaoRelatorios;
                                
                                do{  
                                    menuRelatorios();
                                    opcaoRelatorios = scanner.nextInt();
                                     switch(opcaoRelatorios){
                                        case 1:
                                            hospitalUMa.relatorioTotalPorDoenca();
                                            break;
                                             
                                        case 2:
                                            hospitalUMa.relatorioOutbreak();
                                            break;
                                             
                                        case 3:
                                            hospitalUMa.relatorioTaxas();
                                            break;
                                             
                                        case 4:
                                            hospitalUMa.infetadosPorIdade();
                                            break;
                                             
                                        case 5:
                                            hospitalUMa.RecuperadosPorIdade();
                                            break;
                                            
                                        case 6:
                                            hospitalUMa.ObitosPorIdade();
                                            break;
                                            
                                        case 7:
                                            hospitalUMa.taxaMortalidadeERecuperados();
                                            break; 
                                        
                                        case 0:
                                            
                                            break;        
 
                                    }
                                         
                                } while(opcaoRelatorios !=0);
                                break;
                                

                            case 15:
                                System.out.println("Saindo da aplicação...");
                                System.exit(0);
                                break;

                            case 0:
                               
                                break;    
                        }
                       
                   } while(opcaoAdmin !=0);
                
                break;   
            } 
           
            }while(opcaoPrincipal !=0); 
    }
    
}