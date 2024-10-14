
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author mattiabirti
 */
public class Palle extends Circle{
    
    Circle palla;
    static final int raggio = 25;
    
    public Circle Palle(){
        palla = new Circle(raggio, Color.TRANSPARENT);
        return palla;
    }
    
    /**
     * metodo che crea una palla invisibile
     * @return palla
     */
    public Circle noPalla(){
        palla = new Circle (raggio, Color.TRANSPARENT);
        return palla;
    }
    
    /**
     * metodo che crea una palla visibile
     * @return palla
     */
    public Circle aggPalla(){
        palla = new Circle(raggio, Color.BLACK);
        return palla;
    }
}
