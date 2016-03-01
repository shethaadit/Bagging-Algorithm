import java.io.*;
import java.util.*;

//import ID3.DataSet;
//import ID3.Mappings;

//class to map values of every attributes to the resulting attributes that
//		to be used in Entropy Formula

class Mappings 
{
		public ArrayList<String> mappingvalues = new ArrayList<String>();
		public int maximum;
		public double entropy;
		public String s_name;
		
	//Boolean Function to read data from file
		
	public boolean ReadFile(File fname, ArrayList<DataSet> ds, boolean r_trainig, int trainingSet) 
	{
		Scanner fileScanner = null;
		try 
		{
			fileScanner = new Scanner(fname);
		}
		catch (FileNotFoundException e) 
		{
			return false;
		}

		this.parsing(fileScanner, ds, r_trainig, trainingSet);
		return true;
	}

	//Parsing Function to split data into tokens, Maintaining counters
	
	public void parsing(Scanner fileScanner, ArrayList<DataSet> ds,boolean data_training, int trainingSet) 
	{
		//Trim Function to avoid leading and Trailing white spaces
		
		String line = fileScanner.nextLine().trim();
		String tokens;
		StringTokenizer st = new StringTokenizer(line);
		int i =0;
		int c = 0;
		ArrayList<Mappings> tempAttribute = new ArrayList<Mappings>();
		
		while (st.hasMoreTokens()) 
		{
			tokens = st.nextToken();
			Mappings attribute = new Mappings();
			if (data_training) 
			{
				attribute.s_name = tokens;
			}
			
			//Keeping record of Maximum size of tokens
			
			int maxval = Integer.parseInt(st.nextToken());
			
			if (data_training) 
			{
				attribute.maximum = maxval;
				
				tempAttribute.add(attribute);
				
				ID3.attributes.add(tempAttribute);
				
				i++;
				c++;
			}
		}
		
		for ( int p=0; p < ID3.attributes.get(trainingSet).size(); p++)
		{
			Mappings attribute;
			attribute = ID3.attributes.get(trainingSet).get(p);
			
		}
		
		if (data_training)
			ID3.Att_size = c;

		//Reading tokens of data using FileScanner class
		
		while (fileScanner.hasNextLine()) 
		{
			line = fileScanner.nextLine().trim();
			st = new StringTokenizer(line);
			i = 0;
			String temp = null;
			DataSet r = new DataSet();
			c = 0;
			
			while (c < ID3.Att_size) 
			{
				temp = st.nextToken();
				r.attributeValue[c] = (temp);
				c++;
			}
			
			r.label = st.nextToken();
			ds.add(r);
		}
		
		for (i = 0; i < c; i++) 
		{
				Mappings attribute = ID3.attributes.get(trainingSet).get(i);
				attribute.getMappingValues(ID3.trainingDatasets.get(trainingSet), i);
		}
				
		for (i =0; i < c; i++)
		{
			Mappings attribute = ID3.attributes.get(trainingSet).get(i);
					
			for (int a =0; a < attribute.maximum; a++)
			{
				//System.out.println("maximum and a is " + +attribute.maximum + a);
				String temp = attribute.mappingvalues.get(a);
			}
		}
	
	}
	
	//Function to get mapping values of each column with resulting column
	//			which is being used in Formula
	
	public void getMappingValues(ArrayList<DataSet> ds, int ind) 
	{
		DataSet temp2;
		for (int i = 0; i < ds.size(); i++) 
		{
			temp2 = ds.get(i);
			if (!mappingvalues.contains(temp2.attributeValue[ind])) 
			{
				mappingvalues.add(temp2.attributeValue[ind]);
			}
		}
	}
	
	//Function to get Row Number of Mapped values which is being used in
	//		generating tree
	
	public int getIndex(String val) 
	{
		String temp3;
		for (int i = 0; i < this.mappingvalues.size(); i++) 
		{
			temp3 = this.mappingvalues.get(i);
			if (temp3.equals(val)) 
			{
				return i;
			}
		}
		
		return -999;
	}
}