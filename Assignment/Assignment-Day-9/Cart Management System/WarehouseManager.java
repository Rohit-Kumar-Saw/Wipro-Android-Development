import java.util.List;
import java.util.Scanner;

public class WarehouseManager {
    private Warehouse warehouse;
    private Scanner scanner;

    public WarehouseManager(){
        warehouse=new Warehouse();
        scanner=new Scanner(System.in);
    }
    public void start() {
        while(true)
        {
            showMenu();
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                addItem();
                break;
                case 2:
                updateItem();
                break;
                case 3:
                deleteItem();
                break;
                case 4:
                showItems();
                break;
                case 5:
                showItemQuantity();
                break;
                case 6:
                System.out.println("exiting...");
                default:
                System.out.println("Invalid choice. please choose above options");
            }
        }
    }

    private void showMenu() {
        System.out.println("Warehouse Management Syatem");
        System.out.println("1. Add Item");
        System.out.println("2. Update Item");
        System.out.println("3. Delete Item");
        System.out.println("4. show All Item");
        System.out.println("5. show Item Quantity");
        System.out.println("6. Exit");
        System.out.print("Enter Your Choice");
    }
    private void addItem() {
        System.out.print("Enter Item Id: ");
        String itemId=scanner.nextLine();
        System.out.print("Enter Item Title: ");
        String title=scanner.nextLine();
        System.out.print("Enter Item Price: ");
        double price=scanner.nextDouble();
        scanner.nextLine();
       
        System.out.print("Enter Item Description: ");
        String description=scanner.nextLine();
        System.out.print("Enter Item Quantity: ");
        int quantity=scanner.nextInt();
        scanner.nextLine();

        Item item=new Item(itemId, price, description, title);
        warehouse.addItem(item, quantity);
        System.out.println("Item added successfully");


    }
    private void updateItem(){
        System.out.println("Enter Item Id to Update");
        String itemId=scanner.nextLine();

        Item existingItem=warehouse.getItemById(itemId);
        if(existingItem==null)
        {
            System.out.println("Item not found");
            return;
        }
        System.out.print("Enter new item title(Leave blank to keep" + existingItem.getTitle() + "): ");
        String title =scanner.nextLine();
        if(title.isEmpty())
        {
            title=existingItem.getTitle();
        }
        System.out.print("Enter new Item price (Leave blank to keep " + existingItem.getPrice() +"):" );
        String priceInput=scanner.nextLine();
        double price=priceInput.isEmpty()? existingItem.getPrice():Double.parseDouble(priceInput);

        System.out.print("Enter new Item description (Leave blank to keep " + existingItem.getDescription() +"):" );
        String description=scanner.nextLine();
        if(description.isEmpty())
        {
            description=existingItem.getDescription();
        }

        System.out.print("Enter new Item quantity (Leave blank to keep " + warehouse.getItemQuantity(itemId) +"):" );
        String quantityInput=scanner.nextLine();
        int quantity=quantityInput.isEmpty()?warehouse.getItemQuantity(itemId):Integer.parseInt(quantityInput);

        boolean updated=warehouse.updateItem(itemId, price, description, title, quantity);
        if (updated) {
            System.out.println("Item updated successfully");
        }
        else{
            System.out.println("Item not found");
        }



    }
    private void deleteItem(){
        System.out.print("Enter Item Id to delete");
        String itemId=scanner.nextLine();

        boolean deleted=warehouse.deleteItem(itemId);
        if (deleted) {
            System.out.println("Item deleted successfully");
        }
        else{
            System.out.println("Item not found");
        }
    }
    private void showItems()
    {
        List<Item> items=warehouse.getItems();
        List<Integer>quantities=warehouse.getQuantities();

        if (items.isEmpty()) {
            System.out.println("No items in the warehouse");
            
        }else{
            System.out.println("Items im the warehouse: ");
            for(int i=0;i<items.size();i++)
            {
                System.out.println(items.get(i)+" ,Quantity: " +quantities.get(i));
            }
        }
    }
    private void showItemQuantity(){
        System.out.println("Enter Item Id to check quantity: ");
        String ItemId=scanner.nextLine();

        int quantity=warehouse.getItemQuantity(itemId);
        if (quantity != -1) {
            System.out.println("Item Quantity: "+quantity);
        }
        else{
            System.out.println("Item not found");
        }
    }

    public static void main(String[] args) {
        WarehouseManager manager=new WarehouseManager();
        manager.start();
    }
    
}
