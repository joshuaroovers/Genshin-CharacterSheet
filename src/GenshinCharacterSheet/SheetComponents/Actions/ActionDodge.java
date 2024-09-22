package GenshinCharacterSheet.SheetComponents.Actions;

public class ActionDodge extends Action{

    private static final actionType TYPE = actionType.REACTION;
    private static final int STAMINA_COST = 20;
    private static final String DESCRIPTION = "(cost "+STAMINA_COST+" stamina)\n" +
            "When you are hit by an attack you can spend "+STAMINA_COST+" stamina and halve the damage";

    public ActionDodge() {
        this.description = DESCRIPTION;
        this.type = TYPE;
    }
}
