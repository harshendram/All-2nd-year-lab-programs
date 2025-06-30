package CollectionBook7;


class Book
{
    String title,author,publisher;
    float price;
    Book(String t, String a, String p, float pr){
        title=t;
        author=a;
        publisher=p;
        price=pr;
    }
    public String toString() {
        return "Book Details "+title+" "+author+" "+publisher+" "+price;
    }
}
