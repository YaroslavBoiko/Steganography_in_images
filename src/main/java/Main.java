import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Процес кодування
        Message new_message = new Message();
//        new_message.givedata();

        Image new_image = new Image();

        new_image.new_data = new_message.data_byte;
        new_image.data_to_string();
        new_image.encoding();
        new_image.make_bmp();


        //Декодування

    }

}

