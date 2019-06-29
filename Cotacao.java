import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cotacao {
    private Scanner input;

    public void openFile() {
        try {
            input = new Scanner(new File("cotacoes.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void readRecords() {
        FII record = new FII();

        try {
            System.out.println("\n\nCota \t\t Valor \n");
            while (input.hasNext()) {
                record.setCodigo(input.next());
                record.setCota(input.nextDouble());

                System.out.printf("%s \t\t %4.2f\n", record.getCodigo(), record.getValorCota());
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
    }

    public void closeFile() {
        if (input != null)
            input.close();
    }
}