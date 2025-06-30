package pg10; 
//All item details are recorded in this class 
public class Item  
{ 

String name,id;int price; 
Item(String name,String id,int price){ 
this.name=name; 
this.id=id; 
this.price=price; 
} 
public String toString() { 
return("ItemName "+name+" ItemId: "+id+" ItemPrice : "+price);
}
}
