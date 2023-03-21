
/**
 * Write a description of class StringReverse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringReverse
{
    public static String reverse(String str)
    {
        // must have a terminating case
        if(str.equals(""))
        {
            return str;
        }
        
        // take a small step towards a solution
        String firstChar = str.substring(0,1);
        String restOfString = str.substring(1);
        
        // recurse - call this method with a simpler problem
        String restOfStringReversed = reverse(restOfString);
        
        String strReversed = restOfStringReversed + firstChar;
        return strReversed;
    }
    
    public static String reverseIter(String str)
    {
        String strReversed = "";
        
        for(int i = 0; i < str.length(); i++)
        {
            strReversed = str.substring(i, i + 1) + strReversed;
        }
        
        return strReversed;
    }
}
