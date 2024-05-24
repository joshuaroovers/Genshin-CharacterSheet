package SheetComponents;

public class ElementalShield {
    private int hp;
    private Element element;

    public ElementalShield(int hp, Element elementalShieldType) {
        this.hp = hp;
        this.element = elementalShieldType;
    }

    public int getHP() {
        return hp;
    }
    public void setHP(int elementalShieldHP) {
        this.hp = elementalShieldHP;
    }
    public void adjustHP(int modifier) {
        this.hp += modifier;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element elementalShieldType) {
        this.element = elementalShieldType;
    }

    @Override
    public String toString() {
        return "ElementalShield{" +
                "hp=" + hp +
                ", element=" + element +
                '}';
    }
}
