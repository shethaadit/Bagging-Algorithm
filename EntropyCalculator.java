import java.io.*;
import java.util.*;

//import ID3.DataSet;

// A Class to find Entropy and Information Gain of given attributes with 
		// using stored DataSet

public class EntropyCalculator 
{
	public double infoGain(double r_entropy, ArrayList<Double> s_ent, ArrayList<Integer> size,int data) 
	{
		double i_gain = r_entropy;

		for (int i = 0; i < s_ent.size(); i++) 
		{
			i_gain += -((size.get(i) / (double) data) * s_ent.get(i));
		}
		return i_gain;
	}
	
		public double calculateEntropy(ArrayList<DataSet> d) 
		{
			double entropy = 0;
			if (d.size() == 0) 
			{
				return 0;
			}
			for (int i = 0; i < 2; i++) 
			{
				int count = 0;
				for (int j = 0; j < d.size(); j++) 
				{
					DataSet ds = d.get(j);
					
					if (ds.label.equals(Integer.toString(i))) 
					{
						count++;
					}
				}

				double prob = count / (double) d.size();
				if (count > 0) 
				{
					entropy += -prob * (Math.log(prob) / Math.log(2));
				}
			}
			return entropy;
		}

		
	}


