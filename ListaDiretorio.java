package br.com.fiap.main;

import javax.swing.*;
import java.io.File;

public class ListaDiretorio {

    public static void main(String[] args) {

        do{
            try{
                String path = JOptionPane.showInputDialog("Digite o caminho da pasta (utilize / entre as pastas");
                File dir = new File(path);

                if (dir.isDirectory()) {
                    System.out.println("Conteúdo na pasta: " + path);
                    String[] lista = dir.list();
                    if (lista  != null) {
                        for (String item : lista) {
                            System.out.println(item);
                        }
                    }
                } else {
                    System.out.println("Caminho informado incorreto!");
                }


            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

    }

}
