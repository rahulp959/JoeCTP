package joectp;

import java.io.*;

/**
 *
 * @author Parkar2
 */
public class JoeCTP {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws IOException {
//        InputStreamReader converter = new InputStreamReader(System.in);
//        BufferedReader in = new BufferedReader(converter);
//        int numberOfSpaces = 26;
//        
//        System.out.print("Enter route string : ");
//        
//        String route = in.readLine();
//        
//        System.out.print("Enter route name : ");
//        String routeName = in.readLine();
//        CreateFormattedString(route, routeName);        
//    }
    public static String CreateFormattedString(String route, String routeName) {
        String[] routeArray;
        String formattedString = "";

        routeArray = route.split(" ");

        for (int i = 0; i < routeArray.length - 1; i++) {
            if (i == 0) {
                formattedString = String.format("%-26s%-14s%-14s%-14s%s%n", routeName, routeArray[i], routeArray[i], routeArray[i + 1], routeArray[i + 1]);
            } else {
                formattedString += String.format("%-26s%-14s%-14s%-14s%s%n", "", routeArray[i], routeArray[i], routeArray[i + 1], routeArray[i + 1]);
            }
        }

        return formattedString;
    }

    public static String CreateMultipleFormattedStringEU(String route, String routeName) {
        String[] routeArray;
        String[] routes;
        String formattedString = "";

        routes = route.split("\n");

        for (String routeString : routes) {
            routeArray = routeString.split(" ");

            for (int i = 0; i < routeArray.length - 1; i++) {
                if (i == 0) {
                    formattedString += String.format("%-26s%-14s%-14s%-14s%s%n", (routeName + routeArray[i]), routeArray[i], routeArray[i], routeArray[i + 1], routeArray[i + 1]);
                } else {
                    formattedString += String.format("%-26s%-14s%-14s%-14s%s%n", "", routeArray[i], routeArray[i], routeArray[i + 1], routeArray[i + 1]);
                }
            }
            formattedString += "\n";
        }

        return formattedString;
    }
}
