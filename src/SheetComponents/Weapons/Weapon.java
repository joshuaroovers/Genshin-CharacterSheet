package SheetComponents.Weapons;

public abstract class Weapon {

    public String getBaseName(){
        return this.getClass().getSimpleName();
    }
}
