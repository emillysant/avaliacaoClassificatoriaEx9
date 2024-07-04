import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean programaAtivo = true;
        ArrayList<Alien> aliens = new ArrayList<>(); // Lista para armazenar os alienígenas identificados

        while (programaAtivo) {
            System.out.println("\n=== Sistema de Controle de Alienígenas ===");
            System.out.println("1. Identificar Alienígenas");
            System.out.println("2. Verificar Quarentena");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.println("\nIdentificando alienígenas....");
                    aliens = AlienControlSystem.monitoringAliens();
                    AlienControlSystem.printAliensFound(aliens);
                    break;
                case 2:
                    System.out.println("\nVerificando a necessidade de enviar para quarentena....");
                    AlienControlSystem.quarantineDangerousAliens(aliens);
                    System.out.println("Verificação concluída.");
                    break;
                case 3:
                    System.out.println("\nGerando Relatórios: ");

                    // Filtra apenas os alienígenas em quarentena para o relatório
                    ArrayList<Alien> aliensInQuarantine = getAliensInQuarantine(aliens);
                    AlienControlSystem.printAliensReport(aliensInQuarantine);

                    break;
                case 4:
                    System.out.println("\nEncerrando programa...");
                    programaAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }

        scanner.close();


    }

    private static ArrayList<Alien> getAliensInQuarantine(ArrayList<Alien> aliens) {
        ArrayList<Alien> aliensInQuarantine = new ArrayList<>();
        for (Alien alien : aliens) {
            if (alien.isQuarantine()) {
                aliensInQuarantine.add(alien);
            }
        }
        return aliensInQuarantine;
    }
}



