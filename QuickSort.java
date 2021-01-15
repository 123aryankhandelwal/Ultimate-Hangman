import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class QuickSort
{
	private static List<Users> inputArray = new ArrayList<>();
	static int cat, diff;

    public QuickSort(List<Users> inputArray, int c, int d)
    {
        QuickSort.inputArray = inputArray;
        cat = c;
        diff = d;
    }
 
  
    public List<Users> getSortedArray()
    {
        return QuickSort.inputArray;
    }
 
   void partition(int start, int end)
   {
        int init = start;
        int length = end;
        int pivotIndex = (start+end)/2;
        Users pivot = inputArray.get(pivotIndex);
        while(length>init)
        {
            while(inputArray.get(length).getPB(cat, diff)>pivot.getPB(cat, diff))
            {
                length--;
            }
            
            while(inputArray.get(init).getPB(cat, diff)<pivot.getPB(cat, diff))
            {
                init++;
            }
            
            if(init<=length)
            {
            	Collections.swap(inputArray, init, length);
                length--;
                init++;
            }
        }
        if(start<length)
        {
        	partition(start,length);
        }
        if(end>init)
        {
        	partition(init,end);
        } 
    }
}