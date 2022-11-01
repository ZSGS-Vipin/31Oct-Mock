import java.util.ArrayList;
import java.util.List;

public class RepeatedSubsequencre {
    public static void main(String[] args) {

    }
     static void generatingSubseq(String input, String output, List<List<String>> result)

    {
        if(input.isEmpty())
        {
            ArrayList<String> inner = new ArrayList<>();
            inner.add(output);
            result.add(inner);
            return;
        }
        char ch = input.charAt(0);
       generatingSubseq(input.substring(1),output+ch,result);
       generatingSubseq(input.substring(1),output,result);
    }
     static List<List<String>> subsequence(String input)
    {
        List<List<String>> result = new ArrayList<>();
        generatingSubseq(input,"",result);
        findingSubSequence(result);
        return result;
    }
    static void findingSubSequence(List<List<String>> result)
    {
        List<String> finalResult = new ArrayList<>();
        int count = 0;
       for(int i  = 0; i < result.size();i++)
       {
           for(String chcek : result.get(i))
           {
             int index = 0;
             int inner = index + 2;
             boolean flag = true;
             while(index<chcek.length()-2&&inner<chcek.length())
             {
                 if(chcek.charAt(index)!=chcek.charAt(inner))
                 {
                     flag=false;

                 }
                 index++;
                 inner++;
             }
             if(flag)
             {

                 if(chcek.length()>2) {
                     finalResult.add(chcek);
                     count++;
                 }
             }
           }
       }
      System.out.println(finalResult);
     System.out.println(count);
    }
}
