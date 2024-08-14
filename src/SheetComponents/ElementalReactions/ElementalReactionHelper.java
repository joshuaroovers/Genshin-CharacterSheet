package SheetComponents.ElementalReactions;

import SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementalReactionHelper {

    private static ArrayList<Reaction> allReactions = new ArrayList<>(Arrays.asList( //TODO temporary removed crystallize and swirl cuz of a nullpointer with hasElement in Reaction
            new ReactionBloom(), new ReactionBurning(), new ReactionCatalyze(),
            /*new ReactionCrystallize(),*/ new ReactionElectroCharged(), new ReactionFreeze(),
            new ReactionMelt(), new ReactionOverload(), new ReactionSuperConduct(),
            /*new ReactionSwirl(),*/ new ReactionVaporize()));

    public static Reaction getReaction(Element element1, Element element2){
        Reaction reaction = null;
        if(element1.getClass() != element2.getClass()){

            for (Reaction reaction1 : allReactions) {
                if(reaction1.checkForReaction(element1, element2)){
                    reaction = reaction1;
                }
            }
        }

        return reaction;
    }

    public static ArrayList<Reaction> getReactions(Element element){
        System.out.println("getting reactions for "+element.getName());
        ArrayList<Reaction> reactions = new ArrayList<>();
        for (Reaction reaction : allReactions) {
            System.out.println("checking reaction for: "+element.getName()+" for: "+reaction.getName()+" "+reaction.hasElement(element));
            if(reaction.hasElement(element)){
                System.out.println("reaction found!: "+reaction.getName());
                reactions.add(reaction);
            }
        }

        System.out.println("returning reactions list of "+reactions.size());
        return reactions;
    }

}
