import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.*;
import java.text.*;

public class Corretora extends Pessoa {

    Scanner input = new Scanner(System.in);
    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    List<Cconta> carteira = new ArrayList<Cconta>();

    public class Cconta {
        private String usuario;
        private int agencia;
        private int conta;
        private double valor = 0;

        public void setCodigo(String codigo) {
            this.usuario = codigo;
        }

        public String getCodigo() {
            return this.usuario;
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

        public String toString() {
            return "Valor: R$ " + this.valor;
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

    public void MostraLista() {
        System.out.println(listaPessoas.toString());
        System.out.println("Precione Enter para voltar para o Menu ");
        input.nextLine();

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

    public void ResgataSaldo() {
        double saldoT = 0;
        for (Cconta i : carteira) {
            double total = i.getValor();
            saldoT += total;
        }
        System.out.println("Saldo Atual: R$ " + saldoT);
        System.out.println("Precione Enter para voltar para o Menu ");
        input.nextLine();
    }

    public void retornaCarteira() {
        System.out.println(carteira.toString());
        System.out.println("Precione Enter para voltar para o Menu ");
        input.nextLine();
    }

    public void TED() {
        String verificaCpf;
        Cconta cCarteira = new Cconta();
        double subtraiValor;
        System.out.println("## BEM VINDO AO SISTEMA DE TRANSFERENCIA ELETRONICA ##\n");
        System.out.print("Digite o seu cpf para realizar a TED: ");
        verificaCpf = input.nextLine();

        System.out.println("Verificando o CPF em nossa base de dados... ");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Deu erro!");
        }

        // Cconta i : carteira
        for (Pessoa i : listaPessoas) {
            if (i.getCpf().equals(verificaCpf)) {
                cCarteira.setCodigo(verificaCpf);
                System.out.print("Digite a agencia: ");
                cCarteira.setAgencia(input.nextInt());
                System.out.print("Digite o numero da conta: ");
                cCarteira.setConta(input.nextInt());
                System.out.print("Digite o valor a ser transferido: ");
                cCarteira.setValor(input.nextDouble());
                subtraiValor = cCarteira.getValor();
                if (i.getCpf().equals(verificaCpf) && i.getSaldo() <= 0) {
                    System.out.println("Seu saldo eh insuficiente para fazer uma TED");
                    return;
                } else {
                    i.setSaldo(i.getSaldo() - subtraiValor);
                    if (i.getSaldo() <= 0) {
                        System.out.println("Saldo insuficente para faze a TED");
                        i.setSaldo(i.getSaldo() + subtraiValor);
                        return;
                    }
                }
                System.out.println("\n## TED CONCLUIDO ##");

                carteira.add(cCarteira);
                input.nextLine();
            }
        }

    }

}