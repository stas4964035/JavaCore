package ru.geekbrains.core.lesson5;

import java.io.*;

public class Backup {
    public static void main(String[] args) {
        Backup.copy("./out", "./backup");
    }
    public static void copy(String oldPath,String newPath){
        try{
            (new File(newPath)).mkdirs();
            File oldFile = new File(oldPath);

            String[] file = oldFile.list();

            File temp = null;
            for(int i=0;i<file.length;i++){

                if(oldPath.endsWith(File.separator)){
                    temp = new File(oldPath+file[i]);
                } else {
                    temp = new File(oldPath+File.separator+file[i]);
                }

                if(temp.isFile()){

                    FileInputStream fis = new FileInputStream(temp);
                    FileOutputStream fos = new FileOutputStream(newPath + "/" +  (temp.getName()).toString());

                    byte[] b = new byte[1024*5];
                    int len = -1;
                    while((len = fis.read(b))!=-1){
                        fos.write(b,0,len);
                        fos.flush();
                    }
                    fos.close();
                    fis.close();
                }

                if(temp.isDirectory()){

                    copy(oldPath+"/"+file[i],newPath+"/"+file[i]);
                }
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
