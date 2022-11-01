import java.util.Arrays;

public class ArrayProducts {
    public static void main(String[] args) {
        int[] array = {3,0,1,2};
        int len = array.length;
        System.out.println(Arrays.toString(produts(array,len)));
    }
    public static int[] produts(int[] array, int len)
    {
        int[] result = new int[len];
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        leftSum[0]=1;
        rightSum[len-1]=1;
        for(int index=1;index<len;index++)
        {
            leftSum[index]=leftSum[index-1]*array[index-1];
        }
        for(int index=len-2;index >=0; index--)
        {
            rightSum[index]=rightSum[index+1]*array[index+1];
        }
        for(int i = 0; i < len;i++)
        {
            result[i]=leftSum[i]*rightSum[i];
        }
        return result;
    }
}
