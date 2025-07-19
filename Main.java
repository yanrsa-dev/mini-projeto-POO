import java.util.Scanner;
public class Main{
    	public static void main (String[] args) {
        int op;
        Scanner scan= new Scanner(System.in);
        do{
             System.out.println("------MENU------");
              System.out.println("SELECIONE UMA OPÇÃO");           
            System.out.println("1. Cadastrar Produto");
             System.out.println("2. Alterar Produto");
             System.out.println("3. Cadastrar Cliente");
             System.out.println("4. Alterar Cliente");
             System.out.println("5. Criar Nota de Compra");
             System.out.println("6. Listar Notas Emitidas");
             System.out.println("7. Listar Produtos");
             System.out.println("8. Listar Clientes");
             System.out.println("0. Sair");
             op = scan.nextInt();
             
             switch(op){
                 case 1:
                     // Lógica para cadastrar produto
                     break;
                 case 2:
                     // Lógica para alterar produto
                     break;
                 case 3:
                     // Lógica para cadastrar cliente
                     break;
                 case 4:
                     // Lógica para alterar cliente
                     break;
                 case 5:
                     // Lógica para criar nota de compra
                     break;
                 case 6:
                     // Lógica para listar notas emitidas
                     break;
                 case 7:
                     // Lógica para listar produtos
                     break;
                 case 8:
                     // Lógica para listar clientes
                     break;
                 case 0:
                     System.out.println("Saindo...");
                     break;
                 default:
                     System.out.println("Opção inválida! Tente novamente.");
             } 
        }while(op!=0);
        /*pegando as infos do teclado*/
        scanclose();

    }
}