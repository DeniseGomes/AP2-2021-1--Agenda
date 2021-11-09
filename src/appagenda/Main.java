package appagenda;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main
{   
    public static Agenda a;
    
    static void mostraDados(ContatoBasico obj)            
    {
        System.out.println(obj.getDados());
       if(obj instanceof Contato)
          System.out.println(((Contato)obj).getIdade());
       System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    static void adicionarContato(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Dt de Nascimento(ex:10/09/2020): ");
        String dt[] = sc.next().split("/");
        int dia = Integer.parseInt(dt[0]);
        int mes = Integer.parseInt(dt[1]);
        int ano = Integer.parseInt(dt[2]);
        Contato cont = new Contato(nome, new GregorianCalendar(ano, mes, dia));
        
        boolean flag = true;
        char op;
        while(flag) {
            System.out.print("Adicionar telefone? [s/n]: ");
            op = sc.next().charAt(0);
            
            if(op == 's'){
                System.out.print("Telefone: ");
                String tel = sc.next();
                
                System.out.print("tipo: ");
                String tipo = sc.next();
                
                cont.setTelefone(new Telefone(tel, tipo));
            }
            else{
                flag = false;
            }
        }
        a.inserir(cont);
        System.out.println("Novo contato adicionado");
    }
    static void adicionarContatoComercial(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome da Empresa: ");
        String nome = sc.nextLine();
        
        System.out.print("Atividade: ");
        String atv = sc.nextLine();
        
        System.out.print("Nome do funcionario: ");
        String nomefunc = sc.nextLine();
        ContatoComercial cont = new ContatoComercial(nome,atv,nomefunc);
        
        boolean flag = true;
        char op;
        while(flag) {
            System.out.print("Adicionar telefone? [s/n]: ");
            op = sc.next().charAt(0);
            
            if(op == 's'){
                System.out.print("Telefone: ");
                String tel = sc.next();
                
                System.out.print("tipo: ");
                String tipo = sc.next();
                
                cont.setTelefone(new Telefone(tel, tipo));
            }
            else{
                flag = false;
            }
        }
        a.inserir(cont);
        System.out.println("Novo contato comercial adicionado!");
        
        
    }
    static void adiconarContatoEletronico(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.print("Dt de Nascimento(ex:10/09/2020): ");
        String dt[] = sc.next().split("/");
        int dia = Integer.parseInt(dt[0]);
        int mes = Integer.parseInt(dt[1]);
        int ano = Integer.parseInt(dt[2]);
        
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Website: ");
        String site = sc.next();
        EContato cont = new EContato(nome, new GregorianCalendar(ano, mes, dia), email, site);
        a.inserir(cont);
        System.out.println("Novo contato eletronico adicionado!");
    }
    
    public static void main(String[] args) 
    {   
        a=new Agenda();
        System.out.println("==== Agenda App ====");
        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        while(!sair){
            
            String menu[] = {
                "Sair",
                "Add Contato", 
                "Add contato comercial", 
                "Add contato eletronico", 
                "Buscar contato por nome",
                "Buscar contato por posicao",
                "Buscar contato por email",
                "Listar contatos",
                "Remover contato pelo nome"
            };
            System.out.println("Escolha uma das opcoes:");
            for (int i = menu.length - 1; i >= 0; i--)
                System.out.println(i+"."+menu[i]);
            System.out.print("op: ");
            int op = sc.nextInt();
            switch(op){
                case 0:
                    sair = true;
                    break;
                    
                case 1:
                    adicionarContato();
                    break;
                    
                case 2:
                    adicionarContatoComercial();
                    break;
                case 3:
                    adiconarContatoEletronico();
                    break;
                    
                case 4:
                    sc = new Scanner(System.in);
                    ContatoBasico cont = a.buscar(sc.nextLine());
                    if (cont != null)
                        mostraDados(cont);
                    else
                        System.out.println("contados não encontrado");
                    break;
                    
                case 5:
                    sc = new Scanner(System.in);
                    ContatoBasico con = a.buscar(sc.nextInt());
                    if (con != null)
                        mostraDados(con);
                    else
                        System.out.println("contados não encontrado");
                    break;
                case 6:
                    sc = new Scanner(System.in);
                    EContato econt = a.buscarEmail(sc.next());
                    if (econt != null)
                        mostraDados(econt);
                    else
                        System.out.println("contados não encontrado");
                    break;
                case 7:
                    ArrayList<ContatoBasico> contt = a.buscarTodos();
                    for (ContatoBasico ct : contt) {
                        mostraDados(ct);
                    }
                    break;
                case 8:
                    sc = new Scanner(System.in);
                    a.remover(sc.next());
                    System.out.println("contato removido com sucesso!");
                    break;
                default:
                    sair = true;
                    System.out.println("opcao invalida!!");
                    break;
            }
            System.out.println("===================\n");
        }
        sc.close();
    }
    
}
