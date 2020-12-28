import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       String sequence = sc.nextLine();
       
       //String output =
        solutionFun(input, sequence);
      // System.out.println(output);
       
       
       
    }
    
    public static void solutionFun(String input, String sequence){
        int n =Integer.valueOf(input.split(" ")[0]);
        int m = Integer.valueOf(input.split(" ")[1]);
        int k =Integer.valueOf(input.split(" ")[2]);
        String[] starr=sequence.split(" ");
        List<String> arrayList = new ArrayList<>();
        int[] intarr = new int[starr.length];
        for (int i = 0; i < intarr.length; i++) {
            intarr[i] = Integer.valueOf(starr[i]);
            
        }
        int bit = 0;
          
        List<String> resultlist = new ArrayList<>();
        pairlist(arrayList, sequence.contains(" ") ? sequence.replace(" ", "") : sequence, 0, n/k);
        
        String[] strArray = new String[arrayList.size()];
        strArray = strlistTostrarray(arrayList);
         List<String> list = new ArrayList<>();
         int cnt = 0;
         
          for (int t = 0; t < strArray.length; t++) {
                
                    int[] countarr = new int[k]; 
                    for(int j = 0; j<arrayList.get(t).length(); j++){
                    countarr[j] = intarr[j +cnt];  
                    }
                 
                    
                    
                    if(t==0){
                        if(!((findsum(strArray[t]) % m) == 0)){
                            bit = 1;
                            List<String> finlist = new ArrayList<>();
                             pairlist(finlist,permute(convertStringtoIntArr((strArray[t])+(strArray[t+1].charAt(t)))).get(0) + strArray[t+1].substring(1,strArray[t+1].length()) ,0,2);
                  
                            strArray[t] = finlist.get(t);
                            strArray[t+1] = finlist.get(t+1);
                            arrayList.set(t, finlist.get(t));
                            arrayList.set(t+1,finlist.get(t+1));
                            
                            
                            solutionofSeconditr(input, strlistTostrarray(arrayList), true);
                            arrayList.clear();
                            break;
                            
                        
                        }else{
                         list =  permute(countarr);   
                        }
                    //  System.out.println(list);
                    }else if( t == strArray.length -1) {
                        if((findsum(strArray[t]) % m) == 0){
                            resultlist.add(strArray[t]);
                            break;
                        }
                    }
                    if(t>0 && t != strArray.length -1){
                       list =  permute(countarr); 
                    }
                    
                   cnt = cnt + arrayList.get(t).length();
                    //System.out.println(list);
                    for (int i = 0; i < list.size(); i++) {
                        if((findsum(list.get(i)) % m) == 0){
                         //System.out.println(list.get(i));
                         resultlist.add(list.get(i));
                            break;
                        } 
                    }
                    
                    
                    }
                    
                    
    
        
        
        
        
       int count =0;
       for (int i =0;  i < resultlist.size() -1; i++) {
           if((findsum(resultlist.get(i))) % m == 0){
               count++;
           } 
       }
        if(bit != 1){
          if(count >0 ){
            System.out.println(returnSpaceString(resultlist));
        }else{
            System.out.println("-1");
        }  
        }
        
        
    }
    public static void solutionofSeconditr(String input, String[] secarray, boolean flag){
        int n =Integer.valueOf(input.split(" ")[0]);
        int m = Integer.valueOf(input.split(" ")[1]);
        int k =Integer.valueOf(input.split(" ")[2]);
        int[] starr= convertStringtoIntArr(convertStringArrtoString(secarray)) ; 
        List<String> arrayList = new ArrayList<>();
        int[] intarr = new int[starr.length];
        for (int i = 0; i < intarr.length; i++) {
            intarr[i] = starr[i];
                  

        }
          
        List<String> resultlist = new ArrayList<>();
         pairlist(arrayList,convertStringArrtoString(secarray) , 0, n/k);
       
        
        String[] strArray = new String[arrayList.size()];
        strArray = strlistTostrarray(arrayList);
         List<String> list = new ArrayList<>();
         int cnt = 0;
    
          for (int t = 0; t < strArray.length; t++) {
                
                    int[] countarr = new int[k]; 
                    for(int j = 0; j<k; j++){
                    countarr[j] = intarr[j +cnt];  
                
                    }
                 
                    
                    
                    if(t==0){
                        if(!((findsum(strArray[t]) % m) == 0)){
                            
                    //         arrayList.clear();
                    //          pairlist(arrayList,permute(convertStringtoIntArr((strArray[t])+(strArray[t+1].charAt(t)))).get(0) + strArray[t+1].substring(1,strArray[t+1].length()) ,0,k);
                    //    // System.out.println(arrayList);
                    //         strArray[t] = arrayList.get(t);
                    //         strArray[t+1] = arrayList.get(t+1);
                    //          arrayList.clear();
                    //         solutionofSecond(input, strArray);
                    //         break;
                        }else{
                           if(flag){
                               
                                resultlist.add(strArray[t]);
                                flag = false;
                             
                           }else{
                               list =  permute(countarr); 
                             }
                           
                        }
                    
                    }else if( t == strArray.length -1) {
                        if((findsum(strArray[t]) % m) == 0){
                            resultlist.add(strArray[t]);
                            break;
                        }
                    }
                    if(t>0 && t != strArray.length -1){
                        if((findsum(strArray[t]) % m) == 0){
                            resultlist.add(strArray[t]);
                            
                        }else{
                             list =  permute(countarr); 
                        }
                      
                    }
                    
                   cnt = cnt + k;
                   
                    for (int i = 0; i < list.size(); i++) {
                        if((findsum(list.get(i)) % m) == 0){
                         
                            resultlist.add(list.get(i));
                            break;
                        } 
                    }
                    
                    
                    }
                    

        
        
        
       int count =0;
       for (int i =0;  i < resultlist.size() -1; i++) {
           if((findsum(resultlist.get(i))) % m == 0){
               count++;
           } 
       }
        
        
        if(count >0 ){
            System.out.println(returnSpaceString(resultlist));
            //return returnSpaceString(resultlist);
            return;
        }else{
            System.out.println("-1");
            return;
        }
    }
    public static String returnSpaceString(List<String> list){
        try{
         String str = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                 str = str +" "+ c ;
            }
        }
        return str.substring(1, str.length());   
        }catch(Exception e){}
        return "";
    }
    
 
    public static int[] convertStringtoIntArr(String s){
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            char c = s.charAt(i);
            arr[i] =  Integer.valueOf(c-'0');
            
            }
            
            return arr;
    }
     public static String convertStringArrtoString(String[] s){
        String st = "";
        for (int i = 0; i < s.length; i++) {
            st += s[i];
        }
        
            
            return st;
    }
     public static int[] convertStringArrtoIntArr(String[] s){
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  Integer.parseInt(s[i]);
            }
            
            return arr;
    }
    public static String[] strlistTostrarray(List<String> list){
        String[] s = new String[list.size()];
        
        for(int i = 0 ; i< list.size(); i++){
            s[i] = list.get(i);
        }
        return s;
    }
    public static void pairlist(List<String> list, String seq,int s, int k){
        //System.out.println(seq);
        int length = seq.length();
        int temp =0, chars = length/k;
        String[] eqstr = new String[k];
        if(length % k != 0 ){
            return;
            
        }else{
            for (int i = 0; i < length; i= i+chars) {
                String part = seq.substring(i, i+chars);
                eqstr[temp] = part;
                temp++;
            }
        }
        
        
        for (int i = 0; i < eqstr.length; i++) {
           list.add(eqstr[i]); 
        }
       
        
    }






public static int findsum(String s){
      int sum = 0; 
      for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          sum = sum + Integer.parseInt(""+ch);
      }
      return sum;
        }
        
  public static void swaparr(int[] arr, int K, int M){
      String str = "";
      
      for (int i = 0; i < K; i++) {
        //   int temp = arr[i];
        //   arr[i] =arr[i+1];
        //   arr[i+1] = temp;
          
          str += String.valueOf(arr[i]);
          System.out.print(""+str); 
          if((findsum(str) % M) == 0){
          return;
        }
      }
      
      
  }
  
  public static List<String> getuniquelist(List<String> list){
      List<String> uniquelist = new ArrayList<>();
      List<String> enemyid= new ArrayList<>();
      for (String entry : list) {
          if(!enemyid.contains(entry)){
              enemyid.add(entry);
              uniquelist.add(entry);
          }
      }
      
      return uniquelist;
  }
        
  public static List<String> permute(int[] arr){
       ArrayList<String> list = new ArrayList<>();
      ArrayList<String> flist = new ArrayList<>();
        
      permuteHelper(arr, 0, list);
      
      //System.out.println(list);
      
      String val="";
      for (String string : list) {
          if(string.equals(" ")){
              flist.add(val.trim());
              val = "";
          }
          val += string.trim();
      }
      Collections.reverse(flist);
     //System.out.println(flist.toString());
      
     
      return getuniquelist(flist);
  }  
  


  private static void permuteHelper(int[] arr, int index, ArrayList<String> list){
      
      if(index >= arr.length - 1){
          //System.out.print("[");
          for (int i = 0; i < arr.length-1; i++) {
               list.add(arr[i]+"");
                //list += (arr[i])+"";
              //System.out.print(arr[i]+", ");
          }
          if(arr.length > 0)
                 list.add(arr[arr.length - 1]+"");
                //list += (arr[arr.length - 1])+"";
                //System.out.print(arr[arr.length - 1]);
            
            //System.out.println("]");
             list.add(" ");
            //list+=" ";
            return;
          
      }
      
      for(int i = index; i<arr.length; i++){
          int t = arr[index];
          arr[index] = arr[i];
          arr[i] = t;
          
          permuteHelper(arr, index+1, list);
          
          t = arr[index];
          arr[index] = arr[i];
          arr[i] = t;
      }
  }
}
