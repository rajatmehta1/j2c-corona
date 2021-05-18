import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConvertToMap {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        File f = new File("C:\\mystuff\\J2CCorona\\src\\main\\java\\numbers.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = "";
        while((line = br.readLine()) != null) {
            String[] s = line.split(",");
            sb.append("ambList.add(new Ambulance(\""+ s[0] + "\",\""+s[1].replaceAll("New Delhi","").trim()+"\");\n");
        }
        System.out.println(sb.toString());
    }

}
