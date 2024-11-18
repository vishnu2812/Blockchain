import java.io.*;
import java.util.Date;
import java.util.*;
import java.util.Date;
import java.util.function.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.net.*;




class Balloter
{	public String msg_val;
	public String vote_maxi;
	public String vote_min;
	public String val_row;
	
	
	public int register_voter(String identitiy_V) throws FileNotFoundException
	{
		int newval_f = -1;
    	Scanner get_val_voter = new Scanner(new File("voterlist.txt"));
    	
    	while (get_val_voter.hasNextLine())
    	{
    	    String val_ray = get_val_voter.nextLine();
    	    
    	    String[] list_ar = val_ray.split("\\s");
    	    if( list_ar[0].equals(identitiy_V)==true )
    	    {
    	        if( list_ar[2].equals("0")==false ){ newval_f=0;
    	        	msg_val=list_ar[2];
    	        }

    	        else
    	        {
    	            newval_f = Integer.parseInt(list_ar[1]);
    	            
    	            val_row=val_ray;
    	            
    	            
    	        }

    	        break;
    	    }
    	}
    	return newval_f;
	}	
	public void edit_doc_val(String dir_doc, String StrLast_val)
    {	Calendar date_valB = Calendar.getInstance();
   	    File doc_editmain = new File(dir_doc);
		String ssd;
		SimpleDateFormat form_date = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss.SS");


    	String val_date_line = form_date.format(date_valB.getTime());
		BufferedReader r_valueB = null;
   	    String middle_ln = val_row.substring(0,15)+" "+val_date_line;
		String oldContestent = "";  
		FileWriter w_valueB = null; 
   	    String prev_valCont = "";
   	    
   	   
   	    try
        {		//here we getting value of doc file into our variable
   	        r_valueB = new BufferedReader(new FileReader(doc_editmain));
    	                
            String val_ray = r_valueB.readLine();

            while (val_ray != null) 
            {
                prev_valCont = prev_valCont + val_ray + System.lineSeparator();
                val_ray = r_valueB.readLine();
            }
            //here replacement is done
			String jbana="";
            String newContent = prev_valCont.replaceAll(StrLast_val, middle_ln);
            //here new value is inserted in doc
            w_valueB = new FileWriter(doc_editmain);
			jbana="OK";
            w_valueB.write(newContent);
        }
        catch (IOException er_valB)
        {	//gives us the error if found
            er_valB.printStackTrace();
        }
        finally
        {
            try
            {
                //all opened doc are closed
                r_valueB.close();               
                w_valueB.close();
            } 
            catch (IOException er_valB) 
            {	//error handling
                er_valB.printStackTrace();
            }
        }
    }
}
