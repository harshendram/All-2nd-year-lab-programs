package CollectionBook7;


import java.util.*;

public class BookManager {
    ArrayList<Book> blist=new ArrayList<Book>(10);
    HashMap<Integer,Book> hbook = new HashMap<Integer,Book>();
    ArrayList<Book> sortedlist=new ArrayList<Book>(10);
    ArrayList<Book> costlylist=new ArrayList<Book>(10);
    public void addBooks(Book temp)
    {
        blist.add(temp);
    }
    public void displayBooks()
    {
        for(Book b:blist)
        {
            System.out.println(b);
        }
    }
    public void addHash()
    {
        int id=1;
        for(Book b:blist)
        {
            hbook.put(id++,b);
        }
    }
    public void displayHash()
    {
        for(Map.Entry<Integer,Book> hm: hbook.entrySet())
        {   int k = hm.getKey();
            Book b = hm.getValue();
            System.out.println(k+" "+b);
        }
    }
    void sortBooks() {
        Collections.sort(blist,new CompareBook());

        for(Book b:blist)
        {
            sortedlist.add(b);
        }
        for(Book b:sortedlist)
        {
            System.out.println(b);
        }
    }
    public void searchAuthor(String name)
    {
        for(Book b:sortedlist)
        {
            if(b.author.equalsIgnoreCase(name))
            {
                System.out.println(b);
            }
        }
    }
    public void CostlyBooklist(float t) {

        for(Book b:sortedlist)
        {
            if(b.price>t)
                costlylist.add(b);
        }
        for(Book b:costlylist)
        {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        Book b1=new Book("Java","Schildt","PHI",200.5f);
        Book b2=new Book("C","Kanetkar","McGrawHill",407.5f);
        Book b3=new Book("Python","Priyaa","Macmillan",57.5f);
        Book b4=new Book("C++","Balamurugan","PHI",57.5f);
        Book b5=new Book("C","Balamurugan","PHI",37.5f);
        BookManager bm=new BookManager();
        bm.addBooks(b1);bm.addBooks(b2);bm.addBooks(b3);
        bm.addBooks(b4);bm.addBooks(b5);

        System.out.println("Books in my arraylist(blist)");
        bm.displayBooks();
        System.out.println("Books in my hashmap(books with unique id)");
        bm.addHash();bm.displayHash();
        System.out.println("Books in sortedlist");
        bm.sortBooks();
        System.out.println("Enter author name");
        Scanner s=new Scanner(System.in);
        String t=s.next();
        bm.searchAuthor(t);
        System.out.println("Enter price");
        float p=s.nextFloat();
        bm.CostlyBooklist(p);
    }


}