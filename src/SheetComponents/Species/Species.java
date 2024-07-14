package SheetComponents.Species;

public abstract class Species {

    public String getName(){
        return this.getClass().getSimpleName();
    }
}
