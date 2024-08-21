package UI.Util;

import SheetComponents.Elements.Element;
import SheetComponents.Elements.Physical;
import SheetComponents.Weapons.Weapon;

public class ImageHelper {

    private static String elementImagePathBase = "images/Element_Icons";
    private static String pathElementFlat_Color = elementImagePathBase+"/Flat_Color/Element_Flat_Color_";
    private static String pathElementGilded = elementImagePathBase+"/Gilded/Element_Gilded_";
    private static String pathElementGlow = elementImagePathBase+"/Glow/Element_Glow_";
    private static String pathElementTCG = elementImagePathBase+"/TCG/Element_TCG_";
    private static String pathElementWhite = elementImagePathBase+"/White/Element_White_";
    private static String pathElementBlack = elementImagePathBase+"/Black/Element_Black_";
    private static String weaponImagePathBase = "images/Weapon_Icons";


    public static String getElementURL(Element element, ImageElementVariant imageElementVariant){
        return getImageVariantPath(imageElementVariant) + element.getName() +".png";
    }

    private static String getImageVariantPath(ImageElementVariant imageElementVariant){
        String path = "";
        switch (imageElementVariant){
            case FLAT:
                path = pathElementFlat_Color;
                break;
            case GILDED:
                path = pathElementGilded;
                break;
            case GLOW:
                path = pathElementGlow;
                break;
            case TCG:
                path = pathElementTCG;
                break;
            case WHITE:
                path = pathElementWhite;
                break;
            case BLACK:
                path = pathElementBlack;
                break;
        }

        return path;
    }

    public static String getAttackUnitURL(Element element){
        if(element.getName().equals(Physical.class.getSimpleName())){
            return weaponImagePathBase+"/Physical_DMG.png";
        }else{
            return getElementURL(element, ImageElementVariant.FLAT);
        }
    }

    public static String getWeaponURL(Weapon weapon){
        return weaponImagePathBase + "/" + weapon.getName() +".png";
    }

    }
