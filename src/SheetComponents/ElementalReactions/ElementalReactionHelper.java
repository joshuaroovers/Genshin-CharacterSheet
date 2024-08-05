package SheetComponents.ElementalReactions;

import SheetComponents.Elements.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementalReactionHelper {

    private static ArrayList<Reaction> reactions = new ArrayList<>(Arrays.asList(
            new ReactionBloom(), new ReactionBurning(), new ReactionCatalyze(),
            new ReactionCrystallize(), new ReactionElectroCharged(), new ReactionFreeze(),
            new ReactionMelt(), new ReactionOverload(), new ReactionSuperConduct(),
            new ReactionSwirl(), new ReactionVaporize()));

    public static Reaction getReaction(Element element1, Element element2){
        Reaction reaction = null;
        if(element1.getClass() != element2.getClass()){

            for (Reaction reaction1 : reactions) {
                if(reaction1.checkForReaction(element1, element2)){
                    reaction = reaction1;
                }
            }
//            if(ReactionSwirl.checkForReaction(element1, element2)){                 //Swirl
//                reaction = new ReactionSwirl();
//            }else if(ReactionCrystallize.checkForReaction(element1, element2)){     //Crystallize
//                reaction = new ReactionCrystallize();
//            }else if(ReactionBloom.checkForReaction(element1, element2)){           //Bloom
//                reaction = new ReactionBloom();
//            }else if(ReactionCatalyze.checkForReaction(element1, element2)){        //Catalyze
//                reaction = new ReactionCatalyze();
//            }else if(ReactionFreeze.checkForReaction(element1, element2)){          //Freeze
//                reaction = new ReactionFreeze();
//            }else if(ReactionMelt.checkForReaction(element1, element2)){            //Melt
//                reaction = new ReactionMelt();
//            }else if(ReactionElectroCharged.checkForReaction(element1, element2)){  //Electro-Charged
//                reaction = new ReactionElectroCharged();
//            }else if(ReactionOverload.checkForReaction(element1, element2)){        //Overload
//                reaction = new ReactionOverload();
//            }else if(ReactionSuperConduct.checkForReaction(element1, element2)){    //Super-Conduct
//                reaction = new ReactionSuperConduct();
//            }else if(ReactionVaporize.checkForReaction(element1, element2)){        //Vaporize
//                reaction = new ReactionVaporize();
//            }else if(ReactionBurning.checkForReaction(element1, element2)){         //Burning
//                reaction = new ReactionBurning();
//            }
        }

        return reaction;
    }

    public static ArrayList<Reaction> getReactions(Element element){
        ArrayList<Reaction> reactions = new ArrayList<>();
        for (Reaction reaction : reactions) {
            if(reaction.hasElement(element)){
                reactions.add(reaction);
            }
        }
//        if(ReactionSwirl.hasElement(element)){                 //Swirl
//            reactions.add(new ReactionSwirl());
//        }else if(ReactionCrystallize.hasElement(element)){     //Crystallize
//            reactions.add(new ReactionCrystallize());
//        }else if(ReactionBloom.hasElement(element)){           //Bloom
//            reactions.add(new ReactionBloom());
//        }else if(ReactionCatalyze.hasElement(element)){        //Catalyze
//            reactions.add(new ReactionCatalyze());
//        }else if(ReactionFreeze.hasElement(element)){          //Freeze
//            reactions.add(new ReactionFreeze());
//        }else if(ReactionMelt.hasElement(element)){            //Melt
//            reactions.add(new ReactionMelt());
//        }else if(ReactionElectroCharged.hasElement(element)){  //Electro-Charged
//            reactions.add(new ReactionElectroCharged());
//        }else if(ReactionOverload.hasElement(element)){        //Overload
//            reactions.add(new ReactionOverload());
//        }else if(ReactionSuperConduct.hasElement(element)){    //Super-Conduct
//            reactions.add(new ReactionSuperConduct());
//        }else if(ReactionVaporize.hasElement(element)){        //Vaporize
//            reactions.add(new ReactionVaporize());
//        }else if(ReactionBurning.hasElement(element)){         //Burning
//            reactions.add(new ReactionBurning());
//        }

        return reactions;
    }

}
