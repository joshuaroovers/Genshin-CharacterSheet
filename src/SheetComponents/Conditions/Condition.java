package SheetComponents.Conditions;

public abstract class Condition {

    String description;

    public String getName(){
        String name = this.getClass().getSimpleName();
        if(name.length() > 9){
            name = name.substring(9); //remove the 'Reaction' part of the name
        }

        return name;
    }

    public String getDescription() {
        return description;
    }
}
