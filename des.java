
    public class des {

         // first kVal-hePermutation Table
         int[] P_table1 = { 57, 49, 41, 33, 25,
            17, 9, 1, 58, 50, 42, 34, 26,
            18, 10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36, 63,
            55, 47, 39, 31, 23, 15, 7, 62,
            54, 46, 38, 30, 22, 14, 6, 61,
            53, 45, 37, 29, 21, 13, 5, 28,
            20, 12, 4 };
        
        int[] init_P_table = { 58, 50, 42, 34, 26, 18,
                     10, 2, 60, 52, 44, 36, 28, 20,
                     12, 4, 62, 54, 46, 38,
                     30, 22, 14, 6, 64, 56,
                     48, 40, 32, 24, 16, 8,
                     57, 49, 41, 33, 25, 17,
                     9, 1, 59, 51, 43, 35, 27,
                     19, 11, 3, 61, 53, 45,
                     37, 29, 21, 13, 5, 63, 55,
                     47, 39, 31, 23, 15, 7 };
  
        // Inverse Initial Permutation Table
        int[] inverse_P_table = { 40, 8, 48, 16, 56, 24, 64,
                      32, 39, 7, 47, 15, 55,
                      23, 63, 31, 38, 6, 46,
                      14, 54, 22, 62, 30, 37,
                      5, 45, 13, 53, 21, 61,
                      29, 36, 4, 44, 12, 52,
                      20, 60, 28, 35, 3, 43,
                      11, 51, 19, 59, 27, 34,
                      2, 42, 10, 50, 18, 58,
                      26, 33, 1, 41, 9, 49,
                      17, 57, 25 };
  
            // Straight Permutation Table
            int[] straight_P_table = { 16, 7, 20, 21, 29, 12, 28,
                17, 1, 15, 23, 26, 5, 18,
                31, 10, 2, 8, 24, 14, 32,
                27, 3, 9, 19, 13, 30, 6,
                22, 11, 4, 25 };

  
        // second kVal-Permutation Table
        int[] P_table2 = { 14, 17, 11, 24, 1, 5, 3,
                      28, 15, 6, 21, 10, 23, 19, 12,
                      4, 26, 8, 16, 7, 27, 20, 13, 2,
                      41, 52, 31, 37, 47, 55, 30, 40,
                      51, 45, 33, 48, 44, 49, 39, 56,
                      34, 53, 46, 42, 50, 36, 29, 32 };
  
        
        // S-box Table
        int[][][] sbox = {
            { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
              { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
              { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
              { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },
  
            { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
              { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
              { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
              { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },
            { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
              { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
              { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
              { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },
            { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
              { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
              { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
              { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },
            { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
              { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
              { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
              { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },
            { { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
              { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
              { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
              { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },
            { { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
              { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
              { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
              { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },
            { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
              { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
              { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
              { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } }
        };

        
        // Expansion D-box Table
        int[] exp_box = { 32, 1, 2, 3, 4, 5, 4,
            5, 6, 7, 8, 9, 8, 9, 10,
            11, 12, 13, 12, 13, 14, 15,
            16, 17, 16, 17, 18, 19, 20,
            21, 20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29, 28,
            29, 30, 31, 32, 1 };

        int[] sh_table = { 1, 1, 2, 2, 2, 2, 2, 2,
                            1, 2, 2, 2, 2, 2, 2, 1 };
  

        
        // binary to hex
        String convB2H(String varin)
        {
            int len_t = (int)varin.length() / 4;
            varin = Long.toHexString(Long.parseUnsignedLong(varin, 2));
                
            while (varin.length() < len_t)
            {
                varin = "0" + varin;
            }
             
            return varin;
        }

        // hex to binary
        String con_H2B(String varin)
        {
            int len_t = (varin.length() * 4);

            varin = Long.toBinaryString(Long.parseUnsignedLong(varin, 16));
                
            
            
                while (varin.length() < len_t)
                {
                    varin = "0" + varin;
                }
              
            return varin;
        }
  
        
        //permutate
        String des_perm(int[] sequence, String varin)
        {
            String op_var = "";
            varin = con_H2B(varin);
            int i = 0;
            while( i < sequence.length)
                {
                    op_var = op_var + varin.charAt(sequence[i] - 1);
                    i++;
                }
                 
            op_var = convB2H(op_var);
            return op_var;
        }
        
        // preparing 16 keys for 16 rounds
        String[] des_keyVal(String kVal)
        {
            String keys[] = new String[16];
           
            kVal = des_perm(P_table1, kVal);
            int i = 0;
            while( i < 16)
             {
                kVal = sft_LC(kVal.substring(0, 7), sh_table[i]) + sft_LC(kVal.substring(7, 14),sh_table[i]);
                
                keys[i] = des_perm(P_table2, kVal);
                i++;
            }
            return keys;
        }

        //hex from xor
        String xor(String new_a, String b)
        {
            long rsb = Long.parseUnsignedLong(b, 16);

            long rsa = Long.parseUnsignedLong(new_a, 16);
           
            //now do xor
            
            rsa = rsa ^ rsb;
            // dec to hex
            new_a = Long.toHexString(rsa);
            
            while (new_a.length() < b.length())
               {
                new_a = "0" + new_a;
               }
            return new_a;
        }
  
        // val_Ledes Circular Shifting bits
        String sft_LC(String varin, int numBits)
        {
            int len_t = varin.length() * 4;
            int new_arD[] = new int[len_t];
            int i = 0;
            while( i < len_t - 1)
              {
                new_arD[i] = (i + 2);
                i++;
              }  

            new_arD[len_t - 1] = 1;
            
            while ((numBits--) > 0)
                {
                    varin = des_perm(new_arD, varin);
                }
            return varin;
        }
  
        
  
        // s-box lookup
        String sBox(String varin)
        {
            String op_var = "";
            varin = con_H2B(varin);
            int i = 0;
            while( i < 48)
            {
                String temp = varin.substring(i, (i + 6) );
                int num = (i/6);
                int row = Integer.parseInt(temp.charAt(0) + "" + temp.charAt(5), 2);
                int col = Integer.parseInt(temp.substring(1, 5), 2);
                op_var =  op_var+ Integer.toHexString(sbox[num][row][col]);
                i =i+ 6;
            }
            return op_var;
        }
  
        String round(String varin, String kVal, int num)
        {
            
            String val_Ledes = varin.substring(0, 8);
            String temp = varin.substring(8, 16);
            
            String val_Rides = temp;
            // Expansion des_perm
            temp = des_perm(exp_box, temp);
            
            temp = xor(temp, kVal);
            
            temp = sBox(temp);
            String temes= val_Ledes;
            temp = des_perm(straight_P_table, temp);
            
            val_Ledes = xor(val_Ledes, temp);
            System.out.println("Round "
                               + (num + 1) + " "
                               + val_Rides.toUpperCase()
                               + " " + val_Ledes.toUpperCase() + " "
                               + kVal.toUpperCase());
  
           
            return (val_Rides + val_Ledes);
        }
  
        String encrypt(String shatxt, String kVal)
        {
            int i;
             String keys[] = des_keyVal(kVal);
  
            
            shatxt = des_perm(init_P_table, shatxt);
            System.out.println( "After initial permutation: " + shatxt.toUpperCase());

            String ln_rtext="";
            
            
            System.out.println( "After splitting: L0="+ shatxt.substring(0, 8).toUpperCase()+ " R0=" + shatxt.substring(8, 16).toUpperCase() + "\n");
  
            
            i = 0; 
            while (i < 16) 
            {
                shatxt = round(shatxt, keys[i], i);
                i++;
            }
  
            shatxt = shatxt.substring(8, 16) + shatxt.substring(0, 8);
  
            
            shatxt = des_perm(inverse_P_table, shatxt);
            return shatxt;
        }
  
        
}
