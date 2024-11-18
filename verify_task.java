import java.util.Scanner;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.Random;
import java.util.function.*;

class verify_task
{
	
	static long value_p=19793393;
	static long value_s=12921;
	static long value_g=9381;
	//static newnumber v_t=11;
	static int upperfl=1;
	static long numerical_cal(long value_ah,long value_ag,long value_ax,long value_ap)
	{
		long new_pnum=1;
		for(int jj=0; jj<value_ax; jj++ )
		{
			new_pnum=new_pnum*value_ag;
			
			if(new_pnum>value_ap)
			{
				new_pnum=new_pnum%value_ap;
			}
				
		}
		new_pnum=(value_ah%value_ap)*new_pnum;

		return new_pnum%value_ap;
	}
	
	static int dealing_confirm(long v_t)
	{	HashSet<Long> hash_arr= new HashSet<Long>();
		Scanner s= new Scanner(System.in);
		int upperf2n=1;
		Random new_rnum = new Random();
		
		
		System.out.println("Take the value of g = 9381 and p = 19793393");
		
		int kl=0; 

		while(kl<1 )
		
		{
			System.out.println("Input the value of h, where h = (g^r) mod p ");
			
			long w_num=Long.parseLong(s.nextLine());
			
			if(hash_arr.contains(w_num)==true)
			{
				System.out.println("This h value is used already ! Enter different h value");
				kl--;
			}
			
			else
			{
				hash_arr.add(w_num);

				int rand01=(new_rnum.nextInt(100))%2;

				System.out.println("Random generated value of b is : "+rand01+"\n Now input value for (r+bx) mod (p-1) :");
				
				long value_rbx =Long.parseLong(s.nextLine());
			
				if(numerical_cal(1,value_g,value_rbx,value_p)!=numerical_cal(w_num,v_t,rand01,value_p))
				{
					upperfl=0;
					System.out.println("Verification failed !");
					break;
				}
			}
			kl++;
		}
		if(upperfl==1)
			{
				System.out.println("Verification successful ! ");
			}
		return upperfl;
	}
}
