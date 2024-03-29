package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/16.
 * 所有词统计词频并输出到一个总文件中
 */
public class Practical14_6 {
    public static void main(String[] args) throws FileNotFoundException {
        frequency();
    }

    public static void frequency() throws FileNotFoundException {
        IOutil menu = new IOutil();
        ArrayList<String> goel_list = menu.goelpath("test_file");
        HashMap<String,Integer> wordmap = new HashMap<String, Integer>();

        for(String file:goel_list){
            ArrayList<String> wordlist = readFileByLines(file);
            System.out.println(wordlist);
            for(String word : wordlist) {
                if(!wordmap.containsKey(word)){
                    wordmap.put(word,1);
                }else{
                    wordmap.put( word,(int)wordmap.get(word)+1);
                }
            }
        }

        set2fequecysum("frequencysum/sum.txt",wordmap);
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static ArrayList<String> readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                list.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }

    public static void set2fequecysum(String path,HashMap<String,Integer> map) throws FileNotFoundException {
        File file = new File(path);
        FileOutputStream fop = new FileOutputStream(file);

        try {
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                String str = key+"/"+val+"\n";
                byte[] contentInBytes = str.getBytes();
                fop.write(contentInBytes);
            }
            fop.flush();
            fop.close();
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
