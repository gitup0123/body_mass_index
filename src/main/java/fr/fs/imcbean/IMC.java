package fr.fs.imcbean;

public class IMC {

    private float taille;
    private float poids;
    private float value;
    private String interpretation;

    public IMC(float taille, float poids) {
        this.taille = taille;
        this.poids = poids;
        calculer();
        interpretation = interpreter();
    }

    public void calculer() {
        value = poids / (carre(taille / 100));
    }

    private float carre(float value) {
        return value * value;
    }

    private String interpreter() {
        if (value < 16.5) return "Maigeur excessive !";
        if (value < 18.5) return "Maigeur !";
        if (value < 25) return "Poids normal !";
        if (value < 30) return "Surpoids !";
        if (value < 35) return "Obésité modérée !";
        if (value < 40) return "Obésité sévère !";
        return "Obésité morbide !";
    }

    public String getValue() {
        return String.format("%.2f", value);
    }

    public String getInterpretation() {
        return interpretation;
    }
}
