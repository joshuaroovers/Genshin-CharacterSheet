package SheetComponents;

public class PrimaryStat {
    private String name;
    private int score;

    public PrimaryStat(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public String getName(){
        return name;
    }

    public String getNameAbbreviation(){
        return name.substring(0,2).toUpperCase();
    }

    public int getScore() {
        return score;
    }

    public int getModifier(){
        return (score-10)/2;
    }

    public String getModifierString(){
        int mod = getModifier();
        if(mod < 0){
            return Integer.toString(mod);}
        else{
            return "+" + mod;
        }
    }


    @Override
    public String toString() {
        return "PrimaryStat{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", mod=" + getModifierString() +
                '}';
    }


}
