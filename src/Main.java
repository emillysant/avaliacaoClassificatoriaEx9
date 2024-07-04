import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean programaAtivo = true;
        ArrayList<Alien> aliens = new ArrayList<>();

        while (programaAtivo) {
            System.out.println("\n=== Sistema de Controle de Alienígenas ===");
            System.out.println("1. Identificar Alienígenas");
            System.out.println("2. Verificar Quarentena");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Mostrar Alienígenas de uma Espécie");
            System.out.println("5. Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

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
                    ArrayList<Alien> aliensInQuarantine = getAliensInQuarantine(aliens);
                    AlienControlSystem.printAliensReport(aliensInQuarantine);
                    break;
                case 4:
                    System.out.println("\nMostrar Alienígenas de uma Espécie:");

                    System.out.print("Digite o nome da espécie: ");
                    String especie = scanner.nextLine();
                    ArrayList<Alien> aliensEspecie = AlienControlSystem.filterAliensBySpecies(aliens, especie);

                    if (aliensEspecie.isEmpty()) {
                        System.out.println("Não foram encontrados alienígenas da espécie " + especie + ".");
                    } else {
                        System.out.println("Lista de Alienígenas da Espécie " + especie + ":");
                        AlienControlSystem.printAliensReport(aliensEspecie);
                    }
                    break;
                case 5:
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



