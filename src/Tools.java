public class Tools {
    public String DecimalToBinary(String decimal, int binaryLength) {
        int decimalNumber = Integer.parseInt(decimal);
        String binaryString = Integer.toBinaryString(Integer.parseInt(decimal));
        if (binaryString.length() > binaryLength) {
            binaryString = binaryString.substring(binaryString.length() - binaryLength);
        } else {
            while (binaryString.length() < binaryLength) {
                binaryString = ((decimalNumber < 0) ? '1' : '0') + (binaryString);
            }
        }
        return binaryString;
    }
}
