package com.example.onlinelibrary.utils;

import java.util.UUID;

/**
 * Class description
 *
 * @version        1.0.0, 16/03/31
 */
public class UUID64Util {

    /**
     * Method description binaryTo64
     *
     *
     * @param binary
     *
     * @return String 
     */
    public static String binaryTo64(String binary) {
        StringBuffer sb = new StringBuffer();

        if ((binary == null) || "".equals(binary)) {
            return "";
        }

        if ((binary.length() % 6) != 0) {
            return "";
        }

        for (int i = 0; i < binary.length(); i += 6) {
            sb.append(binaryTo64a(binary.substring(i, i + 6)));
        }

        return sb.toString();
    }

    /**
     * Method description binaryTo64a
     *
     *
     * @param binary
     *
     * @return String 
     */
    public static String binaryTo64a(String binary) {
        if ("000000".equals(binary)) {
            return "0";
        } else if ("000001".equals(binary)) {
            return "1";
        } else if ("000010".equals(binary)) {
            return "2";
        } else if ("000011".equals(binary)) {
            return "3";
        } else if ("000100".equals(binary)) {
            return "4";
        } else if ("000101".equals(binary)) {
            return "5";
        } else if ("000110".equals(binary)) {
            return "6";
        } else if ("000111".equals(binary)) {
            return "7";
        } else if ("001000".equals(binary)) {
            return "8";
        } else if ("001001".equals(binary)) {
            return "9";
        } else if ("001010".equals(binary)) {
            return "a";
        } else if ("001011".equals(binary)) {
            return "b";
        } else if ("001100".equals(binary)) {
            return "c";
        } else if ("001101".equals(binary)) {
            return "d";
        } else if ("001110".equals(binary)) {
            return "e";
        } else if ("001111".equals(binary)) {
            return "f";
        } else if ("010000".equals(binary)) {
            return "g";
        } else if ("010001".equals(binary)) {
            return "h";
        } else if ("010010".equals(binary)) {
            return "i";
        } else if ("010011".equals(binary)) {
            return "j";
        } else if ("010100".equals(binary)) {
            return "k";
        } else if ("010101".equals(binary)) {
            return "l";
        } else if ("010110".equals(binary)) {
            return "m";
        } else if ("010111".equals(binary)) {
            return "n";
        } else if ("011000".equals(binary)) {
            return "o";
        } else if ("011001".equals(binary)) {
            return "p";
        } else if ("011010".equals(binary)) {
            return "q";
        } else if ("011011".equals(binary)) {
            return "r";
        } else if ("011100".equals(binary)) {
            return "s";
        } else if ("011101".equals(binary)) {
            return "t";
        } else if ("011110".equals(binary)) {
            return "u";
        } else if ("011111".equals(binary)) {
            return "v";
        } else if ("100000".equals(binary)) {
            return "w";
        } else if ("100001".equals(binary)) {
            return "x";
        } else if ("100010".equals(binary)) {
            return "y";
        } else if ("100011".equals(binary)) {
            return "z";
        } else if ("100100".equals(binary)) {
            return "A";
        } else if ("100101".equals(binary)) {
            return "B";
        } else if ("100110".equals(binary)) {
            return "C";
        } else if ("100111".equals(binary)) {
            return "D";
        } else if ("101000".equals(binary)) {
            return "E";
        } else if ("101001".equals(binary)) {
            return "F";
        } else if ("101010".equals(binary)) {
            return "G";
        } else if ("101011".equals(binary)) {
            return "H";
        } else if ("101100".equals(binary)) {
            return "I";
        } else if ("101101".equals(binary)) {
            return "J";
        } else if ("101110".equals(binary)) {
            return "K";
        } else if ("101111".equals(binary)) {
            return "L";
        } else if ("110000".equals(binary)) {
            return "M";
        } else if ("110001".equals(binary)) {
            return "N";
        } else if ("110010".equals(binary)) {
            return "O";
        } else if ("110011".equals(binary)) {
            return "P";
        } else if ("110100".equals(binary)) {
            return "Q";
        } else if ("110101".equals(binary)) {
            return "R";
        } else if ("110110".equals(binary)) {
            return "S";
        } else if ("110111".equals(binary)) {
            return "T";
        } else if ("111000".equals(binary)) {
            return "U";
        } else if ("111001".equals(binary)) {
            return "V";
        } else if ("111010".equals(binary)) {
            return "W";
        } else if ("111011".equals(binary)) {
            return "X";
        } else if ("111100".equals(binary)) {
            return "Y";
        } else if ("111101".equals(binary)) {
            return "Z";
        } else if ("111110".equals(binary)) {
            return "_";
        } else if ("111111".equals(binary)) {
            return "-";
        } else {
            return "";
        }
    }

    /**
     * Method description createUniqueCode
     *
     *
     * @param uuid
     *
     * @return String 
     */
    public static String createUniqueCode(UUID uuid) {
        String uuidStr = uuid.toString().replaceAll("-", "").toUpperCase();

        uuidStr = "0" + uuidStr;
        uuidStr = hexToBinary(uuidStr);

        uuidStr = binaryTo64(uuidStr);

        return uuidStr;
    }

    /**
     * Method description hexToBinary
     *
     *
     * @param hex
     *
     * @return String 
     */
    public static String hexToBinary(char hex) {
        String binary = null;

        switch (hex) {
        case '0' :
            binary = "0000";

            break;

        case '1' :
            binary = "0001";

            break;

        case '2' :
            binary = "0010";

            break;

        case '3' :
            binary = "0011";

            break;

        case '4' :
            binary = "0100";

            break;

        case '5' :
            binary = "0101";

            break;

        case '6' :
            binary = "0110";

            break;

        case '7' :
            binary = "0111";

            break;

        case '8' :
            binary = "1000";

            break;

        case '9' :
            binary = "1001";

            break;

        case 'A' :
            binary = "1010";

            break;

        case 'B' :
            binary = "1011";

            break;

        case 'C' :
            binary = "1100";

            break;

        case 'D' :
            binary = "1101";

            break;

        case 'E' :
            binary = "1110";

            break;

        case 'F' :
            binary = "1111";

            break;

        default :
            binary = "";
        }

        return binary;
    }

    /**
     * Method description hexToBinary
     *
     *
     * @param hex
     *
     * @return String 
     */
    public static String hexToBinary(String hex) {
        StringBuffer sb = new StringBuffer();

        if ((hex == null) || "".equals(hex)) {
            return "";
        }

        for (int i = 0; i < hex.length(); i++) {
            sb.append(hexToBinary(hex.charAt(i)));
        }

        return sb.toString();
    }
}
