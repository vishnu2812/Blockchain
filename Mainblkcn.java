import java.io.*;
import java.util.ArrayList;


import java.util.function.*;
//package dst
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mainblkcn
{	public static int hr_d = 5;
	public static int vary_int=10;
	public static Balloter val_bltr = new Balloter();
	public static String Balloter_newbst=" "; 
	public static ArrayList<Combuild> blk_val_arrlist;
	
	
	public static void main(String[] args) throws IOException
	{	
		ArrayList<Combuild> rand01 = docVal_shift();
		blk_val_arrlist=rand01;
		Scanner blkget = new Scanner(System.in);
		int upperfl;
		int lwrfl;

		//get the value from user
		System.out.println("Please enter your Balloter ID");
		String value_blkID = blkget.nextLine();
		
		int reg_val_ivt = val_bltr.register_voter(value_blkID);
		if(reg_val_ivt == -1)
		{	//undoVal=0;
			System.out.println("This VoterID does not exist");
			return;
		}
		else if(reg_val_ivt == 0)
		{	//flag=1;
			System.out.println("Your vote is already given at " + val_bltr.msg_val);
			return;
		}
		else
			upperfl=verify_task.dealing_confirm(reg_val_ivt);
		if(upperfl == 0)
		{
			return;
		}
		//verification totally done

		//now cast vate
		System.out.println("\n");
		System.out.println("Hello there ! Please cast your Vote on : \npress 1 for PARTY A \npress 2 for PARTY B\npress 3 for PARTY C \npress 4 for PARTY D");
		String huffmanB="";

		String msg_val = blkget.nextLine();
		
		System.out.println("Proceeding to Mine block now !!... ");

		value_adderB(make_Bnew(msg_val, blk_val_arrlist.get(blk_val_arrlist.size()-1).currHVal));
		int prns[] = new int[5];
		val_bltr.edit_doc_val("voterlist.txt",val_bltr.val_row);

		System.out.println("\nBlockchain is Valid: " + checkValChainB());
		
		System.out.println("\nThe block chain: ");

		blkVal_type();
	}
	
	public int preflag =1;
	
	public static Boolean checkValChainB() 
	{
		Combuild curValBlk; 
		Combuild preValBlk;
		 
		String TrValH = new String(new char[hr_d]).replace('\0', '0');

		int list_ar[] = new int[4];
		//go through existing block to check hash:
		for(int kl=1; kl < blk_val_arrlist.size(); kl++) 
		{	//int flag=1;
			curValBlk = blk_val_arrlist.get(kl);

			preValBlk = blk_val_arrlist.get(kl-1);
			//check calculated currHVal with registered currHVal:
			if(!curValBlk.currHVal.equals(curValBlk.evaluation_H_val()) )
			{	//flag=0;
				System.out.println("Current Hashes are not equal !!");			
				return false;
			}

			//check registered previous currHVal an=d== previous currHVal  
			if(!preValBlk.currHVal.equals(curValBlk.PrevHVal) ) 
			{	//preflag=0;
				System.out.println("Previous Hashes not equal");

				return false;
			}
			//see the value of currHVal is solved or not

			if(!curValBlk.currHVal.substring( 0, hr_d ).equals(TrValH)) 
			{
				System.out.println("This block hasn't been mined");
				return false;
			}
			list_ar[curValBlk.val_info()-1]++;
		}
		System.out.println("Voting Results currently :\nPARTY A: "+list_ar[0]+"\nPARTY B: "+list_ar[1]+"\nPARTY C: "+list_ar[2]+"\nPARTY D: "+list_ar[3]);
		
		return true;
	}
	
	public static void value_adderB(Combuild valBlk_n) throws IOException
	{
		valBlk_n.blk_mine(hr_d);

		blk_val_arrlist.add(valBlk_n);
		
		valBlk_n.blk_add_doc();
	}

	public static void blkVal_type()
	{
		int zs;

		zs=blk_val_arrlist.size();
		int kl=0;
		while(kl<zs)
		{
			System.out.println(" Block "+(kl+1)+"\n	{");
			blk_val_arrlist.get(kl).detail_block();
			System.out.println("	}");
			kl++;
		}
	}
	public static Combuild make_Bnew(String msg_val,String currHVal)
	{
		Combuild perent=new Combuild(msg_val,currHVal);
		return perent;
	}	
	public static ArrayList<Combuild> docVal_shift() throws FileNotFoundException
	{
	    ArrayList<Combuild> blk_arr_list = new ArrayList<Combuild>();


	    Scanner get_val_voter = new Scanner(new File("value_doc.txt"));
	    
	    while (get_val_voter.hasNextLine())
	    {
	        String val_ray = get_val_voter.nextLine();
	        String zips="";
	        String[] list_ar = val_ray.split("\\s");
	        Combuild perent = new Combuild(list_ar[0],list_ar[1],list_ar[2],Long.parseLong(list_ar[3]),Integer.parseInt(list_ar[4]));
	        blk_arr_list.add(perent);
	    }
	    return blk_arr_list;
	}	
}
