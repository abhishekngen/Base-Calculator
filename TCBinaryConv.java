import javax.print.DocFlavor;
import java.util.ArrayList;

public class TCBinaryConv {
    public String convertToBinary(String numberstring){

        try{
            Integer.parseInt(numberstring);
        }catch(Exception e){
            return "";
        }

        if(Integer.parseInt(numberstring)<0){
            double divisor = 1;
            double total = 1;
            int number = Integer.parseInt(numberstring) * -1;
            ArrayList<String> binaryarray = new ArrayList<String>();
            while(total<number){
                divisor = divisor*2;
                total+=divisor;
            }
            while(divisor>=1){
                if((number - divisor)>=0){
                    binaryarray.add("1");
                    number -= divisor;
                }
                else{
                    binaryarray.add("0");
                }
                divisor = divisor*0.5;

            }

            boolean hasone = false;
            for(int i = binaryarray.size() - 1; i>=0; i--){
                if(binaryarray.get(i) == "0" && hasone){
                    binaryarray.set(i, "1");
                }
                else if(binaryarray.get(i) == "1"){
                    if(!hasone){
                        hasone = true;
                    }
                    else{
                        binaryarray.set(i, "0");
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String a: binaryarray){
                sb.append(a);
            }
            sb.insert(0, "1");
            return sb.toString();
        }
        else{
            BinaryNormal b = new BinaryNormal();
            StringBuilder sb = new StringBuilder(b.convertToBinary(numberstring));
            sb.insert(0, "0");
            return sb.toString();

        }
    }

    public String convertToDenary(String binary)
    {
        int total = 0;
        int length = binary.length();
        double divisor = Math.pow(2, (length-1));
        double divisororiginal = divisor;
        for(int i =0; i<length; i++){
            if(binary.charAt(i) == '1'){
                total+=divisor;
            }
            if(binary.charAt(i) != '1' && binary.charAt(i) != '0'){
                return "";
            }
            divisor = divisor*0.5;
        }
        if(binary.charAt(0) == '1'){
            total -= (divisororiginal*2);
        }
        try {
            return Integer.toString(total);
        }
        catch(Exception e){
            return "";
        }
    }



}
