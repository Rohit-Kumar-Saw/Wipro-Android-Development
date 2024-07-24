public class Sorting {
    public static int[] sor(int[] arr)
    {
        return arr;
    }
    public static void printArr(int[] arr)
    {
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[]arr={3,9,4,1,8,4,7};

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]<arr[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i:arr)
        {
            System.out.print(i+" ");
        }
        
    }
    
}
