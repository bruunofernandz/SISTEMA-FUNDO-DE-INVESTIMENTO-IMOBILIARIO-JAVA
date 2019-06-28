import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.*;

public class Corretora extends Pessoa {

    int saldoT;
    Scanner input = new Scanner(System.in);
    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    Cconta cCarteira = new Cconta();

    public class Cconta {
        private String codigo;
        private int agencia;
        private int conta;
        private double valor;

        List<Cconta> carteira = new ArrayList<Cconta>();

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getCodigo() {
            return this.codigo;
        }

        public void setAgencia(int agencia) {
            this.agencia = agencia;
        }

        public int getAgencia() {
            return this.agencia;
        }

        public void setConta(int conta) {
            this.conta = conta;
        }

        public int getConta() {
            return this.conta;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public double getValor() {
            return this.valor;
        }
    }

    public void Cadastro() {
        Pessoa p = new Pessoa();

        System.out.print("Nome: ");
        p.setNome(input.nextLine());

        if (p.getNome().equals("")) {
            System.out.println("O campo nao pode ficar vazio !");
            return;
        } else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(p.getNome());
            if (matcher.find()) {
                System.out.println("Nao deve conter numeros");
                return;
            }
        }

        System.out.print("CPF: ");
        p.setCpf(input.nextLine());
        System.out.print("RG: ");
        p.setRg(input.nextLine());
        System.out.print("Agencia: ");
        p.setAgencia(input.nextInt());
        System.out.print("Conta: ");
        p.setConta(input.nextInt());
        System.out.print("Saldo: R$ ");
        p.setSaldo(input.nextDouble());

        System.out.println("");
        System.out.println("## Cadastro realizado com sucesso ##");

        listaPessoas.add(p);
        input.nextLine();
    }

    public void mostraLista() {
        System.out.println(listaPessoas.toString());
    }

    public void Editar() {
        String cpf;
        System.out.print("Digite o CPF do usuario no qual os dados serão alterados: ");
        cpf = input.nextLine();

        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaPessoas.get(i).getCpf().equals(cpf)) {
                System.out.println("Verificando o CPF em nossa base de dados... ");
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Deu erro!");
                }
                System.out.println("Nome encontrado, digite as novas informacoes a seguir \n");
                System.out.print("Novo Nome: ");
                listaPessoas.get(i).setNome(input.nextLine());
                System.out.print("Novo CPF: ");
                listaPessoas.get(i).setCpf(input.nextLine());
                System.out.print("Novo RG: ");
                listaPessoas.get(i).setRg(input.nextLine());
                System.out.print("Nova Agencia: ");
                listaPessoas.get(i).setAgencia(input.nextInt());
                System.out.print("Nova Conta: ");
                listaPessoas.get(i).setConta(input.nextInt());
                System.out.print("Novo Saldo: R$ ");
                listaPessoas.get(i).setSaldo(input.nextDouble());
            } else {
                System.out.println("Nome nao encontrado ! \n");
            }
        }
    }

    public void TED() {
        String verificaCpf;
        System.out.println("## BEM VINDO AO SISTEMA DE TRANSFERENCIA ELETRONICA ##\n");
        System.out.print("Digite o seu cpf para realizar a TED: ");
        verificaCpf = input.nextLine();

        System.out.println("Verificando o CPF em nossa base de dados... ");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Deu erro!");
        }

        for (int i = 0; i < listaPessoas.size(); i++) {
            if (verificaCpf != listaPessoas.get(i).getCpf()) {
                System.out.println("Esse CPF nao se encontra em nosso banco de dados!");
                return;
            } else {
                cCarteira.setCodigo(verificaCpf);
                System.out.println("");
            }
        }

    }

}