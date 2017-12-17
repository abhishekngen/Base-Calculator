import java.util.ArrayList;

public class TCFloatingPtConv {
    public String convertToBinary(String numberstring) {
        double number;
        try {
            number = Double.parseDouble(numberstring);
        }
        catch(Exception e){
            return "";
        }

        //for 8 bit mantissa and 4 bit exponent BUT does not allow negative exponents
        TCBinaryConv conv = new TCBinaryConv();
        int integernumber = (int) Math.abs(number);
        double decimalnumber = Math.abs(number) - integernumber;
        //System.out.println(decimalnumber);
        StringBuilder mantissa = new StringBuilder();
        StringBuilder decimalbinary = new StringBuilder();
        double total = 0;
        double divisor = 0.5;
        int bitsleft = 0;
        if(number > 127 || number<-128){
            return "Number out of bounds";
        }
        if(true){
            String intbinary = conv.convertToBinary(Integer.toString(integernumber));
           // System.out.println(intbinary);
            mantissa.append(intbinary);
            bitsleft = 8 - mantissa.length();
            for(int i = 0; i< bitsleft; i++){
                if((total + divisor) <= decimalnumber){
                    decimalbinary.append("1");
                    total += divisor;
                }
                else{
                    decimalbinary.append("0");
                }
                divisor = divisor * 0.5;
            }
            int floatmove = 7 - bitsleft;
            StringBuilder exponent = new StringBuilder();
            divisor = 4;
            total = 0;
            if(floatmove >= 0){
                for(int i = 0; i<3; i++){
                    if(total + divisor <= floatmove){
                        exponent.append("1");
                        total += divisor;
                    }
                    else{
                        exponent.append("0");
                    }
                    divisor = divisor * 0.5;
                }
                exponent.insert(0, "0");
            }
            if(floatmove < 0){
                divisor = 8;
                total = 0;
                int posfloatmove = floatmove*-1;
                for(int i = 0; i<4; i++){
                    if(total + divisor <= posfloatmove){
                        exponent.append("1");
                        total += divisor;
                    }
                    else{
                        exponent.append("0");
                    }
                    divisor = divisor * 0.5;
                }
                boolean hasone = false;
                for(int i = 3; i>=0; i--){
                    if(exponent.charAt(i) == '1' && hasone){
                        exponent.setCharAt(i, '0');
                    }
                    else if(exponent.charAt(i) == '0' && hasone){
                        exponent.setCharAt(i, '1');
                    }
                    if (exponent.charAt(i) == '1' && !hasone) {
                        hasone = true;
                    }

                }

            }

            System.out.println(decimalbinary);
            mantissa.append(decimalbinary);
            System.out.println(mantissa);
            if(number<0){
                boolean hasone = false;
                for(int i = mantissa.length()-1; i>=0; i--){
                    if(mantissa.charAt(i) =='0' && hasone){
                        mantissa.setCharAt(i, '1');
                    }
                    else if(mantissa.charAt(i) == '1' && hasone){
                        mantissa.setCharAt(i, '0');
                    }
                    if(mantissa.charAt(i) == '1' && !hasone){
                        hasone = true;
                    }
                }
            }
            mantissa.append(exponent);
            System.out.println(mantissa);
        }
        return mantissa.toString();

    }

    public String convertToDenary(String binary){
        //For 8 bit mantissa and 4 bit exponent
        if(binary.length() != 12){
            return "Requires 8 bit Mantissa and 4 bit Exponent";
        }
        String mantissa = binary.substring(0, 8);
        String exponentstring = binary.substring(8);
        TCBinaryConv conv = new TCBinaryConv();
        try{
            int exponent = Integer.parseInt(conv.convertToDenary(exponentstring));
            String integerstring = binary.substring(0, exponent+1);
            String decimalstring = binary.substring(exponent+1, 8);
            double integer = Double.parseDouble(conv.convertToDenary(integerstring));
            double divisor = 0.5;
            double decimal = 0;
            System.out.println(integerstring);
            System.out.println(decimalstring);
            for(int i = 0; i<decimalstring.length(); i++){
                if(decimalstring.charAt(i) == '1'){
                    decimal += divisor;
                }
                divisor = divisor * 0.5;
            }
            double number = integer + decimal;
            return Double.toString(number);
        }
        catch(Exception e){
            return "";
        }

    }

}
