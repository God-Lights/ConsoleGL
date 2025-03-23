package net.godlights.edshin.java.console.java;

import main.MainRun;
import net.godlights.edshin.java.console.Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Java {
    public static void ReloadConsole() {
        Console.print("Reload console...");
        try {
            // Simulate the reloading process, for example, restarting a new instance of the application
            String javaBin = System.getProperty("java.home") + "/bin/java";
            String classpath = System.getProperty("java.class.path");
            String className = MainRun.class.getName();

            ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", classpath, className);
            processBuilder.inheritIO();  // To inherit IO streams of the current process
            processBuilder.start();

            System.exit(0);  // Exit the current application
        } catch (Exception e) {
            Console.error(e);
        }
    }
    public static void outLog(String message) {
        try {
            // 현재 jar파일의 위치를 얻어냄
            String jarDir = getJarDir();

            // logs 디렉토리 경로 설정
            Path logsDir = Paths.get(jarDir, "logs");

            // logs 디렉토리가 없으면 생성
            if (!Files.exists(logsDir)) {
                Files.createDirectories(logsDir);
            }

            // 날짜 포맷 지정
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            // 로그 파일 이름 지정
            Path logFilePath = logsDir.resolve(date + ".log");

            // 로그 작성
            writeLog(logFilePath, message);

        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void writeLog(Path logFile, String message) {
        String timestamp = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());
        try (BufferedWriter writer = Files.newBufferedWriter(logFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(timestamp + " " + message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 현재 jar파일 디렉토리 얻는 메소드
    private static String getJarDir() throws URISyntaxException {
        return new File(MainRun.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI()).getParent();
    }
}
