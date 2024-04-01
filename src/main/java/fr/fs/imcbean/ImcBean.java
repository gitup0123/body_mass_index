package fr.fs.imcbean;

import java.util.HashMap;
import java.util.Map;

public class ImcBean {
    public static final String POIDS_KEY = "poids";
    public static final String TAILLE_KEY = "taille";
    private String taille;
    private String poids;
    private IMC imc;
    private Map<String, String> errors;
    private int cpt;


    public ImcBean() {
        cpt=0;
        taille = "";
        poids = "";
        errors = new HashMap<>();
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public int getCpt() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt = cpt;
    }

    public boolean validate() {

        boolean validate = true;
        float tailleValue = 0;
        float poidsValue = 0;

        if (taille.isEmpty()) {
             if (cpt > 0) errors.put(TAILLE_KEY, "La taille ne doit pas être vide !");
            validate = false;
        } else {
            try {
                tailleValue = Float.parseFloat(taille);
                if (tailleValue < 80 || tailleValue > 240) {
                    errors.put(TAILLE_KEY, "La taille doit être comprise entre 80 et 240 !");
                    validate = false;
                }
            } catch (Exception exception) {
                errors.put(TAILLE_KEY, "La taille est une valeur numérique de type 999.99");
                validate = false;
            }
        }
        if (poids.isEmpty()) {
            if (cpt > 0) errors.put(POIDS_KEY, "Le poids ne doit pas être vide !");
            validate = false;
        } else {
            try {
                poidsValue = Float.parseFloat(poids);
                if (poidsValue <= 30) {
                    errors.put(POIDS_KEY, "Le poids doit être supérieur à 30 !");
                    validate = false;
                }
            } catch (Exception exception) {
                errors.put(POIDS_KEY, "Le poids est une valeur numérique de type 999.99");
                validate = false;
            }
        }
        cpt++;
        if (validate) imc = new IMC(tailleValue,poidsValue);
        return validate;
    }

    public String getError(String errorKey) {
        if (errors.get(errorKey) == null)
            return "";
        return errors.get(errorKey);
    }

    public IMC getImc() {
        return imc;
    }

    @Override
    public String toString() {
        return poids + " " + taille;
    }
}

