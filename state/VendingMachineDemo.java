interface VendingState {
    void selectItem(VendingMachine machine, String item);
    void insertMoney(VendingMachine machine, int amount);
    void dispenseItem(VendingMachine machine);
}

class IdleState implements VendingState {
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item selected: " + item);
        machine.setItem(item);
        machine.setState(new HasSelectionState());
    }
    public void insertMoney(VendingMachine machine, int amount) {
        System.out.println("Please select an item first.");
    }
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected.");
    }
}

class HasSelectionState implements VendingState {
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item changed to: " + item);
        machine.setItem(item);
    }
    public void insertMoney(VendingMachine machine, int amount) {
        System.out.println("Money inserted: " + amount);
        machine.setMoney(amount);
        machine.setState(new HasMoneyState());
    }
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Insert money first.");
    }
}

class HasMoneyState implements VendingState {
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("You already inserted money. Dispensing current item.");
    }
    public void insertMoney(VendingMachine machine, int amount) {
        System.out.println("Already received money.");
    }
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing: " + machine.getItem());
        machine.setMoney(0);
        machine.setItem(null);
        machine.setState(new IdleState());
    }
}


class VendingMachine {
    private VendingState currentState;
    private String selectedItem;
    private int money;

    public VendingMachine() {
        this.currentState = new IdleState();
    }

    public void setState(VendingState state) {
        this.currentState = state;
    }

    public void setItem(String item) {
        this.selectedItem = item;
    }

    public String getItem() {
        return selectedItem;
    }
    
    public int getMoney(){
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    // Interface to outside world
    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertMoney(int amount) {
        currentState.insertMoney(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }
}


public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.insertMoney(10); // Not allowed
        vm.dispenseItem();  // Not allowed
        vm.selectItem("Chips"); // Select item
        vm.insertMoney(20);     // Insert money 
        vm.dispenseItem();      // Dispense item
    }
}
