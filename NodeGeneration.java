import java.io.*;
import java.util.ArrayList;

//import ID3.DataSet;
//import ID3.Mappings;
//import ID3.NodeGeneration;

//A class to expand decision tree using recursion and generating nodes

public class NodeGeneration 
{
		//ArrayList structure to get maintain records attributes for which every time
		//			the tree is being splitted and it can not be used furthur
	
		public ArrayList<Mappings> att_Splited;
		public ArrayList<DataSet> data;
		
		public boolean trav;
		
		//double variable to count entropy
		
		public double entropy;
		
		Mappings attr;
		String attr_val;
		
		//variables to be used in Tree 
		
		public NodeGeneration parent;
		public NodeGeneration[] child;
		public int child_Count;
		
		//A parameterized constructor to initialized variable values and 
				// a whole ArrayList has been passed
		
		public NodeGeneration(ArrayList<DataSet> arrayList) 
		{
			this.data = new ArrayList<DataSet>();
			this.att_Splited = new ArrayList<Mappings>();
			this.data = arrayList;
			
			trav = false;
			entropy = 0.0;
			
			parent = null;
			child = null;
			
			attr = null;
			attr_val = null;
			child_Count = 0;
		}
		
		// A parameter less constructor to primarily initialized values
		
		public NodeGeneration() 
		{
			
			this.data = new ArrayList<DataSet>();
			this.att_Splited = new ArrayList<Mappings>();
			
			trav = false;
			entropy = 0.0;
			
			attr = null;
			attr_val = null;
			
			parent = null;
			child = null;
			child_Count = 0;
		}

		
	}
