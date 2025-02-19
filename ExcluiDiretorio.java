package br.com.fiap.main;

import java.io.File;

public class ExcluiDiretorio {

    public static void main(String[] args) {
        try {
            File dir = new File("d:/loja");
            String msg = "";
            if (dir.isDirectory()) {
                if (dir.delete()) {
                    msg = dir.getName() + " excluído com sucesso!";
                } else {
                    if (excluirFilhos(dir)) {
                        msg = dir.getName() + " excluído com sucesso!";
                    } else {
                        msg = "Falha ao excluir a pasta" + dir.getName();
                    }
                }
                System.out.println(msg);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static boolean excluirFilhos(File dir) {
        if (dir.isDirectory()) {
            String[] arquivos = dir.list();
            for (String item : arquivos) {
                boolean sucesso = excluirFilhos(new File(dir, item));
                if (sucesso) {
                    System.out.println("Excluído: " + item);
                } else {
                    System.out.println("Incapaz de excluir: " + item);
                    return false;
                }
            }
        }
        return dir.delete();
    }


}
