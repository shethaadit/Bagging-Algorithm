import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

	//MAIN CLASS
	public class ID3 
	{

		//INITIALIZING ATTRIBUTE SIZE
		public static int Att_size = 0;
		
		//ARRAYLIST TO STORE TEST-DATA FROM TEST FILE
		static ArrayList<DataSet> testDatasets = new ArrayList<DataSet>();
		//ARRAYLIST TO STORE TEST-DATA FROM TRAIN FILE
		static ArrayList<ArrayList<DataSet>> trainingDatasets = new ArrayList<ArrayList<DataSet>>();
		
		static ArrayList<ArrayList<Mappings>> attributes = new ArrayList<ArrayList<Mappings>>();
		
		//ARRAYLIST TO STORE ROOTS OF DIFFERENT TREES
		static ArrayList<NodeGeneration> tree_roots = new ArrayList<NodeGeneration>();
		//ARRAYLIST TO STORE WHOLE TREES OF DIFFERENT FILES
		static ArrayList<CreateTree> trees = new ArrayList<CreateTree>();
		
		//MAIN CLASS OBJECT
		public static ID3 object = new ID3();
		
		
		//Main Function
		public static void main(String[] args) 
		{
				
			ArrayList<Mappings> attUsed = new ArrayList<Mappings>();
			
			Mappings m = new Mappings();
			
			
			if (args.length != 2) 
			{
				System.out.println("Please Enter Training File folder first and then 1 Test File...");
				System.exit(1);
			}
			System.out.println("\n\n");
			
			//STORE FOLDER NAME AND TEST FILE NAME FROM COMMANDLINE.
			String data_Test = args[1];
			String data_Training = args[0];
			
			File trainingData = new File(data_Training);
			File testData = new File(data_Test);
			
			//BOOLEAN FLAGS TO CHECK IF DATA FROM FILE HAS BEEN READ OR NOT
			boolean flag = false;
			boolean r_train = true;
			boolean r_test = false;
			
			int trainingSet = 0;
			for (File file: trainingData.listFiles())
			{
				ArrayList<Mappings> usedAttributes = new ArrayList<Mappings>();
				
				//READ ALL FILES FROM FOLDER
				if(file.isDirectory())
				{
					
					System.out.println("Something went wrong...");
				}
				
				flag = false;
				
				ArrayList<DataSet> trainingDataset = new ArrayList<DataSet>();
				
				//ADDING ALL DATA
				trainingDatasets.add(trainingDataset);
				
				//CHECK IF TRAIN DATA ARE SUCCESSFULLY READ OR NOT
				flag = m.ReadFile(file, trainingDatasets.get(trainingSet), r_train, trainingSet);
				if (flag == false) 
				{
					System.out.println("Data Can not be read from Train file...");
					System.exit(1);
				}
					Mappings attribute;
					for (int i = 0; i < attributes.get(trainingSet).size(); i++) 
					{
						attribute = attributes.get(trainingSet).get(i);
						
					}
					
					NodeGeneration root = new NodeGeneration(trainingDatasets.get(trainingSet));
					
					CreateTree tree = new CreateTree();
					
					//ADDING TREES
					trees.add(tree);
					
					//System.out.println("treesize :" + trees.size());
					
					for (int i = 0; i < attributes.get(trainingSet).size(); i++) 
					{
						String temp = attributes.get(trainingSet).get(i).s_name;
					
					}
					
					Mappings temp_map = new Mappings();
					
					temp_map.s_name = "first";
					
					root.attr = temp_map;
					
					//ADDING ALL ROOTS
					tree_roots.add(root);
					root = tree.genTree(trainingDatasets.get(trainingSet), tree_roots.get(trainingSet), attributes.get(trainingSet), usedAttributes, trainingSet);
					tree_roots.set(trainingSet, root);
					
					trainingSet++;

				}
				
				//CHECK TO READ DATA FROM TEST FILE
				flag = m.ReadFile(testData, testDatasets, r_test, 0);
				
			    if (flag == false) 
			    {
					System.out.println("Test file can not be read...");
					System.exit(1);
				
			    }
			    DecimalFormat df = new DecimalFormat("#.##");
			//System.out.println(trees.size());
			
			double accuracyTestData = trees.get(0).accuracyCalculator(tree_roots, testDatasets, trainingSet);
			
			//PRINTING NUMBER OF BAGS
			System.out.println("*********************************************");
		    System.out.println("Total number of Bags : " + trainingSet);
			
		    //PRINTING ACCURACY ON TEST FILE
			System.out.println("\nCombined Accuracy on test Data Set: " + df.format(accuracyTestData) + "%");
			System.out.println("*********************************************");
			}
		}
	
			
			
