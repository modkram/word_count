package main;

import java.io.*;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Modkram on 30.09.2017.
 */
public class Service {


    public void processLine(String line, Map<String, Words> map){
        line = line.toLowerCase().replace(".", " ").replace(",", " ").replace("  ", " ");
        String[] arr = line.split(" ");
        for (String s : arr) {
            if(s.length()> 0){
                if(map.containsKey(s)){
                    map.get(s).addCount();
                }else{
                    map.put(s, new Words(s, 1));
                }
            }
        }
    }

    public File getFile(String path){
        File file;
        URL urlPath = Main.class.getResource(path);
        if(urlPath != null){
            file = new File(urlPath.getFile());
        }else{
//        File file = new File("D:\\devTools\\projects\\word_count\\src\\lirycs.txt");
            file = new File(path);
            if(!file.exists()){
                return null;
            }
        }
        return file;
    }

    public void readFile(File file, Map<String, Words> map){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.processLine(line, map);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printWords(Integer count, Map<String, Words> map){
        List<Words> collect = map
                .values()
                .stream()
                .sorted(Comparator.comparing(Words::getCount).reversed().thenComparing(Comparator.comparing(Words::getWord)))
                .collect(Collectors.toList());

        collect.stream().limit(count).forEach(System.out::println);
    }
}
