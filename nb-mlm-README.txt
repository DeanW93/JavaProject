-------------------------------NAIVE BAYES MACHINE LEARNING MODEL README-------------------------------------------------------------------------------------------------------------


This Java project uses the Naive Bayes Algorithm to train a machine learning model to predict the likelyhood 
of tonsillitis in patients with given symptoms.

These are constrained to:

Temperature: hot, normal, cool

Aches: yes, no

Sore throat: yes, no

Tonsillitis: yes, no


The program processes a dataset as a text file in the format:

Line: 	[temperature] [aches] [sore throat] [tonsillitis]
	
DATASET EXAMPLE:
	
	hot Yes Yes No
	hot No No No
	normal No Yes Yes
	cool Yes Yes no
	cool Yes No no
	cool No No yes
	normal No Yes yes
	cool No No no
	normal Yes Yes yes
	normal Yes Yes yes
	normal No Yes yes
	hot Yes No no
	normal Yes No no
	hot Yes Yes no
	normal No Yes yes
	cool Yes No no
	normal Yes Yes yes

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

GUI:

The program uses a front end graphical user interface for user input. The main menu consists of three JButtons:

	Train New Data Set: Opens File Manager window, allows user to choose dataset to train from local directory.

	Patient Evaluation: Opens patient evaluation window, allows user to test for the final posterior probability
			    of tonsillitis in a patient using the data trained from the dataset and displays this to the user.
	
	Exit: Exits the program.

FILE MANAGER WINDOW:

This interface implements the following:

	JSlider:  	JSLIDER is at the top of the page. This allows the user to specify the percentage portion of the dataset 
		 	they wish to use to train the machine learning model. The remaining data will be used to self evaluate the model
		  	and will return the prediction success rate of the model as a percentage to the user.
	
	JFileChooser:	JFileChooser is positioned below the JSlider. This allows the user to browse their local directories and select
			a dataset of their prefrence. The file must be a text file with extension .txt. This is imnplenmented in the code in order
			to prevent the user from selecting an incompatible file format.
			
Once a file is selected a file processor object to process and store the data needed in order to use the Naive Bayes algorithm to predict
the relevant probabilities.
			
Patients are created dynamically depending on the dataset size and their data is stored for later use in the Naive Bayes Algorithm.
			
Using a similar algorithm the evaluation portion of the data is stored in a seperate array of patients dynamically created depending on the size of 
the evaluation portion of the dataset. 

A counter is then used as a loop iterates through the evaluation patients array and predicts the likelyhood of tonsillitis and checking if the model prediction was 
"correct" ie: the P(tonsillitis) > P(notonsillitis) in each given patient AND tonsillitis = yes(boolean true).

The prercentage accuracy is returned to the user using counter variables in the format ##.## % eg: 65.45 %

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

PATIENT EVALUATION WINDOW:

This interface implements:
	
	JCheckBox: A series of JCheckBoxes organised using JLabels and JPanels allow the user to specify a patient with custom symptoms
	
	JButton submit: When the user clicks the submit button a new patient object is created. The symptoms specified by the user are stored as patient attributes.
			A probability calculator is instanciated and the NaiveBayesAlgorithm method is called to calculate the final posterior probability of tonsillitis and
			no tonsillitis in the custom patient. This information is then returned to the user. The user may test as many combinations of symptoms as they like.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
































