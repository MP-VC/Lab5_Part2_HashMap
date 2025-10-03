import java.util.HashMap;
/**
 * Write a description of class MapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapTester
{
    // instance variables - replace the example below with your own
    private HashMap<String,String> phoneBook;
    
    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        phoneBook = new HashMap<>();
    }

    /**
     * add to hashmap
     */
    public void enterNumber(String name, String number)
    {
        phoneBook.put(name,number);
    }
    
    public String lookupNumber(String name)
    {
        return phoneBook.get(name);
    }
    
    public boolean verifyKey(String key)
    {
        return phoneBook.containsKey(key);
    }
    
    public void printKeys()
    {
        System.out.println(phoneBook.keySet());
    }
}
