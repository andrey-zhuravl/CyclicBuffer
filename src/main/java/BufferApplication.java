import model.CustomClassLoader;
import model.Scena;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;

import static model.Constants.*;

public class BufferApplication {
    public static void main(String[] args) throws IOException {
//
//        CustomClassLoader customClassLoader = new CustomClassLoader();
//        try {
//            Object obj;
//            obj = customClassLoader.findClass("MyClass1").newInstance();
//            Method[] methods = obj.getClass().getDeclaredMethods();
//            System.out.println(String.format("Methods of %s class:",obj.getClass().getName()));
//            for(Method method : methods) {
//                System.out.println(method.getName());
//            }
//        } catch (ClassFormatError e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();

//        javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
//                        null, "Found : " + gs.length, "screen detected ?",
//                javax.swing.JOptionPane.DEFAULT_OPTION);
//
//        for (int j = 0; j < gs.length; j++) {
//            GraphicsDevice gd = gs[j];
//            JFrame  frame = new JFrame(gd.getDefaultConfiguration());
//            frame.setTitle("I'm on monitor #" + j);
//            frame.setSize(400,200);
//            frame.add(new JLabel("hello world"));
//            frame.setVisible(true);
//        }
        GraphicsDevice gd = gs[0];
        Scena scena = new Scena();
        JFrame frame = new JFrame(gd.getDefaultConfiguration());
        frame.setTitle("LIFTS MODEL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setSize(SCENA_WIDTH + SCENA_BORDER*2,SCENA_HEIGTH + SCENA_BORDER*2);
        frame.setLocation(-1200, 500);
        frame.setResizable(true);
        //frame.setLocationRelativeTo(gd.getDefaultConfiguration());
        frame.setVisible(true);

        frame.add(scena);

    }

    public Integer get1(){
        return 1;
    }
}
