public class Tools {
    public String DecimalToBinary(String decimal,int binaryLength) {
        int decimalNumber = Integer.parseInt(decimal);
        String binaryString = Integer.toBinaryString(decimalNumber);
        while (binaryString.length() < binaryLength) {
            binaryString = "0" + binaryString;
        }
        return binaryString;
    }
}
