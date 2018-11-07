import java.io.*;
import java.nio.file.Files;
import java.io.IOException;

public class Image {
    private String root = "Freddie.jpg";
    public byte[] image_data = data();
    public byte[] new_data;
    public String string_data = "00110011";
    public byte current;


    public Image() throws IOException { }

    public byte[] data() throws IOException {
        File fi = new File(this.root);
        byte[] fileContent = Files.readAllBytes(fi.toPath());
        return fileContent;
    }

    public void data_to_string() {
        String result = "";
        for (int i = 0; i < new_data.length; i++) {
            result = result + Integer.toBinaryString(new_data[i]).toString();
        }
        string_data = result;
    }

    public static String get_first_two_element(String str){
        if (str.length() <= 2 ){return str;}
        return (String) str.subSequence(0, 2);
    }

    public static String delete_first_two_element(String element){
        StringBuffer new_stringBuffer = new StringBuffer(element);
        new_stringBuffer.delete(0, 2);
        return new_stringBuffer.toString();
    }

    public static String delete_last_two_element(String element){
        StringBuffer new_stringBuffer = new StringBuffer(element);
        new_stringBuffer.delete(element.length()-2, element.length());
        return new_stringBuffer.toString();
    }

    public void encoding() throws IOException {

//        String code = this.string_data;
        System.out.println(this.string_data);

        for (int i = 0; i < this.image_data.length; i++) {
            if (string_data.length() != 0) {


                Byte new_byte = new Byte();
                new_byte.data = image_data[i];

                if (new_byte.relevant()) {
                    byte change_byte = image_data[i];


                    String data = get_first_two_element(this.string_data);
                    this.string_data = delete_first_two_element(this.string_data);


                    String num = Integer.toBinaryString(image_data[i]);
                    String final_data = delete_last_two_element(num);
                    System.out.println("1-----");
                    System.out.println(image_data[i]);
                    image_data[i] = (byte) Integer.parseInt((final_data + data), 2);
                    System.out.println("2-----");
                    System.out.println(image_data[i]);
                    System.out.println("3-----");
                    System.out.println(string_data);
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
    }

    public void make_bmp() throws IOException {
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream("Finally.jpg"));
            out.write(image_data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }
}
