import java.util.*;
// import java.util.concurrent.atomic.AtomicInteger;

public class Pessoa {
    // private static final AtomicInteger id = new AtomicInteger(0);
    // private int pessoaId;
    private String nome;
    private String rg;
    private String cpf;
    private int agencia;
    private int conta;
    private double saldo;

    // busca os dados nome
    public void setNome(String n) {
        this.nome = n;
    }

    public String getNome() {
        return this.nome;
    }

    // busca os dados RG
    public void setRg(String r) {
        this.rg = r;
    }

    public String getRg() {
        return this.rg;
    }

    // busca os dados CPF
    public void setCpf(String c) {
        this.cpf = c;
    }

    public String getCpf() {
        return this.cpf;
    }

    // busca os dados Agencia
    public void setAgencia(int a) {
        this.agencia = a;
    }

    public int getAgencia() {
        return this.agencia;
    }

    // busca os dados Conta
    public void setConta(int c) {
        this.conta = c;
    }

    public int getConta() {
        return this.conta;
    }

    // busca os dados Saldo
    public void setSaldo(double s) {
        this.saldo = s;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // public void setId(int i) {
    // this.pessoaId = this.id.incrementAndGet();
    // }

    // public int getId() {
    // return this.pessoaId;
    // }

    public String toString() {
        return "\n" + ">> Nome: " + this.nome + "\n" + ">> CPF: " + this.cpf + "\n" + ">> RG: " + this.rg + "\n"
                + ">> Agencia: " + this.agencia + "\n" + ">> Conta: " + this.conta + "\n" + ">> Saldo: R$ " + this.saldo
                + "\n";

    }
}