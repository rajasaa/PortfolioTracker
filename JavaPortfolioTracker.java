import java.io.IOException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaPortfolioTracker {
	public static void main(String[] args) throws Exception, IOException
	{
	FileInputStream fstream = new FileInputStream("C:\\input.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String strLine;	
    int row = 0;
    HashMap<Integer,String> dict = new HashMap<Integer,String>();
    int [] rowValue = new int[3];
    
    while((strLine = br.readLine())!= null)
{
    	String newStr = strLine.replaceAll("[^\\d,]", "");
    	String [] value = newStr.split(",");
    	int sum = 0;
		for (int i=0; i<value.length; i++ )
		{
			sum = sum + Integer.parseInt(value[i]) ;
		}
		
		rowValue[row] = sum; 
		dict.put(sum, strLine);
		row++;
}
    int temp = 0;
    for (int i = 0; i < row; i++) 
    {
        for (int j = i + 1; j < row; j++) 
        {
            if (rowValue[i] < rowValue[j]) 
            {
                temp = rowValue[i];
                rowValue[i] = rowValue[j];
                rowValue[j] = temp;
            }
        }
    }
    
    for (int j=0;j<rowValue.length;j++){
    	for (int i: dict.keySet())
        {
           if(i == rowValue[j])
        		   {
        	      System.out.println(dict.get(i));
        		   }
        }
    } 
}

}
