package SheetComponents.ElementalReactions;

import SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementalReactionHelper {


    public static Reaction getReaction(Element element1, Element element2){
        Reaction reaction = null;
        if(element1.getClass() != element2.getClass()){

            for (Reaction reaction1 : Reaction.getAllReactions()) {
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
        for (Reaction reaction : Reaction.getAllReactions()) {
//            System.out.println("checking reaction for: "+element.getName()+" for: "+reaction.getName()+" "+reaction.hasElement(element));
            if(reaction.hasElement(element)){
                reactions.add(reaction);
            }
        }

        System.out.println("returning reactions list of "+reactions.size());
        return reactions;
    }

}
