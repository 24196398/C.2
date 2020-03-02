package buble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BinarySearch {
	public static int sucess=0;
	public static int find;
	public static int length;
	public static ArrayList<Integer> fails = new ArrayList<Integer>();
	public static int amount = 1000000;
	public static Boolean inList= false;
	public static int getNum;
	public static int count = 0;
	public static int[] list = new int[length];
	public static int[] analyse;
	

	public static void main(String[] args) {
		for(int l=0;l<amount;l++) {
		Random rd = new Random();
		length = rd.nextInt(100);
		while(length<=1) {
		length = rd.nextInt(100);
		}
		int[] list = new int[length];
		list = random(list);
		binarySort(list);
		}
		
		System.out.println("\rsucess : "+sucess+"/"+amount);
		analyse = convertIntegers(fails);
		if (analyse.length != 0) {
		System.out.println("fails contains : " + fails.toString()); 
		analyse = quickSort(analyse,0,analyse.length-1);
		System.out.println("fails sorted : "+Arrays.toString(analyse));
		System.out.println("fails count : "+getOccurrences(analyse));
		removeDups(analyse);
		}
		
	}

	public static int[] random(int[] list) {
		Random rd = new Random();
		for (int i = 0; i < list.length; i++) {
				list[i] = rd.nextInt(100);
		}
		quickSort(list,0,list.length-1);
		while(inList==false) 
		{
			getNum = rd.nextInt(length);
			if(getNum<=length)
			{
				find = list[getNum];
				inList=true;
			}
			
		}
	inList=false;
		return list;
		
	}
	public static int[] sort(int[] list) {
		int temp;
		int swaps = 0;
		for (int i = 0; i < 100; i++) {

			for (int j = 0; j < list.length - 1; j++) {
				if (list[j] > list[j + 1]) {
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					swaps++;
				}
			}
			if (swaps == 0) {
				i = 101;
			}
			swaps = 0;
			i++;
		}
		return list;

	}
	public static Boolean linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return true;    
            }    
        }
		return false;      
    }    
	public static int[] convertIntegers(List<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	public static int getOccurrences(int[] numbers)
	{
	    count = 0;

	    for (int i = 0; i < numbers.length; i++)
	    {
	        int currentInt = numbers[i];;

	        if (currentInt == numbers[i])
	        {
	            count++;
	        }
	    }

	    return count;
	}
	public static void removeDups(int[] analyse)
	{
		if (analyse.length != 0) {
		int current = analyse[0];
		int d = 0;
		boolean found = false;
		System.out.print(" \rno dups : ");
		for (int i = 0; i < analyse.length; i++) {
		    if (current == analyse[i] && !found) {
		        found = true;
		    } else if (current != analyse[i]) {
		        System.out.print(" " + current);
		        d++;
		        current = analyse[i];
		        found = false;
		    }
		}
		System.out.print("\rcount dups : "+d);
	}}
	static int partition(int[] array, int begin, int end) {
	    int pivot = end;

	    int counter = begin;
	    for (int i = begin; i < end; i++) {
	        if (array[i] < array[pivot]) {
	            int temp = array[counter];
	            array[counter] = array[i];
	            array[i] = temp;
	            counter++;
	        }
	    }
	    int temp = array[pivot];
	    array[pivot] = array[counter];
	    array[counter] = temp;

	    return counter;
	}
	public static int[] quickSort(int[] array, int begin, int end) {
	    if (end <= begin) return array;
	    int pivot = partition(array, begin, end);
	    quickSort(array, begin, pivot-1);
	    quickSort(array, pivot+1, end);
	    return array;
	}
	
	
	
	
	public static void binarySort(int list[])
	{
	int i = 0; 
	int first = 0;
	int last=list.length-1;  
	int mid = (first + last)/2; 
		while( first <= last ){  
		      if ( list[mid] < find ){  
		        first = mid + 1;     
		      }else if ( list[mid] == find ){  
		        sucess++;  
		        break;  
		      }else{  
		         last = mid - 1;  
		      }  
		      mid = (first + last)/2;  
		   }  
		   if ( first > last ){  
		      fails.add(find);
		   }  
		 }  
		
	}

