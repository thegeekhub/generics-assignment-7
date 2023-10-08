package generics_assignment_7;

//PricedItem interface with getPrice() method
interface PricedItem {
 double getPrice();
}

//Book class implementing PricedItem interface
class Book implements PricedItem {
 private String title;
 private String author;
 private double price;

 public Book(String title, String author, double price) {
     this.title = title;
     this.author = author;
     this.price = price;
 }

 @Override
 public double getPrice() {
     return price;
 }

 @Override
 public String toString() {
     return "Book - Title: " + title + ", Author: " + author + ", Price: $" + price;
 }
}

//Gadget class implementing PricedItem interface
class Gadget implements PricedItem {
 private String name;
 private String manufacturer;
 private double price;

 public Gadget(String name, String manufacturer, double price) {
     this.name = name;
     this.manufacturer = manufacturer;
     this.price = price;
 }

 @Override
 public double getPrice() {
     return price;
 }

 @Override
 public String toString() {
     return "Gadget - Name: " + name + ", Manufacturer: " + manufacturer + ", Price: $" + price;
 }
}

//Generic ItemCollection class
class ItemCollection<T extends PricedItem> {
 private java.util.ArrayList<T> items = new java.util.ArrayList<>();

 public void addItem(T item) {
     items.add(item);
 }

 public void removeItem(int index) {
     items.remove(index);
 }

 public T getItem(int index) {
     return items.get(index);
 }

 public double totalPrice() {
     double total = 0.0;
     for (T item : items) {
         total += item.getPrice();
     }
     return total;
 }
 
	public int size() {
		// TODO Auto-generated method stub
		return items.size();
	}
}

public class Main {
 public static void main(String[] args) {
     // Create an instance of ItemCollection that stores PricedItem objects
     ItemCollection<PricedItem> collection = new ItemCollection<>();

     // Add some Book and Gadget objects to the collection
     collection.addItem(new Book("Book1", "Author1", 20.0));
     collection.addItem(new Gadget("Gadget1", "Manufacturer1", 50.0));
     collection.addItem(new Book("Book2", "Author2", 15.0));
     collection.addItem(new Gadget("Gadget2", "Manufacturer2", 30.0));

     // Calculate and print the total price of all items in the collection
     double totalPrice = collection.totalPrice();
     System.out.println("Total Price of All Items: $" + totalPrice);

     // Retrieve and print items by index
     System.out.println("Items in the Collection:");
     for (int i = 0; i < collection.size(); i++) {
         System.out.println(collection.getItem(i));
     }
 }
}

