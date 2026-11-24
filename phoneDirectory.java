
import java.util.*;

class PhoneDirectory {

    static ArrayList<String> names = new ArrayList<>();       // keeps insertion order
    static HashMap<String, String> book = new HashMap<>();    // name -> number (fast lookup)

    static void add(String name, String phone) {
        if (!book.containsKey(name.toLowerCase())) {
            names.add(name);
        }
        book.put(name.toLowerCase(), phone);
    }

    static void search(String key) {
        String p = book.get(key.toLowerCase());               // exact search, O(1)
        System.out.println(p != null ? key + " : " + p : "Not found");
    }

    static void partialSearch(String key) {                   // linear search on ArrayList
        for (String n : names) {
            if (n.toLowerCase().contains(key.toLowerCase())) {
                System.out.println(n + " : " + book.get(n.toLowerCase()));
            }
        }
    }

    static void display() {
        for (String n : names) {
            System.out.println(n + " : " + book.get(n.toLowerCase()));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n1.Add 2.Search 3.Partial Search 4.Display 5.Exit: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Phone: ");
                add(n, sc.nextLine());
            } else if (ch == 2) {
                System.out.print("Name: ");
                search(sc.nextLine());
            } else if (ch == 3) {
                System.out.print("Keyword: ");
                partialSearch(sc.nextLine());
            } else if (ch == 4) {
                display(); 
            }else {
                break;
            }
        }
    }
}
