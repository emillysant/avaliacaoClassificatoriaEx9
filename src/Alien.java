import java.time.LocalDateTime;

public class Alien extends Species{

    private int id;
    private String name;
    private double levelOfDangerAlien;
    private LocalDateTime dateEntry;
    private Boolean weapons;
    private boolean quarantine;

    public Species getSpecies() {
        return species;
    }

    private Species species;

    public Alien(int id, Species species, String name, double levelOfDangerAlien, LocalDateTime dateEntry, Boolean weapons) {
        super(species.getPlanet(), species.getSpecie(), species.getLevelOfDangerSpecie());
        this.id = id;
        this.species = species;
        this.name = name;
        this.levelOfDangerAlien = levelOfDangerAlien;
        this.dateEntry = dateEntry;
        this.weapons = weapons;
        this.quarantine = false;
    }


    public Alien( int id, String planet, String specie, double levelOfDangerSpecie, String name, double levelOfDangerAlien, LocalDateTime dateEntry, Boolean weapons) {
        super( planet, specie, levelOfDangerSpecie);
        this.id = id;
        this.name = name;
        this.levelOfDangerAlien = levelOfDangerAlien;
        this.dateEntry = dateEntry;
        this.weapons = weapons;
        this.quarantine = false;

    }

  public String DangerAvaliation(double levelOfDangerSpecie, double levelOfDangerAlien){
        double dangerBase = levelOfDangerAlien+levelOfDangerSpecie;
        if (weapons && dangerBase >15.0) {
            return "Danger";
        } else {
            return "Not Danger";
        }
  }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLevelOfDangerAlien() {
        return levelOfDangerAlien;
    }

    public LocalDateTime getDateEntry() {
        return dateEntry;
    }

    public Boolean getWeapons() {
        return weapons;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

}
