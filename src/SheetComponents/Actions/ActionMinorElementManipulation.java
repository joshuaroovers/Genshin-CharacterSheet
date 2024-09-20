package SheetComponents.Actions;

import SheetComponents.Elements.Element;

public class ActionMinorElementManipulation extends Action{

    private static final actionType TYPE = actionType.ACTION;
    private static final String DESCRIPTION =
            "You can manipulate the %1$s element in minor ways. " +
            "for example you can:\n" +
            "Create brief harmless environmental effects or small trinkets or objects\n"+
            "Create, destroy or alter %1$s within a 5ft cube\n" +
            "Additionally you can make a special unarmed strike where instead of damage it applies %1$s instead.";
    private Element element;

    public ActionMinorElementManipulation(Element element) {
        this.type = TYPE;
        this.description = DESCRIPTION;
        this.element = element;
    }

    @Override
    public String getName() {
        return "Minor Elemental Manipulation";
    }

    @Override
    public String getDescription() {
        return String.format(description, element.getName());
    }
}
