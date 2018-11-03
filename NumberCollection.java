/*-------------------------------------------------------------------------
// AUTHOR: Anthony Weringer
// FILENAME: NumberCollection.java
// SPECIFICATION: Resizable array of unique integers 
// FOR: CSE 110- Assignment6
// DATE: 9/22/17
// TIME SPENT: 4 hours
//-----------------------------------------------------------*/

import java.util.Arrays;
public class NumberCollection
	{
		/*Instance variables*/
		private int[] numberArray;
		private int count;

		/*Constructor*/

		/*Constructs empty array object using arraySize to set the array capacity*/
		public NumberCollection(int arraySize)
		{
			numberArray = new int[arraySize];
		}

		/*Methods*/

		/*Helper method returns the index of the number specified*/
		private int indexOf(int searchingNum)
		{
			int i;
			for(i = 0; i > -1 && i <= count-1; i++)
			{
					if(searchingNum == numberArray[i])
			  			return -1;
			}
			return i;
		}

		/*Adds number to next available array position if number not used already*/
		public boolean addNumber(int numberToAdd)
		{
			if(indexOf(numberToAdd) != -1)
			{
				numberArray[count] = numberToAdd;
				count++;
				if(count == numberArray.length)
				{
					int[] newNumberArray = Arrays.copyOf(numberArray, 2 * numberArray.length);
					numberArray = newNumberArray;
				}
				/*numberArray[count] = numberToAdd;*/
				
				return true;
			}
			else
				return false;
		}

		/*Finds the maximum*/
		public int findMax()
		{
			int large = numberArray[count];
			int i = count;
			while(i > 0)
		  	{
				if(large < numberArray[i-1])
			  	large = numberArray[i-1];
			  	i--;
			}
			return large;
		}

		/*Finds the minimum*/
		public int findMin()
		{
			int small;
			if(count == 0)small = 0;
			else
				small = numberArray[count-1];
			int i = count-1;
			while(i > 0)
			{
				if(small > numberArray[i-1])
				small = numberArray[i-1];
				i--;
			}
			return small;
		}

		/*Computes and returns sum of numbers*/
		public int computeSum()
		{
			int sum = 0;
			for(int i = 0; i < numberArray.length; i++)
				sum = sum + numberArray[i];
			return sum;
		}

		/*Returns string containing a list of numbers*/
		public String toString()
		{
			String res = "{";
			for(int i = 0; i < count; i++)
			{
				res = res + numberArray[i];
				if(i < count-1)
					res = res + ", ";
			}
			res = res + "}";
			return res;
		}

  } 