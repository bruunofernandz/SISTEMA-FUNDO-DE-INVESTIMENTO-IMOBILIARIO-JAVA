import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao = 0;
        Corretora c = new Corretora();

        do {
            System.out.println("\n\n-------------------------------------------");
            System.out.println("| #### WELCOME TO FII MOB ####             |");
            System.out.println("|                                          |");
            System.out.println("| 1- Cadastrar na corretora                |");
            System.out.println("| 2- Mostrar usuarios cadastrados          |");
            System.out.println("| 3- Editar dados de um usuario cadastrado |");
            System.out.println("| 4- TED                                   |");
            System.out.println("| 5- Investir em FII                       |");
            System.out.println("| 6- Resgatar saldo atual                  |");
            System.out.println("| 0- Sair do menu                          |");
            System.out.println("|                                          |");
            System.out.println("-------------------------------------------");

            System.out.println("");
            System.out.print("Digite uma opcao do menu: ");
            opcao = Integer.parseInt(input.nextLine());

            if (opcao == 1) {
                c.Cadastro();
            } else if (opcao == 2) {
                c.MostraLista();
            } else if (opcao == 3) {
                c.Editar();
            } else if (opcao == 4) {
                c.TED();
            } else if (opcao == 5) {

            } else if (opcao == 6) {
                c.ResgataSaldo();
            } else if (opcao == 7) {
                c.retornaCarteira();
            }

        } while (opcao != 0);

        input.close();
    }

}