import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

abstract class AlienControlSystem {


    public static ArrayList<Alien> monitoringAliens(){


        Alien alien3 = new Alien(2, "Krypton", "Kryptoniano", 7.0, "Kal", 20, LocalDateTime.now(), true);
        Alien alien4 = new Alien(5, "Arrakis", "Gun", 4.0, "Jar", 4.5, LocalDateTime.now(), false);

        Alien alien1 = new Alien(1, SpeciesControlSystem.Vulcaniano(), "Spock", 9.0,LocalDateTime.now(), true);
        Alien alien2 = new Alien(2, SpeciesControlSystem.Kryptoniano(), "Super", 5.0,LocalDateTime.now(), true);

        ArrayList<Alien> aliens = new ArrayList<>();

        aliens.add(alien1);
        aliens.add(alien2);
        aliens.add(alien3);
        aliens.add(alien4);
        return aliens;
    }

    public static void printAliensFound(ArrayList<Alien> aliens) {
        System.out.println("Lista de Alienígenas:");
        for (Alien alien : aliens) {
            System.out.println("ID: " + alien.getId());
            System.out.println("Planeta: " + alien.getPlanet());
            System.out.println("Espécie: " + alien.getSpecie());
            System.out.println("Classificação final: " + alien.DangerAvaliation(alien.getLevelOfDangerSpecie(),alien.getLevelOfDangerAlien() ));
            System.out.println("------------------------------------------");
        }
    }

    public static ArrayList<Alien> quarantineDangerousAliens(ArrayList<Alien> aliens) {
        for (Alien alien : aliens) {
            if (alien.DangerAvaliation(alien.getLevelOfDangerSpecie(), alien.getLevelOfDangerAlien()).equalsIgnoreCase("danger")) {
                alien.setQuarantine(true);
                System.out.println("Enviando " + alien.getName() + " para quarentena.");
            }
        }
        return aliens;
    }

    public static void printAliensReport(ArrayList<Alien> aliens) {
        System.out.println("Lista de Alienígenas:");
        for (Alien alien : aliens) {
            if (alien.isQuarantine()) {
                System.out.println("Alienigena em Quarentena");
            }
            System.out.println("ID: " + alien.getId());
            System.out.println("Planeta: " + alien.getPlanet());
            System.out.println("Espécie: " + alien.getSpecie());
            System.out.println("Nível de Periculosidade da Espécie: " + alien.getLevelOfDangerSpecie());
            System.out.println("ID do Alienígena: " + alien.getId());
            System.out.println("Nome do Alienígena: " + alien.getName());
            System.out.println("Nível de Periculosidade do Alienígena: " + alien.getLevelOfDangerAlien());
            System.out.println("Data de Entrada: " + alien.getDateEntry());
            System.out.println("Classificação final: " + alien.DangerAvaliation(alien.getLevelOfDangerSpecie(),alien.getLevelOfDangerAlien() ));
            System.out.println("Em Quarentena: " + alien.isQuarantine());
            System.out.println("------------------------------------------");
        }
    }


}
