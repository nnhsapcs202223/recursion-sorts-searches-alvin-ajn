import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            tempList = new ArrayList<Integer>();
            return tempList;
        }
        else        // All other size lists are created here
        {
            tempList = makeList(n - 1);
            tempList.add(n);
        }
        return tempList;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList);
        int n = list.size();
        if (n <= 0)
        {
            return list;
        }
        else
        {
            list.add(0, n);
            list = ListMethods.reverseList(list);
        }
        return list;
    }
}