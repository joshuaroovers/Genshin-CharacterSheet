package SheetComponents.Actions;

public abstract class Action {

    protected String description;
//    boolean isSpecialTrigger;

    public String getName() {
        int baseClassNameLength = Action.class.getSimpleName().length();
        return getClass().getSimpleName().substring(baseClassNameLength);
    }

    public String getDescription() {
        return description;
    }
}
