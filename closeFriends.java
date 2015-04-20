// Authors Mathias Nielse s134540 & Daniel Andersen s130022
// Algoritmer og Datastrukturer
// Obligatorisk afleveringopgave
// Opgave 2
 
import java.io.*;
import java.util.*;
 
public class closeFriends {
 
    public static void main(String[] args) throws IOException { 
 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = new ArrayList<String>();
        int relationsArray[][];
        List<Boolean> results = new ArrayList<Boolean>();
        int venskaber[];
        String str = input.readLine();
        String str2 = input.readLine();
        String str3 = null;
        Scanner sc = new Scanner(str);
        double ManiLen, size; 
 
        while(sc.hasNext()) {
            people.add(sc.next());
        }
        sc.close();
 
        relationsArray  = new int[people.size()][people.size()];
 
        while(str2 != null) {
            if(str2.contains("taetvenskab")) {
                str3 = str2.substring(12);
                break;
            }
            String[] split = str2.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            relationsArray[x][y] = 1;
            relationsArray[y][x] = 1;
            str2 = input.readLine();
        }
        
        //Testlinje
         
        String[] split2 = str3.split(" ");
        venskaber = new int[split2.length];
     
         
        for(int i = 0; i < venskaber.length; i++) {
            venskaber[i] = Integer.parseInt(split2[i]); 
        }
 
         
        ManiLen = venskaber.length-1;
 
        size = (ManiLen*(ManiLen+1))/2;
 
        for(int i = 0; i < size; i++) {
            results.add(false);
        }
        int k = 0;
         
         
        for(int i = 0; i <= venskaber.length-2; i++){
             
            for (int j = 1; j+i < venskaber.length; j++) {
                if(relationsArray[venskaber[i]][venskaber[i+j]] == 1) {
                    results.set(k, true);
                    k++;
                } else {
                    k++;
                }
            }
        }
 

        boolean closeRelation = true;
        for(int i = 0; i < results.size(); i++) {
            if(!results.get(i)) {
                System.out.println("nej");
                closeRelation = false;
                break;
            }
        }
        if(closeRelation) System.out.println("ja");
       
    }
 
}