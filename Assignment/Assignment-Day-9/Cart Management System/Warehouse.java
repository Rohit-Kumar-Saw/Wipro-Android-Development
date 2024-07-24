import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Item> items;
    private List<Integer> quantities;
    
    public Warehouse() {
        items=new ArrayList<>();
        quantities=new ArrayList<>();
    }
    public List<Item>getItems() {
        return items;
    }
    public List<Integer>getQuantities() {
        return quantities;
    }
    public boolean addItem(Item item,int quantity)
    {
        items.add(item);
        quantities.add(quantity);
        return true;

    }
    public boolean updateItem(String itemId, double price, String description, String title, int quantity) {
        int index=findItemIndex(itemId);
        if(index!= -1)
        {
         Item item=items.get(index);
         item.setPrice(price);
         item.setDescription(description);
         item.setTitle(title);
         quantities.set(index,quantity);
         return true;
        }
        return false;
    }
    public boolean deleteItem(String itemId)
    {
        int index=findItemIndex(ItemId);
        if(index != -1)
        {
            items.remove(index);
            quantities.remove(index);
            return true;
        }
        return false;
    }
    public int getItemQuantity(String itemId) {
        int index=findItemIndex(itemId);
        if(index != -1){
            return quantities.get(index);
        }
        return -1;
    }
    public Item getItemById(String itemId)
    {
        int index=findItemIndex(itemId);
        if (index!=-1) {
            return items.get(index);
        }
        return null;
    }
    private int findItemIndex(String itemId)
    {
        for(int i=0;i<items.size();i++)
        {
            if(items.get(i).getItemId().equals(itemId))
            {
                return i;
            }
        }
        return -1;
    }
}
