package com.hhs.studybook;

import com.hhs.studybook.swing.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudybookApplication {

    public static void main(String[] args) {
        boolean isClient = false;
        for (String arg : args) {
            System.out.println(arg);
            if (arg.equals("-client"))
                isClient = true;
        }
        if (!isClient) {
            SpringApplication.run(StudybookApplication.class, args);
        } else {
            Login frame = new Login();
            frame.setVisible(true);
        }

    }
}
