package SheetComponents;

public class Inspiration {
    private boolean value;

    public Inspiration(boolean state) {
        this.value = state;
    }

    public boolean getValue(){
        return value;
    }
    public void toggleValue(){
        setValue(!getValue());
    }
    private void setValue(boolean state){
        this.value = state;
    }
}
