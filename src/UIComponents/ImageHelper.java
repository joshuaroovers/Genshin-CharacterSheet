package UIComponents;

import SheetComponents.Element;

public class ImageHelper {
    private static String elementImagePathBase = "images/Element_Icons";
    private static String pathElementFlat_Color = elementImagePathBase+"/Flat_Color/Element_Flat_Color_";
    private static String pathElementGilded = elementImagePathBase+"/Flat_Color/Element_Gilded_";
    private static String pathElementGlow = elementImagePathBase+"/Flat_Color/Element_Glow_";
    private static String pathElementTCG = elementImagePathBase+"/Flat_Color/Element_TCG_";
    private static String pathElementWhite = elementImagePathBase+"/Flat_Color/Element_White_";

    public static String getElementURL(Element element, ImageVariant imageVariant){
        String elementName = element.toString().substring(0,1).toUpperCase() + element.toString().substring(1).toLowerCase();
        return getImageVariantPath(imageVariant)+elementName+".png";
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
