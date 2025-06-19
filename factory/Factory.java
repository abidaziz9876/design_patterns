

interface Shape{
    void Draw();
}

class Square implements Shape{
    @Override
    public void Draw(){
        System.out.println("drawing square");
    }
}

class Circle implements Shape{
    @Override
    public void Draw(){
        System.out.println("drawing circle");
    }
}

class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else{
            return new Square();
        }
    }
}


public class Factory{
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape sp=sf.getShape("square");
        sp.Draw();
    }
}