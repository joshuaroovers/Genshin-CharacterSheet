package GenshinCharacterSheet.SheetComponents.Actions;

public class ActionDash extends Action{

    private static final actionType TYPE = actionType.BONUS;
    private static final int STAMINA_COST = 20;
    private static final String DESCRIPTION = "(cost "+STAMINA_COST+" stamina)\n" +
            "Until the end of your turn your movement speed is doubled";

    public ActionDash() {
        this.description = DESCRIPTION;
        this.type = TYPE;
    }
}
