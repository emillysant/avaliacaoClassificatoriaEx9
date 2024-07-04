public class Species extends Planet{
    private String specie;
    private double levelOfDangerSpecie;

    public Species(String planet, String specie, double levelOfDangerSpecie) {
        super(planet);
        this.specie = specie;
        this.levelOfDangerSpecie = levelOfDangerSpecie;
    }

    public String getSpecie() {
        return specie;
    }

    public double getLevelOfDangerSpecie() {
        return levelOfDangerSpecie;
    }
}
