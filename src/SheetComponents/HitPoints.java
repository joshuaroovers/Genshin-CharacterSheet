package SheetComponents;

public class HitPoints {
    private int maxHP;
    private int currentHP;
    private int temporaryHP;
    private ElementalShield elementalShield;

    public HitPoints(int maxHP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.temporaryHP = 0;
        elementalShield = null;
    }

    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public void adjustCurrentHP(int modifier, Element element){
        if(element != null && elementalShield != null && modifier < 0){
            if(elementalShield.getHP() + modifier < 0){
                int remainder = modifier - elementalShield.getHP();
                setElementalShield(null);
                adjustCurrentHP(remainder);
            }else{
                elementalShield.adjustHP(modifier);
            }
        }
        else if(temporaryHP > 0 && modifier < 0){
            if(temporaryHP + modifier < 0){
                int remainder = modifier - temporaryHP;
                temporaryHP = 0;
                adjustCurrentHP(remainder);
            }else{
                temporaryHP += modifier;
            }
        }
        else if(currentHP + modifier < 0){
            currentHP = 0;
        }
        else if(currentHP + modifier > maxHP){
            currentHP = maxHP;
        }
        else{
            currentHP += modifier;
        }

    }
    public void adjustCurrentHP(int modifier){
        adjustCurrentHP(modifier, null);
    }
    public int getTemporaryHP() {
        return temporaryHP;
    }
    public void setTemporaryHP(int temporaryHP) {
        this.temporaryHP = temporaryHP;
    }

    public ElementalShield getElementalShield() {
        return elementalShield;
    }
    public void setElementalShield(Element element) {
        this.elementalShield = new ElementalShield(element);
    }
}
