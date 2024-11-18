
import java.io.*;
import java.util.Scanner;
import java.util.Random;
//package hello_crypto;
import java.util.Date;

public class Combuild
{
	private String msg_val; // this wil a message 
	public String PrevHVal; //this will be previous haash value
	private long Curr_t_value; 
		//this is timestamp
	public String currHVal; //this is current hash value of block
	public String ssa;
	
	
	//Constructor block.  
	public Combuild(String msg_val,String PrevHVal )
	{	this.Curr_t_value = new Date().getTime(); // getting current timestamp
		this.PrevHVal = PrevHVal; //prev value set
		this.msg_val = msg_val;
		
		
		this.currHVal = evaluation_H_val(); //at last
	}

	private int val_oun;

	public Combuild(String h_curr,String h_prev,String msg_val,long t_val,int val_oun)
	{	
		this.PrevHVal = h_prev;
		this.currHVal = h_curr;
		this.msg_val = msg_val;
		this.val_oun = val_oun;
		this.Curr_t_value = t_val;
		
		
	}
	
	//Hash value for the recent Block using Sha256
	public String evaluation_H_val() 
	{	
		String H_val_evaluated = impleMenter.imple_sha(PrevHVal + Long.toString(Curr_t_value) +Integer.toString(val_oun) +	msg_val);
		
		return H_val_evaluated;
	}
	
	//value of val_oun increasing until currHVal curr_select.
	public void blk_mine(int hr_d) 
	{
		String curr_select = impleMenter.str_diff(hr_d); //making string hr_d * "0" 
		
		while(!currHVal.substring( 0, hr_d).equals(curr_select)) 
		{
			val_oun ++;
		
			currHVal = evaluation_H_val();
		}


		des des_value=new des();
		String DES_evaluated1 = des_value.encrypt(currHVal.substring(0,16),"133457799BBCDFF1");
		String DES_evaluated2 = des_value.encrypt(currHVal.substring(16,32),"133457799BBCDFF1");
		String DES_evaluated3 = des_value.encrypt(currHVal.substring(32,48),"133457799BBCDFF1");
		String DES_evaluated4 = des_value.encrypt(currHVal.substring(48,64),"133457799BBCDFF1");
		String DES_ANS=(DES_evaluated1+DES_evaluated2+DES_evaluated3+DES_evaluated4);
		
		//currHVal=(DES_evaluated1+DES_evaluated2+DES_evaluated3+DES_evaluated4); 
		System.out.println("Mined the Block successfully ! : " + currHVal);
	
	}
	
	
	public void detail_block()
	{	System.out.println("		Previous value Hash : "+PrevHVal);
		System.out.println("\n");
		System.out.println("		Current value Hash : "+currHVal);
		System.out.println("\n");
		System.out.println("		Current Time : "+Curr_t_value);
		System.out.println("\n");
		System.out.println("		Current Data : "+msg_val);
		System.out.println("\n");
		//System.out.println("		Nonce : "+val_oun);
	}
	public void blk_add_doc() throws IOException
	{
    	FileWriter file_wr = null;
    	BufferedWriter br_wr = null;
    	PrintWriter print_wr = null;
    	try 
    	{ 
    	    file_wr = new FileWriter("value_doc.txt", true);

    	    
			br_wr = new BufferedWriter(file_wr);
    	    
			
			
			print_wr = new PrintWriter(br_wr);
    	    
			
			print_wr.println( currHVal + " " + PrevHVal + " " + msg_val + " " + Curr_t_value + " " + val_oun);
    	    
			print_wr.flush();
    	} 
    	finally 
    	{ 
    	    try 
    	    { 
    	        print_wr.close();
    	        br_wr.close();
    	        file_wr.close();
    	    } 
    	    catch (IOException io) 
			{


			}
    	}
	}	
	public int val_info()
	{ return Integer.parseInt(msg_val); 	}

	
}
