interface FanState {
    void handleRequest(Fan fan);
}
// Concrete States
class OffState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on low.");
        fan.setState(new LowState());
    }
}
class LowState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on medium.");
        fan.setState(new MediumState());
    }
}
class MediumState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on high.");
        fan.setState(new HighState());
    }
}
class HighState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned off.");
        fan.setState(new OffState());
    }
}
// Context
class Fan {
    private FanState currentState;
    public Fan() {
        this.currentState = new OffState();
    }
    public void setState(FanState state) {
        this.currentState = state;
    }
    public void request() {
        currentState.handleRequest(this);
    }
}

public class FanSystem {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.request(); // Turns on low
        fan.request(); // Turns on medium
        fan.request(); // Turns on high
        fan.request(); // Turns off
    }
}