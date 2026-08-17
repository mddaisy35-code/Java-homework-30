import java.util.Scanner;

class ShoppingCart {

    String cartOwnerName;

    class Item {

        String itemName;
        double price;
        int quantity;
        double[] priceHistory;

        void addItem(Scanner sc) {

            System.out.print("Enter Cart Owner Name: ");
            cartOwnerName = sc.nextLine();

            System.out.print("Enter Item Name: ");
            itemName = sc.nextLine();

            System.out.print("Enter Quantity: ");
            quantity = sc.nextInt();

            System.out.print("Enter Number of Price Updates: ");
            int updates = sc.nextInt();

            priceHistory = new double[updates];

            System.out.println("Enter Prices:");

            for (int i = 0; i < priceHistory.length; i++) {
                priceHistory[i] = sc.nextDouble();
            }

            price = priceHistory[priceHistory.length - 1];

            System.out.println("Item added successfully!");
        }

        void updatePriceHistory(Scanner sc) {

            System.out.print("Enter Number of Price Updates: ");
            int updates = sc.nextInt();

            priceHistory = new double[updates];

            System.out.println("Enter Prices:");

            for (int i = 0; i < priceHistory.length; i++) {
                priceHistory[i] = sc.nextDouble();
            }

            price = priceHistory[priceHistory.length - 1];

            System.out.println("Price history updated!");
        }

        void calculateTotalBill() {

            price = priceHistory[priceHistory.length - 1];

            double total = price * quantity;

            System.out.println("Latest Price: " + price);
            System.out.println("Total Bill: " + total);
        }

        void displayCart() {

            price = priceHistory[priceHistory.length - 1];

            double total = price * quantity;

            System.out.println("\n----- Cart Details -----");

            System.out.println("Cart Owner: " + cartOwnerName);
            System.out.println("Item Name: " + itemName);
            System.out.println("Quantity: " + quantity);

            System.out.print("Price History: ");

            for (int i = 0; i < priceHistory.length; i++) {
                System.out.print(priceHistory[i] + " ");
            }

            System.out.println("\nLatest Price: " + price);
            System.out.println("Total Bill: " + total);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();
        Item item = cart.new Item();

        int choice;

        do {

            System.out.println("\n===== SHOPPING CART MENU =====");
            System.out.println("1. Add Item");
            System.out.println("2. Update Price History");
            System.out.println("3. Calculate Total Bill");
            System.out.println("4. Display Cart Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    item.addItem(sc);
                    break;

                case 2:
                    item.updatePriceHistory(sc);
                    break;

                case 3:
                    item.calculateTotalBill();
                    break;

                case 4:
                    item.displayCart();
                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}