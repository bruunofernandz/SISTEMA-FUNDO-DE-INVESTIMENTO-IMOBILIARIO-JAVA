import java.util.regex.*;

public class Regex {
    String nome;

    public void ValidaNome(String n) {
        this.nome = n;
        if (n.equals("")) {
            System.out.println("O campo nao pode ficar em branco !");
            return;
        } else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(nome);
            if (matcher.find()) {
                System.out.println("Nao deve conter numeros !");
                return;
            }
        }
    }

}