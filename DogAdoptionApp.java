package terriers;
import java.util.Scanner;
import java.util.*;

public class DogAdoptionApp {
	
	static class Dog {
		int id;
		String breed;
		String name;
		String sex;
		double height;
		double weight;
		double cost;
		int age;
		String size;
		
		public Dog(int id, String n, String breed, String sex, double h, double w, double cost, int age, String s) {
			this.id = id;
			name = n;
			this.breed = breed;
			this.sex = sex;
			height = h;
			weight = w;
			this.cost = cost;
			this.age = age;
			size = s;
		}
		
		public void displaySummary() {
			System.out.println("ID: " + id + " | Breed: " + breed + " | Name: " + name);
		}
		
		public void displayDetails() {
			System.out.println("Dog ID: " + id);
			System.out.println("Breed: " + breed);
	        System.out.println("Name: " + name);
	        System.out.println("Sex: " + sex);
	        System.out.println("Age: " + age + " years");
	        System.out.println("Height: " + height + " inches");
	        System.out.println("Weight: " + weight + " lbs");
	        System.out.println("Cost: $" + cost);
	        System.out.println("----------------------------");
	     }
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Dog> terriers = new ArrayList<>();
		
		//creates the abbreviations for each of the dog breeds.
		Map<String, String> breedAbbrevi = new HashMap<>();
		breedAbbrevi.put("apt", "American Pitbull Terrier");
		breedAbbrevi.put("bt", "Bull Terrier");
		breedAbbrevi.put("yt", "Yorkshire Terrier");
		breedAbbrevi.put("ct", "Cairn Terrier");
		breedAbbrevi.put("bwt", "Biewer Terrier");
		breedAbbrevi.put("bogt", "Boglen Terrier");
		breedAbbrevi.put("ddt", "Dandie Dinmont Terrier");
		breedAbbrevi.put("it", "Irish Terrier");
		breedAbbrevi.put("pt", "Patterdale Terrier");
		
		// Create 14 dogs
		terriers.add(new Dog(1, "Macy", "American Pitbull Terrier", "Female", 18.0, 60.0, 100.0, 2, "large"));
		terriers.add(new Dog(2, "Maggie", "American Pitbull Terrier", "Female", 19.5, 58.0, 100.0, 3, "large"));
		terriers.add(new Dog(3, "Chase", "Biewer Terrier", "Male", 9.0, 7.0, 80.0, 1, "small"));
		terriers.add(new Dog(4, "Max", "Biewer Terrier", "Male", 8.5, 6.5, 80.0, 1, "small"));
		terriers.add(new Dog(5, "Finn", "Boglen Terrier", "Male", 12.0, 15.0, 100.0, 2, "medium"));
		terriers.add(new Dog(6, "Pookie", "Bull Terrier", "Female", 21.0, 55.0, 98.0, 4, "large"));
		terriers.add(new Dog(7, "Zoe", "Cairn Terrier", "Female", 10.0, 13.0, 80.0, 3, "small"));
		terriers.add(new Dog(8, "Buddy", "Cairn Terrier", "Male", 9.5, 12.0, 80.0, 2, "small"));
		terriers.add(new Dog(9, "Milo", "Dandie Dinmont Terrier", "Male", 8.0, 18.0, 95.0, 4, "small"));
		terriers.add(new Dog(10, "Ruby", "Irish Terrier", "Female", 18.0, 27.0, 98.0, 3, "medium"));
		terriers.add(new Dog(11, "Charlie", "Irish Terrier", "Male", 17.5, 26.5, 98.0, 2, "medium"));
		terriers.add(new Dog(12, "Teddy", "Patterdale Terrier", "Male", 12.0, 13.0, 95.0, 3, "small"));
		terriers.add(new Dog(13, "Chloe", "Yorkshire Terrier", "Female", 8.0, 7.0, 100.0, 1, "small"));

      System.out.println("🐾 Welcome To Mercy's Terrific Terriers! 🐾");
      try { 
    	  Thread.sleep(1800);
      } catch (InterruptedException e) {
    	  System.out.println("Oops! Something went wrong with the delay.");
      }
      
      System.out.println("Here we sell 10 breeds of Terriers!");
      System.out.println("We provide info on each dog's breed, height, weight, cost, age, sex, and name.\n");

      System.out.print("Would you like to purchase a dog? (yes/no): ");
      String response = scanner.nextLine().trim().toLowerCase();

      if (!response.equals("yes")) {
          System.out.println("No worries! Thanks for visiting Mercy's Terrific Terriers!");
          return;
      }

      /*System.out.print("What is your name? ");
      String customerName = scanner.nextLine();*/

      while (true) {
          System.out.print("\nWhat size dog would you like (small, medium, large)? Or type 'all' to view all breeds: ");
          String sizeChoice = scanner.nextLine().trim().toLowerCase();

          List<Dog> filteredDogs = new ArrayList<>();

          if (sizeChoice.equals("all")) {
              System.out.println("\nAvailable Breeds:");
              for (Dog dog : terriers) {
                  System.out.println("- " + dog.breed);
              }
          } else {
              for (Dog dog : terriers) {
                  if (dog.size.equalsIgnoreCase(sizeChoice)) {
                      filteredDogs.add(dog);
                  }
              }

              if (filteredDogs.isEmpty()) {
                  System.out.print("Sorry, we have no dogs of that size. Would you like to see other dogs? (yes/no): ");
                  String seeOthers = scanner.nextLine().trim().toLowerCase();
                  if (!seeOthers.equals("yes")) {
                      System.out.println("No worries! Thanks for visiting Mercy's Terrific Terriers!");
                      break;
                  } else {
                      continue; // goes back to size prompt
                  }
              } else {
                  System.out.println("\nHere are our " + sizeChoice + " Terriers:");
                  for (Dog dog : filteredDogs) {
                      dog.displaySummary();
                  }
              }
          }
          
          System.out.println("\nAvailable breed abbreviations:");
          for(Map.Entry<String, String> entry : breedAbbrevi.entrySet()) {
        	  System.out.println(entry.getKey() + " - " + entry.getValue());
          }
          
          System.out.print("\nIf you'd like more info about a breed, type its abbreviation (or 'back' to go back): ");
          String abbrevInput = scanner.nextLine().trim().toLowerCase();

          if (abbrevInput.equalsIgnoreCase("back")) {
              continue; // back to size menu
          }
          
          String fullBreed = breedAbbrevi.get(abbrevInput);
          
          if(fullBreed == null) {
        	  System.out.println("Invalid abbreviation. Please try again.");
        	  continue;
          }

          List<Dog> breedDogs = new ArrayList<>();
          for (Dog dog : terriers) {
              if (dog.breed.equalsIgnoreCase(fullBreed)) {
                  breedDogs.add(dog);
              }
          }

          if (breedDogs.isEmpty()) {
              System.out.println("We don't have dogs of that breed. Returning to size menu.");
              continue;
          }

          System.out.println("\nAvailable " + fullBreed + "s:");
          for (Dog dog : breedDogs) {
              dog.displayDetails();
          }

          System.out.print("Type the ID of the dog you'd like to adopt (or 'back' to choose another breed): ");
          String dogChoice = scanner.nextLine().trim();

          if (dogChoice.equalsIgnoreCase("back")) {
              continue;
          }

          Dog selectedDog = null;
          try {
              int selectedId = Integer.parseInt(dogChoice);
              for (Dog dog : breedDogs) {
                  if (dog.id == selectedId) {
                      selectedDog = dog;
                      break;
                  }
              }
          } catch (NumberFormatException e) {
              System.out.println("Invalid input. Returning to breed menu.");
              continue;
          }

          if (selectedDog == null) {
              System.out.println("Dog not found with that ID. Returning to breed menu.");
              continue;
          }
          
          System.out.print("What is your name? ");
          String customerName = scanner.nextLine();

          System.out.print("Would you like to rename " + selectedDog.name + "? (yes/no): ");
          String renameChoice = scanner.nextLine().trim().toLowerCase();

          String finalName = selectedDog.name;
          if (renameChoice.equals("yes")) {
              System.out.print("Enter the new name: ");
              finalName = scanner.nextLine();
          }

          System.out.println("\nReady to purchase!");
          try { 
        	  Thread.sleep(1800);
          } catch (InterruptedException e) {
        	  System.out.println("Oops! Something went wrong with the delay.");
          }
          System.out.println("\n" + finalName + " the " + selectedDog.breed + " costs $" + selectedDog.cost);
          System.out.print("Please input the amount to pay: $");
          double payment = 0;

          try {
              payment = Double.parseDouble(scanner.nextLine());
          } catch (NumberFormatException e) {
              System.out.println("Invalid amount. Canceling purchase.");
              continue;
          }

          if (payment < selectedDog.cost) {
              System.out.println("Insufficient payment. Transaction canceled.");
              continue;
          }

          System.out.println("\n Customer " + customerName + " has adopted our lovely terrier " +
                  finalName + " the " + selectedDog.breed + "!");
          System.out.println("Thank you for giving a home to one of our special Terriers!");
          System.out.println("\nPlease come back again. Bye!");

          break; // exit after successful adoption
      }

      scanner.close();
  }

}
