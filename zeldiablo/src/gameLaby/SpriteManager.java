package gameLaby;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteManager {
    private BufferedImage spriteSheet; // attribut de l'image bufferisée
    private int spriteSize; // taille des sprites

    /*
    * méthode qui permet de charger une image et de la découper en sprites
    * @param path : chemin de l'image
    * @param spriteSize : taille des sprites
    */
    public SpriteManager(String path, int spriteSize) {
        this.spriteSize = spriteSize;
        try {
            spriteSheet = ImageIO.read(new File(path)); // chargement de l'image avec le path
        }
        // gestion des exceptions
        // si le fichier n'est pas trouvé
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // méthode qui permet de récupérer un sprite à partir de la position x et y dans la grille
    public BufferedImage getSprite(int xGrid, int yGrid) {
        return spriteSheet.getSubimage(xGrid * spriteSize, yGrid * spriteSize, spriteSize, spriteSize);
    }
}
