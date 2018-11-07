import java.util.Scanner;

//Клас Messages
public class Message {


    public String data_str;
    public byte[] data_byte = setMessages();


    public byte[] setMessages() {
        Scanner scan = new Scanner(System.in);

        String new_one = scan.nextLine();

        Integer size = new_one.length();

        String result = size.toString() + new_one;

        byte[] byte_array = result.getBytes();

        return byte_array;
    }

    public void givedata() {
        for (int i = 0; i < data_byte.length; i++) {
            System.out.println(data_byte[i]);

        }
    }
}

