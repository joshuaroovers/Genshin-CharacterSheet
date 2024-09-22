package GenshinCharacterSheet.SheetComponents;

public class Stamina {
    private final int maxStamina = 100;
    private int currentStamina;

    public Stamina() {
        this.currentStamina = maxStamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }

    public double getSpentPercentage(){
        return ((double) (maxStamina-currentStamina) /maxStamina)*100.0;
    }


    public void adjustCurrentStamina(int modifier, int maxStaminaBonus){
        if(!(currentStamina + modifier < 0)){
            if(currentStamina + modifier > maxStamina+maxStaminaBonus){
                currentStamina = maxStamina+maxStaminaBonus;
            }else{
                currentStamina += modifier;
            }
        }
    }
}
