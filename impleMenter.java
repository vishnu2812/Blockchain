import java.security.MessageDigest;
//using java library itself
public class impleMenter {
	
	
	public static String imple_sha(String entry_str){
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Applies sha256 to our variable string, 
			byte[] currHVal = digest.digest(entry_str.getBytes("UTF-8"));
			//using UTF-8 implements
			StringBuffer str_Ox = new StringBuffer(); // in hexidecimal


				for (int kl = 0; kl < currHVal.length; kl++)
				 {
					String str_new = Integer.toHexString(0xff & currHVal[kl]); //convert
					
					
					if(str_new.length() == 1)
					{
						str_Ox.append('0');
					} 

					str_Ox.append(str_new);
				}
				

			return str_Ox.toString();
		}
		catch(Exception er_valB)
		{	//if there is any error
			throw new RuntimeException(er_valB);
		}
	}

	
	public static String str_diff(int hr_d)
	{
		return new String(new char[hr_d]).replace('\0', '0');
	}
	
	
}
