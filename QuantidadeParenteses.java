package com.leetcode;

import java.io.*;
import java.util.*;

public class QuantidadeParenteses {

    static File file;
    static boolean mostrarTempoGasto = false;
    static long start, elapsed;

    static List<String> resultados = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        Locale.setDefault(new Locale("pt","BR"));

        String path;

        if (args.length > 0 && args[0].equals("path")) {
            path = args[1];
            if (args.length > 2 && args[2].equals("showTimeSpent")) {
                mostrarTempoGasto = true;
            }
        } else {
            path = getPathFromConsole();
        }

        start = System.currentTimeMillis();
        readFileAndCheckQuantityOfParentheses(path);
        exportFormattedToFile(path);
        elapsed = (System.currentTimeMillis() - start);
        if (mostrarTempoGasto) {System.out.println(elapsed + "ms") ; }
    }

    public static String getPathFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o endereço do arquivo(caso esteja na mesma pasta do programa, digite apenas o nome do arquivo)");
        String path = sc.next();
        sc.close();

        return path;
    }

    public static void readFileAndCheckQuantityOfParentheses(String filePath) throws IOException {
        BufferedReader br;
        try {
            file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
            throw new FileNotFoundException("Arquivo não encontrado");
        }


        //Lista de parenteses abertos
        Stack<Character> openParentheses = new Stack<>();

        String line;
        while (( line = br.readLine()) != null) {
            openParentheses.clear();
            try {
                for (Character letter : line.toCharArray()) {
                    if (letter == '(') {
                        openParentheses.push(letter);
                    } else if (letter == ')') {
                        openParentheses.pop();
                    }
                }

                //Se não estiver vazio então tem parenteses abertos
                if (openParentheses.isEmpty()) {
                    resultados.add("correct");
                } else {
                    resultados.add("incorrect");
                }
                //Se ele tentar fechar um parenteses que não existe então causará uma exception.
                //Logo, terá um parenteses fechado a mais
            } catch(EmptyStackException e) {
                resultados.add("incorrect");
            }
        }
        br.close();
    }

    public static void exportFormattedToFile(String path) throws IOException {
        String fileName = "out-" + file.getName();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        Iterator<String> it = resultados.iterator();
        if (resultados.size() > 0) {
            bw.write(it.next());
        }

        while (it.hasNext()) {
            bw.newLine();
            bw.write(it.next());
        }
        bw.close();
    }
}
