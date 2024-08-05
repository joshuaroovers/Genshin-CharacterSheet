package UIComponents.util;

import SheetComponents.Element;
import javafx.scene.paint.Color;

public class ImageHelper {
    private static String elementImagePathBase = "images/Element_Icons";
    private static String pathElementFlat_Color = elementImagePathBase+"/Flat_Color/Element_Flat_Color_";
    private static String pathElementGilded = elementImagePathBase+"/Flat_Color/Element_Gilded_";
    private static String pathElementGlow = elementImagePathBase+"/Flat_Color/Element_Glow_";
    private static String pathElementTCG = elementImagePathBase+"/Flat_Color/Element_TCG_";
    private static String pathElementWhite = elementImagePathBase+"/Flat_Color/Element_White_";

    public static String getElementURL(Element element, ImageVariant imageVariant){
        return getImageVariantPath(imageVariant) + getElementName(element) +".png";
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

    public static String getElementName(Element element){
        return element.toString().substring(0,1).toUpperCase() + element.toString().substring(1).toLowerCase();
    }

    public static Color getElementColor(Element element){
        Color color = Color.GRAY;
        switch (element){
            case ANEMO:
                color = Color.valueOf("#33D7A0");
                break;
            case CRYO:
                color = Color.valueOf("#7AF2F2");
                break;
            case DENDRO:
                color = Color.valueOf("#9BE53D");
                break;
            case ELECTRO:
                color = Color.valueOf("#CC80FF");
                break;
            case GEO:
                color = Color.valueOf("#FFB00D");
                break;
            case HYDRO:
                color = Color.valueOf("#00C0FF");
                break;
            case PYRO:
                color = Color.valueOf("#FF6640");
                break;
        }

        return color;
    }
}
