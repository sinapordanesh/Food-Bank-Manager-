package edu.ucalgary.ensf409;

public enum ClientType {
    ADULTMALE, ADULTFEMALE, CHILDOVER8, CHILDUNDER8;
    public NutritionalItems getNutritionalItems(int wG, int fV, int p, int o, int c) {
        switch(this) {
            case ADULTMALE:
                NutritionalItems adultMale = new NutritionalItems(wG, fV, p, o, c);
                return adultMale;
            case ADULTFEMALE:
                NutritionalItems adultFemale = new NutritionalItems(wG, fV, p, o, c);
                return adultFemale;
            case CHILDOVER8:
                NutritionalItems childUnder8 = new NutritionalItems(wG, fV, p, o, c);
                return childUnder8;
            case CHILDUNDER8:
                NutritionalItems childOver8 = new NutritionalItems(wG, fV, p, o, c);
                return childOver8;
        }
        return null;
    }
}
