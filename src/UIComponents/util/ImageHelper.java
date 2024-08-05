package UIComponents.util;

import SheetComponents.Elements.Element;

public class ImageHelper {
    private static String elementImagePathBase = "images/Element_Icons";
    private static String pathElementFlat_Color = elementImagePathBase+"/Flat_Color/Element_Flat_Color_";
    private static String pathElementGilded = elementImagePathBase+"/Gilded/Element_Gilded_";
    private static String pathElementGlow = elementImagePathBase+"/Glow/Element_Glow_";
    private static String pathElementTCG = elementImagePathBase+"/TCG/Element_TCG_";
    private static String pathElementWhite = elementImagePathBase+"/White/Element_White_";

    public static String getElementURL(Element element, ImageVariant imageVariant){
        return getImageVariantPath(imageVariant) + element.getName() +".png";
    }

    private static String getImageVariantPath(ImageVariant imageVariant){
        String path = "";
        switch (imageVariant){
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
        }

        return path;
    }

}
