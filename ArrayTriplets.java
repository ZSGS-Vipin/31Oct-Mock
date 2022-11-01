import java.util.*;

public class ArrayTriplets {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,4};
        int len = array.length;
        tripletsOfArray(array,len);
    }
    public static void triplets(int[] array, int len)
    {
        //brute force
        List<List<Integer>> outer = new ArrayList<>();
        for(int i = 0; i < len-2;i++)
        {
            for(int j = i+1;j<len-1;j++)
            {
                for(int k = j+1;j<len;j++)
                {
                    if(array[i]+array[j]+array[k]==0)
                    {
                        List<Integer> inner = new ArrayList<>();
                        inner.add(array[i]);
                        inner.add(array[j]);
                        inner.add(array[k]);
                        outer.add(inner);
                    }
                }
            }
        }
        System.out.println(outer);
    }
        static void tripletsOfArray(int arr[], int n)
        {
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for (int index = 0; index < n - 1; index++) {

                HashSet<Integer> hashSet = new HashSet<Integer>();
             //added hashmap and checking the multiplication of the three products
                for (int inner = index + 1; inner < n; inner++) {
                    int product = 1;
                    int temp = -(arr[index] + arr[inner]);
                    if (hashSet.contains(temp)) {
                       if(!hashMap.containsKey(product)&&(!hashMap.containsValue(arr[inner]))) {
                           if (temp + arr[index] + arr[inner] == 0) {
                               product = product * (arr[inner] * arr[index] * temp);
                               System.out.println(arr[inner] + " " + temp + " " + arr[index]);
                               hashMap.put(product, arr[inner]);
                           }
                       }
                        }

                    else {
                        hashSet.add(arr[inner]);
                    }
                }
            }


            }
        }








