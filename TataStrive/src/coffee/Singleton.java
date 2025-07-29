package coffee;

class Singleton {
    // Step 1: Create a private static instance of the same class
    private static Singleton instance;

    // Step 2: Make the constructor private so no other class can instantiate it
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: Provide a public static method to get the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method
    public void serveCoffee() {
        System.out.println("Serving coffee...");
    }

    public static void main(String[] args) {
        Singleton coffeeMachine1 = Singleton.getInstance();
        Singleton coffeeMachine2 = Singleton.getInstance();

        coffeeMachine1.serveCoffee();

        // Verifying both references point to the same instance
        System.out.println(coffeeMachine1 == coffeeMachine2); // Output: true
    }
}