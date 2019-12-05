import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Paths;

/**
*Clase Writter
*Clase que lee archivos
**/

public class Writter {
  public static void main(String[] args) {
    try {
            Path path = Paths.get("csv.txt"); //Este es la ruta del archivo a leer
            List<String> lines = Files.readAllLines(path); //Leo todas las lineas en una lista
            Path polarpath = Paths.get("calculo.txt"); //Aqui se genera el otro archivo
            String polar = "";
            for (String string : lines) { //Se itera
                String row[] = string.split(",");
                double x = Double.parseDouble(row[0]);
                double y = Double.parseDouble(row[1]);

                double r = Math.sqrt((Math.pow(x, 2))+(Math.pow(y, 2))); //Aqui se calcula el radio
                double ang = Math.atan(y/x);  //Y aqui el angulo

                polar += "radio= "+ r + " angulo= "+ang+"\n"; //Arma el String para presentar en el archivo txt
            }
            Files.write(polarpath, polar.getBytes()); //Y aqui imprime los resultados de los calculos
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

