import java.util.ArrayList;

public class BinaryNormal {

    public String convertToBinary(String numberstring){
        double divisor = 1;
        double total = 1;
        int number;
        try {
            number = Integer.parseInt(numberstring);
        }
        catch(Exception e){
            return "";
        }
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
        StringBuilder sb = new StringBuilder();
        for(String a: binaryarray){
            sb.append(a);
        }
        return sb.toString();
    }
    public String convertToDenary(String binary)
    {
        int total = 0;
        int length = binary.length();
        double divisor = Math.pow(2, (length-1));
        for(int i =0; i<length; i++){
            if(binary.charAt(i) == '1'){
                total+=divisor;
            }
            divisor = divisor*0.5;
        }
        return Integer.toString(total);
    }
}
