
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Bryan Justo
 * Sorting program
 * Java
 * https://github.com/BryanJusto
 * https://www.linkedin.com/in/bryan-justo/
 */

public class SortingProg {
	File file = new File ("temp.txt");
	PrintWriter pw;
	StringBuilder rece = new StringBuilder();
	  private int[] numbers;
	  private int[] helper;

	  private int number;

	
	public int[] bubble(String x){
		
		String[] parts = x.split(" ");
		int[] n1 = new int[parts.length];
		for(int n = 0; n < parts.length; n++) {
		   n1[n] = Integer.parseInt(parts[n]);
		}
		
		int temp;
		
		for(int i = 0; i < n1.length-1; i++){
			for(int j = 1; j<n1.length-i;j++){
				
			
			if(n1[j-1] > n1[j]){
				temp = n1[j - 1];
				n1[j - 1] = n1[j];
				n1[j] = temp;
				}	
			}
			try {
				printin((i + 1) + "th it result " + Arrays.toString(n1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n1;
		}

	public int[] quickSort(int[] arr, int low, int high){
 
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
		
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			}
		try {
			printin("result " + Arrays.toString(arr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
		return arr;
		
	}

	  public void sort(int[] values) {
	    this.numbers = values;
	    number = values.length;
	    this.helper = new int[number];
	    mergesort(0, number - 1);
	  }

	  private void mergesort(int low, int high) {
	    if (low < high) {
	      int middle = low + (high - low) / 2;
	      mergesort(low, middle);
	      mergesort(middle + 1, high);
	      merge(low, middle, high);
	    }
	  }

	  private void merge(int low, int middle, int high) {

	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    while (i <= middle && j <= high) {
	      if (helper[i] <= helper[j]) {
	        numbers[k] = helper[i];
	        i++;
	      } else {
	        numbers[k] = helper[j];
	        j++;
	      }
	      k++;
	      try {
			printin("The Left " +Arrays.toString(numbers) + " Right " +Arrays.toString(helper) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    while (i <= middle) {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	      
	      try {
			printin("middle " +Arrays.toString(numbers) + " " +Arrays.toString(helper) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	     
	  }

	
	public void printin(String s) throws IOException{
		if(file.exists()){
			pw = new PrintWriter(new BufferedWriter(new FileWriter("temp.txt", true)));
		}
		else{
			pw = new PrintWriter(file);
		}
		
		pw.println(s);
		pw.close();
	}
	public void prevReceipt() throws FileNotFoundException{
		//Variable		
		
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(file);
			Scanner input = new Scanner(file);
			while(input.hasNext()){
				rece.append(input.nextLine());
				rece.append("\n");
			}
			input.close();
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(){
		file.delete();
	}
}
	


