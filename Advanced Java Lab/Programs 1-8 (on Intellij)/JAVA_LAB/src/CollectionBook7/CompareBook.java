package CollectionBook7;


import java.util.*;
class CompareBook implements Comparator<Book>
{
    public int compare(Book x, Book y) {
        return (int)(x.price-y.price);
    }
}
