public class Wine {
    protected double fixed_acidity;
    protected double volatile_acidity;
    protected double citric_acid;
    protected double residual_sugar;
    protected double chlorides;
    protected double free_sulfur_dioxide;
    protected double total_sulfur_dioxide;
    protected double density;
    protected double pH;
    protected double sulphates;
    protected double alcohol;
    protected double quality;

    protected int ID;
    protected String WineKind;


    public Wine() {
    }

    public Wine(double fixed_acidity, double volatile_acidity, double citric_acid, double residual_sugar, double chlorides, double free_sulfur_dioxide, double total_sulfur_dioxide, double density, double pH, double sulphates, double alcohol, double quality) {
        this.fixed_acidity = fixed_acidity;
        this.volatile_acidity = volatile_acidity;
        this.citric_acid = citric_acid;
        this.residual_sugar = residual_sugar;
        this.chlorides = chlorides;
        this.free_sulfur_dioxide = free_sulfur_dioxide;
        this.total_sulfur_dioxide = total_sulfur_dioxide;
        this.density = density;
        this.pH = pH;
        this.sulphates = sulphates;
        this.alcohol = alcohol;
        this.quality = quality;
    }

    public double getFixed_acidity() {
        return fixed_acidity;
    }
    public void setFixed_acidity(double fixed_acidity) {
        this.fixed_acidity = fixed_acidity;
    }


    public double getVolatile_acidity() {
        return volatile_acidity;
    }
    public void setVolatile_acidity(double volatile_acidity) {
        this.volatile_acidity = volatile_acidity;
    }


    public double getCitric_acid() {
        return citric_acid;
    }
    public void setCitric_acid(double citric_acid) {
        this.citric_acid = citric_acid;
    }


    public double getResidual_sugar() {
        return residual_sugar;
    }
    public void setResidual_sugar(double residual_sugar) {
        this.residual_sugar = residual_sugar;
    }


    public double getChlorides() {
        return chlorides;
    }
    public void setChlorides(double chlorides) {
        this.chlorides = chlorides;
    }


    public double getFree_sulfur_dioxide() {
        return free_sulfur_dioxide;
    }
    public void setFree_sulfur_dioxide(double free_sulfur_dioxide) {
        this.free_sulfur_dioxide = free_sulfur_dioxide;
    }


    public double getTotal_sulfur_dioxide() {
        return total_sulfur_dioxide;
    }
    public void setTotal_sulfur_dioxide(double total_sulfur_dioxide) {
        this.total_sulfur_dioxide = total_sulfur_dioxide;
    }


    public double getDensity() {
        return density;
    }
    public void setDensity(double density) {
        this.density = density;
    }


    public double getpH() {
        return pH;
    }
    public void setpH(double pH) {
        this.pH = pH;
    }


    public double getSulphates() {
        return sulphates;
    }
    public void setSulphates(double sulphates) {
        this.sulphates = sulphates;
    }


    public double getAlcohol() {
        return alcohol;
    }
    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    
    public double getQuality() {
        return quality;
    }
    public void setQuality(double quality) {
        this.quality = quality;
    }


    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }


    public String getWineKind() {
        return WineKind;
    }
    public void setWineKind(String wineKind) {
        WineKind = wineKind;
    }


}
