package metier;

import java.io.Serializable;

public class Mouse implements Serializable
{
    private int x;
    private int y;
    private String name;
    public Mouse(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public Mouse(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals (Mouse mouse) {
        return mouse.name.equals(this.name);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getName() {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString (){
        return name;
    }
}
