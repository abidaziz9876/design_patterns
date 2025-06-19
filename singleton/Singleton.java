



public class Singleton {
    public static void main(String[] args) {
        DBInstance instance1= DBInstance.getInstance();
        // DBInstance instance2= DBInstance.getInstance();
        System.out.println(instance1.hashCode());
        // System.out.println(instance2.hashCode());
    }
}
